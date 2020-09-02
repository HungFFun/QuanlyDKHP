package GiaodienSV;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.LopHocphanDAO;
import DoituongData.ChitietLophocphan;
import DoituongData.Dangkihocphan;
import DoituongData.HocphanDaDangki;
import DoituongData.ThongtinLophocphan;
import DoituongData.Thongtindangnhap;
import javax.swing.ImageIcon;

public class Sv_Dangkihocphan extends JPanel {

	/**
	 * Create the panel.
	 */
	JTable tblDSLopHP, tblCTLopHP,tblHocphandadangki;
	DefaultTableModel modelDSLopHP, modelCTLopHP, modelHocphandaDangki;
	JScrollPane scrollDSLopHP, scrollCTLopHP, scrollHocphandadangki;



	private String ma;
	private JTextField txtMonhoccantim;
	private JComboBox cbHocki;
	private JComboBox cbNamhoc;
	public Sv_Dangkihocphan(Thongtindangnhap thongtindangnhap) {
		setLayout(null);

		ma= thongtindangnhap.getMa();


		JPanel panel_Dangkyhocphan = new JPanel();
		panel_Dangkyhocphan.setBackground(new Color(255, 255, 240));
		panel_Dangkyhocphan.setBounds(0, 0, 1002, 592);
		ButtonGroup buttonGroup = new ButtonGroup();
		panel_Dangkyhocphan.setLayout(null);

		JLabel lbl_hocphanchodangky = new JLabel("Học phần chờ đăng kí");
		lbl_hocphanchodangky.setBounds(330, 5, 288, 29);
		lbl_hocphanchodangky.setForeground(new Color(255, 0, 0));
		lbl_hocphanchodangky.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_Dangkyhocphan.add(lbl_hocphanchodangky);



		JPanel panel_HocphanChoDangky = new JPanel();
		panel_HocphanChoDangky.setBounds(10, 94, 988, 198);
		panel_HocphanChoDangky.setLayout(null);

		String[] tieude = {"Mã HP", "Tên học phần", " Số tín chỉ","Sĩ số tối đa","Đã đang ký","Học phần học trước (a)"};
		modelDSLopHP = new DefaultTableModel(tieude, 0);
		tblDSLopHP = new JTable(modelDSLopHP);
		JScrollPane scrollDSLopHP = new JScrollPane();
		scrollDSLopHP = new JScrollPane(tblDSLopHP);
		scrollDSLopHP.setBounds(0, 0, 988, 198);
		scrollDSLopHP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorter1;
		sorter1 = new TableRowSorter<TableModel>(tblDSLopHP.getModel());
		tblDSLopHP.addMouseListener(tblDSLopHP());
		panel_HocphanChoDangky.add(scrollDSLopHP, BorderLayout.CENTER);

		panel_Dangkyhocphan.add(panel_HocphanChoDangky);

		JButton btnThongtinlop = new JButton("Xem chi tiết");
		btnThongtinlop.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\target.png"));
		btnThongtinlop.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThongtinlop.setBounds(632, 302, 166, 27);
		btnThongtinlop.addActionListener(btnThongtinlop());
		panel_Dangkyhocphan.add(btnThongtinlop);

		JPanel panel_Chitiethocphan = new JPanel();
		panel_Chitiethocphan.setBorder(new TitledBorder(null, "Chi ti\u1EBFt l\u1EDBp h\u1ECDc ph\u1EA7n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Chitiethocphan.setBounds(10, 343, 874, 85);
		String[] tieudeCTLHP = {"Lịch học", "Phòng học", " Dẫy nhà","Giảng viên","Thời gian"};

		modelCTLopHP = new DefaultTableModel(tieudeCTLHP, 0);
		tblCTLopHP = new JTable(modelCTLopHP);
		scrollCTLopHP = new JScrollPane(tblCTLopHP);
		scrollCTLopHP.setBounds(10, 18, 854, 59);
		scrollCTLopHP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterChitietlophoc;
		sorterChitietlophoc = new TableRowSorter<TableModel>(tblCTLopHP.getModel());
		panel_Chitiethocphan.setLayout(null);
		panel_Chitiethocphan.add(scrollCTLopHP);

		panel_Dangkyhocphan.add(panel_Chitiethocphan);

		JPanel panel_HocphanDadangki = new JPanel();
		panel_HocphanDadangki.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hoc phần đã đang kí", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_HocphanDadangki.setBounds(10, 438, 874, 144);

		String[] tieudeHocphandadangki = {"Mã lớp học phần", "Tên môn học", " Giảng viên","Tiết học","Phòng học","Ngày bắt đầu"};
		modelHocphandaDangki = new DefaultTableModel(tieudeHocphandadangki, 0);
		tblHocphandadangki = new JTable(modelHocphandaDangki);
		scrollHocphandadangki = new JScrollPane(tblHocphandadangki);
		scrollHocphandadangki.setBounds(10, 22, 854, 112);
		scrollHocphandadangki.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterHocphandadangki;
		sorterHocphandadangki = new TableRowSorter<TableModel>(tblHocphandadangki.getModel());
		panel_HocphanDadangki.setLayout(null);
		panel_HocphanDadangki.setLayout(null);
		panel_HocphanDadangki.add(scrollHocphandadangki, BorderLayout.CENTER);

		panel_Dangkyhocphan.add(panel_HocphanDadangki);

		add(panel_Dangkyhocphan);

		JLabel lblTenMonhocCantim = new JLabel("Môn học cần tìm:");
		lblTenMonhocCantim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenMonhocCantim.setBounds(10, 297, 144, 36);
		panel_Dangkyhocphan.add(lblTenMonhocCantim);

		txtMonhoccantim = new JTextField();
		txtMonhoccantim.setBounds(164, 297, 242, 36);
		panel_Dangkyhocphan.add(txtMonhoccantim);
		txtMonhoccantim.setColumns(10);

		JButton btnTimMonhoc = new JButton("Tìm môn học");
		btnTimMonhoc.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\search.png"));
		btnTimMonhoc.addActionListener(btnTimMonhoc());
		btnTimMonhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimMonhoc.setBounds(416, 302, 166, 27);
		panel_Dangkyhocphan.add(btnTimMonhoc);
		JButton btnDangkymon = new JButton("Đăng ký");
		btnDangkymon.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\security.png"));
		btnDangkymon.setBounds(894, 359, 104, 69);
		btnDangkymon.addActionListener( btnDangkymon());
		btnDangkymon.setForeground(new Color(255, 0, 0));
		btnDangkymon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_Dangkyhocphan.add(btnDangkymon);

		JButton btnHuylophocphan = new JButton("Hủy lớp");
		btnHuylophocphan.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\eraser.png"));
		btnHuylophocphan.setForeground(Color.RED);
		btnHuylophocphan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHuylophocphan.setBounds(894, 480, 104, 69);
		btnHuylophocphan.addActionListener(btnHuylophocphaṇ̣̣());
		panel_Dangkyhocphan.add(btnHuylophocphan);

		JButton btnTailai = new JButton("Tải lại");
		btnTailai.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\reload2.png"));
		btnTailai.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTailai.setBounds(823, 302, 144, 27);
		btnTailai.addActionListener(btnTailai());
		panel_Dangkyhocphan.add(btnTailai);

		cbHocki = new JComboBox();
		cbHocki.setModel(new DefaultComboBoxModel(new String[] {"HK1", "HK2", "HK3"}));
		cbHocki.setFont(new Font("Tahoma", Font.BOLD, 17));
		cbHocki.setBounds(251, 48, 72, 21);
		cbHocki.addMouseListener(cbHocki());
		panel_Dangkyhocphan.add(cbHocki);

		JLabel lblHcK = new JLabel("Học kì:");
		lblHcK.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHcK.setBounds(157, 44, 84, 28);
		panel_Dangkyhocphan.add(lblHcK);

		JLabel lblNmHc = new JLabel("Năm học");
		lblNmHc.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNmHc.setBounds(474, 44, 84, 28);
		panel_Dangkyhocphan.add(lblNmHc);

		cbNamhoc = new JComboBox();
		cbNamhoc.setModel(new DefaultComboBoxModel(new String[] {"2019-2020", "2020-2021", "2021-2022"}));
		cbNamhoc.setFont(new Font("Tahoma", Font.BOLD, 17));
		cbNamhoc.setBounds(592, 48, 133, 21);
		panel_Dangkyhocphan.add(cbNamhoc);

		JButton btnTaiLaiLophocPhan = new JButton("Tải LHP");
		btnTaiLaiLophocPhan.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\reload2.png"));
		btnTaiLaiLophocPhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTaiLaiLophocPhan.setBounds(823, 42, 144, 27);
		btnTaiLaiLophocPhan.addActionListener(btnTaiLaiLophocPhan());
		panel_Dangkyhocphan.add(btnTaiLaiLophocPhan);


	}
	private MouseListener cbHocki() {
		// TODO Auto-generated method stub
		return new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				modelDSLopHP.setRowCount(0);
				modelCTLopHP.setRowCount(0);
				DanhsachLophocphan(cbHocki.getSelectedItem().toString(), cbNamhoc.getSelectedItem().toString());
				txtMonhoccantim.setText("");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		};
	}
	private MouseListener tblDSLopHP() {
		// TODO Auto-generated method stub
		return new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				modelCTLopHP.setRowCount(0);
				int row=tblDSLopHP.getSelectedRow();
				if ( row==-1)
				{
					JOptionPane.showConfirmDialog(null, "Chọn lớp trước khi xem");
				}
				else
				{
					String maLophocphan =tblDSLopHP.getValueAt(row, 0).toString();				
					ChitietLophocphan chitietLophocphans = new LopHocphanDAO().getChitietLophocphan(maLophocphan);
					ArrayList<ChitietLophocphan> listCTLHP = new ArrayList<ChitietLophocphan>();
					listCTLHP.add(chitietLophocphans);
					for(ChitietLophocphan CTLHP: listCTLHP)
					{
						modelCTLopHP.addRow(new Object[] {
								CTLHP.getLichoc(),
								CTLHP.getPhonghoc(),
								CTLHP.getDaynha(),
								CTLHP.getGiangvien(),
								CTLHP.getNgayBatdau()

						});
					}
				}
			}
		};
	}
	private ActionListener btnTaiLaiLophocPhan() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				modelDSLopHP.setRowCount(0);
				modelCTLopHP.setRowCount(0);
				modelHocphandaDangki.setRowCount(0);
				DanhsachLophocphan(cbHocki.getSelectedItem().toString(), cbNamhoc.getSelectedItem().toString());
				Hiendanhsachhocphandadangki(ma,  cbNamhoc.getSelectedItem().toString());

			}
		};
	}
	private ActionListener btnTailai() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modelDSLopHP.setRowCount(0);
				modelCTLopHP.setRowCount(0);
				DanhsachLophocphan(cbHocki.getSelectedItem().toString(), cbNamhoc.getSelectedItem().toString());
				txtMonhoccantim.setText("");
			}
		};
	}
	private ActionListener btnTimMonhoc() {
		// TODO Auto-generated method stub
		//	ThongtinLophocphan thongtinLophocphan = new ThongtinLophocphan(maLHP, tenMonhoc, tenGV, sotinchi, maPhonghoc, ngayBatdau, ngayKetthuc, tiet, thu)
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				modelDSLopHP.setRowCount(0);
				String hk = cbHocki.getSelectedItem().toString().trim();
				ArrayList<ThongtinLophocphan> listlophoccantim = new LopHocphanDAO().Timlophocphan(txtMonhoccantim.getText(),hk );
				for(ThongtinLophocphan lh: listlophoccantim)
				{
					modelDSLopHP.addRow(new Object[] {
							lh.getMaLHP(),
							lh.getTenMonhoc(),
							lh.getSotinchi(),
					});
				}
			}
		};
	}
	private ActionListener btnHuylophocphaṇ̣̣() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row=tblHocphandadangki.getSelectedRow();
				if(row != -1) {
					String maLophocphan =tblHocphandadangki.getValueAt(row, 0).toString();		
					Dangkihocphan huyDangkihocphan = new Dangkihocphan(maLophocphan, ma);

//					if ( (new LopHocphanDAO().Huylophocphan(huyDangkihocphan)!=false))
//					{
//						JOptionPane.showConfirmDialog(null, "Hủy thành công");
//
//					}
					
					int y = JOptionPane.showConfirmDialog(null,"Bạn Có Muốn Hủy Hay Không?");
					if(y == JOptionPane.YES_OPTION) {
						new LopHocphanDAO().Huylophocphan(huyDangkihocphan);
					}
					modelHocphandaDangki.setRowCount(0);
					modelDSLopHP.setRowCount(0);
					DanhsachLophocphan(cbHocki.getSelectedItem().toString(), cbNamhoc.getSelectedItem().toString());
					Hiendanhsachhocphandadangki(ma, cbNamhoc.getSelectedItem().toString());
				}
				else {
					JOptionPane.showMessageDialog(null,"Chưa Chọn Lớp Học Phần Để Hủy");
				}

			}
		};
	}
	private ActionListener btnDangkymon() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//modelCTLopHP.setRowCount(0);
				int i = 0;
				int row = tblHocphandadangki.getRowCount();
				int row1=tblDSLopHP.getSelectedRow();
				if(row1 != -1) {
					if(row == 0) {
						System.out.println(row1);
						String maLophocphan =tblDSLopHP.getValueAt(row1, 0).toString();		
						Dangkihocphan dangkihocphan = new Dangkihocphan(maLophocphan, ma);
						//							if ( (new LopHocphanDAO().DangKyHocphan(dangkihocphan)!=false))
						//							{
						//								JOptionPane.showConfirmDialog(null, "Đăng kí thành công");
						//								
						//							}
						int y = JOptionPane.showConfirmDialog(null,"Bạn Có Muốn Đăng Kí Hay Không?");
						if(y == JOptionPane.YES_OPTION) {
							new LopHocphanDAO().DangKyHocphan(dangkihocphan);
						}
						modelHocphandaDangki.setRowCount(0);
						modelDSLopHP.setRowCount(0);
						modelCTLopHP.setRowCount(0);
						DanhsachLophocphan(cbHocki.getSelectedItem().toString(), cbNamhoc.getSelectedItem().toString());
						Hiendanhsachhocphandadangki(ma, cbNamhoc.getSelectedItem().toString().trim());
					}
					else
					{
						while(i < tblHocphandadangki.getRowCount()) {
							if(row==1) {
								if(tblCTLopHP.getValueAt(0, 0).toString().trim().equalsIgnoreCase(tblHocphandadangki.getValueAt(row-1, 3).toString().trim())) {
									JOptionPane.showMessageDialog(null,"Trùng Lịch");
									break;
								}
								else {
									String maLophocphan =tblDSLopHP.getValueAt(row1, 0).toString();		
									Dangkihocphan dangkihocphan = new Dangkihocphan(maLophocphan, ma);
									//							if ( (new LopHocphanDAO().DangKyHocphan(dangkihocphan)!=false))
									//							{
									//								JOptionPane.showConfirmDialog(null, "Đăng kí thành công");
									//								
									//							}
									int y = JOptionPane.showConfirmDialog(null,"Bạn Có Muốn Đăng Kí Hay Không?");
									if(y == JOptionPane.YES_OPTION) {
										new LopHocphanDAO().DangKyHocphan(dangkihocphan);
									}
									modelHocphandaDangki.setRowCount(0);
									modelDSLopHP.setRowCount(0);
									modelCTLopHP.setRowCount(0);
									DanhsachLophocphan(cbHocki.getSelectedItem().toString(), cbNamhoc.getSelectedItem().toString());
									Hiendanhsachhocphandadangki(ma, cbNamhoc.getSelectedItem().toString().trim());
									break;
								}
							}
							else {
								if(tblCTLopHP.getValueAt(0, 0).toString().trim().equalsIgnoreCase(tblHocphandadangki.getValueAt(row-1, 3).toString().trim())) {
									JOptionPane.showMessageDialog(null,"Trùng Lịch");
									break;
								}
							}
							i ++;
							row --;
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Chưa Chọn Lớp Học Phần Để Đăng Kí");
				}
			}
		};
	}
	public void Hiendanhsachhocphandadangki(String ma, String namHoc) {
		ArrayList<HocphanDaDangki> listHocphanDadangki = new LopHocphanDAO().getDSHocphandadangki(ma, namHoc,cbHocki.getSelectedItem().toString().trim());
		for(HocphanDaDangki hp: listHocphanDadangki)
		{
			modelHocphandaDangki.addRow(new Object[] {
					hp.getMaLHp(),
					hp.getTenLophocphan(),
					hp.getTenGiangvien(),
					hp.getTietHoc(),
					hp.getMaPhonghoc(),
					hp.getNgayBatdau()


			});
		}
	}

	private ActionListener btnThongtinlop() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modelCTLopHP.setRowCount(0);
				int row=tblDSLopHP.getSelectedRow();
				if ( row==-1)
				{
					JOptionPane.showConfirmDialog(null, "Chọn lớp trước khi xem");
				}
				else
				{
					String maLophocphan =tblDSLopHP.getValueAt(row, 0).toString();				
					ChitietLophocphan chitietLophocphans = new LopHocphanDAO().getChitietLophocphan(maLophocphan);
					ArrayList<ChitietLophocphan> listCTLHP = new ArrayList<ChitietLophocphan>();
					listCTLHP.add(chitietLophocphans);
					for(ChitietLophocphan CTLHP: listCTLHP)
					{
						modelCTLopHP.addRow(new Object[] {
								CTLHP.getLichoc(),
								CTLHP.getPhonghoc(),
								CTLHP.getDaynha(),
								CTLHP.getGiangvien(),
								CTLHP.getNgayBatdau()

						});
					}



				}
			}
		};
	}

	public void DanhsachLophocphan(String hocKi, String namHoc) {
		ArrayList<ThongtinLophocphan> listThongtinLopHP = new LopHocphanDAO().getDSThongtinLophocphan(hocKi, namHoc,ma);
		for(ThongtinLophocphan lh: listThongtinLopHP)
		{
			modelDSLopHP.addRow(new Object[] {
					lh.getMaLHP(),
					lh.getTenMonhoc(),
					lh.getSotinchi(),
					lh.getSiSoToida(),
					lh.getDaDangki()

			});
		}
	}
}

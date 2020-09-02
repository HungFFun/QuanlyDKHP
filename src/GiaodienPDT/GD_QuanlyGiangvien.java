package GiaodienPDT;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.PhongdaotaoDAO;
import Doituong.Giangvien_GiaovuPDT;
import Doituong.Sinhviens;
import DoituongData.Quanlylophocphan;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;


public class GD_QuanlyGiangvien extends JPanel {
	private JTextField txtMaGV;
	private JTextField txtGiangvienCantim;
	private JTextField txtTenGV;
	private JTextField txtGioitinh;
	private JTextField txtKhoa;
	private JTextField txtNgaysinh;
	private JTextField txtSDT;
	private JComboBox<String> cbTrinhdo;
	private JTextField txtDiachi;
	private JLabel lblCanhbao ;
	private JComboBox cbTimkiem;

	JTable tblDSgiangvien;
	DefaultTableModel modelDSgiangvien;
	JScrollPane scrollDSgiangvien;
	PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();

	/**
	 * Create the panel.
	 */
	public GD_QuanlyGiangvien() {
		setLayout(null);

		JPanel panel_Thongtin = new JPanel();
		panel_Thongtin.setBackground(new Color(255, 255, 240));
		panel_Thongtin.setLayout(null);
		panel_Thongtin.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_Thongtin.setBounds(0, 22, 999, 319);
		add(panel_Thongtin);

		JLabel lblMaGV = new JLabel("Mã GV:");
		lblMaGV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaGV.setBounds(95, 24, 60, 25);
		panel_Thongtin.add(lblMaGV);

		txtMaGV = new JTextField();
		txtMaGV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMaGV.setColumns(10);
		txtMaGV.setBounds(233, 22, 185, 30);
		panel_Thongtin.add(txtMaGV);

		JLabel lblSDT = new JLabel("SĐT:");
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSDT.setBounds(545, 78, 62, 20);
		panel_Thongtin.add(lblSDT);

		JLabel lblNgaysinh = new JLabel("Ngày Sinh:");
		lblNgaysinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgaysinh.setBounds(545, 26, 102, 20);
		panel_Thongtin.add(lblNgaysinh);

		JLabel lblGioitinh = new JLabel("Giới Tính:");
		lblGioitinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGioitinh.setBounds(95, 133, 87, 20);
		panel_Thongtin.add(lblGioitinh);

		JLabel lblDiachi = new JLabel("Địa Chỉ:");
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiachi.setBounds(548, 192, 99, 25);
		panel_Thongtin.add(lblDiachi);

		JLabel lblTrinhdo = new JLabel("Trình Độ");
		lblTrinhdo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrinhdo.setBounds(545, 133, 72, 20);
		panel_Thongtin.add(lblTrinhdo);

		JLabel lblKhoa = new JLabel("Khoa:");
		lblKhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKhoa.setBounds(95, 194, 45, 20);
		panel_Thongtin.add(lblKhoa);

		JLabel lblGiangvienCantim = new JLabel("Tìm giảng viên theo ->");
		lblGiangvienCantim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiangvienCantim.setBounds(38, 290, 185, 25);
		panel_Thongtin.add(lblGiangvienCantim);

		txtGiangvienCantim = new JTextField();
		txtGiangvienCantim.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtGiangvienCantim.setColumns(10);
		txtGiangvienCantim.setBounds(415, 290, 278, 25);
		panel_Thongtin.add(txtGiangvienCantim);

		JButton btnTimkiem = new JButton("Tìm");
		btnTimkiem.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\search.png"));
		btnTimkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimkiem.setBounds(703, 290, 119, 25);
		btnTimkiem.addActionListener(btnTimkiem());
		panel_Thongtin.add(btnTimkiem);

		txtTenGV = new JTextField();
		txtTenGV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTenGV.setColumns(10);
		txtTenGV.setBounds(233, 74, 185, 30);
		panel_Thongtin.add(txtTenGV);

		txtGioitinh = new JTextField();
		txtGioitinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtGioitinh.setColumns(10);
		txtGioitinh.setBounds(233, 129, 185, 30);
		panel_Thongtin.add(txtGioitinh);

		txtKhoa = new JTextField();
		txtKhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtKhoa.setColumns(10);
		txtKhoa.setBounds(233, 190, 185, 30);
		panel_Thongtin.add(txtKhoa);

		txtNgaysinh = new JTextField();
		txtNgaysinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNgaysinh.setColumns(10);
		txtNgaysinh.setBounds(711, 22, 185, 30);
		panel_Thongtin.add(txtNgaysinh);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSDT.setColumns(10);
		txtSDT.setBounds(711, 68, 185, 30);
		panel_Thongtin.add(txtSDT);

		cbTrinhdo = new JComboBox<String>();
		cbTrinhdo.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbTrinhdo.setBounds(711, 129, 185, 30);
		panel_Thongtin.add(cbTrinhdo);
		cbTrinhdo.addItem("Tiến sĩ khoa học");
		cbTrinhdo.addItem("Tiến sĩ");
		cbTrinhdo.addItem("Thạc sĩ");
		cbTrinhdo.addItem("Cử nhân");
		cbTrinhdo.addItem("Kỹ sư");

		txtDiachi = new JTextField();
		txtDiachi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDiachi.setColumns(10);
		txtDiachi.setBounds(711, 186, 185, 30);
		panel_Thongtin.add(txtDiachi);

		JLabel lblTenGV = new JLabel("Tên GV:");
		lblTenGV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenGV.setBounds(93, 78, 62, 20);
		panel_Thongtin.add(lblTenGV);

		JButton btnTailai = new JButton("Tải lại");
		btnTailai.setBackground(new Color(248, 248, 255));
		btnTailai.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\reload2.png"));
		btnTailai.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTailai.setBounds(848, 290, 119, 25);
		btnTailai.addActionListener(btnTailai());
		panel_Thongtin.add(btnTailai);

		lblCanhbao = new JLabel("");
		lblCanhbao.setForeground(Color.RED);
		lblCanhbao.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCanhbao.setBounds(310, 241, 413, 26);
		panel_Thongtin.add(lblCanhbao);

		cbTimkiem = new JComboBox();
		cbTimkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbTimkiem.setModel(new DefaultComboBoxModel(new String[] {"", "Mã Giảng viên", "Tên Giảng viên"}));
		cbTimkiem.setBounds(233, 294, 150, 21);
		panel_Thongtin.add(cbTimkiem);

		JPanel panel_table = new JPanel();
		panel_table.setBackground(new Color(255, 255, 240));
		panel_table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_table.setBounds(0, 342, 805, 243);

		String[] tieude = {"Mã GV", " Tên GV","Giới tính","Ngày sinh","SDT","Địa chỉ","Khoa","Trình độ"};

		modelDSgiangvien = new DefaultTableModel(tieude, 0);
		tblDSgiangvien = new JTable(modelDSgiangvien);
		scrollDSgiangvien = new JScrollPane(tblDSgiangvien);
		scrollDSgiangvien.setBounds(10, 10, 785, 223);
		scrollDSgiangvien.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterGiangvien;
		sorterGiangvien = new TableRowSorter<TableModel>(tblDSgiangvien.getModel());
		tblDSgiangvien.addMouseListener(tblDSgiangvien());
		panel_table.setLayout(null);
		panel_table.add(scrollDSgiangvien);
		DanhsachGiangvien();
		add(panel_table);

		JPanel panel_Chucnang = new JPanel();
		panel_Chucnang.setBackground(new Color(255, 255, 240));
		panel_Chucnang.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_Chucnang.setBounds(807, 342, 192, 243);
		add(panel_Chucnang);
		panel_Chucnang.setLayout(null);

		JLabel lblChucnang = new JLabel("Chức năng");
		lblChucnang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChucnang.setBounds(52, 10, 103, 32);
		panel_Chucnang.add(lblChucnang);

		JButton btnThemGiangvien = new JButton("Thêm giảng viên");
		btnThemGiangvien.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\plus (1).png"));
		btnThemGiangvien.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemGiangvien.setBounds(10, 52, 172, 32);
		btnThemGiangvien.addActionListener(btnThemGiangvien());
		panel_Chucnang.add(btnThemGiangvien);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\delete (1).png"));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setBounds(10, 88, 172, 32);
		btnXoa.addActionListener(btnXoa());
		panel_Chucnang.add(btnXoa);

		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\refresh.png"));
		btnCapnhat.addActionListener(btnCapnhat());
		btnCapnhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapnhat.setBounds(10, 172, 172, 32);
		panel_Chucnang.add(btnCapnhat);

		JButton btnChonGV = new JButton("Chọn GV");
		btnChonGV.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\selection.png"));
		btnChonGV.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChonGV.setBounds(10, 130, 172, 32);
		btnChonGV.addActionListener(btnChonGV());
		panel_Chucnang.add(btnChonGV);

		JLabel lblQunLGing = new JLabel("Quản lý Giảng viên");
		lblQunLGing.setForeground(Color.RED);
		lblQunLGing.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQunLGing.setBounds(411, 0, 175, 19);
		add(lblQunLGing);

	}
	private MouseListener tblDSgiangvien() {
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
				int row = tblDSgiangvien.getSelectedRow();

				txtMaGV.setText(tblDSgiangvien.getValueAt(row, 0).toString());
				txtTenGV.setText(tblDSgiangvien.getValueAt(row, 1).toString());
				txtGioitinh.setText(tblDSgiangvien.getValueAt(row, 2).toString());
				txtNgaysinh.setText(tblDSgiangvien.getValueAt(row, 3).toString());
				txtSDT.setText(tblDSgiangvien.getValueAt(row, 4).toString());
				txtDiachi.setText(tblDSgiangvien.getValueAt(row, 5).toString());
				txtKhoa.setText(tblDSgiangvien.getValueAt(row, 6).toString());
				cbTrinhdo.setSelectedItem(tblDSgiangvien.getValueAt(row, 7).toString());

			}
		};
	}
	public void Canhbao(String mess, JTextField txt)
	{
		lblCanhbao.setText(mess);
		txt.requestFocus();
	}
	private ActionListener btnCapnhat() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub


				String maGV = txtMaGV.getText().toString();

				if ( maGV.length()==0)
				{
					Canhbao("Chọn Giảng viên cần cập nhật", txtMaGV);
				}
				else {
					String ma = txtMaGV.getText();
					String ten = txtTenGV.getText();

					String giotinh = txtGioitinh.getText();
					String ngaysinh= txtNgaysinh.getText();
					String soDienthoai = txtSDT.getText();
					String diachi = txtDiachi.getText();
					String khoa = txtKhoa.getText();
					String trinhdo = cbTrinhdo.getSelectedItem().toString().trim();

					PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();
					if (phongdaotaoDAO.CapnhatGiangVien(ma, ten, giotinh, ngaysinh, soDienthoai, diachi, khoa, trinhdo))
					{
						JOptionPane.showMessageDialog(null	, "Cập nhật thành công");
						modelDSgiangvien.setRowCount(0);
						DanhsachGiangvien();
					}
				}

			}
		};
	}

	private ActionListener btnChonGV() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tblDSgiangvien.getSelectedRow();

				if ( row==-1)
				{
					JOptionPane.showMessageDialog(null	, "Chọn Giảng viên trong danh sách");
				}
				else {

					txtMaGV.setText(tblDSgiangvien.getValueAt(row, 0).toString());
					txtTenGV.setText(tblDSgiangvien.getValueAt(row, 1).toString());
					txtGioitinh.setText(tblDSgiangvien.getValueAt(row, 2).toString());
					txtNgaysinh.setText(tblDSgiangvien.getValueAt(row, 3).toString());
					txtSDT.setText(tblDSgiangvien.getValueAt(row, 4).toString());
					txtDiachi.setText(tblDSgiangvien.getValueAt(row, 5).toString());
					txtKhoa.setText(tblDSgiangvien.getValueAt(row, 6).toString());
					cbTrinhdo.setSelectedItem(tblDSgiangvien.getValueAt(row, 7).toString());
				}
			}
		};
	}
	private void tailai()
	{
		modelDSgiangvien.setRowCount(0);
		txtDiachi.setText("");
		txtGiangvienCantim.setText("");
		txtGioitinh.setText("");
		txtKhoa.setText("");
		txtMaGV.setText("");
		txtNgaysinh.setText("");
		txtSDT.setText("");
		txtTenGV.setText("");
		cbTrinhdo.setSelectedIndex(0);

	}

	private ActionListener btnTailai() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tailai();
				DanhsachGiangvien();
			}
		};
	}

	private ActionListener btnTimkiem() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String Giangviencantim=txtGiangvienCantim.getText();
				if(Giangviencantim.length()==0)
				{
					Canhbao("Điền thông tin vào ô tìm kiếm", txtGiangvienCantim);
				}
				else
				{
					if (cbTimkiem.getSelectedItem() == "Tên Giảng viên")	
					{

						ArrayList<Giangvien_GiaovuPDT> ListGVCantim = phongdaotaoDAO.TimsGiangvienTheoten(txtGiangvienCantim.getText());
						modelDSgiangvien.getDataVector().removeAllElements(); 
						Dulieucantim(ListGVCantim);

					}
					else if (cbTimkiem.getSelectedItem() == "Mã Giảng viên")
					{
						ArrayList<Giangvien_GiaovuPDT> ListGVCantim = phongdaotaoDAO.TimsGiangvienTheoMa(txtGiangvienCantim.getText());
						modelDSgiangvien.getDataVector().removeAllElements(); 
						Dulieucantim(ListGVCantim);
					}
					else if (cbTimkiem.getSelectedItem() == "")
					{
						Canhbao("Chọn phương thức cần tìm kiếm", txtGiangvienCantim);
					}
				}	
			}
		};
	}
	public void Dulieucantim (ArrayList<Giangvien_GiaovuPDT> list)
	{
		for(Giangvien_GiaovuPDT giangvien_GiaovuPDT : list)
		{

			modelDSgiangvien.addRow(new Object[] {
					giangvien_GiaovuPDT.getMa(),
					giangvien_GiaovuPDT.getTen(),
					giangvien_GiaovuPDT.getGiotinh(),
					giangvien_GiaovuPDT.getNgaysinh(),
					giangvien_GiaovuPDT.getSoDienthoai(),
					giangvien_GiaovuPDT.getDiachi(),
					giangvien_GiaovuPDT.getKhoa(),
					giangvien_GiaovuPDT.getTrinhdo()
			});
		}
	}

	private ActionListener btnXoa() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=tblDSgiangvien.getSelectedRow();

				if ( row==-1)
				{
					JOptionPane.showMessageDialog(null	, "Chọn giảng viên trước khi xóa");
				}
				else {
					String maGV =tblDSgiangvien.getValueAt(row, 0).toString();
					if(new PhongdaotaoDAO().XoaGiangvien(maGV)!=false) {

						if (new PhongdaotaoDAO().Xoataikhoan(maGV)!=false)
						{
							JOptionPane.showMessageDialog(null	, "Xóa giảng viên thành công");
							modelDSgiangvien.setRowCount(0);
							DanhsachGiangvien();;
						}
					}
				}
			}
		};
	}

	private boolean Validate() {


		String ma = txtMaGV.getText().trim();
		String ten = txtTenGV.getText().trim();
		String gioitinh = txtGioitinh.getText().trim();
		String ngaysinh= txtNgaysinh.getText().trim();
		String soDienthoai = txtSDT.getText().trim();
		String diachi = txtDiachi.getText().trim();
		String khoa = txtKhoa.getText().trim();
		String trinhdo = cbTrinhdo.getSelectedItem().toString().trim();

		if(!( ma.matches("^\\d{4}[G][V]\\d{4}")))
		{
			txtMaGV.requestFocus();
			Canhbao("Mã GV: Nhập đúng định dạng d{4}[G][V]\\d{4}", txtMaGV);
			return false;
		}
		if(!(ten.length() >= 2 && ten.matches("[a-zA-Z\\s]+" )))
		{
			txtTenGV.requestFocus();
			Canhbao("Tên GV: Nhập đúng định dạng trên 2 kí tự", txtTenGV);
			return false;
		}
		if(!( soDienthoai.matches("^\\d{10}")))
		{
			txtSDT.requestFocus();
			Canhbao("SDT: Nhập đúng định dạng 10 số", txtSDT);
			return false;
		}
		if(!(diachi.length() >= 2 && diachi.matches("[a-zA-Z0-9\\s]+" )) )
		{
			txtDiachi.requestFocus();
			Canhbao("Địa chỉ: Nhập đúng định dạng trên 2 kí tự", txtDiachi);
			return false;
		}
		if(!(khoa.length() >= 2 ))
		{
			txtKhoa.requestFocus();
			Canhbao("Khoa: Nhập đúng định dạng trên 2 kí tự", txtKhoa);
			return false;
		}
		return true;
	}

	private ActionListener btnThemGiangvien() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GD_ThemGiangvien();
				//			if(Validate()!=false)
				//			{
				//
				//				String ma = txtMaGV.getText();
				//				String ten = txtTenGV.getText();
				//				String gioitinh = txtGioitinh.getText();
				//				String ngaysinh= txtNgaysinh.getText();
				//				String soDienthoai = txtSDT.getText();
				//				String diachi = txtDiachi.getText();
				//				String khoa = txtKhoa.getText();
				//				String trinhdo = cbTrinhdo.getSelectedItem().toString().trim();
				//				if (ma.length()==0 || ten.length()==0|| gioitinh.length()==0||ngaysinh.length()==0||soDienthoai.length()==0||diachi.length()==0||khoa.length()==0||trinhdo.length()==0)
				//				{
				//					Canhbao("Điền đầy đủ thông tin trước khi nhật", txtMaGV);
				//				}
				//				else
				//				{
				//					PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();
				//					phongdaotaoDAO.themTaikhoan(ma, "123", "Giang vien");
				//					if (phongdaotaoDAO.themGiangvien(ma, ten, gioitinh, ngaysinh, soDienthoai, diachi, khoa, trinhdo))
				//					{
				//						JOptionPane.showMessageDialog(null	, "Thêm thành công");
				//						modelDSgiangvien.setRowCount(0);
				//						DanhsachGiangvien();
				//					}
				//				}
				//			}

			}
		};
	}
	public void DanhsachGiangvien() {
		ArrayList<Giangvien_GiaovuPDT> listQuanliGiangvien = new PhongdaotaoDAO().getDSGiangvien();

		for(Giangvien_GiaovuPDT gv : listQuanliGiangvien)
		{
			modelDSgiangvien.addRow(new Object[] {
					gv.getMa(),
					gv.getTen(),
					gv.getGiotinh(),
					gv.getNgaysinh(),
					gv.getSoDienthoai(),
					gv.getDiachi(),
					gv.getKhoa(),
					gv.getTrinhdo()
			});
		}
	}
}

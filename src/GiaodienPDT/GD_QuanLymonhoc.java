package GiaodienPDT;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.GiangvienDAO;
import DAO.LopHocphanDAO;
import DAO.PhongdaotaoDAO;
import Doituong.Monhoc;
import DoituongData.Lichday;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GD_QuanLymonhoc extends JPanel {
	private JTextField txtMamonhoc;
	private JTextField txtTenmonhoc;
	private JTextField txtSotinchi;
	private JTextField txtTenmonhoCantim;
	private JLabel lblCanhbao;
	private JComboBox cbmTimMon;


	JTable tblMonhoc;
	DefaultTableModel modelMonhoc;
	JScrollPane scrollMonhoc;

	/**
	 * Create the panel.
	 */
	public GD_QuanLymonhoc() {
		setLayout(null);

		JPanel panel_Chinh = new JPanel();
		panel_Chinh.setForeground(new Color(135, 206, 235));
		panel_Chinh.setBackground(new Color(245, 245, 245));
		panel_Chinh.setBounds(0, 0, 1010, 556);
		add(panel_Chinh);
		panel_Chinh.setLayout(null);

		JPanel panel_tabale = new JPanel();
		panel_tabale.setForeground(new Color(0, 0, 0));
		panel_tabale.setBackground(new Color(255, 255, 240));
		panel_tabale.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch m\u00F4n h\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_tabale.setBounds(10, 276, 791, 277);

		String [] tieude = {"Mã môn học","Tên môn học","Số tín chỉ"};
		modelMonhoc = new DefaultTableModel(tieude, 0);
		tblMonhoc = new JTable(modelMonhoc);
		scrollMonhoc = new JScrollPane(tblMonhoc);
		scrollMonhoc.setBounds(10, 18, 773, 243);
		scrollMonhoc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterMonhoc;
		sorterMonhoc = new TableRowSorter<TableModel>(tblMonhoc.getModel());
		tblMonhoc.addMouseListener(tblMonhoc());
		panel_tabale.setLayout(null);
		panel_tabale.add(scrollMonhoc);

		panel_Chinh.add(panel_tabale);


		JPanel panel_ChucNang = new JPanel();
		panel_ChucNang.setForeground(new Color(0, 0, 0));
		panel_ChucNang.setBackground(new Color(255, 255, 240));
		panel_ChucNang.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
		panel_ChucNang.setBounds(804, 276, 195, 277);
		panel_Chinh.add(panel_ChucNang);
		panel_ChucNang.setLayout(null);

		JButton btnThemmonhoc = new JButton("Thêm môn học");
		btnThemmonhoc.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\plus (1).png"));
		btnThemmonhoc.addActionListener(btnThemmonhoc());
		btnThemmonhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThemmonhoc.setBounds(10, 59, 175, 27);
		panel_ChucNang.add(btnThemmonhoc);

		JButton btnXoaMonhoc = new JButton("Xóa");
		btnXoaMonhoc.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\delete (1).png"));
		btnXoaMonhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoaMonhoc.setBounds(10, 107, 175, 27);
		btnXoaMonhoc.addActionListener(btnXoaMonhoc());
		panel_ChucNang.add(btnXoaMonhoc);

		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\refresh.png"));
		btnCapnhat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCapnhat.setBounds(10, 194, 175, 27);
		btnCapnhat.addActionListener(btnCapnhat());
		panel_ChucNang.add(btnCapnhat);

		JLabel lblChcNng = new JLabel("Chức năng");
		lblChcNng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChcNng.setBounds(44, 10, 93, 23);
		panel_ChucNang.add(lblChcNng);

		JButton btnChonmon = new JButton("Chọn môn học");
		btnChonmon.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\selection.png"));
		btnChonmon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChonmon.setBounds(10, 150, 175, 27);
		btnChonmon.addActionListener(btnChonmon());
		panel_ChucNang.add(btnChonmon);

		JButton btnInMonHoc = new JButton("In DSMH");
		btnInMonHoc.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\printer.png"));
		btnInMonHoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInMonHoc.setBounds(10, 240, 175, 27);
		btnInMonHoc.addActionListener(btnInMonHoc());
		panel_ChucNang.add(btnInMonHoc);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 24, 989, 248);
		panel_Chinh.add(panel);
		panel.setLayout(null);

		JLabel lblSotinchi = new JLabel("Số tín chỉ:");
		lblSotinchi.setBounds(669, 54, 98, 28);
		panel.add(lblSotinchi);
		lblSotinchi.setFont(new Font("Tahoma", Font.BOLD, 15));

		txtSotinchi = new JTextField();
		txtSotinchi.setBounds(669, 105, 145, 28);
		txtSotinchi.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(txtSotinchi);
		txtSotinchi.setColumns(10);

		JLabel lblTenmonhoc = new JLabel("Tên môn học:");
		lblTenmonhoc.setBounds(382, 54, 122, 28);
		panel.add(lblTenmonhoc);
		lblTenmonhoc.setFont(new Font("Tahoma", Font.BOLD, 15));

		txtTenmonhoc = new JTextField();
		txtTenmonhoc.setBounds(329, 105, 251, 28);
		txtTenmonhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(txtTenmonhoc);
		txtTenmonhoc.setColumns(10);

		JLabel lblMamonhoc = new JLabel("Mã môn học:");
		lblMamonhoc.setBounds(64, 54, 98, 28);
		panel.add(lblMamonhoc);
		lblMamonhoc.setFont(new Font("Tahoma", Font.BOLD, 15));

		txtMamonhoc = new JTextField();
		txtMamonhoc.setBounds(46, 105, 169, 28);
		txtMamonhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(txtMamonhoc);
		txtMamonhoc.setColumns(10);

		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\search.png"));
		btnTmKim.setBounds(636, 207, 139, 27);
		panel.add(btnTmKim);
		btnTmKim.addActionListener(btnTmKim());
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btnTailai = new JButton("Tải lại");
		btnTailai.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\reload2.png"));
		btnTailai.setBounds(816, 207, 163, 27);
		panel.add(btnTailai);
		btnTailai.setFont(new Font("Tahoma", Font.BOLD, 15));

		txtTenmonhoCantim = new JTextField();
		txtTenmonhoCantim.setBounds(347, 210, 233, 26);
		panel.add(txtTenmonhoCantim);
		txtTenmonhoCantim.setColumns(10);

		JLabel lblTimmonhoc = new JLabel("Tìm môn học theo ->");
		lblTimmonhoc.setBounds(46, 206, 163, 28);
		panel.add(lblTimmonhoc);
		lblTimmonhoc.setFont(new Font("Tahoma", Font.BOLD, 15));

		lblCanhbao = new JLabel("");
		lblCanhbao.setBounds(46, 161, 279, 27);
		panel.add(lblCanhbao);
		lblCanhbao.setForeground(Color.RED);
		lblCanhbao.setFont(new Font("Tahoma", Font.BOLD, 15));

		cbmTimMon = new JComboBox();
		cbmTimMon.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbmTimMon.setModel(new DefaultComboBoxModel(new String[] {"", "Tên môn", "Mã môn"}));
		cbmTimMon.setBounds(206, 212, 122, 21);
		panel.add(cbmTimMon);

		JLabel lblQunLMn = new JLabel("Quản lý môn học");
		lblQunLMn.setForeground(new Color(255, 0, 0));
		lblQunLMn.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQunLMn.setBounds(398, 0, 175, 19);
		panel_Chinh.add(lblQunLMn);
		btnTailai.addActionListener(btnTailai());
		DanhsachMonhoc();

	}
	private MouseListener tblMonhoc() {
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
				int row = tblMonhoc.getSelectedRow();
				txtMamonhoc.setText(tblMonhoc.getValueAt(row, 0).toString());
				txtTenmonhoc.setText(tblMonhoc.getValueAt(row, 1).toString());
				txtSotinchi.setText(tblMonhoc.getValueAt(row, 2).toString());
			}
		};
	}
	private ActionListener btnInMonHoc() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				System.out.println("Compiling Report Design ...");
//				try {
//					/**
//					 * Compile the report to a file name same as
//					 * the JRXML file name
//					 */
//					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLDKHP;" + "username=sa;password=sapassword");
//					File initialFile = new File("src/thongKe/DanhSachMonHoc.jrxml");
//					InputStream targetStream = new FileInputStream(initialFile);
//					JasperDesign jd = JRXmlLoader.load(targetStream);
//					JasperReport jr = JasperCompileManager.compileReport(jd);
//					Map<String, Object> parameters = new HashMap<String, Object>();
//					JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con);
//					JasperViewer.viewReport(jp,false);
//					JasperExportManager.exportReportToPdfFile(jp, "D:/QuanLyDKHP_V2/pdf/DanhSachMonHoc.pdf");
//					System.out.println("Done compiling!!! ...");
//				} catch (SQLException | JRException | IOException ex) {
//					ex.printStackTrace();
//				}
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
				String malop = txtMamonhoc.getText().toString();

				if ( malop.length()==0)
				{
					Canhbao("Chọn môn cần cập nhật", txtMamonhoc);
				}
				else {
					String ma = txtMamonhoc.getText();
					String tenMH = txtTenmonhoc.getText();
					String soTinchi = txtSotinchi.getText();
					if(new PhongdaotaoDAO().CapnhatMonhoc(ma, tenMH, soTinchi))
					{
						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
						modelMonhoc.setRowCount(0);
						DanhsachMonhoc();
						XoaTrang();
					}
				}

			}
		};
	}
	private ActionListener btnChonmon() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tblMonhoc.getSelectedRow();
				if ( row==-1)
				{
					JOptionPane.showMessageDialog(null	, "Chọn lớp trong danh sách");
				}
				else {

					txtMamonhoc.setText(tblMonhoc.getValueAt(row, 0).toString());
					txtTenmonhoc.setText(tblMonhoc.getValueAt(row, 1).toString());
					txtSotinchi.setText(tblMonhoc.getValueAt(row, 2).toString());
				}

			}
		};
	}
	private void XoaTrang()
	{
		txtTenmonhoCantim.setText("");
		txtMamonhoc.setText("");
		txtTenmonhoc.setText("");
		txtSotinchi.setText("");
		lblCanhbao.setText("");

	}
	private ActionListener btnTailai() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modelMonhoc.setRowCount(0);
				DanhsachMonhoc();
				XoaTrang();


			}
		};
	}
	private ActionListener btnTmKim() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String thongtintim = txtTenmonhoCantim.getText();
				if(thongtintim.length()==0 )
				{
					Canhbao("Điền thông tin tìm kiếm", txtTenmonhoCantim);
				}
				else
				{
					if( cbmTimMon.getSelectedItem() =="")
					{
						Canhbao("Chọn kiểu tìm kiếm", txtTenmonhoCantim);
					}
					else if ( cbmTimMon.getSelectedItem() =="Tên môn")
					{
						ArrayList<Monhoc> listmonhoc = new  PhongdaotaoDAO().TimsMonhocTen(txtTenmonhoCantim.getText());
						DulieuCantim(listmonhoc);
					}
					else if(cbmTimMon.getSelectedItem()=="Mã môn")
					{
						ArrayList<Monhoc> listmonhoc= new PhongdaotaoDAO().TimsMonhocMaMonhoc(txtTenmonhoCantim.getText());
						DulieuCantim(listmonhoc);
					}
				}
			}
		};
	}
	public void DulieuCantim (ArrayList<Monhoc> list)
	{
		modelMonhoc.setRowCount(0);
		for (Monhoc mh : list)
			modelMonhoc.addRow(new Object[] {
					mh.getMaMH(),
					mh.getTenMH(),
					mh.getSoTinchi()
			});
	}
	private ActionListener btnXoaMonhoc() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=tblMonhoc.getSelectedRow();
				if ( row==-1)
				{
					JOptionPane.showMessageDialog(null	, "Chọn lớp trước khi xóa");
				}
				else {
					String maMonhoc =tblMonhoc.getValueAt(row, 0).toString();

					if (new PhongdaotaoDAO().XoaMonhoc(maMonhoc)!=false)
					{
						JOptionPane.showMessageDialog(null	, "Xóa thành công");
						modelMonhoc.setRowCount(0);
						DanhsachMonhoc();
						XoaTrang();
					}
				}
			}
		};
	}
	private boolean Validate() {

		String maMH = txtMamonhoc.getText();
		String TenMH = txtTenmonhoc.getText();
		String Sotinchi = txtSotinchi.getText();
		if(!( maMH.length() >=2 ))
		{
			txtMamonhoc.requestFocus();
			Canhbao("Tên SV: Nhập đúng định dạng trên 2 kí tự", txtMamonhoc);
			return false;
		}
		if(!(TenMH.length() >= 2 ))
		{
			txtTenmonhoc.requestFocus();
			Canhbao("Địa chỉ: Nhập đúng định dạng trên 2 kí tự", txtTenmonhoc);
			return false;
		}

		if(!(Sotinchi.length() >= 1 && Sotinchi.matches("^\\d")))
		{
			txtSotinchi.requestFocus();
			Canhbao("SDT: Nhập đúng định dạng trên 0 kí tự số", txtSotinchi);
			return false;
		}
		return true;
	}

	private ActionListener btnThemmonhoc() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maMH = txtMamonhoc.getText();
				String TenMH = txtTenmonhoc.getText();
				String Sotinchi = txtSotinchi.getText();
				if(Validate()!=false) {
					if(new PhongdaotaoDAO().themMonhoc(maMH, TenMH, Sotinchi))
					{
						JOptionPane.showMessageDialog(null, "Thêm môn học thành công");
						modelMonhoc.setRowCount(0);
						DanhsachMonhoc();
						XoaTrang();
					}
					else
						JOptionPane.showMessageDialog(null, "Trùng mã");
				}
			}
		};
	}

	public void DanhsachMonhoc() {
		ArrayList<Monhoc> listMonhoc = new PhongdaotaoDAO().getDSSMonhoc();
		for(Monhoc mh: listMonhoc)
		{
			modelMonhoc.addRow(new Object[] {
					mh.getMaMH(),
					mh.getTenMH(),
					mh.getSoTinchi()
			});
		}
	}
}

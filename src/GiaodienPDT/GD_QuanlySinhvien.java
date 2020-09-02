package GiaodienPDT;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.PhongdaotaoDAO;
import Doituong.Sinhviens;
import DoituongData.Quanlylophocphan;
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
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class GD_QuanlySinhvien extends JPanel {
	private JTextField txtMaSV;
	private JTextField txtSinhvienCantim;
	private JTextField txtTenSV;
	private JComboBox<String> cbGioiTinh;
	private JTextField txtNgaysinh;
	private JTextField txtSDT;
	private JComboBox<String> cbTrangthai;
	private JTextField txtDiachi;
	private JComboBox cbTimkiem ;

	JTable tblDSSinhvien;
	DefaultTableModel modelDSSinhvien;
	JScrollPane scrollDSSinhvien;
	private JTextField txtMalop;
	private JLabel lblCanhbao ;

	PhongdaotaoDAO phongdaotaoDAO = new  PhongdaotaoDAO();

	/**
	 * Create the panel.
	 */
	public GD_QuanlySinhvien() {
		setLayout(null);

		JPanel panel_Thongtin = new JPanel();
		panel_Thongtin.setBackground(new Color(255, 255, 240));
		panel_Thongtin.setLayout(null);
		panel_Thongtin.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_Thongtin.setBounds(0, 20, 1004, 319);
		add(panel_Thongtin);

		JLabel lblMaSV = new JLabel("Mã SV:");
		lblMaSV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaSV.setBounds(44, 24, 60, 25);
		panel_Thongtin.add(lblMaSV);

		txtMaSV = new JTextField();
		txtMaSV.setIgnoreRepaint(true);
		txtMaSV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMaSV.setColumns(10);
		txtMaSV.setBounds(208, 22, 185, 30);
		panel_Thongtin.add(txtMaSV);

		JLabel lblSDT = new JLabel("SĐT:");
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSDT.setBounds(549, 187, 62, 20);
		panel_Thongtin.add(lblSDT);

		JLabel lblNgaysinh = new JLabel("Ngày Sinh:");
		lblNgaysinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgaysinh.setBounds(42, 211, 96, 20);
		panel_Thongtin.add(lblNgaysinh);

		JLabel lblGioitinh = new JLabel("Giới Tính:");
		lblGioitinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGioitinh.setBounds(42, 153, 85, 20);
		panel_Thongtin.add(lblGioitinh);

		JLabel lblDiachi = new JLabel("Địa Chỉ:");
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiachi.setBounds(549, 135, 73, 25);
		panel_Thongtin.add(lblDiachi);

		JLabel lblTrangthai = new JLabel("Trạng thái:");
		lblTrangthai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrangthai.setBounds(547, 76, 93, 20);
		panel_Thongtin.add(lblTrangthai);

		txtSinhvienCantim = new JTextField();
		txtSinhvienCantim.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSinhvienCantim.setColumns(10);
		txtSinhvienCantim.setBounds(333, 282, 332, 25);
		panel_Thongtin.add(txtSinhvienCantim);

		JButton btnTimkiem = new JButton("Tìm");
		btnTimkiem.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\search.png"));
		btnTimkiem.addActionListener(btnTimkiem());
		btnTimkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimkiem.setBounds(679, 282, 138, 25);
		panel_Thongtin.add(btnTimkiem);

		txtTenSV = new JTextField();
		txtTenSV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTenSV.setColumns(10);
		txtTenSV.setBounds(208, 85, 185, 30);
		panel_Thongtin.add(txtTenSV);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbGioiTinh.setBounds(208, 149, 185, 30);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		panel_Thongtin.add(cbGioiTinh);

		txtNgaysinh = new JTextField();
		txtNgaysinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNgaysinh.setColumns(10);
		txtNgaysinh.setBounds(208, 207, 185, 30);
		panel_Thongtin.add(txtNgaysinh);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSDT.setColumns(10);
		txtSDT.setBounds(705, 183, 185, 30);
		panel_Thongtin.add(txtSDT);

		cbTrangthai = new JComboBox<String>();
		cbTrangthai.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbTrangthai.setBounds(705, 72, 185, 30);
		cbTrangthai.addItem("Đang học");
		cbTrangthai.addItem("Ngưng học");
		panel_Thongtin.add(cbTrangthai);

		txtDiachi = new JTextField();
		txtDiachi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDiachi.setColumns(10);
		txtDiachi.setBounds(705, 133, 185, 30);
		panel_Thongtin.add(txtDiachi);

		JLabel lblTenSv = new JLabel("Tên SV:");
		lblTenSv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenSv.setBounds(42, 89, 62, 20);
		panel_Thongtin.add(lblTenSv);

		JLabel lblMalop = new JLabel("Mã lớp:");
		lblMalop.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMalop.setBounds(549, 29, 72, 20);
		panel_Thongtin.add(lblMalop);

		txtMalop = new JTextField();
		txtMalop.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMalop.setColumns(10);
		txtMalop.setBounds(705, 22, 185, 30);
		panel_Thongtin.add(txtMalop);

		JButton btnTailai = new JButton("Tải lại");
		btnTailai.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\reload2.png"));
		btnTailai.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTailai.setBounds(827, 282, 143, 25);
		btnTailai.addActionListener(btnTailai());
		panel_Thongtin.add(btnTailai);

		cbTimkiem = new JComboBox();
		cbTimkiem.setModel(new DefaultComboBoxModel(new String[] {"", "Tên sinh viên", "Mã sinh viên"}));
		cbTimkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbTimkiem.setBounds(169, 282, 154, 25);

		panel_Thongtin.add(cbTimkiem);

		JLabel lblTmKimTheo = new JLabel("Tìm kiếm theo:");
		lblTmKimTheo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTmKimTheo.setBounds(44, 284, 115, 20);
		panel_Thongtin.add(lblTmKimTheo);

		lblCanhbao = new JLabel("");
		lblCanhbao.setForeground(Color.RED);
		lblCanhbao.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCanhbao.setBounds(295, 247, 625, 25);
		panel_Thongtin.add(lblCanhbao);

		JPanel panel_table = new JPanel();
		panel_table.setBackground(new Color(255, 255, 240));
		panel_table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_table.setBounds(0, 340, 814, 282);

		String[] tieude = {"Mã SV", " Tên SV","Giới tính","Ngày sinh","SDT","Địa chỉ","Mã lớp","Trạng thái"};

		modelDSSinhvien = new DefaultTableModel(tieude, 0);
		tblDSSinhvien = new JTable(modelDSSinhvien);
		scrollDSSinhvien = new JScrollPane(tblDSSinhvien);
		scrollDSSinhvien.setBounds(10, 10, 794, 262);
		scrollDSSinhvien.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterGiangvien;
		sorterGiangvien = new TableRowSorter<TableModel>(tblDSSinhvien.getModel());
		tblDSSinhvien.addMouseListener(tblDSSinhvien());
		panel_table.setLayout(null);
		panel_table.add(scrollDSSinhvien);
		DanhsachSinhvien();

		add(panel_table);

		JPanel panel_Chucnang = new JPanel();
		panel_Chucnang.setBackground(new Color(255, 255, 240));
		panel_Chucnang.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_Chucnang.setBounds(816, 340, 188, 282);
		add(panel_Chucnang);
		panel_Chucnang.setLayout(null);

		JLabel lblChucnang = new JLabel("Chức năng");
		lblChucnang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChucnang.setBounds(51, 10, 103, 25);
		panel_Chucnang.add(lblChucnang);

		JButton btnThemSinhvien = new JButton("Thêm sinh viên");
		btnThemSinhvien.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\plus (1).png"));
		btnThemSinhvien.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemSinhvien.setBounds(10, 62, 156, 32);
		btnThemSinhvien.addActionListener(btnThemSinhvien());
		panel_Chucnang.add(btnThemSinhvien);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\delete (1).png"));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setBounds(10, 104, 156, 32);
		btnXoa.addActionListener(btnXoa());
		panel_Chucnang.add(btnXoa);

		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\refresh.png"));
		btnCapnhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapnhat.setBounds(10, 188, 156, 32);
		btnCapnhat.addActionListener(btnCapnhat());
		panel_Chucnang.add(btnCapnhat);

		JButton btnChonSinhvien = new JButton("Chọn sinh viên");
		btnChonSinhvien.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\selection.png"));
		btnChonSinhvien.addActionListener(btnChonSinhvien());
		btnChonSinhvien.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChonSinhvien.setBounds(10, 146, 156, 32);
		panel_Chucnang.add(btnChonSinhvien);

		JButton btnIndanhsach = new JButton("IN");
		btnIndanhsach.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\printer.png"));
		btnIndanhsach.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIndanhsach.setBounds(10, 230, 156, 32);
		panel_Chucnang.add(btnIndanhsach);
		btnIndanhsach.addActionListener(btnIndanhsach());

		JLabel lblQunLSinh = new JLabel("Quản lý sinh viên");
		lblQunLSinh.setForeground(Color.RED);
		lblQunLSinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQunLSinh.setBounds(415, 0, 145, 19);
		add(lblQunLSinh);
	}
	private MouseListener tblDSSinhvien() {
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
				int row=tblDSSinhvien.getSelectedRow();

				txtMaSV.setText(tblDSSinhvien.getValueAt(row, 0).toString());
				txtTenSV.setText(tblDSSinhvien.getValueAt(row, 1).toString());
				cbGioiTinh.setSelectedItem(tblDSSinhvien.getValueAt(row, 2).toString().trim());
				txtNgaysinh.setText(tblDSSinhvien.getValueAt(row, 3).toString());
				txtSDT.setText(tblDSSinhvien.getValueAt(row, 4).toString());
				txtDiachi.setText(tblDSSinhvien.getValueAt(row, 5).toString());
				txtMalop.setText(tblDSSinhvien.getValueAt(row, 6).toString());
				cbTrangthai.setSelectedItem(tblDSSinhvien.getValueAt(row, 7).toString());
			}
		};
	}
	private ActionListener btnIndanhsach() {
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
//					File initialFile = new File("src/thongKe/ThongTinSinhVien.jrxml");
//					InputStream targetStream = new FileInputStream(initialFile);
//					JasperDesign jd = JRXmlLoader.load(targetStream);
//					//Build a new query
//					String theQuery = "select [MaSV],[TenSV],[GioiTinh],[NgaySinh],[SDT],[DiaChi],sv.[MaLop],[TrangThai],[TenLop],[NienKhoa],[TenKhoa]" + 
//							" from [dbo].[SinhVien] as sv join [dbo].[Lop] as l on sv.[MaLop]=l.[MaLop]" + 
//							" join [dbo].[Khoa] as k on l.[MaKhoa]=k.[MaKhoa]" + 
//							" where sv.MaSV = '" + txtMaSV.getText().toString().trim() + "'";
//
//					// update the data query
//					JRDesignQuery newQuery = new JRDesignQuery();
//					newQuery.setText(theQuery);
//					jd.setQuery(newQuery);
//
//					JasperReport jr = JasperCompileManager.compileReport(jd);
//					Map<String, Object> parameters = new HashMap<String, Object>();
//					JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con);
//					JasperViewer.viewReport(jp,false);
//					JasperExportManager.exportReportToPdfFile(jp, "D:/QuanLyDKHP_V2/pdf/ThongTinSinhVien.docx");
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
				String maSV = txtMaSV.getText().toString();

				if ( maSV.length()==0)
				{
					Canhbao("Chọn sinh viên cần cập nhật", txtMaSV);
				}
				else {

					String ma = txtMaSV.getText();
					String ten = txtTenSV.getText();
					String giotinh = cbGioiTinh.getSelectedItem().toString().trim();
					String ngaysinh= txtNgaysinh.getText();
					String soDienthoai = txtSDT.getText();
					String diachi = txtDiachi.getText();
					String malop = txtMalop.getText();
					String trangthai = cbTrangthai.getSelectedItem().toString().trim();

					PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();
					if (phongdaotaoDAO.CapnhatSinhvien(ma, ten, giotinh, ngaysinh, soDienthoai, diachi, malop, trangthai))
					{
						JOptionPane.showMessageDialog(null	, "Cập nhật thành công");
						modelDSSinhvien.setRowCount(0);
						DanhsachSinhvien();
					}
				}
			}
		};
	}

	private ActionListener btnChonSinhvien() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=tblDSSinhvien.getSelectedRow();


				if ( row==-1)
				{
					JOptionPane.showMessageDialog(null	, "Chọn sinh viên trong danh sách");
				}
				else {

					txtMaSV.setText(tblDSSinhvien.getValueAt(row, 0).toString());
					txtTenSV.setText(tblDSSinhvien.getValueAt(row, 1).toString());
					cbGioiTinh.setSelectedItem(tblDSSinhvien.getValueAt(row, 2).toString().trim());
					txtNgaysinh.setText(tblDSSinhvien.getValueAt(row, 3).toString());
					txtSDT.setText(tblDSSinhvien.getValueAt(row, 4).toString());
					txtDiachi.setText(tblDSSinhvien.getValueAt(row, 5).toString());
					txtMalop.setText(tblDSSinhvien.getValueAt(row, 6).toString());
					cbTrangthai.setSelectedItem(tblDSSinhvien.getValueAt(row, 7).toString());
				}

			}
		};
	}
	private void Tailai()
	{
		txtDiachi.setText("");
		cbGioiTinh.setSelectedIndex(0);
		txtMaSV.setText("");
		txtMalop.setText("");
		txtNgaysinh.setText("");
		txtSDT.setText("");
		txtSinhvienCantim.setText("");
		txtTenSV.setText("");
		cbTrangthai.setSelectedIndex(0);
		Canhbao("", txtMaSV);

	}

	private ActionListener btnTailai() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Tailai();
				DanhsachSinhvien();
			}
		};
	}


	private ActionListener btnTimkiem() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String Cantim= txtSinhvienCantim.getText();
				if(Cantim.equals(""))
				{
					Canhbao("Điền thông tin cần tìm. Theo đúng cách đẫ chọn", txtSinhvienCantim);
				}
				else
				{

					if (cbTimkiem.getSelectedItem() == "Tên sinh viên")	
					{
						ArrayList<Sinhviens> DSSVTimTheoTen =phongdaotaoDAO.TimsinhvienTheoten(txtSinhvienCantim.getText());
						DulieuBangcCantim(DSSVTimTheoTen);
					}
					else if (cbTimkiem.getSelectedItem() == "Mã sinh viên")
					{
						ArrayList<Sinhviens> DSSVTimTheoMa =phongdaotaoDAO.TimsinhvienTheoMa(txtSinhvienCantim.getText());
						DulieuBangcCantim(DSSVTimTheoMa);
					}
					else if (cbTimkiem.getSelectedItem() == "")
					{
						Canhbao("Chọn phương thức cần tìm kiếm", txtSinhvienCantim);
					}
				}

			}
		};
	}

	private void DulieuBangcCantim(ArrayList<Sinhviens> list)
	{
		modelDSSinhvien.getDataVector().removeAllElements(); // xóa tất cả các dòng trong tabel
		for (Sinhviens sinhviens : list)
		{

			modelDSSinhvien.addRow(new Object[] {
					sinhviens.getMa(),
					sinhviens.getTen(),
					sinhviens.getGiotinh(),
					sinhviens.getNgaysinh(),
					sinhviens.getSoDienthoai(),
					sinhviens.getDiachi(),
					sinhviens.getMalop(),
					sinhviens.getTrangthai()
			});
		}
	}

	private ActionListener btnXoa() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=tblDSSinhvien.getSelectedRow();

				if ( row==-1)
				{
					JOptionPane.showMessageDialog(null	, "Chọn Sinh viên trước khi xóa");
				}
				else {
					String maSV =tblDSSinhvien.getValueAt(row, 0).toString();
					if(new PhongdaotaoDAO().XoaSinhvien(maSV)!=false) {

						if (new PhongdaotaoDAO().Xoataikhoan(maSV)!=false)
						{
							JOptionPane.showMessageDialog(null	, "Xóa Sinh viên thành công");
							modelDSSinhvien.setRowCount(0);
							DanhsachSinhvien();
						}
					}
				}
			}
		};
	}
	private boolean Validate() {

		String ma = txtMaSV.getText().trim();
		String ten = txtTenSV.getText().trim();
		String giotinh = cbGioiTinh.getSelectedItem().toString().trim();
		String ngaysinh= txtNgaysinh.getText().trim();
		String soDienthoai = txtSDT.getText().trim();
		String diachi = txtDiachi.getText().trim();
		String malop = txtMalop.getText().trim();
		String trangthai = cbTrangthai.getSelectedItem().toString().trim();

		if(!( ma.matches("^\\d{2}[S][V]\\d{6}")))
		{
			txtMaSV.requestFocus();
			Canhbao("Mã SV: Nhập đúng định dạng 2 số 2 chữ SV 6 số cuối", txtMaSV);
			return false;
		}

		if(!( ten.length() >=2 ))
		{
			txtTenSV.requestFocus();
			Canhbao("Tên SV: Nhập đúng định dạng trên 2 kí tự", txtTenSV);
			return false;
		}
		if(!(ngaysinh.length() >= 2))
		{
			txtNgaysinh.requestFocus();
			Canhbao("Ngày sinh: Nhập đúng định dạng trên 2 kí tự", txtNgaysinh);
			return false;
		}
		if(!(soDienthoai.length() >= 2 && soDienthoai.matches("^\\d{10}")))
		{
			txtSDT.requestFocus();
			Canhbao("SDT: Nhập đúng định dạng trên 10 kí tự số", txtSDT);
			return false;
		}
		if(!(diachi.length() >= 2 ))
		{
			txtDiachi.requestFocus();
			Canhbao("Địa chỉ: Nhập đúng định dạng trên 2 kí tự", txtDiachi);
			return false;
		}
		if(!(malop.length() >= 2 ) )
		{
			txtMalop.requestFocus();
			Canhbao("Lớp học: Nhập đúng định dạng trên 2 kí tự", txtMalop);
			return false;
		}
		return true;
	}


	private ActionListener btnThemSinhvien() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new GD_ThemSinhVien();
				//				try {
				//
				//					if(Validate()!=false)
				//					{
				//						String ma = txtMaSV.getText();
				//						String ten = txtTenSV.getText();
				//						String giotinh = txtGioitinh.getText();
				//						String ngaysinh= txtNgaysinh.getText();
				//						String soDienthoai = txtSDT.getText();
				//						String diachi = txtDiachi.getText();
				//						String malop = txtMalop.getText();
				//						String trangthai = txtTrangthai.getText();
				//
				//						PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();
				//						phongdaotaoDAO.themTaikhoan(ma, "123", "Sinh vien");
				//						if (phongdaotaoDAO.themSinhvien(ma, ten, giotinh, ngaysinh, soDienthoai, diachi, malop, trangthai)!=false)
				//						{
				//							JOptionPane.showMessageDialog(null	, "Thêm thành công");
				//							modelDSSinhvien.setRowCount(0);
				//							DanhsachSinhvien();
				//						}
				//						else
				//							JOptionPane.showMessageDialog(null, "Trùng mã");
				//					}
				//				} catch (Exception e) {
				//					// TODO: handle exception
				//				}
			}
		};
	}

	public void DanhsachSinhvien() {
		ArrayList<Sinhviens> listQuanlySinhvien = new PhongdaotaoDAO().getDSSinhvien();

		for(Sinhviens sv : listQuanlySinhvien)
		{
			modelDSSinhvien.addRow(new Object[] {
					sv.getMa(),
					sv.getTen(),
					sv.getGiotinh(),
					sv.getNgaysinh(),
					sv.getSoDienthoai(),
					sv.getDiachi(),
					sv.getMalop(),
					sv.getTrangthai()
			});
		}
	}
}

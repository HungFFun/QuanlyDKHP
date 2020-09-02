package GiaodienPDT;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.PhongdaotaoDAO;
import Doituong.LophocphanMoi;
import Doituong.Monhoc;
import Doituong.Sinhviens;
import DoituongData.Quanlylophocphan;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
////import net.sf.jasperreports.engine.JRException;
////import net.sf.jasperreports.engine.JasperCompileManager;
////import net.sf.jasperreports.engine.JasperExportManager;
////import net.sf.jasperreports.engine.JasperFillManager;
////import net.sf.jasperreports.engine.JasperPrint;
////import net.sf.jasperreports.engine.JasperReport;
////import net.sf.jasperreports.engine.design.JRDesignQuery;
////import net.sf.jasperreports.engine.design.JasperDesign;
////import net.sf.jasperreports.engine.xml.JRXmlLoader;
////import net.sf.jasperreports.view.JasperViewer;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.imageio.IIOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class GD_QuanlyLopHocphan extends JPanel {
	private JTextField txtMalop;
	private JComboBox<String> cbMonHoc;
	private JTextField txtThu;
	private JTextField txtPhonghoc;
	private JTextField txtNgayketthuc;
	private JTextField txtTiethoc;
	private JTextField txtNgaybatdau;
	JTable tblDSLopHP;
	DefaultTableModel modelDSLopHP;
	JScrollPane scrollDSLopHP;
	private JTextField txtMaLHPcantim;
	private JTextField txtTenGV;
	private JLabel lblCanhbao;
	private JTextField txtSoluongSV;
	private JTextField txtHocki;
	private JTextField txtNamhoc;
	private JComboBox cbTimkiem;

	/**
	 * Create the panel.
	 */
	public GD_QuanlyLopHocphan() {
		setBackground(new Color(255, 250, 240));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		panel.setBounds(1, 21, 1000, 286);
		add(panel);

		JLabel lblMalop = new JLabel("Mã Lớp:");
		lblMalop.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMalop.setBounds(71, 13, 72, 25);
		panel.add(lblMalop);

		txtMalop = new JTextField();
		txtMalop.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMalop.setColumns(10);
		txtMalop.setBounds(203, 13, 185, 25);
		panel.add(txtMalop);

		JLabel lblMamon = new JLabel("Môn Học:");
		lblMamon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMamon.setBounds(71, 45, 84, 35);
		panel.add(lblMamon);

		
		cbMonHoc = new JComboBox<String>();
		cbMonHoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbMonHoc.setBounds(202, 50, 185, 25);
		ThemMonHoc();
		panel.add(cbMonHoc);

		JLabel lblNgaybatdau = new JLabel("Ngày Bắt Đầu:");
		lblNgaybatdau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgaybatdau.setBounds(549, 127, 117, 35);
		panel.add(lblNgaybatdau);

		JLabel lblTiethoc = new JLabel("Tiết:");
		lblTiethoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTiethoc.setBounds(767, 13, 50, 25);
		panel.add(lblTiethoc);

		JLabel lblNgayketthuc = new JLabel("Ngày Kết Thúc:");
		lblNgayketthuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayketthuc.setBounds(549, 164, 117, 35);
		panel.add(lblNgayketthuc);

		JLabel lblPhonghoc = new JLabel("Phòng Học:");
		lblPhonghoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhonghoc.setBounds(71, 134, 101, 20);
		panel.add(lblPhonghoc);

		txtThu = new JTextField();
		txtThu.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtThu.setColumns(10);
		txtThu.setBounds(685, 13, 72, 25);
		panel.add(txtThu);

		txtPhonghoc = new JTextField();
		txtPhonghoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPhonghoc.setColumns(10);
		txtPhonghoc.setBounds(203, 130, 184, 25);
		panel.add(txtPhonghoc);

		txtNgayketthuc = new JTextField();
		txtNgayketthuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNgayketthuc.setColumns(10);
		txtNgayketthuc.setBounds(686, 168, 210, 28);
		panel.add(txtNgayketthuc);

		txtTiethoc = new JTextField();
		txtTiethoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTiethoc.setColumns(10);
		txtTiethoc.setBounds(812, 13, 84, 25);
		panel.add(txtTiethoc);

		txtNgaybatdau = new JTextField();
		txtNgaybatdau.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNgaybatdau.setColumns(10);
		txtNgaybatdau.setBounds(685, 131, 211, 28);
		panel.add(txtNgaybatdau);

		JLabel lblThu = new JLabel("Thứ:");
		lblThu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThu.setBounds(549, 14, 66, 22);
		panel.add(lblThu);

		JLabel lblTenlophocphanCantim = new JLabel("Tìm lớp học phần theo  -->");
		lblTenlophocphanCantim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenlophocphanCantim.setBounds(22, 253, 206, 23);
		panel.add(lblTenlophocphanCantim);

		txtMaLHPcantim = new JTextField();
		txtMaLHPcantim.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtMaLHPcantim.setBounds(398, 253, 266, 23);
		panel.add(txtMaLHPcantim);
		txtMaLHPcantim.setColumns(10);

		JButton btnTimKim = new JButton("Tìm kiếm");
		btnTimKim.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\search.png"));
		btnTimKim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTimKim.setBounds(685, 253, 148, 24);
		btnTimKim.addActionListener(btnTimKim());
		panel.add(btnTimKim);

		JButton btnTailai = new JButton("Tải lại");
		btnTailai.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\reload2.png"));
		btnTailai.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTailai.setBounds(843, 253, 133, 24);
		btnTailai.addActionListener(btnTailai());
		panel.add(btnTailai);

		JLabel lblTenGv = new JLabel("Tên GV:");
		lblTenGv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenGv.setBounds(71, 89, 84, 35);
		panel.add(lblTenGv);

		txtTenGV = new JTextField();
		txtTenGV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTenGV.setColumns(10);
		txtTenGV.setBounds(203, 91, 183, 25);
		panel.add(txtTenGV);

		lblCanhbao = new JLabel("");
		lblCanhbao.setForeground(Color.RED);
		lblCanhbao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCanhbao.setBounds(49, 218, 489, 25);
		panel.add(lblCanhbao);

		JLabel lblSoluongSV = new JLabel("Số lượng SV:");
		lblSoluongSV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoluongSV.setBounds(71, 171, 101, 20);
		panel.add(lblSoluongSV);

		JLabel lblHocki = new JLabel("Học kì:");
		lblHocki.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHocki.setBounds(547, 51, 84, 20);
		panel.add(lblHocki);

		JLabel lblNamhoc = new JLabel("Năm học:");
		lblNamhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNamhoc.setBounds(549, 97, 84, 20);
		panel.add(lblNamhoc);

		txtSoluongSV = new JTextField();
		txtSoluongSV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSoluongSV.setColumns(10);
		txtSoluongSV.setBounds(202, 174, 184, 25);
		panel.add(txtSoluongSV);

		txtHocki = new JTextField();
		txtHocki.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtHocki.setColumns(10);
		txtHocki.setBounds(685, 49, 211, 28);
		panel.add(txtHocki);

		txtNamhoc = new JTextField();
		txtNamhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNamhoc.setColumns(10);
		txtNamhoc.setBounds(685, 93, 211, 28);
		panel.add(txtNamhoc);

		cbTimkiem = new JComboBox();
		cbTimkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbTimkiem.setModel(new DefaultComboBoxModel(new String[] {"", "Tên lớp học", "Mã lớp học", "Tên giảng viên", "Mã giảng viên"}));
		cbTimkiem.setBounds(226, 253, 162, 24);
		panel.add(cbTimkiem);

		JPanel panel_table = new JPanel();
		panel_table.setBackground(new Color(255, 255, 240));
		panel_table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
		panel_table.setBounds(1, 309, 835, 297);


		String[] tieude = {"Mã LHP", "Môn học", "Giảng Viên","Thứ","Tiết học","Phòng học","Số lượng SV","Học kì","Năm học","Ngày bắt đầu","Ngày kết thúc"};

		modelDSLopHP = new DefaultTableModel(tieude, 0);
		tblDSLopHP = new JTable(modelDSLopHP);
		tblDSLopHP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollDSLopHP = new JScrollPane(tblDSLopHP);
		scrollDSLopHP.setFont(new Font("Tahoma", Font.BOLD, 10));
		scrollDSLopHP.setBounds(10, 10, 815, 277);
		scrollDSLopHP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterKhachhang;
		sorterKhachhang = new TableRowSorter<TableModel>(tblDSLopHP.getModel());
		tblDSLopHP.addMouseListener(tblDSLopHP());
		panel_table.setLayout(null);
		panel_table.add(scrollDSLopHP);

		add(panel_table);

		DanhsachLophocphan();

		JPanel panel_Chucnang = new JPanel();
		panel_Chucnang.setBackground(new Color(255, 255, 240));
		panel_Chucnang.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
		panel_Chucnang.setBounds(840, 309, 171, 297);
		add(panel_Chucnang);
		panel_Chucnang.setLayout(null);

		JLabel lblChucnang = new JLabel("CHỨC NĂNG");
		lblChucnang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChucnang.setBounds(33, 10, 102, 28);
		panel_Chucnang.add(lblChucnang);

		JButton btnTaolophocphan = new JButton("Tạo lớp");
		btnTaolophocphan.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\plus (1).png"));
		btnTaolophocphan.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaolophocphan.setBounds(10, 66, 151, 28);
		btnTaolophocphan.addActionListener(btnTaolophocphan());
		panel_Chucnang.add(btnTaolophocphan);

		JButton btnXoalophocphan = new JButton("Xóa lớp");
		btnXoalophocphan.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\delete (1).png"));
		btnXoalophocphan.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoalophocphan.setBounds(10, 111, 151, 28);
		btnXoalophocphan.addActionListener(btnXoalophocphan());
		panel_Chucnang.add(btnXoalophocphan);

		JButton btncapnhat = new JButton("Cập nhật ");
		btncapnhat.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\refresh.png"));
		btncapnhat.addActionListener(btncapnhat());
		btncapnhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btncapnhat.setBounds(10, 187, 151, 28);
		panel_Chucnang.add(btncapnhat);

		JButton btnChonLHP = new JButton("Chọn lớp");
		btnChonLHP.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\selection.png"));
		btnChonLHP.addActionListener(btnChonLHP());
		btnChonLHP.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChonLHP.setBounds(10, 149, 151, 28);
		panel_Chucnang.add(btnChonLHP);
		
		JButton btnIn = new JButton("In lớp đã chọn");
		btnIn.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\printer.png"));
		btnIn.addActionListener(btnIn());
		btnIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIn.setBounds(10, 225, 151, 28);
		panel_Chucnang.add(btnIn);


		JLabel lblQunLLp = new JLabel("Quản lý lớp học phần");
		lblQunLLp.setForeground(Color.RED);
		lblQunLLp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQunLLp.setBounds(382, -2, 186, 24);
		add(lblQunLLp);

	}
	private void ThemMonHoc() {
		// TODO Auto-generated method stub
		PhongdaotaoDAO pdt = new PhongdaotaoDAO();
		List<Monhoc> listMonHoc = pdt.getDSSMonhoc();
		listMonHoc.forEach(x -> cbMonHoc.addItem(x.getTenMH().toString().trim()));
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
				int row=tblDSLopHP.getSelectedRow();
				txtMalop.setText(tblDSLopHP.getValueAt(row, 0).toString());
				cbMonHoc.setSelectedItem(tblDSLopHP.getValueAt(row, 1).toString());
				txtTenGV.setText(tblDSLopHP.getValueAt(row, 2).toString());
				txtThu.setText(tblDSLopHP.getValueAt(row, 3).toString());
				txtTiethoc.setText(tblDSLopHP.getValueAt(row, 4).toString());
				txtPhonghoc.setText(tblDSLopHP.getValueAt(row, 5).toString());
				txtSoluongSV.setText(tblDSLopHP.getValueAt(row, 6).toString());
				txtHocki.setText(tblDSLopHP.getValueAt(row, 7).toString());
				txtNamhoc.setText(tblDSLopHP.getValueAt(row, 8).toString());
				txtNgaybatdau.setText(tblDSLopHP.getValueAt(row, 9).toString());
				txtNgayketthuc.setText(tblDSLopHP.getValueAt(row, 10).toString());
			}
		};
	}

	private ActionListener btnIn() {
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
//					File initialFile = new File("src/thongKe/DanhSachLopHocPhan.jrxml");
//				    InputStream targetStream = new FileInputStream(initialFile);
//					JasperDesign jd = JRXmlLoader.load(targetStream);
//					//Build a new query
//					String theQuery = "select lhp.[MaLHP],[Hocki],[NamHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu],gv.[TenGV],sv.[MaSV],[TenSV],sv.[GioiTinh],sv.[NgaySinh],[TenLop],[TenMonHoc],[SoTinChi]" + 
//							" from [dbo].[GiangVien_PDT] as gv join [dbo].[LopHocPhan] as lhp on gv.[MaGV]=lhp.[MaGV]" + 
//							" join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH" + 
//							" join [dbo].[DSLHP] as dslhp on dslhp.MaLHP=lhp.MaLHP" + 
//							" join [dbo].[Sinhvien] as sv on sv.MaSV=dslhp.MaSV" + 
//							" join [dbo].[Lop] as l on l.[MaLop]=sv.[MaLop]" + 
//							" where lhp.MaLHP = '" + txtMalop.getText().toString().trim() + "'";
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
//					JasperExportManager.exportReportToPdfFile(jp, "D:/QuanLyDKHP_V2/pdf/DanhSachLopHocPhan.pdf");
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

	private ActionListener btncapnhat() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				String maLOp =txtMalop.getText().toString();

				if ( maLOp.length()==0)
				{
					Canhbao("Chọn lớp cập cần cập nhật", txtMalop);
				}
				else {
					String maLHP = txtMalop.getText();
					String tenGV =txtTenGV.getText();
					String tenMonhoc = cbMonHoc.getSelectedItem().toString().trim();
					String maPhonghoc= txtPhonghoc.getText();
					String hocKi = txtHocki.getText();
					String namhoc= txtNamhoc.getText();
					String soluongSV= txtSoluongSV.getText();
					String tietday = txtTiethoc.getText();
					String thu = txtThu.getText();
					String ngayBatdau= txtNgaybatdau.getText();
					String ngatKetthuc = txtNgayketthuc.getText();


					PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();
					String maGV = phongdaotaoDAO.MaGiangvien(tenGV);
					String maMH = phongdaotaoDAO.MaMonhoc(tenMonhoc);

					if (phongdaotaoDAO.CapnhatLophocphan(maLHP, maGV, maMH, maPhonghoc, hocKi, namhoc, soluongSV, ngayBatdau, ngatKetthuc, tietday, thu) )
					{
						JOptionPane.showMessageDialog(null	, "Cập nhật thành công");
						modelDSLopHP.setRowCount(0);
						tailai();
						DanhsachLophocphan();

					}

				}
			}
		};
	}

	private ActionListener btnChonLHP() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=tblDSLopHP.getSelectedRow();

				if ( row==-1)
				{
					JOptionPane.showMessageDialog(null	, "Chọn lớp trên danh sách");
				}
				else {
					txtMalop.setText(tblDSLopHP.getValueAt(row, 0).toString());
					cbMonHoc.setSelectedItem(tblDSLopHP.getValueAt(row, 1).toString());
					txtTenGV.setText(tblDSLopHP.getValueAt(row, 2).toString());
					txtThu.setText(tblDSLopHP.getValueAt(row, 3).toString());
					txtTiethoc.setText(tblDSLopHP.getValueAt(row, 4).toString());
					txtPhonghoc.setText(tblDSLopHP.getValueAt(row, 5).toString());
					txtSoluongSV.setText(tblDSLopHP.getValueAt(row, 6).toString());
					txtHocki.setText(tblDSLopHP.getValueAt(row, 7).toString());
					txtNamhoc.setText(tblDSLopHP.getValueAt(row, 8).toString());
					txtNgaybatdau.setText(tblDSLopHP.getValueAt(row, 9).toString());
					txtNgayketthuc.setText(tblDSLopHP.getValueAt(row, 10).toString());
				}
			}
		};
	}

	private void tailai()
	{

		txtMaLHPcantim.setText("");
		txtMalop.setText("");
		cbMonHoc.setSelectedIndex(0);
		txtNgaybatdau.setText("");
		txtNgayketthuc.setText("");
		txtPhonghoc.setText("");
		txtThu.setText("");
		txtTiethoc.setText("");
		txtTenGV.setText("");
		txtNamhoc.setText("");
		txtHocki.setText("");
		txtSoluongSV.setText("");
		Canhbao("", txtMalop);
	}
	private ActionListener btnTailai() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tailai();
				modelDSLopHP.setRowCount(0);
				DanhsachLophocphan();
			}
		};
	}


	private ActionListener btnTimKim() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String Cantim = txtMaLHPcantim.getText();
				if(Cantim.equals(""))
				{
					Canhbao("Nhập Dữ liệu cần tìm. Theo đúng Cách đã chọn", txtMaLHPcantim);
				}
				else
				{
					if(cbTimkiem.getSelectedItem() == "")
					{
						Canhbao("Chọn Phương thức tìm kiếm", txtMaLHPcantim);
					}
					else if (cbTimkiem.getSelectedItem() == "Tên lớp học")	
					{
						ArrayList<Quanlylophocphan>DSLHPTimTheoTenMonhoc = new PhongdaotaoDAO().TimLophocphanTheoTenmonhoc(txtMaLHPcantim.getText());
						DulieuBangCantim(DSLHPTimTheoTenMonhoc);
					}
					else if (cbTimkiem.getSelectedItem() == "Mã lớp học")
					{
						ArrayList<Quanlylophocphan>DSLHPTimTheoMalop = new PhongdaotaoDAO().TimLophocphanTheoMalop(txtMaLHPcantim.getText());
						DulieuBangCantim(DSLHPTimTheoMalop);
					}
					else if (cbTimkiem.getSelectedItem() == "Tên giảng viên")
					{
						ArrayList<Quanlylophocphan>DSLHPTimTheoTenGV = new PhongdaotaoDAO().TimLophocphanTheoTenGiangvien(txtMaLHPcantim.getText());
						DulieuBangCantim(DSLHPTimTheoTenGV);
					}
					else if (cbTimkiem.getSelectedItem() == "Mã giảng viên")
					{
						ArrayList<Quanlylophocphan>DSLHPTimTheoMaGV = new PhongdaotaoDAO().TimLophocphanTheoMaGV(txtMaLHPcantim.getText());
						DulieuBangCantim(DSLHPTimTheoMaGV);
					}
				}

			}
		};
	}
	// tìm danh sách các lớp học phần cần tìm rồi hiện thị lên bảng modelDSLophP
	private void DulieuBangCantim(ArrayList<Quanlylophocphan> list)
	{
		modelDSLopHP.getDataVector().removeAllElements();// xóa dữ liệu trọng bảng cũ
		for(Quanlylophocphan quanlylophocphan : list)
		{
			modelDSLopHP.addRow(new Object[] {
					quanlylophocphan.getMaLHP(),
					quanlylophocphan.getMonHoc(),
					quanlylophocphan.getTenGV(),
					quanlylophocphan.getThu(),
					quanlylophocphan.getTietHoc(),
					quanlylophocphan.getPhonghoc(),
					quanlylophocphan.getSoluongSV(),
					quanlylophocphan.getHocki(),
					quanlylophocphan.getNamhoc(),
					quanlylophocphan.getNgayBatdau(),
					quanlylophocphan.getNgayKetthuc()
			});
		}
	}

	private ActionListener btnXoalophocphan() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//	modelDSLopHP.setRowCount(0);
				int row=tblDSLopHP.getSelectedRow();
				if ( row==-1)
				{
					JOptionPane.showMessageDialog(null	, "Chọn lớp trước khi xóa");
				}
				else {
					String maLophocphan =tblDSLopHP.getValueAt(row, 0).toString();

					if (new PhongdaotaoDAO().Xoalophocphan(maLophocphan)!=false)
					{
						JOptionPane.showMessageDialog(null	, "Hủy thành công");
						modelDSLopHP.setRowCount(0);
						DanhsachLophocphan();
					}
				}
			}
		};
	}
	private boolean Validate() {

		String maLHP = txtMalop.getText().trim();
		String tenGV =txtTenGV.getText().trim();
//		String tenMonhoc = cbMonHoc.getText().trim();
		String maPhonghoc= txtPhonghoc.getText().trim();
		String tietday = txtTiethoc.getText().trim();
		String thu = txtThu.getText().trim();
		String ngayBatdau= txtNgaybatdau.getText().trim();
		String ngatKetthuc = txtNgayketthuc.getText().trim();


		if(!( maLHP.matches("^\\d{4}[H][P]\\d{4}")))
		{
			txtMalop.requestFocus();
			Canhbao("Mã LHP: Nhập đúng định dạng d{4}[H][P]\\d{4}", txtMalop);
			return false;
		}
//		if(!( tenMonhoc.length() >=2 ))
//		{
//			txtMamon.requestFocus();
//			Canhbao("Môn học: Nhập đúng định dạng trên 2 kí tự", txtMamon);
//			return false;
//		}
		if(!(tenGV.length() >= 2))
		{
			txtTenGV.requestFocus();
			Canhbao("Tên GV: Nhập đúng định dạng trên 2 kí tự", txtTenGV);
			return false;
		}
		if(!(maPhonghoc.length() >= 2 ))
		{
			txtPhonghoc.requestFocus();
			Canhbao("Phòng học: Nhập đúng định dạng trên 2 kí tự", txtPhonghoc);
			return false;
		}
		if(!(tietday.length() >= 2 ))
		{
			txtTiethoc.requestFocus();
			Canhbao("Tiết dậy: Nhập đúng định dạng trên 2 kí tự", txtTiethoc);
			return false;
		}
		if(!(thu.length() >= 2 ) )
		{
			txtThu.requestFocus();
			Canhbao("Thứ: Nhập đúng định dạng trên 2 kí tự", txtThu);
			return false;
		}
		if(!(ngayBatdau.length() >= 2 ) )
		{
			txtNgaybatdau.requestFocus();
			Canhbao("Thứ: Nhập đúng định dạng trên 2 kí tự", txtNgaybatdau);
			return false;
		}
		if(!(ngatKetthuc.length() >= 2 ) )
		{
			txtThu.requestFocus();
			Canhbao("Thứ: Nhập đúng định dạng trên 2 kí tự", txtNgayketthuc);
			return false;
		}
		return true;
	}


	private ActionListener btnTaolophocphan() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new GD_ThemLopHocPhan();
			
//				try {
//
//					if(Validate()!=false)
//					{
//
//						String maLHP = txtMalop.getText();
//						String tenGV =txtTenGV.getText();
//						String tenMonhoc = txtMamon.getText();
//						String maPhonghoc= txtPhonghoc.getText();
//						String tietday = txtTiethoc.getText();
//						String thu = txtThu.getText();
//						String ngayBatdau= txtNgaybatdau.getText();
//						String ngatKetthuc = txtNgayketthuc.getText();
//						String hocKi = txtHocki.getText();
//						String namhoc = txtNamhoc.getText();
//						String soluongSV = txtSoluongSV.getText();
//
//						PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();
//						String maGV = phongdaotaoDAO.MaGiangvien(tenGV);
//						String maMH = phongdaotaoDAO.MaMonhoc(tenMonhoc);
//						if (phongdaotaoDAO.themLophocphan(maLHP, maGV, maMH, maPhonghoc, hocKi, namhoc, soluongSV, ngayBatdau, ngatKetthuc, tietday, ngatKetthuc) )
//						{
//							JOptionPane.showMessageDialog(null	, "Thêm thành công");
//							modelDSLopHP.setRowCount(0);
//							tailai();
//							DanhsachLophocphan();
//						}
//
//					}
//				} catch (Exception e) {
//					// TODO: handle exception
//					Canhbao("Mã lớp học phần trùng", txtMalop);
//				}
			}
		};
	}
	public void DanhsachLophocphan() {
		ArrayList<Quanlylophocphan> listQuanlilophoaphan = new PhongdaotaoDAO().getDSlophocphan();

		for(Quanlylophocphan ql : listQuanlilophoaphan)
		{
			modelDSLopHP.addRow(new Object[] {
					ql.getMaLHP(),
					ql.getMonHoc(),
					ql.getTenGV(),
					ql.getThu(),
					ql.getTietHoc(),
					ql.getPhonghoc(),
					ql.getSoluongSV(),
					ql.getHocki(),
					ql.getNamhoc(),
					ql.getNgayBatdau(),
					ql.getNgayKetthuc()

			});
		}
	}
}

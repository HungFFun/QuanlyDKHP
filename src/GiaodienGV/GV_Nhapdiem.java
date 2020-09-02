package GiaodienGV;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.LopHocphanDAO;
import DAO.PhongdaotaoDAO;
import DoituongData.LopNhapDiem;
import DoituongData.ThongtinNhapdiem;
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
import DoituongData.Thongtindangnhap;

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
import javax.swing.ImageIcon;

public class GV_Nhapdiem extends JPanel {
	private JTextField txtLophocphancantim;
	private JTextField txtMasv;
	private JTextField txtMhp;
	private JTextField txtTK;
	private JTextField txtGK;
	private JTextField txtTH;
	private JTextField txtCK;

	JTable tblDSLop;
	DefaultTableModel modelDSLop;
	JScrollPane scrollDSLop;

	JTable tblNhapdiem;
	DefaultTableModel modelNhapdiem;
	JScrollPane scrollNhapdiem;
	PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();
	private JTextField txtMaMH;
	private String maTim="";
	private JLabel lblCanhbao;

	/**
	 * Create the panel.
	 */
	public GV_Nhapdiem(Thongtindangnhap thongtindangnhap) {
		setLayout(null);

		JPanel panel_Chinh = new JPanel();
		panel_Chinh.setBounds(0, 0, 998, 669);
		add(panel_Chinh);
		panel_Chinh.setLayout(null);

		JPanel panel_table = new JPanel();
		panel_table.setBackground(new Color(255, 255, 240));
		panel_table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
		panel_table.setBounds(10, 394, 805, 220);
		String[] tieude = {"Mã LHP","Mã MH", "Tên môn học", " Mã SV","Tên SV","Điểm TK","Điểm GK","Điểm TH","Điểm Cuối kì"};

		modelNhapdiem = new DefaultTableModel(tieude, 0);
		tblNhapdiem = new JTable(modelNhapdiem);
		scrollNhapdiem = new JScrollPane(tblNhapdiem);
		scrollNhapdiem.setBounds(10, 10, 785, 200);
		scrollNhapdiem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterNhapdiem;
		tblNhapdiem.addMouseListener(tblNhapdiem());
		sorterNhapdiem = new TableRowSorter<TableModel>(tblNhapdiem.getModel());
		panel_table.setLayout(null);
		panel_table.add(scrollNhapdiem);

		panel_Chinh.add(panel_table);

		JPanel panel_Chucnang = new JPanel();
		panel_Chucnang.setBackground(new Color(255, 255, 240));
		panel_Chucnang.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
		panel_Chucnang.setBounds(816, 233, 170, 381);
		panel_Chinh.add(panel_Chucnang);
		panel_Chucnang.setLayout(null);

		JButton btnChonsinhvienNhapdiem = new JButton("ChonSV");
		btnChonsinhvienNhapdiem.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\selection.png"));
		btnChonsinhvienNhapdiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChonsinhvienNhapdiem.setBounds(10, 112, 150, 28);
		btnChonsinhvienNhapdiem.addActionListener(btnChonSV());
		panel_Chucnang.add(btnChonsinhvienNhapdiem);


		JButton btnTailai = new JButton("Tải lại");
		btnTailai.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\reload2.png"));
		btnTailai.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTailai.setBounds(10, 65, 150, 28);
		btnTailai.addActionListener(btnTailai());
		panel_Chucnang.add(btnTailai);

		JButton btnNhapdiem = new JButton("Nhập điểm");
		btnNhapdiem.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\important-delivery.png"));
		btnNhapdiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNhapdiem.setBounds(10, 156, 150, 28);
		btnNhapdiem.addActionListener(btnNhapdiem());
		panel_Chucnang.add(btnNhapdiem);

		JLabel lblChcNng = new JLabel("Chức năng");
		lblChcNng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChcNng.setBounds(44, 21, 87, 28);
		panel_Chucnang.add(lblChcNng);

		JButton btnInBangdiem = new JButton("In điểm");
		btnInBangdiem.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\printer.png"));
		btnInBangdiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInBangdiem.setBounds(10, 206, 150, 28);
		panel_Chucnang.add(btnInBangdiem);

		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setBounds(10, 254, 150, 28);
		panel_Chucnang.add(btnXoaTrang);
		btnXoaTrang.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\delete.png"));
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoaTrang.addActionListener(btnXoaTrang());
		btnInBangdiem.addActionListener(btnInBangdiem());

		JPanel panel_Thongtin = new JPanel();
		panel_Thongtin.setBackground(new Color(255, 255, 240));
		panel_Thongtin.setBounds(10, 22, 976, 208);
		panel_Chinh.add(panel_Thongtin);
		panel_Thongtin.setLayout(null);

		JLabel lblThngK = new JLabel("Thường kì:");
		lblThngK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThngK.setBounds(529, 12, 87, 25);
		panel_Thongtin.add(lblThngK);

		JLabel lblGiuaki = new JLabel("Giữa kì:");
		lblGiuaki.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiuaki.setBounds(529, 55, 87, 25);
		panel_Thongtin.add(lblGiuaki);

		JLabel lblthuchanh = new JLabel("Thực hành:");
		lblthuchanh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblthuchanh.setBounds(529, 98, 87, 25);
		panel_Thongtin.add(lblthuchanh);

		JLabel lblCuoiki = new JLabel("Cuối kì:");
		lblCuoiki.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCuoiki.setBounds(529, 133, 87, 25);
		panel_Thongtin.add(lblCuoiki);

		JLabel lblLophocphancantim = new JLabel("Lớp học phần cần nhập điểm:");
		lblLophocphancantim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLophocphancantim.setBounds(40, 166, 233, 25);
		panel_Thongtin.add(lblLophocphancantim);

		txtLophocphancantim = new JTextField();
		txtLophocphancantim.setBounds(299, 168, 286, 25);
		txtLophocphancantim.setColumns(10);
		maTim=txtLophocphancantim.getText();
		panel_Thongtin.add(txtLophocphancantim);

		JButton btnTm = new JButton("Tìm");
		btnTm.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\search.png"));
		btnTm.addActionListener(btnTim());
		btnTm.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTm.setBounds(683, 168, 162, 21);
		panel_Thongtin.add(btnTm);

		JLabel lblMasinhvien = new JLabel("Mã sinh viên:");
		lblMasinhvien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMasinhvien.setBounds(40, 12, 122, 25);
		panel_Thongtin.add(lblMasinhvien);

		JLabel lblMahocphan = new JLabel("Mã học phần:");
		lblMahocphan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMahocphan.setBounds(40, 98, 122, 25);

		panel_Thongtin.add(lblMahocphan);

		txtMasv = new JTextField();
		txtMasv.setBounds(190, 10, 162, 33);
		panel_Thongtin.add(txtMasv);
		txtMasv.setColumns(10);

		txtMhp = new JTextField();
		txtMhp.setColumns(10);
		txtMhp.setBounds(190, 96, 162, 33);
		panel_Thongtin.add(txtMhp);

		txtTK = new JTextField();
		txtTK.setColumns(10);
		txtTK.setBounds(683, 10, 162, 25);
		panel_Thongtin.add(txtTK);

		txtGK = new JTextField();
		txtGK.setColumns(10);
		txtGK.setBounds(683, 53, 162, 27);
		panel_Thongtin.add(txtGK);

		txtTH = new JTextField();
		txtTH.setColumns(10);
		txtTH.setBounds(683, 96, 162, 25);
		panel_Thongtin.add(txtTH);

		txtCK = new JTextField();
		txtCK.setColumns(10);
		txtCK.setBounds(683, 131, 162, 25);
		panel_Thongtin.add(txtCK);

		JLabel lblMamonhoc = new JLabel("Mã môn học:");
		lblMamonhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMamonhoc.setBounds(40, 55, 122, 25);
		panel_Thongtin.add(lblMamonhoc);

		txtMaMH = new JTextField();
		txtMaMH.setColumns(10);
		txtMaMH.setBounds(190, 53, 162, 33);
		panel_Thongtin.add(txtMaMH);

		lblCanhbao = new JLabel("");
		lblCanhbao.setForeground(Color.RED);
		lblCanhbao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCanhbao.setBounds(40, 133, 313, 23);
		panel_Thongtin.add(lblCanhbao);

		JLabel lblQunLim = new JLabel("Quản lý điểm");
		lblQunLim.setForeground(new Color(255, 0, 0));
		lblQunLim.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQunLim.setBounds(394, 0, 122, 23);
		panel_Chinh.add(lblQunLim);

		JPanel panel_DSlop = new JPanel();
		panel_DSlop.setBackground(new Color(255, 255, 240));
		panel_DSlop.setBounds(10, 233, 805, 159);
		panel_Chinh.add(panel_DSlop);
		panel_DSlop.setLayout(null);

		String[] tieudeDSL = {"Mã LHP", "Tên môn học", " Số Sinh viên","Học kì"};

		modelDSLop = new DefaultTableModel(tieudeDSL, 0);
		tblDSLop = new JTable(modelDSLop);
		scrollDSLop = new JScrollPane(tblDSLop);
		scrollDSLop.setBounds(10, 10, 785, 139);
		scrollDSLop.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterDSLop;
		sorterDSLop = new TableRowSorter<TableModel>(tblDSLop.getModel());
		panel_DSlop.add(scrollDSLop);
		
		DanhLopday(thongtindangnhap.getMa());
		tblDSLop.addMouseListener(tblDSLop());

	}
	private MouseListener tblNhapdiem() {
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
				int row=tblNhapdiem.getSelectedRow();
					txtMhp.setText(tblNhapdiem.getValueAt(row, 0).toString());
					txtMaMH.setText(tblNhapdiem.getValueAt(row, 1).toString());
					txtMasv.setText(tblNhapdiem.getValueAt(row, 3).toString());
			

			}
		};
	}
	private MouseListener tblDSLop() {
		// TODO Auto-generated method stub
		return new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row=tblDSLop.getSelectedRow();
				String ma =tblDSLop.getValueAt(row, 0).toString();
				modelNhapdiem.setRowCount(0);
				ArrayList<ThongtinNhapdiem> listLophochanCannhapdiem = phongdaotaoDAO.TimLophocphanCannhapdiem(ma);
				for (ThongtinNhapdiem nd : listLophochanCannhapdiem)
				{
					modelNhapdiem.addRow(new Object[] {
							nd.getMaLHP(),
							nd.getMaMH(),
							nd.getTenMH(),
							nd.getMaSV(),
							nd.getTenSV(),
							nd.getDiemTK(),
							nd.getDiemGK(),
							nd.getDiemTH(),
							nd.getDiemCk()
					});

				}
				
			}
		};
	}
	private ActionListener btnXoaTrang() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtCK.setText("");
				txtGK.setText("");
				txtLophocphancantim.setText("");
				txtMaMH.setText("");
				txtMasv.setText("");
				txtMhp.setText("");
				txtTH.setText("");
				txtTK.setText("");
			}
		};
	}
	private ActionListener btnInBangdiem() {
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
				//					File initialFile = new File("src/thongKe/BangDiemLopHocPhan.jrxml");
				//				    InputStream targetStream = new FileInputStream(initialFile);
				//					JasperDesign jd = JRXmlLoader.load(targetStream);
				//					//Build a new query
				//					String theQuery = "select sv.[MaSV],[TenSV],sv.[MaLop],[NgaySinh],[GioiTinh],[TrangThai],[TenLop],[TenKhoa],[NamHoc],Hocki,mh.[MaMH],lhp.[MaLHP],[DiemTK]," + 
				//							" [DiemGK],[DiemTH],[DiemCK],[TenMonHoc],[SoTinChi]" + 
				//							" from [dbo].[Khoa] as k join [dbo].[Lop] as l on k.MaKhoa=l.MaKhoa" + 
				//							"	join [dbo].[Sinhvien] as sv on l.MaLop=sv.MaLop" + 
				//							"	join [dbo].[BangDiem] as bd on sv.MaSV=bd.MaSV join [dbo].[LopHocPhan] as lhp on bd.MaLHP=lhp.MaLHP" + 
				//							"	join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH" + 
				//							" where lhp.[MaLHP] like '" + txtMhp.getText().toString().trim() + "'";
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
				//					JasperExportManager.exportReportToPdfFile(jp, "D:/QuanLyDKHP_V2/pdf/BangDiemLopHocPhan.pdf");
				//					System.out.println("Done compiling!!! ...");
				//				} catch (SQLException | JRException | IOException ex) {
				//					ex.printStackTrace();
			}
		};
	}
	public void Canhbao(String mess, JTextField txt)
	{
		lblCanhbao.setText(mess);
		txt.requestFocus();
	}
	private boolean Validate() {

		String TK = txtTK.getText().trim();
		String GK =txtGK.getText().trim();
		String TH =txtTH.getText().trim();
		String CK =txtCK.getText().trim();
		if(TK.equals("")==false) {
			if(!( TK.matches("\\d*")))
			{
				txtTK.requestFocus();
				Canhbao("Thường kì: Nhập đúng định dạng số", txtTK);
				return false;
			}
			if(!(Double.parseDouble(TK)<=10 && Double.parseDouble(TK)>=0)) {
				txtTK.requestFocus();
				Canhbao("Thường kì: phải >= 0 và <=10", txtTK);
				return false;
			}
		}
		if(GK.equals("")==false) {
			if(!( GK.matches("\\d*")))
			{
				txtGK.requestFocus();
				Canhbao("Giữa kì: Nhập đúng định dạng số", txtGK);
				return false;
			}
			if(!(Double.parseDouble(GK)<=10 && Double.parseDouble(GK)>=0)) {
				txtGK.requestFocus();
				Canhbao("Giữa kì: phải >= 0 và <=10", txtGK);
				return false;
			}
		}
		if(TH.equals("")==false) {
			if(!( TH.matches("\\d*")))
			{
				txtTH.requestFocus();
				Canhbao("Thực hành: Nhập đúng định dạng số", txtTH);
				return false;
			}
			if(!(Double.parseDouble(TH)<=10 && Double.parseDouble(TH)>=0)) {
				txtTH.requestFocus();
				Canhbao("Thực hành: phải >= 0 và <=10", txtTH);
				return false;
			}
		}
		if(CK.equals("")==false) {
			if(!( CK.matches("\\d*")))
			{
				txtCK.requestFocus();
				Canhbao("Cuối kì: Nhập đúng định dạng số", txtCK);
				return false;
			}
			if(!(Double.parseDouble(CK)<=10 && Double.parseDouble(CK)>=0)) {
				txtCK.requestFocus();
				Canhbao("Cuối kì: phải >= 0 và <=10", txtCK);
				return false;
			}
		}
		return true;
	}
	private ActionListener btnNhapdiem() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row=tblNhapdiem.getSelectedRow();

				if ( row==-1)
				{
					JOptionPane.showMessageDialog(null	, "Tìm Danh sách lớp");
				}
				else {
					if(Validate()!=false)
					{
						//						System.out.println("s");
						String maMH= txtMaMH.getText().trim();
						String maSV =txtMasv.getText().trim();
						String maLHP = txtMhp.getText().trim();
						if(phongdaotaoDAO.TimBangDiem(maSV, maMH)==false) {
							phongdaotaoDAO.ThemBangDiem(maSV, maMH, maLHP);
						}

						if(txtTK.getText().equals("")!=true) {
							Double diemTK = Double.parseDouble(txtTK.getText().trim());
							if (phongdaotaoDAO.Nhapdiem("[DiemTK]",diemTK,txtMasv.getText().trim(),txtMaMH.getText().trim())==false){
								JOptionPane.showMessageDialog(null, "Nhập điểm thất Bại");
							}

						}
						if(txtGK.getText().equals("")!=true) {
							Double diemGK = Double.parseDouble(txtGK.getText().trim());
							if (phongdaotaoDAO.Nhapdiem("[DiemGK]",diemGK,txtMasv.getText().trim(),txtMaMH.getText().trim())==false){
								JOptionPane.showMessageDialog(null, "Nhập điểm thất Bại");
							}

						}
						if(txtTH.getText().equals("")!=true) {
							Double diemTH = Double.parseDouble(txtTH.getText().trim());
							if (phongdaotaoDAO.Nhapdiem("[DiemTH]",diemTH,txtMasv.getText().trim(),txtMaMH.getText().trim())==false){
								JOptionPane.showMessageDialog(null, "Nhập điểm thất Bại");
							}

						}
						if(txtCK.getText().equals("")!=true) {
							Double diemCK = Double.parseDouble(txtCK.getText().trim());
							if (phongdaotaoDAO.Nhapdiem("[DiemCK]",diemCK,txtMasv.getText().trim(),txtMaMH.getText().trim())==false){
								JOptionPane.showMessageDialog(null, "Nhập điểm thất Bại");
							}
						}
						modelNhapdiem.setRowCount(0);
						Danhsachlophoc(txtLophocphancantim.getText());
					}
				}





			}



		};
	}
	private ActionListener btnChonSV() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				int row=tblNhapdiem.getSelectedRow();

				if ( row==-1)
				{
					JOptionPane.showMessageDialog(null	, "Tìm danh sách lớp rồi chọn Sinh");
				}
				else {

					txtMhp.setText(tblNhapdiem.getValueAt(row, 0).toString());
					txtMaMH.setText(tblNhapdiem.getValueAt(row, 1).toString());
					txtMasv.setText(tblNhapdiem.getValueAt(row, 3).toString());
				}

			}
		};
	}
	private ActionListener btnTailai() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String malopcantim=txtLophocphancantim.getText();
				if(malopcantim.length()==0)
				{
					Canhbao("Điền mã lớp cần nhập điểm", txtLophocphancantim);
				}
				else
				{

					tailai();
				}
			}
		};
	}
	private void tailai()
	{
		modelNhapdiem.setRowCount(0);
		txtLophocphancantim.setText("");
		txtMaMH.setText("");
		txtCK.setText("");
		txtGK.setText("");
		txtMasv.setText("");
		txtMhp.setText("");
		txtTH.setText("");
		txtTK.setText("");


	}
	private ActionListener btnTim() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String malopcantim=txtLophocphancantim.getText();
				if(malopcantim.length()==0)
				{
					Canhbao("Điền mã lớp cần nhập điểm", txtLophocphancantim);
				}
				else
				{
					modelNhapdiem.setRowCount(0);
					ArrayList<ThongtinNhapdiem> listLophochanCannhapdiem = phongdaotaoDAO.TimLophocphanCannhapdiem(txtLophocphancantim.getText());
					for (ThongtinNhapdiem nd : listLophochanCannhapdiem)
					{
						modelNhapdiem.addRow(new Object[] {
								nd.getMaLHP(),
								nd.getMaMH(),
								nd.getTenMH(),
								nd.getMaSV(),
								nd.getTenSV(),
								nd.getDiemTK(),
								nd.getDiemGK(),
								nd.getDiemTH(),
								nd.getDiemCk()
						});

					}

				}
			}
		};
	}


	void  DanhLopday (String maGV)
	{
		LopHocphanDAO lopHocphanDAO = new LopHocphanDAO();
		ArrayList<LopNhapDiem> listNhapDiems = lopHocphanDAO.getDSLopdangday(maGV);
		for (LopNhapDiem nd : listNhapDiems)
		{

			modelDSLop.addRow(new Object[] {
					nd.getMaLHP(),
					nd.getTenMH(),
					nd.getSoSV(),
					nd.getHocki(),
			});

		}
	}

	void Danhsachlophoc(String maLHP) {
		ArrayList<ThongtinNhapdiem> listLophochanCannhapdiem = phongdaotaoDAO.TimLophocphanCannhapdiem(maLHP);
		for (ThongtinNhapdiem nd : listLophochanCannhapdiem)
		{

			modelNhapdiem.addRow(new Object[] {
					nd.getMaLHP(),
					nd.getMaMH(),
					nd.getTenMH(),
					nd.getMaSV(),
					nd.getTenSV(),
					nd.getDiemTK(),
					nd.getDiemGK(),
					nd.getDiemTH(),
					nd.getDiemCk()
			});

		}
	}

}

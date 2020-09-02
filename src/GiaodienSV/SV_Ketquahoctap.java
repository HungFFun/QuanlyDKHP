package GiaodienSV;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.SinhvienDAO;
import DoituongData.DSBangdiem;
import DoituongData.ThongtinSinhvien;
import DoituongData.Thongtindangnhap;
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

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class SV_Ketquahoctap extends JPanel {

	/**
	 * Create the panel.
	 */
	JTable tblBangdiem;
	DefaultTableModel modelBangdiem;
	JScrollPane scrollBangdiem;
	private String ma;
	private JComboBox cbHocki;
	private JComboBox cbNamhoc;
	public SV_Ketquahoctap(Thongtindangnhap thongtindangnhap) {
		setLayout(null);
		ma= thongtindangnhap.getMa();


		// lấy thông tin sinh viên đăng nhập
		ThongtinSinhvien thongtinSinhvien = new SinhvienDAO().getThongtinsinhvien(thongtindangnhap.getMa());
		JPanel panel_Thongtonsinhvien = new JPanel();
		panel_Thongtonsinhvien.setBackground(new Color(255, 255, 240));
		panel_Thongtonsinhvien.setLayout(null);
		panel_Thongtonsinhvien.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_Thongtonsinhvien.setBounds(10, 24, 982, 184);
		add(panel_Thongtonsinhvien);

		JLabel label = new JLabel("Hinh");
		label.setBounds(30, 10, 82, 97);
		panel_Thongtonsinhvien.add(label);

		JLabel label_1 = new JLabel("Mã sinh viên:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(26, 128, 82, 16);
		panel_Thongtonsinhvien.add(label_1);

		JLabel lblTrangthai = new JLabel("Trạng thái:");
		lblTrangthai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrangthai.setBounds(211, 21, 102, 33);
		panel_Thongtonsinhvien.add(lblTrangthai);

		JLabel lblNgayvaotruong = new JLabel("Ngày vào  trường:");
		lblNgayvaotruong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgayvaotruong.setBounds(211, 64, 115, 33);
		panel_Thongtonsinhvien.add(lblNgayvaotruong);

		JLabel lblKhoa = new JLabel("Khoa:");
		lblKhoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKhoa.setBounds(211, 100, 102, 33);
		panel_Thongtonsinhvien.add(lblKhoa);

		JLabel lblNganh = new JLabel("Ngành:");
		lblNganh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNganh.setBounds(211, 143, 102, 33);
		panel_Thongtonsinhvien.add(lblNganh);

		JLabel lblNienkhoa = new JLabel("Niên khóa:");
		lblNienkhoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNienkhoa.setBounds(559, 21, 102, 33);
		panel_Thongtonsinhvien.add(lblNienkhoa);

		JLabel lblCoSo = new JLabel("Cơ Sở:");
		lblCoSo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCoSo.setBounds(559, 52, 102, 33);
		panel_Thongtonsinhvien.add(lblCoSo);

		JLabel lblLoaihinhdaotao = new JLabel("Loại hình đào tạo:");
		lblLoaihinhdaotao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoaihinhdaotao.setBounds(559, 100, 115, 33);
		panel_Thongtonsinhvien.add(lblLoaihinhdaotao);

		JLabel lblLop = new JLabel("Lớp:");
		lblLop.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLop.setBounds(559, 143, 102, 33);
		panel_Thongtonsinhvien.add(lblLop);




		JLabel lblVlMasinhvien = new JLabel("");
		lblVlMasinhvien.setBounds(30, 154, 82, 23);
		lblVlMasinhvien.setText(thongtinSinhvien.getMasv());
		panel_Thongtonsinhvien.add(lblVlMasinhvien);

		JLabel lblVlTrangthai = new JLabel("");
		lblVlTrangthai.setBounds(363, 21, 92, 27);
		lblVlTrangthai.setText(thongtinSinhvien.getTranthai());
		panel_Thongtonsinhvien.add(lblVlTrangthai);

		JLabel lblVlKhoa = new JLabel("");
		lblVlKhoa.setBounds(363, 100, 123, 33);
		lblVlKhoa.setText(thongtinSinhvien.getTenkhoa());
		panel_Thongtonsinhvien.add(lblVlKhoa);

		JLabel lblVlnienkhoa = new JLabel("");
		lblVlnienkhoa.setBounds(751, 21, 102, 33);
		lblVlnienkhoa.setText(thongtinSinhvien.getNienkhoa());
		panel_Thongtonsinhvien.add(lblVlnienkhoa);

		JLabel lblVlLop = new JLabel("");
		lblVlLop.setBounds(751, 150, 145, 24);
		lblVlLop.setText(thongtinSinhvien.getTenlophoc());
		panel_Thongtonsinhvien.add(lblVlLop);

		JLabel label_15 = new JLabel("TP.HCM");
		label_15.setBounds(751, 57, 102, 24);
		panel_Thongtonsinhvien.add(label_15);

		JLabel lblVlNganh = new JLabel("");
		lblVlNganh.setBounds(363, 143, 123, 33);

		panel_Thongtonsinhvien.add(lblVlNganh);

		JPanel panel_bangdiem = new JPanel();
		panel_bangdiem.setBackground(new Color(255, 255, 240));
		panel_bangdiem.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kết quả học tập", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_bangdiem.setBounds(10, 218, 982, 356);


		String[] tieudeBangdiem = {"Môn học", "Mã lớp học phần", " Thường kì ","Giữ kì","Thực hành","Cuối kì"};
		modelBangdiem = new DefaultTableModel(tieudeBangdiem, 0);
		tblBangdiem = new JTable(modelBangdiem);
		scrollBangdiem = new JScrollPane(tblBangdiem);
		scrollBangdiem.setBounds(10, 63, 962, 283);
		scrollBangdiem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterBangdiem;
		sorterBangdiem = new TableRowSorter<TableModel>(tblBangdiem.getModel());
		panel_bangdiem.setLayout(null);
		panel_bangdiem.add(scrollBangdiem);

		add(panel_bangdiem);

		JLabel lblHcK = new JLabel("Học kì:");
		lblHcK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHcK.setBounds(31, 21, 60, 25);
		panel_bangdiem.add(lblHcK);

		cbHocki = new JComboBox();
		cbHocki.setModel(new DefaultComboBoxModel(new String[] {"HK1", "HK2", "HK3"}));
		cbHocki.setFont(new Font("Tahoma", Font.BOLD, 17));
		cbHocki.setBounds(101, 20, 80, 25);
		panel_bangdiem.add(cbHocki);

		cbNamhoc = new JComboBox();
		cbNamhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbNamhoc.setModel(new DefaultComboBoxModel(new String[] {"", "2019-2020", "2020-2021", "2018-2019", "2017-2018"}));
		cbNamhoc.setBounds(304, 22, 125, 23);
		panel_bangdiem.add(cbNamhoc);

		JButton btnXemDiem = new JButton("Xem điểm");
		btnXemDiem.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\target.png"));
		btnXemDiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXemDiem.setBounds(439, 21, 140, 25);
		btnXemDiem.addActionListener(btnXemDiem());
		panel_bangdiem.add(btnXemDiem);

		JButton btnIn = new JButton("In điểm");
		btnIn.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\printer.png"));
		btnIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIn.setBounds(846, 21, 126, 25);
		btnIn.addActionListener(btnIn());
		panel_bangdiem.add(btnIn);



		JButton btnDiemtatcaCacmon = new JButton("Điểm tất cả các môn");
		btnDiemtatcaCacmon.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\scroll.png"));
		btnDiemtatcaCacmon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDiemtatcaCacmon.setBounds(613, 21, 223, 25);
		btnDiemtatcaCacmon.addActionListener(btnDiemtatcaCacmon());
		panel_bangdiem.add(btnDiemtatcaCacmon);

		JLabel lblNamhoc = new JLabel("Năm học:");
		lblNamhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNamhoc.setBounds(214, 21, 80, 25);
		panel_bangdiem.add(lblNamhoc);

		JLabel lblKtQuHc = new JLabel("Kết quả học tập");
		lblKtQuHc.setForeground(Color.RED);
		lblKtQuHc.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblKtQuHc.setBounds(417, 0, 147, 23);
		add(lblKtQuHc);

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
//					File initialFile = new File("src/thongKe/BangDiemSinhVienMotHocKi.jrxml");
//				    InputStream targetStream = new FileInputStream(initialFile);
//					JasperDesign jd = JRXmlLoader.load(targetStream);
//					//Build a new query
//					String theQuery = "select sv.MaSV,TenSV,sv.MaLop," + 
//							"NgaySinh,GioiTinh," + 
//							"TenLop,TenKhoa," + 
//							"NamHoc,Hocki,mh.MaMH," + 
//							"lhp.MaLHP,DiemTK," + 
//							"DiemGK,DiemTH,DiemCK," + 
//							"TenMonHoc,SoTinChi" + 
//							" from [dbo].[Khoa] as k" + 
//							"	join [dbo].[Lop] as l on k.MaKhoa=l.MaKhoa" + 
//							"	join [dbo].[Sinhvien] as sv on l.MaLop=sv.MaLop" + 
//							"	join [dbo].[BangDiem] as bd on sv.MaSV=bd.MaSV join [dbo].[LopHocPhan] as lhp on bd.MaLHP=lhp.MaLHP" + 
//							"	join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH" + 
//							" where Hocki = '"+ cbHocki.getSelectedItem() + 
//							"' and NamHoc = '" + cbNamhoc.getSelectedItem() + 
//							"' and sv.MaSV = '" + ma +"'";
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
//					JasperExportManager.exportReportToPdfFile(jp, "D:/QuanLyDKHP/pdf/BangDiemSinhVienMotHocKi.docx");
//				} catch (SQLException | JRException | IOException ex) {
//					ex.printStackTrace();
//				}
				System.out.println("Done compiling!!! ...");
			}
		};
	}


	private ActionListener btnDiemtatcaCacmon() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DSDiemTatcaCacki();
			}
		};
	}


	private ActionListener btnXemDiem() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maSV = ma;
				String namHoc = cbNamhoc.getSelectedItem().toString();
				String hocKi = cbHocki.getSelectedItem().toString();
				Ketquahoctap(maSV, namHoc, hocKi);
			}
		};
	}


	public void Ketquahoctap(String maSV, String namHoc, String hocKi) {
		modelBangdiem.setRowCount(0);
		ArrayList<DSBangdiem> listBangdiem = new SinhvienDAO().getDSbangdiem(maSV, namHoc, hocKi);
		for(DSBangdiem bd: listBangdiem)
		{
			modelBangdiem.addRow(new Object[] {
					bd.getTenmonhoc(),
					bd.getMaLHP(),
					bd.getThuongki(),
					bd.getGiuaki(),
					bd.getDiemthuchanh(),
					bd.getCuoiki(),

			});
		}

	}
	public void DSDiemTatcaCacki() {
		modelBangdiem.setRowCount(0);
		ArrayList<DSBangdiem> listBangdiem = new SinhvienDAO().DSDiemTatcaHocki(ma);
		for(DSBangdiem bd: listBangdiem)
		{
			modelBangdiem.addRow(new Object[] {
					bd.getTenmonhoc(),
					bd.getMaLHP(),
					bd.getThuongki(),
					bd.getGiuaki(),
					bd.getDiemthuchanh(),
					bd.getCuoiki(),

			});
		}

	}
}

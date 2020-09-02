package GiaodienPDT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import DAO.PhongdaotaoDAO;
import Doituong.Giangvien_GiaovuPDT;
import Doituong.Khoa;
import Doituong.Monhoc;
import javax.swing.DefaultComboBoxModel;

public class GD_ThemLopHocPhan extends JFrame {

	private JPanel contentPane;

	private JTextField txtMalop;
	private JComboBox<String> cbMonHoc;
	private JComboBox<String> cbThu;
	private JTextField txtPhonghoc;
	private JTextField txtTiethoc;
	JTable tblDSLopHP;
	DefaultTableModel modelDSLopHP;
	JScrollPane scrollDSLopHP;
	JTable tblDSGiangvien;
	DefaultTableModel modelDSGiangvien;
	JScrollPane scrollDSGiangvien;

	private JTextField txtTenGV;
	private JComboBox<String> cbSoLuong;
	private JComboBox<String> cbHocki;
	private JComboBox<String> cbmKhoa;
	private JTextField txtNamhoc;
	//private JComboBox cbTimkiem;
	private JComboBox cbmTimkiem;
	private JLabel lblCanhbao;
	private JDateChooser dateChooser_NgayBatDau;
	private JDateChooser dateChooser_NgayKetThuc;
	private JTextField txtTimkiem;

	PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new GD_ThemLopHocPhan();
	}

	public GD_ThemLopHocPhan() {
		GiaoDien();
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);

	}
	public void GiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1239, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBounds(10, 41, 376, 493);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblMalop = new JLabel("Mã Lớp:");
		lblMalop.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMalop.setBounds(26, 13, 72, 25);
		panel.add(lblMalop);

		txtMalop = new JTextField();
		txtMalop.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMalop.setColumns(10);
		txtMalop.setBounds(162, 13, 198, 25);
		panel.add(txtMalop);

		JLabel lblMamon = new JLabel("Môn Học:");
		lblMamon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMamon.setBounds(26, 53, 84, 25);
		panel.add(lblMamon);

		cbMonHoc = new JComboBox<String>();
		cbMonHoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbMonHoc.setBounds(162, 53, 198, 25);
		ThemMonHoc();
		panel.add(cbMonHoc);

		JLabel lblNgaybatdau = new JLabel("Ngày Bắt Đầu:");
		lblNgaybatdau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgaybatdau.setBounds(26, 383, 117, 25);
		panel.add(lblNgaybatdau);

		JLabel lblTiethoc = new JLabel("Tiết:");
		lblTiethoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTiethoc.setBounds(244, 232, 42, 25);
		panel.add(lblTiethoc);

		JLabel lblNgayketthuc = new JLabel("Ngày Kết Thúc:");
		lblNgayketthuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayketthuc.setBounds(26, 437, 117, 25);
		panel.add(lblNgayketthuc);

		JLabel lblPhonghoc = new JLabel("Phòng Học:");
		lblPhonghoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhonghoc.setBounds(26, 139, 101, 20);
		panel.add(lblPhonghoc);

		cbThu = new JComboBox<String>();
		cbThu.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbThu.setBounds(162, 232, 72, 25);
		cbThu.addItem("Thứ 2");
		cbThu.addItem("Thứ 3");
		cbThu.addItem("Thứ 4");
		cbThu.addItem("Thứ 5");
		cbThu.addItem("Thứ 6");
		cbThu.addItem("Thứ 7");
		cbThu.addItem("Chủ nhật");
		panel.add(cbThu);

		txtPhonghoc = new JTextField();
		txtPhonghoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPhonghoc.setColumns(10);
		txtPhonghoc.setBounds(162, 137, 198, 25);
		panel.add(txtPhonghoc);

		txtTiethoc = new JTextField();
		txtTiethoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTiethoc.setColumns(10);
		txtTiethoc.setBounds(290, 232, 72, 25);
		panel.add(txtTiethoc);

		JLabel lblThu = new JLabel("Thứ:");
		lblThu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThu.setBounds(26, 233, 66, 22);
		panel.add(lblThu);

		JLabel lblTenGv = new JLabel("Tên GV:");
		lblTenGv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenGv.setBounds(26, 99, 84, 25);
		panel.add(lblTenGv);

		txtTenGV = new JTextField();
		txtTenGV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTenGV.setColumns(10);
		txtTenGV.setBounds(162, 95, 198, 25);
		panel.add(txtTenGV);

		JLabel lblSoluongSV = new JLabel("Số lượng SV:");
		lblSoluongSV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoluongSV.setBounds(26, 186, 101, 20);
		panel.add(lblSoluongSV);

		JLabel lblHocki = new JLabel("Học kì:");
		lblHocki.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHocki.setBounds(26, 286, 84, 20);
		panel.add(lblHocki);

		JLabel lblNamhoc = new JLabel("Năm học:");
		lblNamhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNamhoc.setBounds(26, 338, 84, 25);
		panel.add(lblNamhoc);

		cbSoLuong = new JComboBox<String>();
		cbSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbSoLuong.setBounds(162, 184, 198, 25);
		cbSoLuong.addItem("35");
		cbSoLuong.addItem("40");
		cbSoLuong.addItem("45");
		cbSoLuong.addItem("50");
		cbSoLuong.addItem("60");
		cbSoLuong.addItem("80");
		panel.add(cbSoLuong);

		cbHocki = new JComboBox<String>();
		cbHocki.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbHocki.setBounds(162, 283, 198, 28);
		cbHocki.addItem("HK1");
		cbHocki.addItem("HK2");
		cbHocki.addItem("HK3");
		panel.add(cbHocki);


		txtNamhoc = new JTextField();
		txtNamhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNamhoc.setColumns(10);
		txtNamhoc.setBounds(162, 335, 198, 28);
		panel.add(txtNamhoc);

		dateChooser_NgayBatDau = new JDateChooser();
		dateChooser_NgayBatDau.setBounds(162, 383, 198, 25);
		dateChooser_NgayBatDau.setDateFormatString("yyyy-mm-dd");
		panel.add(dateChooser_NgayBatDau);

		dateChooser_NgayKetThuc = new JDateChooser();
		dateChooser_NgayKetThuc.setBounds(162, 434, 198, 28);
		dateChooser_NgayKetThuc.setDateFormatString("yyyy-mm-dd");
		panel.add(dateChooser_NgayKetThuc);

		JLabel lblThongtin = new JLabel("Thông tin lớp học phần");
		lblThongtin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongtin.setBounds(109, 10, 224, 21);
		contentPane.add(lblThongtin);

		JPanel panel_Table = new JPanel();
		panel_Table.setBounds(396, 352, 827, 169);
		contentPane.add(panel_Table);
		panel_Table.setLayout(null);
		String[] tieude = {"Mã LHP", "Môn học", "Giảng Viên","Thứ","Tiết học","Phòng học","Số lượng SV","Học kì","Năm học","Ngày bắt đầu","Ngày kết thúc"};

		modelDSLopHP = new DefaultTableModel(tieude, 0);
		tblDSLopHP = new JTable(modelDSLopHP);
		tblDSLopHP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollDSLopHP = new JScrollPane(tblDSLopHP);
		scrollDSLopHP.setFont(new Font("Tahoma", Font.BOLD, 10));
		scrollDSLopHP.setBounds(0, 10, 825, 481);
		scrollDSLopHP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterDSLopHP;
		sorterDSLopHP = new TableRowSorter<TableModel>(tblDSLopHP.getModel());
		panel_Table.setLayout(null);
		panel_Table.add(scrollDSLopHP);

		JLabel lblDanhsachLopHocphanMoiThem = new JLabel("Danh sanh lớp học phần vừa thêm");
		lblDanhsachLopHocphanMoiThem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDanhsachLopHocphanMoiThem.setBounds(700, 10, 327, 21);
		contentPane.add(lblDanhsachLopHocphanMoiThem);

		JButton btnThemLophocphan = new JButton("Thêm lớp học phần");
		btnThemLophocphan.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\plus (1).png"));
		btnThemLophocphan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemLophocphan.addActionListener(btnThemLophocphan());
		btnThemLophocphan.setBounds(10, 548, 201, 33);
		contentPane.add(btnThemLophocphan);

		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\delete.png"));
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaTrang.setBounds(375, 548, 158, 33);
		btnXoaTrang.addActionListener(btnXoaTrang());
		contentPane.add(btnXoaTrang);

		lblCanhbao = new JLabel("");
		lblCanhbao.setForeground(new Color(255, 0, 0));
		lblCanhbao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCanhbao.setBounds(571, 552, 512, 29);
		contentPane.add(lblCanhbao);

		JPanel panel_tableDanhsachGiangvien = new JPanel();
		panel_tableDanhsachGiangvien.setBounds(396, 41, 819, 197);
		contentPane.add(panel_tableDanhsachGiangvien);
		panel_tableDanhsachGiangvien.setLayout(null);
		String[] tieudeDSGiangvien = {"Mã GV", "Tên GV", "Khoa","Giới tính","SDT","Địa chỉ","Trình độ"};

		modelDSGiangvien = new DefaultTableModel(tieudeDSGiangvien, 0);
		tblDSGiangvien = new JTable(modelDSGiangvien);
		tblDSGiangvien.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tblDSGiangvien.addMouseListener(tblDSGiangvien());
		scrollDSGiangvien = new JScrollPane(tblDSGiangvien);
		scrollDSGiangvien.setFont(new Font("Tahoma", Font.BOLD, 10));
		scrollDSGiangvien.setBounds(10, 10, 799, 180);
		scrollDSGiangvien.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterDSGiangvien;
		sorterDSGiangvien = new TableRowSorter<TableModel>(tblDSLopHP.getModel());
		panel_tableDanhsachGiangvien.setLayout(null);
		panel_tableDanhsachGiangvien.add(scrollDSGiangvien);

		JLabel lblKhoa = new JLabel("Khoa:");
		lblKhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKhoa.setBounds(406, 258, 56, 21);
		ThemKhoa();
		contentPane.add(lblKhoa);

		cbmKhoa =new JComboBox<String>();
		cbmKhoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbmKhoa.setBounds(460, 260, 158, 21);
		contentPane.add(cbmKhoa);

		JLabel lblTimkiem = new JLabel("Tìm Giang viên theo ->");
		lblTimkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimkiem.setBounds(406, 303, 178, 21);
		contentPane.add(lblTimkiem);

		cbmTimkiem = new JComboBox();
		cbmTimkiem.setModel(new DefaultComboBoxModel(new String[] {"", "Tên Giảng viên", "Mã Giảng viên"}));
		cbmTimkiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbmTimkiem.setBounds(594, 304, 144, 21);
		contentPane.add(cbmTimkiem);

		txtTimkiem = new JTextField();
		txtTimkiem.setBounds(769, 306, 158, 19);
		contentPane.add(txtTimkiem);
		txtTimkiem.setColumns(10);

		JButton btnTimkiem = new JButton("Tìm kiếm");
		btnTimkiem.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\search.png"));
		btnTimkiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimkiem.setBounds(992, 291, 172, 33);
		btnTimkiem.addActionListener(btnTimkiem());
		contentPane.add(btnTimkiem);

		JButton btnXoaLop = new JButton("Xóa lớp");
		btnXoaLop.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\eraser.png"));
		btnXoaLop.addActionListener(btnXoaLop());
		btnXoaLop.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaLop.setBounds(221, 548, 144, 33);
		contentPane.add(btnXoaLop);
		DanhsachGiangvien();



	}
	private ActionListener btnXoaLop() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=tblDSLopHP.getSelectedRow();
				if ( row==-1)
				{
					Canhbao("Chọn lớp trước khi xóa", txtTimkiem);
				}
				else {
					String maLophocphan =tblDSLopHP.getValueAt(row, 0).toString();

					if (new PhongdaotaoDAO().Xoalophocphan(maLophocphan)!=false)
					{
						JOptionPane.showMessageDialog(null	, "Hủy thành công");
					}
				}
			}
		};
	}

	private MouseListener tblDSGiangvien() {
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
				int row = tblDSGiangvien.getSelectedRow();

				txtTenGV.setText(tblDSGiangvien.getValueAt(row, 1).toString());
			}
		};
	}

	private ActionListener btnTimkiem() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Giangviencantim=txtTimkiem.getText();

				if(Giangviencantim.length()==0)
				{
					Canhbao("Điền thông tin vào ô tìm kiếm", txtTimkiem);
				}
				else
				{
					if (cbmTimkiem.getSelectedItem() == "Tên Giảng viên")	
					{

						ArrayList<Giangvien_GiaovuPDT> ListGVCantim = phongdaotaoDAO.TimsGiangvienTheoten(txtTimkiem.getText());
						modelDSGiangvien.getDataVector().removeAllElements(); 
						Dulieucantim(ListGVCantim);
					}
					else if (cbmTimkiem.getSelectedItem() == "Mã Giảng viên")
					{
						ArrayList<Giangvien_GiaovuPDT> ListGVCantim = phongdaotaoDAO.TimsGiangvienTheoMa(txtTimkiem.getText());
						modelDSGiangvien.getDataVector().removeAllElements(); 
						Dulieucantim(ListGVCantim);
					}
					else if (cbmTimkiem.getSelectedItem() == "")
					{
						Canhbao("Chọn phương thức cần tìm kiếm", txtTimkiem);
					}
				}	

			}
		};
	}
	public void Dulieucantim (ArrayList<Giangvien_GiaovuPDT> list)
	{
		for(Giangvien_GiaovuPDT giangvien_GiaovuPDT : list)
		{

			modelDSGiangvien.addRow(new Object[] {
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

	public void DanhsachGiangvien() {
		ArrayList<Giangvien_GiaovuPDT> listQuanliGiangvien = new PhongdaotaoDAO().getDSGiangvien();

		for(Giangvien_GiaovuPDT gv : listQuanliGiangvien)
		{
			modelDSGiangvien.addRow(new Object[] {
					gv.getMa(),
					gv.getTen(),
					gv.getKhoa(),
					gv.getGiotinh(),
					gv.getSoDienthoai(),
					gv.getDiachi(),
					gv.getTrinhdo()
			});
		}
	}


	private void ThemMonHoc() {
		// TODO Auto-generated method stub
		PhongdaotaoDAO pdt = new PhongdaotaoDAO();
		List<Monhoc> listMonHoc = pdt.getDSSMonhoc();
		listMonHoc.forEach(x -> cbMonHoc.addItem(x.getTenMH().toString().trim()));
	}
	private void ThemKhoa() {
		// TODO Auto-generated method stub
		PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();
		List<Khoa> listKhoa = phongdaotaoDAO.getDSSKhoa();System.out.println(listKhoa);
		listKhoa.forEach(y -> cbmKhoa.addItem(y.getTenKhoa().toString().trim()));
	}

	private ActionListener btnXoaTrang() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtMalop.setText("");
				cbMonHoc.setSelectedIndex(0);
				txtPhonghoc.setText("");
				cbThu.setSelectedIndex(0);
				txtTiethoc.setText("");
				txtTenGV.setText("");
				txtNamhoc.setText("");
				cbHocki.setSelectedIndex(0);
				cbSoLuong.setSelectedIndex(0);
				Canhbao("", txtMalop);
				setDefaultCloseOperation(HIDE_ON_CLOSE);// Dư lại giao diện chính. nếu không bấm tắt sẽ tắt cả 2 giao diện
			}
		};
	}
	public void Canhbao(String mess, JTextField txt)
	{
		lblCanhbao.setText(mess);
		txt.requestFocus();
	}
	private boolean Validate() {

		String maLHP = txtMalop.getText().trim();
		String tenGV =txtTenGV.getText().trim();
		String maPhonghoc= txtPhonghoc.getText().trim();
		String tietday = txtTiethoc.getText().trim();
		String namhoc= txtNamhoc.getText().trim();
		String ngaybatdau = DateFormat.getDateInstance().format(dateChooser_NgayBatDau.getDate());
		String ngayketthuc =DateFormat.getDateInstance().format(dateChooser_NgayKetThuc.getDate());

		if(!( maLHP.matches("^\\d{4}[H][P]\\d{4}")))
		{
			txtMalop.requestFocus();
			Canhbao("Mã LHP: Nhập đúng định dạng 4 số + 'HP'+ 4 số", txtMalop);
			return false;
		}
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
		if(!(namhoc.length()>=2))
		{
			txtNamhoc.requestFocus();
			Canhbao("Điên năm học cho lớp học phần", txtNamhoc);
			return false;
		}
		if((ngaybatdau.equals(ngayketthuc)))
		{
			Canhbao("Ngày bắt đầu không được bằng ngày kết thúc", txtMalop);
			return false;
		}

		return true;
	}
	private ActionListener btnThemLophocphan() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					setDefaultCloseOperation(HIDE_ON_CLOSE);// Dư lại giao diện chính. nếu không bấm tắt sẽ tắt cả 2 giao diện

					if(Validate()!=false)
					{

						String maLHP = txtMalop.getText();
						String tenGV =txtTenGV.getText();
						String tenMonhoc = cbMonHoc.getSelectedItem().toString().trim();
						String maPhonghoc= txtPhonghoc.getText();
						String tietday = txtTiethoc.getText();
						String thu = cbThu.getSelectedItem().toString().trim();
						String ngayBatdau=  DateFormat.getDateInstance().format(dateChooser_NgayBatDau.getDate());
						String ngatKetthuc =  DateFormat.getDateInstance().format(dateChooser_NgayKetThuc.getDate());
						String hocKi = cbHocki.getSelectedItem().toString().trim();
						String namhoc = txtNamhoc.getText();
						String soluongSV = cbSoLuong.getSelectedItem().toString().trim();

						PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();
						String maGV = phongdaotaoDAO.MaGiangvien(tenGV);
						String maMH = phongdaotaoDAO.MaMonhoc(tenMonhoc);
						if (phongdaotaoDAO.themLophocphan(maLHP, maGV, maMH, maPhonghoc, hocKi, namhoc, soluongSV, ngayBatdau, ngatKetthuc, tietday, thu) )
						{
							JOptionPane.showMessageDialog(null	, "Thêm thành công");
						}
						modelDSLopHP.addRow(new Object[] {
								maLHP,
								tenMonhoc,
								tenGV,
								thu,
								tietday,
								maPhonghoc,
								soluongSV,
								hocKi,
								namhoc,
								ngayBatdau,
								ngatKetthuc
						});

					}
				} catch (Exception e1) {
					// TODO: handle exception
					Canhbao("Mã lớp học phần trùng", txtMalop);
				}
			}
		};
	}
}

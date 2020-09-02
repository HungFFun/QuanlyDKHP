package GiaodienPDT;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;

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

import javax.swing.ImageIcon;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import DAO.PhongdaotaoDAO;
import Doituong.Giangvien_GiaovuPDT;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class GD_ThemSinhVien extends JFrame {


	private JPanel contentPane;
	private JTextField txtMaSV;
	private JTextField txtTenSV;
	private JTextField txtSDT;
	private JTextField txtDiachi;
	private JTextField txtMalop;
	private JComboBox<String> cbmTrangThai;
	private JComboBox cbmGioiTinh;
	private JDateChooser dateChooser_Ngaysinh;
	private JLabel lblCanhbao;
	private JComboBox cbTimkiem ;
	JTable tblDSSinhvien;
	DefaultTableModel modelDSSinhvien;
	JScrollPane scrollDSsinhvien;
	private 	PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new GD_ThemSinhVien();
	}

	public GD_ThemSinhVien() {
		GiaoDien();
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);

	}
	public void GiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1253, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Chinh = new JPanel();
		panel_Chinh.setBackground(new Color(255, 255, 240));
		panel_Chinh.setBounds(0, 0, 1242, 575);
		contentPane.add(panel_Chinh);
		panel_Chinh.setLayout(null);

		JButton btnThemSinhvien = new JButton("Thêm Sinh viên");
		btnThemSinhvien.setForeground(new Color(0, 0, 0));
		btnThemSinhvien.setBackground(new Color(255, 255, 240));
		btnThemSinhvien.setIcon(new ImageIcon("D:\\QuanLyDKHP\\plus.png"));
		btnThemSinhvien.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThemSinhvien.setBounds(43, 529, 195, 38);
		btnThemSinhvien.addActionListener(btnThmGingVin());
		btnThemSinhvien.setToolTipText("Nhấn thêm để thêm sinh viên mới");
		panel_Chinh.add(btnThemSinhvien);

		JButton btnXoatrang = new JButton("Xóa Trắng");
		btnXoatrang.setBackground(new Color(255, 255, 240));
		btnXoatrang.setIcon(new ImageIcon("D:\\QuanLyDKHP\\delete.png"));
		btnXoatrang.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoatrang.setBounds(305, 529, 175, 38);
		btnXoatrang.addActionListener(btnXoatrang());
		panel_Chinh.add(btnXoatrang);

		JLabel lblThongtin = new JLabel("Thông tin Sinh Viên");
		lblThongtin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongtin.setBounds(150, 10, 226, 25);
		panel_Chinh.add(lblThongtin);

		JPanel panel_Thongtin = new JPanel();
		panel_Thongtin.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(135, 206, 235)));
		panel_Thongtin.setBackground(new Color(255, 255, 224));
		panel_Thongtin.setBounds(10, 48, 420, 457);
		panel_Chinh.add(panel_Thongtin);
		panel_Thongtin.setLayout(null);

		JLabel lblMaSV = new JLabel("Mã SV:");
		lblMaSV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaSV.setBounds(44, 24, 60, 25);
		panel_Thongtin.add(lblMaSV);
		
				JLabel lblTenSv = new JLabel("Tên SV:");
				lblTenSv.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblTenSv.setBounds(44, 76, 62, 20);
				panel_Thongtin.add(lblTenSv);

		JLabel lblNgaysinh = new JLabel("Ngày Sinh:");
		lblNgaysinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgaysinh.setBounds(44, 171, 96, 20);
		panel_Thongtin.add(lblNgaysinh);

		JLabel lblGioitinh = new JLabel("Giới Tính:");
		lblGioitinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGioitinh.setBounds(40, 127, 85, 20);
		panel_Thongtin.add(lblGioitinh);

		JLabel lblTrangthai = new JLabel("Trạng thái:");
		lblTrangthai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrangthai.setBounds(547, 76, 93, 20);
		panel_Thongtin.add(lblTrangthai);
		
				txtMaSV = new JTextField();
				txtMaSV.setIgnoreRepaint(true);
				txtMaSV.setFont(new Font("Tahoma", Font.BOLD, 15));
				txtMaSV.setColumns(10);
				txtMaSV.setBounds(208, 22, 185, 30);
				panel_Thongtin.add(txtMaSV);

	
		txtTenSV = new JTextField();
		txtTenSV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTenSV.setColumns(10);
		txtTenSV.setBounds(208, 72, 185, 30);
		panel_Thongtin.add(txtTenSV);


		cbmGioiTinh = new JComboBox();
		cbmGioiTinh.setBounds(203, 122, 185, 30);
		panel_Thongtin.add(cbmGioiTinh);
		cbmGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbmGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));

		dateChooser_Ngaysinh = new JDateChooser();
		dateChooser_Ngaysinh.setBounds(203, 171, 185, 30);
		panel_Thongtin.add(dateChooser_Ngaysinh);
		dateChooser_Ngaysinh.setDateFormatString("yyyy-mm-dd");

		cbmTrangThai = new JComboBox<String>();
		cbmTrangThai.setModel(new DefaultComboBoxModel(new String[] {"", "Đang học", "Nghỉ học", "Bảo lưu"}));
		cbmTrangThai.setBounds(208, 284, 185, 30);
		panel_Thongtin.add(cbmTrangThai);
		cbmTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));

		txtSDT = new JTextField();
		txtSDT.setBounds(208, 334, 185, 30);
		panel_Thongtin.add(txtSDT);
		txtSDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSDT.setColumns(10);

		txtDiachi = new JTextField();
		txtDiachi.setBounds(208, 384, 185, 30);
		panel_Thongtin.add(txtDiachi);
		txtDiachi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDiachi.setColumns(10);
		
		txtMalop = new JTextField();
		txtMalop.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMalop.setColumns(10);
		txtMalop.setBounds(208, 230, 185, 30);
		panel_Thongtin.add(txtMalop);
		
		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrangThai.setBounds(44, 289, 96, 25);
		panel_Thongtin.add(lblTrangThai);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSDT.setBounds(44, 339, 70, 25);
		panel_Thongtin.add(lblSDT);
		
		JLabel lblDiachi = new JLabel("Địa chỉ:");
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiachi.setBounds(44, 389, 96, 25);
		panel_Thongtin.add(lblDiachi);
		
		JLabel lblMalop = new JLabel("Mã lớp:");
		lblMalop.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMalop.setBounds(44, 235, 96, 25);
		panel_Thongtin.add(lblMalop);

		JPanel panel_Table = new JPanel();
		panel_Table.setBounds(436, 48, 799, 457);
		panel_Chinh.add(panel_Table);
		panel_Table.setLayout(null);
		String[] tieude = {"Mã SV", " Tên SV","Giới tính","Ngày sinh","SDT","Địa chỉ","Mã lớp","Trạng thái"};

		modelDSSinhvien = new DefaultTableModel(tieude, 0);
		tblDSSinhvien = new JTable(modelDSSinhvien);
		scrollDSsinhvien = new JScrollPane(tblDSSinhvien);
		scrollDSsinhvien.setBounds(0, 0, 795, 457);
		scrollDSsinhvien.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterGiangvien;
		sorterGiangvien = new TableRowSorter<TableModel>(tblDSSinhvien.getModel());
		panel_Table.setLayout(null);
		panel_Table.add(scrollDSsinhvien);



		JLabel lblDanhsachGiangvienVuathemMoi = new JLabel("Danh sách Sinh Viên vừa thêm mới");
		lblDanhsachGiangvienVuathemMoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhsachGiangvienVuathemMoi.setBounds(727, 10, 314, 25);
		panel_Chinh.add(lblDanhsachGiangvienVuathemMoi);

		lblCanhbao = new JLabel("");
		lblCanhbao.setForeground(new Color(255, 0, 0));
		lblCanhbao.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCanhbao.setBounds(507, 529, 624, 28);
		panel_Chinh.add(lblCanhbao);
		cbmTrangThai.addItem("Tiến sĩ khoa học");
		cbmTrangThai.addItem("Tiến sĩ");
		cbmTrangThai.addItem("Thạc sĩ");
		cbmTrangThai.addItem("Cử nhân");
		cbmTrangThai.addItem("Kỹ sư");


	}
	public void Canhbao(String mess, JTextField txt)
	{
		lblCanhbao.setText(mess);
		txt.requestFocus();
	}
	private ActionListener btnThoat() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		};
	}

	private ActionListener btnXoatrang() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtMaSV.setText("");
				txtDiachi.setText("");
				txtSDT.setText("");
				txtTenSV.setText("");
				setDefaultCloseOperation(HIDE_ON_CLOSE);// Dư lại giao diện chính. nếu không bấm tắt sẽ tắt cả 2 giao diện
			}
		};
	}

	private boolean Validate() {

		String ma = txtMaSV.getText().trim();
		String ten = txtTenSV.getText().trim();
		String soDienthoai = txtSDT.getText().trim();
		String diachi = txtDiachi.getText().trim();
		String malop = txtMalop.getText().trim();

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

	private ActionListener btnThmGingVin() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setDefaultCloseOperation(HIDE_ON_CLOSE);// Dư lại giao diện chính. nếu không bấm tắt sẽ tắt cả 2 giao diện

				if(Validate()!=false)
				{
					String ma = txtMaSV.getText();
					String ten = txtTenSV.getText();
					String soDienthoai = txtSDT.getText();
					String diachi = txtDiachi.getText();
					String ngaysinh = DateFormat.getDateInstance().format(dateChooser_Ngaysinh.getDate());
					String giotinh= cbmGioiTinh.getSelectedItem().toString();
					String malop = txtMalop.getText();
					String trangthai= cbmTrangThai.getSelectedItem().toString();
					if (ma.length()==0 || ten.length()==0||soDienthoai.length()==0||diachi.length()==0)
					{
						Canhbao("Điền đầy đủ thông tin trước khi nhật", txtMaSV);
					}
					else
					{
						PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();
						phongdaotaoDAO.themTaikhoan(ma, "123", "Sinh vien");
						if (phongdaotaoDAO.themSinhvien(ma, ten, giotinh, ngaysinh, soDienthoai, diachi, malop, trangthai)!=false)
						{
							JOptionPane.showMessageDialog(null	, "Thêm thành công");
							modelDSSinhvien.addRow(new Object[] {
									txtMaSV.getText(),
									txtTenSV.getText(), 
									cbmGioiTinh.getSelectedIndex(), 
									ngaysinh,
									txtSDT.getText(),
									txtDiachi.getText(),
									txtMalop.getText(),
									cbmTrangThai.getSelectedIndex()
									
							});
						}
						else
							JOptionPane.showMessageDialog(null, "Trùng mã");
					}
				}
			}
		};
	}
}

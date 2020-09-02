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

public class GD_ThemGiangvien extends JFrame {
	private JTextField txtMaGV;
	private JTextField txtTenGV;
	private JTextField txtSDT;
	private JComboBox<String> cbmTrinhdo;
	private JTextField txtDiachi;
	private JPanel contentPane;
	private JComboBox cbmGioiTinh;
	private JComboBox<String> cbmKhoa;
	private JDateChooser dateChooser_Ngaysinh;
	private JLabel lblCanhbao;

	JTable tblDSgiangvien;
	DefaultTableModel modelDSgiangvien;
	JScrollPane scrollDSgiangvien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new GD_ThemGiangvien();
	}

	public GD_ThemGiangvien() {
		GiaoDien();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

		JPanel panel_Thongtin = new JPanel();
		panel_Thongtin.setBackground(new Color(255, 255, 240));
		panel_Thongtin.setBounds(0, 0, 1242, 575);
		contentPane.add(panel_Thongtin);
		panel_Thongtin.setLayout(null);

		JButton btnThmGingVin = new JButton("Thêm Giảng viên");
		btnThmGingVin.setForeground(new Color(0, 0, 0));
		btnThmGingVin.setBackground(new Color(255, 255, 240));
		btnThmGingVin.setIcon(new ImageIcon("D:\\QuanLyDKHP\\plus.png"));
		btnThmGingVin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThmGingVin.setBounds(43, 529, 195, 38);
		btnThmGingVin.addActionListener(btnThemGiangvien());
		panel_Thongtin.add(btnThmGingVin);

		JButton btnXoatrang = new JButton("Xóa Trắng");
		btnXoatrang.setBackground(new Color(255, 255, 240));
		btnXoatrang.setIcon(new ImageIcon("D:\\QuanLyDKHP\\delete.png"));
		btnXoatrang.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoatrang.setBounds(305, 529, 175, 38);
		btnXoatrang.addActionListener(btnXoatrang());
		panel_Thongtin.add(btnXoatrang);

		JLabel lblThongtinGiangvienMoi = new JLabel("Thông tin Giảng viên mơi");
		lblThongtinGiangvienMoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongtinGiangvienMoi.setBounds(150, 10, 226, 25);
		panel_Thongtin.add(lblThongtinGiangvienMoi);

		JPanel panel_KhungVien = new JPanel();
		panel_KhungVien.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(135, 206, 235)));
		panel_KhungVien.setBackground(new Color(255, 255, 224));
		panel_KhungVien.setBounds(10, 48, 420, 457);
		panel_Thongtin.add(panel_KhungVien);
		panel_KhungVien.setLayout(null);

		JLabel lblMaGV = new JLabel("Mã GV:");
		lblMaGV.setBounds(48, 25, 60, 25);
		panel_KhungVien.add(lblMaGV);
		lblMaGV.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblTenGV = new JLabel("Tên GV:");
		lblTenGV.setBounds(48, 76, 62, 20);
		panel_KhungVien.add(lblTenGV);
		lblTenGV.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblGioitinh = new JLabel("Giới Tính:");
		lblGioitinh.setBounds(48, 127, 87, 20);
		panel_KhungVien.add(lblGioitinh);
		lblGioitinh.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNgaysinh = new JLabel("Ngày Sinh:");
		lblNgaysinh.setBounds(48, 181, 90, 20);
		panel_KhungVien.add(lblNgaysinh);
		lblNgaysinh.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblTrinhdo = new JLabel("Trình Độ");
		lblTrinhdo.setBounds(48, 233, 72, 20);
		panel_KhungVien.add(lblTrinhdo);
		lblTrinhdo.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblKhoa = new JLabel("Khoa:");
		lblKhoa.setBounds(51, 292, 45, 20);
		panel_KhungVien.add(lblKhoa);
		lblKhoa.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblSDT = new JLabel("SĐT:");
		lblSDT.setBounds(48, 342, 62, 20);
		panel_KhungVien.add(lblSDT);
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblDiachi = new JLabel("Địa Chỉ:");
		lblDiachi.setBounds(48, 390, 99, 25);
		panel_KhungVien.add(lblDiachi);
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 15));

		txtMaGV = new JTextField();
		txtMaGV.setBounds(203, 23, 185, 30);
		panel_KhungVien.add(txtMaGV);
		txtMaGV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMaGV.setColumns(10);

		txtTenGV = new JTextField();
		txtTenGV.setBounds(203, 72, 185, 30);
		panel_KhungVien.add(txtTenGV);
		txtTenGV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTenGV.setColumns(10);

		cbmGioiTinh = new JComboBox();
		cbmGioiTinh.setBounds(203, 122, 185, 30);
		panel_KhungVien.add(cbmGioiTinh);
		cbmGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbmGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));

		dateChooser_Ngaysinh = new JDateChooser();
		dateChooser_Ngaysinh.setBounds(203, 171, 185, 30);
		panel_KhungVien.add(dateChooser_Ngaysinh);
		dateChooser_Ngaysinh.setDateFormatString("yyyy-mm-dd");

		cbmTrinhdo = new JComboBox<String>();
		cbmTrinhdo.setBounds(203, 228, 185, 30);
		panel_KhungVien.add(cbmTrinhdo);
		cbmTrinhdo.setFont(new Font("Tahoma", Font.BOLD, 15));

		cbmKhoa = new JComboBox<String>();
		cbmKhoa.setModel(new DefaultComboBoxModel(new String[] {"Công nghệ thông tin", "Chính trị", "Kinh tế", "Môi Trường", "Thời Trang"}));
		cbmKhoa.setBounds(203, 287, 185, 30);
		panel_KhungVien.add(cbmKhoa);
		cbmKhoa.setFont(new Font("Tahoma", Font.BOLD, 15));

		txtSDT = new JTextField();
		txtSDT.setBounds(203, 338, 185, 30);
		panel_KhungVien.add(txtSDT);
		txtSDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSDT.setColumns(10);

		txtDiachi = new JTextField();
		txtDiachi.setBounds(203, 388, 185, 30);
		panel_KhungVien.add(txtDiachi);
		txtDiachi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDiachi.setColumns(10);

		JPanel panel_Table = new JPanel();
		panel_Table.setBounds(436, 48, 799, 457);
		panel_Thongtin.add(panel_Table);
		panel_Table.setLayout(null);
		String[] tieude = {"Mã GV", " Tên GV","Giới tính","Ngày sinh","SDT","Địa chỉ","Khoa","Trình độ"};

		modelDSgiangvien = new DefaultTableModel(tieude, 0);
		tblDSgiangvien = new JTable(modelDSgiangvien);
		scrollDSgiangvien = new JScrollPane(tblDSgiangvien);
		scrollDSgiangvien.setBounds(0, 0, 795, 457);
		scrollDSgiangvien.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterGiangvien;
		sorterGiangvien = new TableRowSorter<TableModel>(tblDSgiangvien.getModel());
		panel_Table.setLayout(null);
		panel_Table.add(scrollDSgiangvien);



		JLabel lblDanhsachGiangvienVuathemMoi = new JLabel("Danh sách Giảng viên vừa thêm mới");
		lblDanhsachGiangvienVuathemMoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhsachGiangvienVuathemMoi.setBounds(727, 10, 314, 25);
		panel_Thongtin.add(lblDanhsachGiangvienVuathemMoi);

		lblCanhbao = new JLabel("");
		lblCanhbao.setForeground(new Color(255, 0, 0));
		lblCanhbao.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCanhbao.setBounds(507, 529, 471, 28);
		panel_Thongtin.add(lblCanhbao);
		cbmTrinhdo.addItem("Tiến sĩ khoa học");
		cbmTrinhdo.addItem("Tiến sĩ");
		cbmTrinhdo.addItem("Thạc sĩ");
		cbmTrinhdo.addItem("Cử nhân");
		cbmTrinhdo.addItem("Kỹ sư");


	}
	public void Canhbao(String mess, JTextField txt)
	{
		lblCanhbao.setText(mess);
		txt.requestFocus();
	}

	private ActionListener btnXoatrang() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtMaGV.setText("");
				txtDiachi.setText("");
				txtSDT.setText("");
				txtTenGV.setText("");
				setDefaultCloseOperation(HIDE_ON_CLOSE);// Dư lại giao diện chính. nếu không bấm tắt sẽ tắt cả 2 giao diện
			}
		};
	}

	private boolean Validate() {


		String ma = txtMaGV.getText().trim();
		String ten = txtTenGV.getText().trim();
		String soDienthoai = txtSDT.getText().trim();
		String diachi = txtDiachi.getText().trim();
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

		return true;
	}

	private ActionListener btnThemGiangvien() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setDefaultCloseOperation(HIDE_ON_CLOSE);// Dư lại giao diện chính. nếu không bấm tắt sẽ tắt cả 2 giao diện
				if(Validate()!=false)
				{
					String ma = txtMaGV.getText();
					String ten = txtTenGV.getText();
					String soDienthoai = txtSDT.getText();
					String diachi = txtDiachi.getText();
					String gioitinh = cbmGioiTinh.getSelectedItem().toString();
					String khoa = cbmKhoa.getSelectedItem().toString();
					String trinhdo = cbmTrinhdo.getSelectedItem().toString();
					String ngaysinh = DateFormat.getDateInstance().format(dateChooser_Ngaysinh.getDate());
					if (ma.length()==0 || ten.length()==0||soDienthoai.length()==0||diachi.length()==0)
					{
						Canhbao("Điền đầy đủ thông tin trước khi nhật", txtMaGV);
					}
					else
					{
						PhongdaotaoDAO phongdaotaoDAO = new PhongdaotaoDAO();
						phongdaotaoDAO.themTaikhoan(ma, "123", "Giang vien");
						if (phongdaotaoDAO.themGiangvien(ma, ten, gioitinh, ngaysinh, soDienthoai, diachi, khoa, trinhdo))
						{
							JOptionPane.showMessageDialog(null	, "Thêm thành công");
							modelDSgiangvien.setRowCount(0);
							
						}
						modelDSgiangvien.addRow(new Object[] {
								txtMaGV.getText(),
								txtTenGV.getText(), 
								cbmGioiTinh.getSelectedIndex(), 
								ngaysinh,
								txtSDT.getText(),
								txtDiachi.getText(),
								cbmKhoa.getSelectedIndex(),
								cbmTrinhdo.getSelectedIndex()

						});
					}
				}
			}
		};
	}
}

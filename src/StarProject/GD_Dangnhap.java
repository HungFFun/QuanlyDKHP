package StarProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


import DAO.TaikhoanDAO;
import Doituong.taikhoan;
import DoituongData.Thongtindangnhap;


import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class GD_Dangnhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSinhvien;
	private JTextField txtMatKhau;
	Component component = this;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new GD_Dangnhap();
	}

	/**
	 * Create the frame.
	 */
	public GD_Dangnhap() {
		GiaoDien();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);

	}
	public void GiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		try {
			BufferedImage h1;
			ImageIcon icon1;
			h1 = ImageIO.read(new File("phongdaotao.jpg"));
			icon1 = new ImageIcon(h1.getScaledInstance(988, 123, h1.SCALE_SMOOTH));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 10, 324, 384);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 224));
		panel_5.setBounds(10, 10, 306, 363);
		panel.add(panel_5);
		panel_5.setBorder(new TitledBorder(null, "\u0110\u0103ng Nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setLayout(null);

		JLabel lblMaSinhvien = new JLabel("Mã Sinh viên-Giảng viên");
		lblMaSinhvien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaSinhvien.setBounds(68, 58, 201, 25);
		panel_5.add(lblMaSinhvien);

		txtMaSinhvien = new JTextField();
		txtMaSinhvien.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMaSinhvien.setBackground(new Color(255, 250, 250));
		txtMaSinhvien.setBounds(67, 105, 180, 40);
		txtMaSinhvien.setText("admin");
		txtMaSinhvien.addKeyListener(txtMatKhau());
		panel_5.add(txtMaSinhvien);
		txtMaSinhvien.setColumns(10);

		JLabel lblMatkhau = new JLabel("Mật khẩu:");
		lblMatkhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMatkhau.setBounds(73, 167, 127, 28);
		panel_5.add(lblMatkhau);

		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMatKhau.setBackground(new Color(255, 250, 250));
		txtMatKhau.setBounds(70, 215, 177, 40);
		txtMatKhau.setText("123");
		txtMatKhau.addKeyListener(txtMatKhau());
		panel_5.add(txtMatKhau);
		txtMatKhau.setColumns(10);

		JButton btnDangnhap = new JButton("Đăng nhập");
		btnDangnhap.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\login.png"));
		btnDangnhap.addActionListener(btnDangnhap());
		btnDangnhap.setBackground(new Color(255, 255, 224));
		btnDangnhap.setFocusable(false);
		btnDangnhap.setForeground(new Color(0, 0, 0));
		btnDangnhap.setBounds(67, 301, 180, 40);
		panel_5.add(btnDangnhap);
		try {
			BufferedImage h2;
			ImageIcon icon2;
			h2= ImageIO.read(new File("huongdandkhp.jpg"));
			icon2 = new ImageIcon(h2.getScaledInstance(674, 303, h2.SCALE_SMOOTH));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	; 

	private KeyListener txtMatKhau() {
		// TODO Auto-generated method stub
		return new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String ma = txtMaSinhvien.getText();
					String matkhau = txtMatKhau.getText();

					Thongtindangnhap thongtindangnhap = new Thongtindangnhap();

					thongtindangnhap = new TaikhoanDAO().getthongtinDangnhapSV(ma, matkhau);

					Thongtindangnhap thongtindangnhapGV = new Thongtindangnhap();
					thongtindangnhapGV = new TaikhoanDAO().getthongtinDangnhapGV(ma, matkhau);

					if ((ma.matches("^[2][0][1][5][G][V][1][0][2][0]$")) )
					{
						new GD_Trangchu(thongtindangnhapGV);
						component.setVisible(false);
					}
					else  if((ma.matches("[2][0][1][5][G][V]\\d{4}")) )
					{

						new GD_Trangchu(thongtindangnhapGV);
						component.setVisible(false);
					}
					else  if((ma.matches("[a][d][m][i][n]")) )
					{

						new GD_Trangchu(thongtindangnhapGV);
						component.setVisible(false);
					}
					else if ((ma.matches("^[1][3][S][V]\\d{6}$")) )//
					{

						new GD_Trangchu(thongtindangnhap);
						component.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Tài Khoản hoặc mật khẩu không đúng. \n\t          XIN VUI LÒNG NHẬP LẠI");
					}
				}
			}
		};
	}

	
	private ActionListener btnDangnhap() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ma = txtMaSinhvien.getText();
				String matkhau = txtMatKhau.getText();

				Thongtindangnhap thongtindangnhap = new Thongtindangnhap();

				thongtindangnhap = new TaikhoanDAO().getthongtinDangnhapSV(ma, matkhau);

				Thongtindangnhap thongtindangnhapGV = new Thongtindangnhap();
				thongtindangnhapGV = new TaikhoanDAO().getthongtinDangnhapGV(ma, matkhau);

				if ((ma.matches("^[2][0][1][5][G][V][1][0][2][0]$")) )
				{
					new GD_Trangchu(thongtindangnhapGV);
					component.setVisible(false);
				}
				else  if((ma.matches("[2][0][1][5][G][V]\\d{4}")) )
				{

					new GD_Trangchu(thongtindangnhapGV);
					component.setVisible(false);
				}
				else  if((ma.matches("[a][d][m][i][n]")) )
				{

					new GD_Trangchu(thongtindangnhapGV);
					component.setVisible(false);
				}
				else if ((ma.matches("^[1][3][S][V]\\d{6}$")) )//
				{

					new GD_Trangchu(thongtindangnhap);
					component.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,"Tài Khoản hoặc mật khẩu không đúng. \n\t          XIN VUI LÒNG NHẬP LẠI");
				}




			}
		};
	}
}

package GiaodienPDT;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import DAO.PhongdaotaoDAO;
import DAO.TaikhoanDAO;
import DoituongData.Thongtindangnhap;
import StarProject.GD_Dangnhap;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;

public class GD_DoiMatkhau extends JPanel {
	private JTextField txtxTaikhoan;
	private JTextField txtMatkhau;
	private JTextField txtMatkhaumoi;
	private JTextField txtNhaplaiMatkhau;
	private JLabel lblMess;
	Component component = this;
	
	

	/**
	 * Create the panel.
	 */
	public GD_DoiMatkhau(Thongtindangnhap thongtindangnhap) {
		setBackground(new Color(255, 255, 240));
		setLayout(null);

		JLabel lbliMtKhu = new JLabel("Đổi mật khẩu");
		lbliMtKhu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbliMtKhu.setBounds(394, 32, 167, 49);
		add(lbliMtKhu);

		JLabel lblTiKhon = new JLabel("Tài khoản:");
		lblTiKhon.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTiKhon.setBounds(208, 110, 149, 29);

		add(lblTiKhon);

		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMtKhu.setBounds(208, 178, 149, 29);
		add(lblMtKhu);

		JLabel lblMtKhuMi = new JLabel("Mật khẩu mới:");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMtKhuMi.setBounds(208, 251, 149, 29);
		add(lblMtKhuMi);

		JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu mới:");
		lblNhpLiMt.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNhpLiMt.setBounds(208, 324, 211, 29);
		add(lblNhpLiMt);

		txtxTaikhoan = new JTextField();
		txtxTaikhoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtxTaikhoan.setBounds(610, 111, 211, 29);
		txtxTaikhoan.setColumns(10);
		txtxTaikhoan.setText(thongtindangnhap.getMa());
		add(txtxTaikhoan);

		txtMatkhau = new JTextField();
		txtMatkhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMatkhau.setColumns(10);
		txtMatkhau.setBounds(610, 179, 211, 29);
		add(txtMatkhau);

		txtMatkhaumoi = new JTextField();
		txtMatkhaumoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMatkhaumoi.setColumns(10);
		txtMatkhaumoi.setBounds(610, 252, 211, 29);
		add(txtMatkhaumoi);

		txtNhaplaiMatkhau = new JTextField();
		txtNhaplaiMatkhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNhaplaiMatkhau.setColumns(10);
		txtNhaplaiMatkhau.setBounds(610, 311, 211, 29);
		add(txtNhaplaiMatkhau);

		JButton btnDoimatkhau = new JButton("Đổi mật khẩu");
		btnDoimatkhau.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\refresh (1).png"));
		btnDoimatkhau.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDoimatkhau.setBounds(208, 425, 200, 29);
		btnDoimatkhau.addActionListener(btnDoimatkhau());
		add(btnDoimatkhau);

		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setIcon(new ImageIcon("D:\\QuanLyDKHP_v2\\eraser.png"));
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaTrang.setBounds(621, 425, 200, 29);
		btnXoaTrang.addActionListener(btnXoaTrang());
		add(btnXoaTrang);

		lblMess = new JLabel("");
		lblMess.setForeground(Color.RED);
		lblMess.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMess.setBounds(269, 373, 552, 35);
		add(lblMess);

	}
	public void Canhbao(String mess, JTextField txt)
	{
		lblMess.setText(mess);
		txt.requestFocus();
	}

	private ActionListener btnDoimatkhau() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String matkhau = txtMatkhau.getText();
				String taikhoan = txtxTaikhoan.getText();
				String matkhaumoi = txtMatkhaumoi.getText();
				String nhaplaimatkhau = txtNhaplaiMatkhau.getText();
				if ( matkhau.length()==0 || taikhoan.length()==0|| matkhaumoi.length()==0||nhaplaimatkhau.length()==0)
				{
					Canhbao("Điền đủ thông tin trước khi đổi mật khẩu", txtMatkhau);
				}
				else
				{
					
					TaikhoanDAO taikhoanDAO = new TaikhoanDAO();
					String matKhaumoi = txtMatkhaumoi.getText();
					String NhaplaiMatkhau =txtNhaplaiMatkhau.getText();
					if(matKhaumoi.equals(NhaplaiMatkhau))
					{
						
						taikhoanDAO.DoiMatkhau(txtxTaikhoan.getText(), txtNhaplaiMatkhau.getText());
						JOptionPane.showMessageDialog(null, "Đổi thanh công - Đăng nhập lại để tiếp tục");
						new GD_Dangnhap();
						component.setVisible(false);
						
					}
					else
					{
						Canhbao("Nhập lại mật khẩu không trùng với mật khẩu mới", txtMatkhaumoi);
					}
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
				txtMatkhaumoi.setText("");
				txtNhaplaiMatkhau.setText("");
				txtMatkhau.setText("");
				lblMess.setText("");
			}
		};
	}

}

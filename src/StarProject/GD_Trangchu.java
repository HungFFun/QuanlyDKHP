package StarProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DoituongData.Thongtindangnhap;
import GiaodienGV.GV_Lichday;
import GiaodienGV.GV_Nhapdiem;
import GiaodienGV.GV_Thongtin;
import GiaodienPDT.GD_DoiMatkhau;
import GiaodienPDT.GD_QuanLymonhoc;
import GiaodienPDT.GD_QuanlyGiangvien;
import GiaodienPDT.GD_QuanlyLopHocphan;
import GiaodienPDT.GD_QuanlySinhvien;

import GiaodienSV.SV_Ketquahoctap;
import GiaodienSV.SV_Thongtinsinhvien;
import GiaodienSV.SV_XemlicHoc;
import GiaodienSV.Sv_Dangkihocphan;

public class GD_Trangchu extends JFrame {
	Component component = this;
	private JPanel contentPane;
	private JPanel panel_Chinh;
	private JPanel panel_QuanluHocphan;
	private JPanel panel_QuanlyGiangvien;
	private JPanel panel_QuanlySinhvien;
	private JPanel panel_QuanlyMonhoc;
	
	private JPanel panel_Doimatkhau;
	private JPanel panel_Thongtincanhan;
	private JPanel panel_SVXemlichoc;
	private JPanel panel_SVketquahoctap;
	private JPanel panel_SVDangkihocphan;
	
	private JPanel panel_GVThongtin;
	private JPanel panel_GVLichday;
	private JPanel panel_GVNhapdiem;
	private JMenu mnChucnang;
	private JMenu mnSinhVin;
	private JMenu mnGingVin;
	
	private String ma, ten;
private Thongtindangnhap thongtindangnhap1 = new Thongtindangnhap();
	public GD_Trangchu(Thongtindangnhap thongtindangnhap)  {
		GiaoDien(thongtindangnhap);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		ma= thongtindangnhap.getMa();
		ten= thongtindangnhap.getTen();
		thongtindangnhap1 = thongtindangnhap;
		PhanQuyen();
	}
	public  void GiaoDien(Thongtindangnhap thongtindangnhap) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Trai = new JPanel();
		panel_Trai.setBounds(0, 0, 69, 741);
		panel_Trai.setBackground(new Color(51, 204, 255));
		contentPane.add(panel_Trai);
		
		JPanel panel_phai = new JPanel();
		panel_phai.setBounds(1079, 0, 57, 741);
		panel_phai.setBackground(new Color(51, 204, 255));
		contentPane.add(panel_phai);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setBounds(72, 0, 1007, 88);
		panel_Title.setBackground(Color.WHITE);
		panel_Title.setLayout(null);
		
		try {
			BufferedImage h1;
			ImageIcon icon1;
			h1 = ImageIO.read(new File("phongdaotao.jpg"));
			icon1 = new ImageIcon(h1.getScaledInstance(988, 123, h1.SCALE_SMOOTH));
			JLabel lbltop = new JLabel();
			lbltop.setForeground(Color.WHITE);
			lbltop.setLayout(null);
			lbltop.setBounds(0, 10, 987, 78); 
			lbltop.setIcon(icon1);  
			panel_Title.add(lbltop);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					

		contentPane.add(panel_Title);
		try {
			BufferedImage h2;
			ImageIcon icon2;
			h2= ImageIO.read(new File("huongdandkhp.jpg"));
			icon2 = new ImageIcon(h2.getScaledInstance(674, 303, h2.SCALE_SMOOTH));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		JPanel panel_Menu = new JPanel();
		panel_Menu.setBounds(72, 86, 1007, 40);
		contentPane.add(panel_Menu);
		panel_Menu.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(135, 206, 235));
		menuBar.setBounds(0, 0, 1007, 40);
		panel_Menu.add(menuBar);
		
		JMenu mnTrangCh = new JMenu("      Trang chủ      ");
		mnTrangCh.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnTrangCh);
		
		JMenuItem mntmThongbao = new JMenuItem(" Hướng dẫn sử dụng      ");
		mnTrangCh.add(mntmThongbao);
		
		mnChucnang = new JMenu("              Phòng đào tạo          ");
		mnChucnang.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnChucnang);
		
		JMenuItem mntmQuanlihocphan = new JMenuItem("        Quản lý lớp học phần       ");
		mntmQuanlihocphan.addActionListener(mntmQuanlihocphan());
		mnChucnang.add(mntmQuanlihocphan);
		
		JMenuItem mntmQuanlisinhvien = new JMenuItem("        Quản lý sinh viên       ");
		mntmQuanlisinhvien.addActionListener(mntmQuanlisinhvien());
		mnChucnang.add(mntmQuanlisinhvien);
		
		JMenuItem mntmQuanliGiangvien = new JMenuItem("        Quản lý giảng viên      ");
		mntmQuanliGiangvien.addActionListener(mntmQuanliGiangvien());
		mnChucnang.add(mntmQuanliGiangvien);
		
		JMenuItem mntmQuanlyDiem = new JMenuItem("        Quản lý điểm       ");
		mntmQuanlyDiem.addActionListener(mntmQuanlyDiem());
		mnChucnang.add(mntmQuanlyDiem);
		
		JMenuItem mntmQuanLyMon = new JMenuItem("        Quản lý môn học");
		mntmQuanLyMon.addActionListener(mntmQuanLyMon());
		mnChucnang.add(mntmQuanLyMon);
		
		mnSinhVin = new JMenu("            Sinh viên                      ");
		mnSinhVin.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnSinhVin);
		
		JMenuItem mntmThongtinsinhvien = new JMenuItem("        Thông tin sinh viên");
		mntmThongtinsinhvien.addActionListener(mntmThngTinSinh());
		mnSinhVin.add(mntmThongtinsinhvien);
		
		JMenuItem mntmKetquahoctap = new JMenuItem("        Kết quả học tập");
		mntmKetquahoctap.addActionListener(mntmKtQuHc());
		mnSinhVin.add(mntmKetquahoctap);
		
		JMenuItem mntmXemLichHoc = new JMenuItem("        Xem lịch học");
		mntmXemLichHoc.addActionListener(mntmXemLichHc());
		mnSinhVin.add(mntmXemLichHoc);
		
		JMenuItem mntmDangkihocphan = new JMenuItem("        Đăng kí học phần");
		mntmDangkihocphan.addActionListener(mntmangKHc());
		mnSinhVin.add(mntmDangkihocphan);
		
		mnGingVin = new JMenu("           Giảng viên             ");
		mnGingVin.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnGingVin);
		
		JMenuItem mntmXemThongtin = new JMenuItem("        Xem thông tin");
		mntmXemThongtin.addActionListener(mntmXemThongtin());
		mnGingVin.add(mntmXemThongtin);
		
		JMenuItem mntmXemlichday = new JMenuItem("        Xem lịch dạy");
		mntmXemlichday.addActionListener(mntmXemlichday());
		mnGingVin.add(mntmXemlichday);
		
		JMenuItem mntmNhapdiem = new JMenuItem("        Nhập điểm");
		mntmNhapdiem.addActionListener(mntmNhapdiem());
		mnGingVin.add(mntmNhapdiem);
		
		JMenu mnTaikhoan = new JMenu("                Tài khoản         ");
		mnTaikhoan.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnTaikhoan);
		
		JMenuItem mntmDoimatkhau = new JMenuItem("         Đổi mật khẩu");
		mntmDoimatkhau.addActionListener(mntmiMtKhu());
		mnTaikhoan.add(mntmDoimatkhau);
		
		JMenuItem mntmDangxuat = new JMenuItem("         Đăng xuất");
		mntmDangxuat.addActionListener(mntmngXut());
		mnTaikhoan.add(mntmDangxuat);
		
		panel_Chinh = new JPanel();
		panel_Chinh.setBounds(72, 126, 1007, 615);
		contentPane.add(panel_Chinh);
		panel_Chinh.setLayout(null);
	}



	private void PhanQuyen() {
		// TODO Auto-generated method stub
		if (thongtindangnhap1.getChucVu().equalsIgnoreCase("Sinh Viên")) {
			mnChucnang.setEnabled(false);
			mnGingVin.setEnabled(false);
		}
		else if(thongtindangnhap1.getChucVu().equalsIgnoreCase("Giảng Viên")) {
			mnChucnang.setEnabled(false);
			mnSinhVin.setEnabled(false);
		}
		else if(thongtindangnhap1.getChucVu().equalsIgnoreCase("Phòng đào tạo")) {
			mnGingVin.setEnabled(false);
			mnSinhVin.setEnabled(false);
		}
	}
	private ActionListener mntmNhapdiem() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_GVNhapdiem= new GV_Nhapdiem(thongtindangnhap1);
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_GVNhapdiem);
				panel_GVNhapdiem.setBounds(15, 0,1007, 637);
			}
		};
	}
	private ActionListener mntmQuanLyMon() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel_QuanlyMonhoc= new GD_QuanLymonhoc();
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_QuanlyMonhoc);
				panel_QuanlyMonhoc.setBounds(0, 0,1007, 637);
			}
		};
	}
	private ActionListener mntmXemlichday() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_GVLichday= new GV_Lichday(thongtindangnhap1);
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_GVLichday);
				panel_GVLichday.setBounds(0, 0,1007, 637);
			}
		};
	}
	private ActionListener mntmXemThongtin() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_GVThongtin= new GV_Thongtin(thongtindangnhap1);
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_GVThongtin);
				panel_GVThongtin.setBounds(0, 0,1007, 637);
			}
		};
	}
	private ActionListener mntmangKHc() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_SVDangkihocphan= new Sv_Dangkihocphan(thongtindangnhap1);
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_SVDangkihocphan);
				panel_SVDangkihocphan.setBounds(0, 0, 1007, 637);
			}
		};
	}
	private ActionListener mntmKtQuHc() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_SVketquahoctap= new SV_Ketquahoctap(thongtindangnhap1);
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_SVketquahoctap);
				panel_SVketquahoctap.setBounds(0, 0, 1007, 637);
			}
		};
	}
	private ActionListener mntmXemLichHc() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_SVXemlichoc= new SV_XemlicHoc(thongtindangnhap1);
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_SVXemlichoc);
				panel_SVXemlichoc.setBounds(0, 0, 1007, 637);
			}
		};
	}
	private ActionListener mntmThngTinSinh() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel_Thongtincanhan= new SV_Thongtinsinhvien(thongtindangnhap1);
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_Thongtincanhan);
				panel_Thongtincanhan.setBounds(0, 0,1007, 637);
			}
		};
	}


	private ActionListener mntmngXut() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GD_Dangnhap();
				component.setVisible(false);
			}
		};
	}

	private ActionListener mntmiMtKhu() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_Doimatkhau= new GD_DoiMatkhau(thongtindangnhap1);
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_Doimatkhau);
				panel_Doimatkhau.setBounds(0, 0,1007, 637);
			}
		};
	}



	private ActionListener mntmQuanlyDiem() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_GVNhapdiem= new GV_Nhapdiem(thongtindangnhap1);
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_GVNhapdiem);
				panel_GVNhapdiem.setBounds(0, 0, 1007, 637);
			}
		};
	}

	private ActionListener mntmQuanliGiangvien() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_QuanlyGiangvien= new GD_QuanlyGiangvien();
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_QuanlyGiangvien);
				panel_QuanlyGiangvien.setBounds(0, 0, 1007, 637);
			}
		};
	}

	private ActionListener mntmQuanlisinhvien() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_QuanlySinhvien= new GD_QuanlySinhvien();
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_QuanlySinhvien);
				panel_QuanlySinhvien.setBounds(0, 0,1007, 637);
			}
		};
	}

	private ActionListener mntmQuanlihocphan() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel_QuanluHocphan= new GD_QuanlyLopHocphan();
				panel_Chinh.removeAll();
				panel_Chinh.add(panel_QuanluHocphan);
				panel_QuanluHocphan.setBounds(0, 0,1007, 637);
			}
		};
	}
}

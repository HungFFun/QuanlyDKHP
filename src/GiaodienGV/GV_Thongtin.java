package GiaodienGV;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import DAO.GiangvienDAO;
import DoituongData.ThongtinGiangvien;
import DoituongData.Thongtindangnhap;

public class GV_Thongtin extends JPanel {

	/**
	 * Create the panel.
	 */
	public GV_Thongtin(Thongtindangnhap thongtindangnhap) {
		setBackground(new Color(255, 255, 240));
		setLayout(null);
		JPanel panel_Thongtinsinhvien = new JPanel();
		panel_Thongtinsinhvien.setBackground(new Color(255, 255, 224));
		panel_Thongtinsinhvien.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 191, 255)));
		panel_Thongtinsinhvien.setBounds(10, 10, 974, 171);
		add(panel_Thongtinsinhvien);
		panel_Thongtinsinhvien.setLayout(null);
		
		JLabel lblHinhSV = new JLabel("Hinh");
		lblHinhSV.setBounds(27, 27, 76, 103);
		panel_Thongtinsinhvien.add(lblHinhSV);
		
		
		
		JLabel lblMaGV = new JLabel("Mã giảng viên:");
		lblMaGV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaGV.setBounds(161, 21, 125, 33);
		panel_Thongtinsinhvien.add(lblMaGV);
		
		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrangThai.setBounds(161, 72, 109, 33);
		panel_Thongtinsinhvien.add(lblTrangThai);
		
		JLabel lblNVaoTruong = new JLabel("Ngày vào  trường:");
		lblNVaoTruong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNVaoTruong.setBounds(161, 115, 142, 33);
		panel_Thongtinsinhvien.add(lblNVaoTruong);
		
		JLabel lblKhoa = new JLabel("Khoa:");
		lblKhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKhoa.setBounds(534, 21, 61, 33);
		panel_Thongtinsinhvien.add(lblKhoa);
		
		JLabel lblCoSo = new JLabel("Cơ Sở:");
		lblCoSo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCoSo.setBounds(534, 103, 70, 33);
		panel_Thongtinsinhvien.add(lblCoSo);
		
		JLabel lblLoaiHinhDaoTao = new JLabel("Trình độ:");
		lblLoaiHinhDaoTao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiHinhDaoTao.setBounds(534, 61, 90, 33);
		panel_Thongtinsinhvien.add(lblLoaiHinhDaoTao);
		
		// lấy thông tin giảng viên
		
		ThongtinGiangvien thongtinGiangvien = new GiangvienDAO().getThongtinGiangvien(thongtindangnhap.getMa());
		
		JLabel lblVlMagiangvien = new JLabel("");
		lblVlMagiangvien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVlMagiangvien.setBounds(313, 21, 100, 24);
		lblVlMagiangvien.setText(thongtinGiangvien.getMaGV());
		panel_Thongtinsinhvien.add(lblVlMagiangvien);
		
		JLabel lblVlTrangthai = new JLabel("Đang dạy");
		lblVlTrangthai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVlTrangthai.setBounds(313, 65, 100, 24);
		panel_Thongtinsinhvien.add(lblVlTrangthai);
		
		JLabel lblVLNgayvaotruong = new JLabel("");
		lblVLNgayvaotruong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVLNgayvaotruong.setBounds(313, 115, 100, 24);
		panel_Thongtinsinhvien.add(lblVLNgayvaotruong);
		
		JLabel lblVLkhoa = new JLabel("");
		lblVLkhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVLkhoa.setBounds(739, 21, 100, 24);
		lblVLkhoa.setText(thongtinGiangvien.getKhoa());
		panel_Thongtinsinhvien.add(lblVLkhoa);
		
		JLabel lblVLTrinhdo = new JLabel("");
		lblVLTrinhdo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVLTrinhdo.setBounds(739, 70, 100, 24);
		lblVLTrinhdo.setText(thongtinGiangvien.getTrinhdo());
		panel_Thongtinsinhvien.add(lblVLTrinhdo);
		
		JLabel lblVLcoso = new JLabel("TP.HCM");
		lblVLcoso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVLcoso.setBounds(739, 112, 100, 24);
		panel_Thongtinsinhvien.add(lblVLcoso);
		
		JPanel panel_Thontincanhan = new JPanel();
		panel_Thontincanhan.setBackground(new Color(255, 255, 224));
		panel_Thontincanhan.setBorder(new TitledBorder(null, "Thông tin cá nhân", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 191, 255)));
		panel_Thontincanhan.setBounds(10, 197, 974, 265);
		add(panel_Thontincanhan);
		panel_Thontincanhan.setLayout(null);
		
		JLabel lblDanToc = new JLabel("Dân tộc:");
		lblDanToc.setBounds(156, 135, 78, 34);
		panel_Thontincanhan.add(lblDanToc);
		lblDanToc.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblHoTen = new JLabel("Họ tên:");
		lblHoTen.setBounds(156, 33, 78, 33);
		panel_Thontincanhan.add(lblHoTen);
		lblHoTen.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblDienthoai = new JLabel("Điện thoại:");
		lblDienthoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDienthoai.setBounds(156, 84, 85, 33);
		panel_Thontincanhan.add(lblDienthoai);
		
		JLabel lblNoiSinh = new JLabel("Nợi sinh:");
		lblNoiSinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNoiSinh.setBounds(548, 33, 70, 31);
		panel_Thontincanhan.add(lblNoiSinh);
		
		JLabel lblTonGiao = new JLabel("Tôn giáo:");
		lblTonGiao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTonGiao.setBounds(548, 77, 70, 24);
		panel_Thontincanhan.add(lblTonGiao);
		
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCMND.setBounds(548, 125, 70, 25);
		panel_Thontincanhan.add(lblCMND);
		
		JLabel lblNoicap = new JLabel("Nơi cấp:");
		lblNoicap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNoicap.setBounds(548, 186, 70, 25);
		panel_Thontincanhan.add(lblNoicap);
		
		JLabel lblMail = new JLabel("Email:");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMail.setBounds(156, 181, 78, 34);
		panel_Thontincanhan.add(lblMail);
		
		JLabel lblVlHoten = new JLabel("");
		lblVlHoten.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVlHoten.setBounds(319, 41, 100, 24);
		lblVlHoten.setText(thongtinGiangvien.getTenGV());
		panel_Thontincanhan.add(lblVlHoten);
		
		JLabel lblVldantoc = new JLabel("Kinh");
		lblVldantoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVldantoc.setBounds(319, 141, 100, 24);
		panel_Thontincanhan.add(lblVldantoc);
		
		JLabel lblSdt = new JLabel("");
		lblSdt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSdt.setBounds(319, 82, 135, 24);
		lblSdt.setText(thongtinGiangvien.getSdt());
		panel_Thontincanhan.add(lblSdt);
		
		JLabel lblNgaysinh = new JLabel("");
		lblNgaysinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgaysinh.setBounds(744, 36, 100, 24);
		lblNgaysinh.setText(thongtinGiangvien.getNgaysinh().toString());
		panel_Thontincanhan.add(lblNgaysinh);
		
		JLabel lblVlTongiao = new JLabel("Không");
		lblVlTongiao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVlTongiao.setBounds(754, 77, 100, 24);
		panel_Thontincanhan.add(lblVlTongiao);

	}

}

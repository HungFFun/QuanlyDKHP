package GiaodienSV;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import DAO.SinhvienDAO;
import DoituongData.ThongtinSinhvien;
import DoituongData.Thongtindangnhap;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class SV_Thongtinsinhvien extends JPanel {

	/**
	 * Create the panel.
	 */
	public SV_Thongtinsinhvien(Thongtindangnhap thongtindangnhap) {
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		
		JPanel panel_Thongtinsinhvien = new JPanel();
		panel_Thongtinsinhvien.setBackground(new Color(255, 255, 224));
		panel_Thongtinsinhvien.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_Thongtinsinhvien.setBounds(10, 38, 987, 215);
		add(panel_Thongtinsinhvien);
		panel_Thongtinsinhvien.setLayout(null);
		
		
		
		
		JLabel lblHinhSV = new JLabel("Hinh");
		lblHinhSV.setBounds(20, 21, 82, 97);
		panel_Thongtinsinhvien.add(lblHinhSV);
		
		JLabel lblMasinhvien = new JLabel("MSV:");
		lblMasinhvien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMasinhvien.setBounds(30, 134, 54, 25);
		panel_Thongtinsinhvien.add(lblMasinhvien);
		
		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrangThai.setBounds(196, 21, 102, 33);
		panel_Thongtinsinhvien.add(lblTrangThai);
		
		JLabel lblNVaoTruong = new JLabel("Ngày vào  trường:");
		lblNVaoTruong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNVaoTruong.setBounds(196, 159, 150, 33);
		panel_Thongtinsinhvien.add(lblNVaoTruong);
		
		JLabel lblKhoa = new JLabel("Khoa:");
		lblKhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKhoa.setBounds(196, 64, 102, 33);
		panel_Thongtinsinhvien.add(lblKhoa);
		
		JLabel lblNganh = new JLabel("Ngành:");
		lblNganh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNganh.setBounds(196, 107, 102, 33);
		panel_Thongtinsinhvien.add(lblNganh);
		
		JLabel lblNienkhoa = new JLabel("Niên khóa:");
		lblNienkhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNienkhoa.setBounds(552, 21, 102, 33);
		panel_Thongtinsinhvien.add(lblNienkhoa);
		
		JLabel lblCoSo = new JLabel("Cơ Sở:");
		lblCoSo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCoSo.setBounds(552, 65, 102, 33);
		panel_Thongtinsinhvien.add(lblCoSo);
		
		JLabel lblLoaiHinhDaoTao = new JLabel("Loại hình đào tạo:");
		lblLoaiHinhDaoTao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiHinhDaoTao.setBounds(552, 107, 138, 33);
		panel_Thongtinsinhvien.add(lblLoaiHinhDaoTao);
		
		JLabel lblLop = new JLabel("Lớp:");
		lblLop.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLop.setBounds(552, 159, 102, 33);
		panel_Thongtinsinhvien.add(lblLop);
		
		
		
		
		
		JPanel panel_Thongtincanhan = new JPanel();
		panel_Thongtincanhan.setBackground(new Color(255, 255, 224));
		panel_Thongtincanhan.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin c\u00E1 nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_Thongtincanhan.setBounds(10, 261, 987, 265);
		add(panel_Thongtincanhan);
		panel_Thongtincanhan.setLayout(null);
		
		JLabel lblDanToc = new JLabel("Dân tộc:");
		lblDanToc.setBounds(98, 132, 70, 16);
		panel_Thongtincanhan.add(lblDanToc);
		lblDanToc.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblHoTen = new JLabel("Họ tên:");
		lblHoTen.setBounds(98, 30, 102, 33);
		panel_Thongtincanhan.add(lblHoTen);
		lblHoTen.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setBounds(98, 73, 102, 33);
		panel_Thongtincanhan.add(lblNgaySinh);
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblDiachi = new JLabel("Địa chỉ:");
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiachi.setBounds(98, 172, 70, 16);
		panel_Thongtincanhan.add(lblDiachi);
		
		JLabel lblDienthoai = new JLabel("Điện thoại:");
		lblDienthoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDienthoai.setBounds(98, 205, 86, 32);
		panel_Thongtincanhan.add(lblDienthoai);
		
		JLabel lblGioitinh = new JLabel("Giới tính:");
		lblGioitinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGioitinh.setBounds(557, 40, 86, 16);
		panel_Thongtincanhan.add(lblGioitinh);
		
		JLabel lblTonGiao = new JLabel("Tôn giáo:");
		lblTonGiao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTonGiao.setBounds(557, 81, 86, 25);
		panel_Thongtincanhan.add(lblTonGiao);
		
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCMND.setBounds(557, 120, 70, 28);
		panel_Thongtincanhan.add(lblCMND);
		
		JLabel lblNoicap = new JLabel("Nơi cấp:");
		lblNoicap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNoicap.setBounds(557, 164, 70, 32);
		panel_Thongtincanhan.add(lblNoicap);
		
		JLabel lblMail = new JLabel("Email:");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMail.setBounds(557, 213, 70, 24);
		panel_Thongtincanhan.add(lblMail);
		
		
		// lấy thong tin sinh vien ra để hiên thị lên label
		ThongtinSinhvien thongtinSinhvien = new SinhvienDAO().getThongtinsinhvien(thongtindangnhap.getMa());
		JLabel lblVLTensinhven = new JLabel("");
		
		lblVLTensinhven.setForeground(Color.RED);
		lblVLTensinhven.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVLTensinhven.setBounds(47, 44, 168, 25);
		lblVLTensinhven.setText(thongtinSinhvien.getTensv());
		//panel_chaoSinhvien.add(lblVLTensinhven);
		
		JLabel lblVlmasinhvien = new JLabel("");
		lblVlmasinhvien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVlmasinhvien.setBounds(20, 169, 102, 23);
		lblVlmasinhvien.setText(thongtinSinhvien.getMasv());
		panel_Thongtinsinhvien.add(lblVlmasinhvien);
		
		JLabel lblVlTrangthai = new JLabel("");
		lblVlTrangthai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVlTrangthai.setBounds(347, 21, 92, 27);
		lblVlTrangthai.setText(thongtinSinhvien.getTranthai());
		panel_Thongtinsinhvien.add(lblVlTrangthai);
		
		JLabel lblVTkhoa = new JLabel("");
		lblVTkhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVTkhoa.setBounds(347, 64, 123, 33);
		lblVTkhoa.setText(thongtinSinhvien.getTenkhoa());
		panel_Thongtinsinhvien.add(lblVTkhoa);
		
		JLabel lblVlnienkhoa = new JLabel("");
		lblVlnienkhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVlnienkhoa.setBounds(750, 21, 102, 33);
		lblVlnienkhoa.setText(thongtinSinhvien.getNienkhoa());
		panel_Thongtinsinhvien.add(lblVlnienkhoa);
		
		JLabel lblVLlop = new JLabel("");
		lblVLlop.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVLlop.setBounds(752, 168, 145, 24);
		lblVLlop.setText(thongtinSinhvien.getTenlophoc());
		panel_Thongtinsinhvien.add(lblVLlop);
		
		JLabel lblVlcoso = new JLabel("TP.HCM");
		lblVlcoso.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVlcoso.setBounds(760, 69, 102, 24);
		panel_Thongtinsinhvien.add(lblVlcoso);
		
		JLabel lblVlHoten = new JLabel("");
		lblVlHoten.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVlHoten.setBounds(288, 32, 156, 33);
		lblVlHoten.setText(thongtinSinhvien.getTensv());
		panel_Thongtincanhan.add(lblVlHoten);
		
		JLabel lblVlngaysinh = new JLabel("Chua ep kieu đuoc");
		lblVlngaysinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVlngaysinh.setText(thongtinSinhvien.getNgaysinh().toString());
		lblVlngaysinh.setBounds(288, 72, 124, 33);
		panel_Thongtincanhan.add(lblVlngaysinh);
		
		JLabel lblVldienthoai = new JLabel("");
		lblVldienthoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVldienthoai.setBounds(288, 204, 173, 33);
		lblVldienthoai.setText(thongtinSinhvien.getSdt());
		panel_Thongtincanhan.add(lblVldienthoai);
		
		JLabel lblVLdiachi = new JLabel("");
		lblVLdiachi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVLdiachi.setBounds(288, 155, 234, 33);
		lblVLdiachi.setText(thongtinSinhvien.getDiachi());
		panel_Thongtincanhan.add(lblVLdiachi);
		
		JLabel lblVlgioitinh = new JLabel("");
		lblVlgioitinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVlgioitinh.setBounds(752, 32, 86, 33);
		lblVlgioitinh.setText(thongtinSinhvien.getGiotinh());
		panel_Thongtincanhan.add(lblVlgioitinh);
	}

}

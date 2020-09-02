package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Doituong.Sinhviens;
import DoituongData.DSBangdiem;
import DoituongData.Thoikhoabieu;
import DoituongData.ThongtinSinhvien;


public class SinhvienDAO {
	public Connection conn;
	

	public SinhvienDAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=QLDKHP;" + "username=sa;password=123456");
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}


	public ThongtinSinhvien getThongtinsinhvien(String masv)
	{
		ThongtinSinhvien tt = new ThongtinSinhvien();
		String sql ="select [MaSV],[TenSV],[GioiTinh],[NgaySinh],[SDT],[DiaChi],[TenLop],[TenKhoa],[NienKhoa],[TrangThai] from [dbo].[Sinhvien] as sv join [dbo].[Lop] as l on sv.MaLop=l.MaLop join [dbo].[Khoa] as k  on l.MaKhoa=k.MaKhoa where [MaSV] like '"+masv+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 

				tt.setMasv(rs.getString(1));
				tt.setTensv(rs.getString(2));
				tt.setGiotinh(rs.getString(3));
				tt.setNgaysinh(rs.getDate(4));
				tt.setSdt(rs.getString(5));
				tt.setDiachi(rs.getString(6));
				tt.setTenlophoc(rs.getString(7));
				tt.setTenkhoa(rs.getString(8));
				tt.setNienkhoa(rs.getString(9));
				tt.setTranthai(rs.getString(10));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tt;
	}
	public ArrayList<DSBangdiem> getDSbangdiem( String maSV, String namHoc, String hocKi) 
	{
		String sql = "select [TenMonHoc],bd.[MaLHP],[DiemTK],[DiemGK],[DiemTH],[DiemCK] from [dbo].[BangDiem] as bd join [dbo].[LopHocPhan] as lhp on bd.MaLHP= lhp.MaLHP  join [dbo].[MonHoc] as mh on lhp.MaMH = mh.MaMH where [MaSV] like '"+maSV+"' and [NamHoc] like '"+namHoc+"' and [Hocki] like '"+hocKi+"'";
		ArrayList<DSBangdiem> listBD = new  ArrayList<DSBangdiem>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DSBangdiem dsBangdiem = new DSBangdiem();
				dsBangdiem.setTenmonhoc(rs.getString(1));
				dsBangdiem.setMaLHP(rs.getString(2));
				dsBangdiem.setThuongki(rs.getFloat(3));
				dsBangdiem.setGiuaki(rs.getFloat(4));
				dsBangdiem.setDiemthuchanh(rs.getFloat(5));
				dsBangdiem.setCuoiki(rs.getFloat(6));
				listBD.add(dsBangdiem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listBD; 
	}
	public ArrayList<DSBangdiem> DSDiemTatcaHocki( String maSV) 
	{
		String sql = "select [TenMonHoc],bd.[MaLHP],[DiemTK],[DiemGK],[DiemTH],[DiemCK] from [dbo].[BangDiem] as bd join [dbo].[LopHocPhan] as lhp on bd.MaLHP= lhp.MaLHP  join [dbo].[MonHoc] as mh on lhp.MaMH = mh.MaMH where [MaSV] like '"+maSV+"'";
		ArrayList<DSBangdiem> listBD = new  ArrayList<DSBangdiem>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DSBangdiem dsBangdiem = new DSBangdiem();
				dsBangdiem.setTenmonhoc(rs.getString(1));
				dsBangdiem.setMaLHP(rs.getString(2));
				dsBangdiem.setThuongki(rs.getFloat(3));
				dsBangdiem.setGiuaki(rs.getFloat(4));
				dsBangdiem.setDiemthuchanh(rs.getFloat(5));
				dsBangdiem.setCuoiki(rs.getFloat(6));
				listBD.add(dsBangdiem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listBD; 
	}

	public ArrayList<Thoikhoabieu> getThoikhoabieu ( String maSV, String thu)
	{
		ArrayList<Thoikhoabieu> listMonhoctrongngay = new ArrayList<Thoikhoabieu>();
		String sql = "select mh.[MaMH],[TenMonHoc], [Thu],[TietDay],[MaPhongHoc], [TenGV] from [dbo].[DSLHP] as dslhp join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV where  [MaSV] like '"+maSV+"' and [Thu] like "+thu;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Thoikhoabieu thoikhoabieu = new Thoikhoabieu();
				thoikhoabieu.setMaHP(rs.getString(1));
				thoikhoabieu.setTenmonhoc(rs.getString(2));
				thoikhoabieu.setThu(rs.getString(3));
				thoikhoabieu.setTiethoc(rs.getString(4));
				thoikhoabieu.setPhonghoc(rs.getString(5));
				thoikhoabieu.setGiangvien(rs.getString(6));
				listMonhoctrongngay.add(thoikhoabieu);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return listMonhoctrongngay;
	}


}

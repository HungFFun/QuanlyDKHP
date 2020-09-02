package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Doituong.Sinhviens;
import DoituongData.Lichday;
import DoituongData.ThongtinGiangvien;

public class GiangvienDAO {

	public Connection conn;
	public ArrayList<Sinhviens> list = new ArrayList<Sinhviens>();

	public GiangvienDAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=QLDKHP;" + "username=sa;password=123456");
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	public ThongtinGiangvien getThongtinGiangvien (String  maGV)
	{
		ThongtinGiangvien thongtinGiangvien = new ThongtinGiangvien();
		try {
			String sql = "select [MaGV],[TenGV],[GioiTinh],[NgaySinh],[SDT],[Khoa],[TrinhDo] from [dbo].[GiangVien_PDT] where [MaGV] like '"+maGV+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				thongtinGiangvien.setMaGV(rs.getString(1));
				thongtinGiangvien.setTenGV(rs.getString(2));
				thongtinGiangvien.setGiotinh(rs.getString(3));
				thongtinGiangvien.setNgaysinh(rs.getDate(4));
				thongtinGiangvien.setSdt(rs.getString(5));
				thongtinGiangvien.setKhoa(rs.getString(6));
				thongtinGiangvien.setTrinhdo(rs.getString(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return thongtinGiangvien;
	}

	public ArrayList<Lichday> getLichday(String maGV, String thu)
	{
		ArrayList<Lichday> listLichday = new ArrayList<Lichday>();
		Lichday lichday = new  Lichday();
		try {
			String sql ="select [MaLHP], [TenMonHoc],[SoTinChi],[TietDay],lhp.[MaPhongHoc],[DayNha],[NgayBatDau],[NgayKetThuc] from [dbo].[LopHocPhan] as lhp join [dbo].[MonHoc] as mh on  lhp.MaMH=mh.MaMH join [dbo].[PhongHoc] as ph on lhp.MaPhongHoc=ph.MaPhongHoc where  [MaGV] like '"+maGV+"' and [Thu] like "+thu;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs  = ps.executeQuery();
			while (rs.next()) {
				lichday.setMaLHP(rs.getString(1));
				lichday.setTenLHP(rs.getString(2));
				lichday.setSotinchi(rs.getString(3));
				lichday.setTietday(rs.getString(4));
				lichday.setPhonghoc(rs.getString(5));
				lichday.setDaynha(rs.getString(6));
				lichday.setNgayBatdau(rs.getDate(7));
				lichday.setNgayKetthuc(rs.getDate(8));
				listLichday.add(lichday);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listLichday;
	}







}

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Doituong.Sinhviens;
import DoituongData.Thongtindangnhap;

public class TaikhoanDAO {
	public Connection conn;
	public ArrayList<Sinhviens> list = new ArrayList<Sinhviens>();

	public TaikhoanDAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=QLDKHP;" + "username=sa;password=123456");
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	public Thongtindangnhap getthongtinDangnhapSV (String ma, String matkhau)
	{

		String sql = " select  [TenSV] ,[MaSV],[ChucVu] from [dbo].[Sinhvien] as s join [dbo].[TaiKhoan] as t  on s.MaSV=t.[MaTK]"
				+ "where [MaTK] like '"+ ma+"' and [MatKhau] like '"+ matkhau+"'";
		Thongtindangnhap dn = new Thongtindangnhap();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				
				dn.setTen(rs.getString(1));
				dn.setMa(rs.getString(2));
				dn.setChucVu(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dn;
	}
	public Thongtindangnhap getthongtinDangnhapGV (String ma, String matkhau)
	{

		String sql = "select  [TenGV], [MaGV],[ChucVu] from [dbo].[GiangVien_PDT] as gv join [dbo].[TaiKhoan] as t on gv.MaGV=t.MaTK " 
					+ "where [MaTK] like '"+ ma+"' and [MatKhau] like '"+ matkhau+"'";
		Thongtindangnhap dn = new Thongtindangnhap();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				
				dn.setTen(rs.getString(1));
				dn.setMa(rs.getString(2));
				dn.setChucVu(rs.getString(3));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dn;
	}

	public boolean DoiMatkhau(String ma,String matKhau)
	{
		String sql = "update [dbo].[TaiKhoan] set [MatKhau]=? where  [MaTK]like '"+ma+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, matKhau);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	

}

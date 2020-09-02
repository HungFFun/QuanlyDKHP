package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Doituong.Bangdiem;
import Doituong.Giangvien_GiaovuPDT;
import Doituong.Khoa;
import Doituong.LophocphanMoi;
import Doituong.Monhoc;
import Doituong.Sinhviens;
import DoituongData.Dangkihocphan;
import DoituongData.Quanlylophocphan;
import DoituongData.ThongtinLophocphan;
import DoituongData.ThongtinNhapdiem;



public class PhongdaotaoDAO {
	public Connection conn;


	public PhongdaotaoDAO () {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=QLDKHP;" + "username=sa;password=123456");
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}



	//


	// Quản lí môn hoc

	public ArrayList<Khoa> getDSSKhoa() {

		ArrayList<Khoa> listQuanlyKhoa = new ArrayList<Khoa>();
		String sql = "select * from [dbo].[Khoa]";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				Khoa khoa = new Khoa();
				khoa.setMaKhoa(rs.getString(1));
				khoa.setTenKhoa(rs.getString(2));
				listQuanlyKhoa.add(khoa);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listQuanlyKhoa;
	}

	public ArrayList<Monhoc> getDSSMonhoc() {

		ArrayList<Monhoc> listQuanlyMonhoc = new ArrayList<Monhoc>();
		String sql = "select *from [dbo].[MonHoc]";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				Monhoc mh = new Monhoc();
				mh.setMaMH(rs.getString(1));
				mh.setTenMH(rs.getString(2));
				mh.setSoTinchi(rs.getInt(3));
				listQuanlyMonhoc.add(mh);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listQuanlyMonhoc;
	}

	public boolean themMonhoc(String  maMH, String TenMH, String Sotinchi) {
		String sql = "insert into [dbo].[MonHoc] VALUES (?,?,?)";
		PreparedStatement ps =null; 
		int n =0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, maMH);
			ps.setString(2, TenMH);
			ps.setString(3, Sotinchi);
			n =ps.executeUpdate() ;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n >0;
	}
	public boolean XoaMonhoc(String maMH)
	{
		String sql = "delete from [dbo].[MonHoc] where [MaMH] like '"+maMH+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	public ArrayList<Monhoc> TimsMonhocTen(String tenMH)
	{


		ArrayList<Monhoc> lisMonhocCantim = new ArrayList<Monhoc>();
		String sql = "select * from [dbo].[MonHoc] where [TenMonHoc] like N'%"+tenMH+"%'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Monhoc mh = new Monhoc();
				mh.setMaMH(rs.getString(1));
				mh.setTenMH(rs.getString(2));
				mh.setSoTinchi(rs.getInt(3));
				lisMonhocCantim.add(mh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lisMonhocCantim;
	}
	
	public ArrayList<Monhoc> TimsMonhocMaMonhoc(String maMH)
	{


		ArrayList<Monhoc> lisMonhocCantim = new ArrayList<Monhoc>();
		String sql = "select * from [dbo].[MonHoc] where [MaMH] like '"+maMH+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Monhoc mh = new Monhoc();
				mh.setMaMH(rs.getString(1));
				mh.setTenMH(rs.getString(2));
				mh.setSoTinchi(rs.getInt(3));
				lisMonhocCantim.add(mh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lisMonhocCantim;
	}
	


	//----------------------------------------------

	// Quan li sinh vien

	public ArrayList<Sinhviens> getDSSinhvien() {

		ArrayList<Sinhviens> listQuanlysinhvien = new ArrayList<Sinhviens>();
		String sql = "select *from Sinhvien";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				Sinhviens sv = new Sinhviens();
				sv.setMa(rs.getString(1));
				sv.setTen(rs.getString(2));
				sv.setGiotinh(rs.getString(3));
				sv.setNgaysinh(rs.getDate(4));
				sv.setSoDienthoai(rs.getString(5));
				sv.setDiachi(rs.getString(6));
				sv.setMalop(rs.getString(7));
				sv.setTrangthai(rs.getString(8));
				listQuanlysinhvien.add(sv);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listQuanlysinhvien;
	}

	public boolean themSinhvien(String  ma, String ten,String giotinh, String ngaysinh, String soDienthoai, String diachi,String malop, String trangthai) {
		String sql = "insert into [dbo].[Sinhvien] VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps =null; 
		int n =0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ma);
			ps.setString(2, ten);
			ps.setString(3, giotinh);
			ps.setString(4, ngaysinh);
			ps.setString(5, soDienthoai);
			ps.setString(6, diachi);
			ps.setString(7, malop);
			ps.setString(8, trangthai);
			n =ps.executeUpdate() ;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n >0;
	}
	public boolean XoaSinhvien(String maSV)
	{
		String sql = "delete from [dbo].[Sinhvien] where [MaSV] like '"+maSV+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	public ArrayList<Sinhviens> TimsinhvienTheoten(String tenSV)
	{

		ArrayList<Sinhviens> listSinhvienCantim = new ArrayList<Sinhviens>();
		String sql = "select *from Sinhvien where [TenSV] like N'%"+tenSV+"%'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Sinhviens sinhviens = new Sinhviens();
				sinhviens.setMa(rs.getString(1));
				sinhviens.setTen(rs.getString(2));
				sinhviens.setGiotinh(rs.getString(3));
				sinhviens.setNgaysinh(rs.getDate(4));
				sinhviens.setSoDienthoai(rs.getString(5));
				sinhviens.setDiachi(rs.getString(6));
				sinhviens.setMalop(rs.getString(7));
				sinhviens.setTrangthai(rs.getString(8));
				listSinhvienCantim.add(sinhviens);			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listSinhvienCantim;
	}
	public ArrayList<Sinhviens> TimsinhvienTheoMa(String maSV)
	{

		ArrayList<Sinhviens> listSinhvienCantim = new ArrayList<Sinhviens>();
		String sql = "select *from Sinhvien where [MaSV] like '"+maSV+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Sinhviens sinhviens = new Sinhviens();
				sinhviens.setMa(rs.getString(1));
				sinhviens.setTen(rs.getString(2));
				sinhviens.setGiotinh(rs.getString(3));
				sinhviens.setNgaysinh(rs.getDate(4));
				sinhviens.setSoDienthoai(rs.getString(5));
				sinhviens.setDiachi(rs.getString(6));
				sinhviens.setMalop(rs.getString(7));
				sinhviens.setTrangthai(rs.getString(8));
				listSinhvienCantim.add(sinhviens);			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listSinhvienCantim;
	}

	//-------------------------------------------



	public  String MaGiangvien(String tenGV)
	{
		String sql ="select [MaGV] from [dbo].[GiangVien_PDT] where ([TenGV])  like N'%"+tenGV+"%'";
		String maGV = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				maGV=rs.getString(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return maGV;
	}
	public  String MaMonhoc(String tenMonhoc)
	{
		String sql ="select [MaMH] from[dbo].[MonHoc]  where [TenMonHoc] like N'%"+tenMonhoc+"%'";
		String maMH = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				maMH=rs.getString(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return maMH;
	}

	public ArrayList<Giangvien_GiaovuPDT> getDSGiangvien() {
		String sql = "select * from [dbo].[GiangVien_PDT]";
		ArrayList<Giangvien_GiaovuPDT>listQuanlyGiangvien = new ArrayList<Giangvien_GiaovuPDT>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				Giangvien_GiaovuPDT gv= new Giangvien_GiaovuPDT();
				gv.setMa(rs.getString(1));
				gv.setTen(rs.getString(2));
				gv.setGiotinh(rs.getString(3));
				gv.setNgaysinh(rs.getDate(4));
				gv.setSoDienthoai(rs.getString(5));
				gv.setDiachi(rs.getString(6));
				gv.setKhoa(rs.getString(7));
				gv.setTrinhdo(rs.getString(8));

				listQuanlyGiangvien.add(gv);	

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listQuanlyGiangvien;
	}

	public ArrayList<Quanlylophocphan> getDSlophocphan() {
		String sql = "select [MaLHP],[TenMonHoc], [TenGV],[Thu],[TietDay],[MaPhongHoc],[SoluongSV],[Hocki],[NamHoc],[NgayBatDau],[NgayKetThuc] from [dbo].[LopHocPhan] as lhp join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH";
		ArrayList<Quanlylophocphan>listQuanlylophocphan = new ArrayList<Quanlylophocphan>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				Quanlylophocphan ql = new Quanlylophocphan();
				ql.setMaLHP(rs.getString(1));
				ql.setMonHoc(rs.getString(2));
				ql.setTenGV(rs.getString(3));
				ql.setThu(rs.getString(4));
				ql.setTietHoc(rs.getString(5));
				ql.setPhonghoc(rs.getString(6));
				ql.setSoluongSV(rs.getString(7));
				ql.setHocki(rs.getString(8));
				ql.setNamhoc(rs.getString(9));
				ql.setNgayBatdau(rs.getDate(10));
				ql.setNgayKetthuc(rs.getDate(11));

				listQuanlylophocphan.add(ql);	

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listQuanlylophocphan;
	}
	//Giangvien_GiaovuPDT giangvien_GiaovuPDT = new Giangvien_GiaovuPDT(ma, ho, ten, giotinh, ngaysinh, soDienthoai, diachi, khoa, trinhdo)
	public boolean themTaikhoan(String  ma, String matkhau, String chucvu) {
		String sql = "insert into [dbo].[TaiKhoan] VALUES (?,?,?)";
		PreparedStatement ps =null; 
		int n =0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ma);
			ps.setString(2, matkhau);
			ps.setString(3, chucvu);
			n =ps.executeUpdate() ;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n >0;
	}

	public boolean Xoataikhoan(String maGV)
	{
		String sql = "delete from [dbo].[TaiKhoan] where [MaTK] like '"+maGV+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}


	public boolean themGiangvien(String  ma, String ten,String giotinh, String ngaysinh, String soDienthoai, String diachi,String khoa, String trinhdo) {
		String sql = "insert into [dbo].[GiangVien_PDT] VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps =null; 
		int n =0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ma);
			ps.setString(2, ten);
			ps.setString(3, giotinh);
			ps.setString(4, ngaysinh);
			ps.setString(5, soDienthoai);
			ps.setString(6, diachi);
			ps.setString(7, khoa);
			ps.setString(8, trinhdo);
			n =ps.executeUpdate() ;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n >0;
	}


	public boolean XoaGiangvien(String maGV)
	{
		String sql = "delete from [dbo].[GiangVien_PDT] where [MaGV] like '"+maGV+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	//Giangvien_GiaovuPDT giangvien_GiaovuPDT = new Giangvien_GiaovuPDT(ma, ho, ten, giotinh, ngaysinh, soDienthoai, diachi, khoa, trinhdo)
	public ArrayList<Giangvien_GiaovuPDT> TimsGiangvienTheoten(String tenGV)
	{

		ArrayList<Giangvien_GiaovuPDT> listGVCantim = new ArrayList<Giangvien_GiaovuPDT>();
		String sql = "select *from [dbo].[GiangVien_PDT] where [TenGV] like N'%"+tenGV+"%'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Giangvien_GiaovuPDT gv = new Giangvien_GiaovuPDT();
				gv.setMa(rs.getString(1));
				gv.setTen(rs.getString(2));
				gv.setGiotinh(rs.getString(3));
				gv.setNgaysinh(rs.getDate(4));
				gv.setSoDienthoai(rs.getString(5));
				gv.setDiachi(rs.getString(6));
				gv.setKhoa(rs.getString(7));
				gv.setTrinhdo(rs.getString(8));
				listGVCantim.add(gv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listGVCantim;
	}
	public ArrayList<Giangvien_GiaovuPDT> TimsGiangvienTheoMa(String maGV)
	{

		ArrayList<Giangvien_GiaovuPDT> listGVCantim = new ArrayList<Giangvien_GiaovuPDT>();
		String sql = "select *from [dbo].[GiangVien_PDT] where [MaGV] like N'%"+maGV+"%'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Giangvien_GiaovuPDT gv = new Giangvien_GiaovuPDT();
				gv.setMa(rs.getString(1));
				gv.setTen(rs.getString(2));
				gv.setGiotinh(rs.getString(3));
				gv.setNgaysinh(rs.getDate(4));
				gv.setSoDienthoai(rs.getString(5));
				gv.setDiachi(rs.getString(6));
				gv.setKhoa(rs.getString(7));
				gv.setTrinhdo(rs.getString(8));
				listGVCantim.add(gv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listGVCantim;
	}
	//LophocphanMoi lophocphanMoi = new LophocphanMoi(maLHP, maGV, maMH, maPhonghoc, hocKi, namhoc, soluongSV, ngayBatdau, ngatKetthuc, tietday, thu)
	public boolean themLophocphan(String  maLHP, String maGV, String maMH,String maPhonghoc, String hocKi,String namhoc,String soluongSV, String ngayBatdau, String ngatKetthuc, String tietday, String thu) {
		String sql = "insert into [dbo].[LopHocPhan] VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps =null; 
		int n =0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, maLHP);
			ps.setString(2, maGV);
			ps.setString(3, maMH);
			ps.setString(4, maPhonghoc);
			ps.setString(5, hocKi);
			ps.setString(6, namhoc);
			ps.setString(7, soluongSV);
			ps.setString(8, ngayBatdau);
			ps.setString(9, ngatKetthuc);
			ps.setString(10, tietday);
			ps.setString(11, thu);
			n =ps.executeUpdate() ;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n >0;
	}


	public boolean Xoalophocphan (String maLHP)
	{
		String sql = "delete from [dbo].[LopHocPhan] where [MaLHP] like '"+maLHP+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	//LophocphanMoi lophocphanMoi = new LophocphanMoi(maLHP, maGV, maMH, maPhonghoc, hocKi, namhoc, soluongSV, ngayBatdau, ngatKetthuc, tietday, thu);
	public boolean CapnhatLophocphan(String maLHP,String maGV,String maMH,String maPhonghoc,String hocKi,String namhoc, String soluongSV,String ngayBatdau, String ngatKetthuc, String tietday, String thu)
	{
		String sql = "update [dbo].[LopHocPhan] set [MaGV]= ?,[MaMH] =?,[MaPhongHoc]=?,[Hocki]=?,[NamHoc]=?,[SoluongSV]=?,[NgayBatDau]=?,[NgayKetThuc]=?,[TietDay]=?,[Thu] =? where [MaLHP] like '"+maLHP+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maGV);
			ps.setString(2, maMH);
			ps.setString(3, maPhonghoc);
			ps.setString(4, hocKi);
			ps.setString(5, namhoc);
			ps.setString(6, soluongSV);
			ps.setString(7, ngayBatdau);
			ps.setString(8, ngatKetthuc);
			ps.setString(9, tietday);
			ps.setString(10, thu);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//Sinhviens sinhviens = new Sinhviens(ma, ho, ten, giotinh, ngaysinh, soDienthoai, diachi, malop, trangthai)
	public boolean CapnhatSinhvien(String ma,String ten,String giotinh,String ngaysinh,String soDienthoai,String diachi,String malop,String trangthai)
	{
		String sql = "update [dbo].[Sinhvien] set [TenSV]=?,[GioiTinh]=?,[NgaySinh]=?,[SDT]=?,[DiaChi]=?, [MaLop]=?,[TrangThai]=? where [MaSV] like '"+ma+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ten);
			ps.setString(2, giotinh);
			ps.setString(3, ngaysinh);
			ps.setString(4, soDienthoai);
			ps.setString(5, diachi);
			ps.setString(6, malop);
			ps.setString(7, trangthai);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//Giangvien_GiaovuPDT giangvien_GiaovuPDT = new Giangvien_GiaovuPDT(ma, ho, ten, giotinh, ngaysinh, soDienthoai, diachi, khoa, trinhdo)
	public boolean CapnhatGiangVien(String ma,String ten,String giotinh,String ngaysinh,String soDienthoai,String diachi,String khoa,String trinhdo)
	{
		String sql = "update [dbo].[GiangVien_PDT] set [TenGV]=?,[GioiTinh]=?,[NgaySinh]=?,[SDT]=?,[DiaChi]=?, [Khoa]=?,[TrinhDo]=? where [MaGV] like '"+ma+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ten);
			ps.setString(2, giotinh);
			ps.setString(3, ngaysinh);
			ps.setString(4, soDienthoai);
			ps.setString(5, diachi);
			ps.setString(6, khoa);
			ps.setString(7, trinhdo);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean CapnhatMonhoc(String ma,String tenMH,String soTinchi)
	{
		String sql = "update [dbo].[MonHoc] set [TenMonHoc]=?,[SoTinChi]=? where [MaMH] like '"+ma+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tenMH);
			ps.setString(2, soTinchi);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

//	Quanlylophocphan quanlylophocphan = new Quanlylophocphan(maLHP, monHoc, tenGV, thu, tietHoc, phonghoc, soluongSV, hocki, namhoc, ngayBatdau, ngayKetthuc)
	public ArrayList<Quanlylophocphan> TimLophocphanTheoTenmonhoc(String tenLHP)
	{
		ArrayList<Quanlylophocphan>lisLophocphancantim = new ArrayList<Quanlylophocphan>();
		String sql = "select [MaLHP],[TenMonHoc], [TenGV],[Thu],[TietDay],[MaPhongHoc],[SoluongSV],[Hocki],[NamHoc],[NgayBatDau],[NgayKetThuc] from [dbo].[LopHocPhan] as lhp join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH where [TenMonHoc] like N'%"+tenLHP+"%'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Quanlylophocphan quanlylophocphan = new Quanlylophocphan();
				quanlylophocphan.setMaLHP(rs.getString(1));
				quanlylophocphan.setMonHoc(rs.getString(2));
				quanlylophocphan.setTenGV(rs.getString(3));
				quanlylophocphan.setThu(rs.getString(4));
				quanlylophocphan.setTietHoc(rs.getString(5));
				quanlylophocphan.setPhonghoc(rs.getString(6));
				quanlylophocphan.setSoluongSV(rs.getString(7));
				quanlylophocphan.setHocki(rs.getString(8));
				quanlylophocphan.setNamhoc(rs.getString(9));
				quanlylophocphan.setNgayBatdau(rs.getDate(10));
				quanlylophocphan.setNgayKetthuc(rs.getDate(11));
				lisLophocphancantim.add(quanlylophocphan);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lisLophocphancantim;
	}
	
	public ArrayList<Quanlylophocphan> TimLophocphanTheoTenGiangvien(String tenGV)
	{
		ArrayList<Quanlylophocphan>lisLophocphancantim = new ArrayList<Quanlylophocphan>();
		String sql = "select [MaLHP],[TenMonHoc], [TenGV],[Thu],[TietDay],[MaPhongHoc],[SoluongSV],[Hocki],[NamHoc],[NgayBatDau],[NgayKetThuc] from [dbo].[LopHocPhan] as lhp join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH  where [TenGV] like N'%"+tenGV+"%'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Quanlylophocphan quanlylophocphan = new Quanlylophocphan();
				quanlylophocphan.setMaLHP(rs.getString(1));
				quanlylophocphan.setMonHoc(rs.getString(2));
				quanlylophocphan.setTenGV(rs.getString(3));
				quanlylophocphan.setThu(rs.getString(4));
				quanlylophocphan.setTietHoc(rs.getString(5));
				quanlylophocphan.setPhonghoc(rs.getString(6));
				quanlylophocphan.setSoluongSV(rs.getString(7));
				quanlylophocphan.setHocki(rs.getString(8));
				quanlylophocphan.setNamhoc(rs.getString(9));
				quanlylophocphan.setNgayBatdau(rs.getDate(10));
				quanlylophocphan.setNgayKetthuc(rs.getDate(11));
				lisLophocphancantim.add(quanlylophocphan);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lisLophocphancantim;
	}
	
	
	public ArrayList<Quanlylophocphan> TimLophocphanTheoMalop(String maLHP)
	{
		ArrayList<Quanlylophocphan>lisLophocphancantim = new ArrayList<Quanlylophocphan>();
		String sql = "select [MaLHP],[TenMonHoc], [TenGV],[Thu],[TietDay],[MaPhongHoc],[SoluongSV],[Hocki],[NamHoc],[NgayBatDau],[NgayKetThuc] from [dbo].[LopHocPhan] as lhp join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH where [MaLHP] like '"+maLHP+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Quanlylophocphan quanlylophocphan = new Quanlylophocphan();
				quanlylophocphan.setMaLHP(rs.getString(1));
				quanlylophocphan.setMonHoc(rs.getString(2));
				quanlylophocphan.setTenGV(rs.getString(3));
				quanlylophocphan.setThu(rs.getString(4));
				quanlylophocphan.setTietHoc(rs.getString(5));
				quanlylophocphan.setPhonghoc(rs.getString(6));
				quanlylophocphan.setSoluongSV(rs.getString(7));
				quanlylophocphan.setHocki(rs.getString(8));
				quanlylophocphan.setNamhoc(rs.getString(9));
				quanlylophocphan.setNgayBatdau(rs.getDate(10));
				quanlylophocphan.setNgayKetthuc(rs.getDate(11));
				lisLophocphancantim.add(quanlylophocphan);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lisLophocphancantim;
	}
	public ArrayList<Quanlylophocphan> TimLophocphanTheoMaGV(String maGV)
	{
		ArrayList<Quanlylophocphan>lisLophocphancantim = new ArrayList<Quanlylophocphan>();
		String sql = "select [MaLHP],[TenMonHoc], [TenGV],[Thu],[TietDay],[MaPhongHoc],[SoluongSV],[Hocki],[NamHoc],[NgayBatDau],[NgayKetThuc] from [dbo].[LopHocPhan] as lhp join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH where gv.[MaGV]  like '"+maGV+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Quanlylophocphan quanlylophocphan = new Quanlylophocphan();
				quanlylophocphan.setMaLHP(rs.getString(1));
				quanlylophocphan.setMonHoc(rs.getString(2));
				quanlylophocphan.setTenGV(rs.getString(3));
				quanlylophocphan.setThu(rs.getString(4));
				quanlylophocphan.setTietHoc(rs.getString(5));
				quanlylophocphan.setPhonghoc(rs.getString(6));
				quanlylophocphan.setSoluongSV(rs.getString(7));
				quanlylophocphan.setHocki(rs.getString(8));
				quanlylophocphan.setNamhoc(rs.getString(9));
				quanlylophocphan.setNgayBatdau(rs.getDate(10));
				quanlylophocphan.setNgayKetthuc(rs.getDate(11));
				lisLophocphancantim.add(quanlylophocphan);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lisLophocphancantim;
	}


	public ArrayList<ThongtinNhapdiem> TimLophocphanCannhapdiem(String maLHP)
	{
		String sql = "select dslhp.[MaLHP],mh.[MaMH],[TenMonHoc],sv.[MaSV],[TenSV] ,[DiemTK],[DiemGK],[DiemTH],[DiemCK] from [dbo].[DSLHP] as dslhp join [dbo].[Sinhvien] as sv on sv.MaSV=dslhp.MaSV join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH left join [dbo].[BangDiem] as b on b.MaSV=sv.MaSV where dslhp.[MaLHP] like '"+maLHP+"%'";
		ArrayList<ThongtinNhapdiem>lisLophocphancantim = new ArrayList<ThongtinNhapdiem>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ThongtinNhapdiem thongtinNhapdiem = new ThongtinNhapdiem();
				thongtinNhapdiem.setMaLHP(rs.getString(1));
				thongtinNhapdiem.setMaMH(rs.getString(2));
				thongtinNhapdiem.setTenMH(rs.getString(3));
				thongtinNhapdiem.setMaSV(rs.getString(4));
				thongtinNhapdiem.setTenSV(rs.getString(5));
				thongtinNhapdiem.setDiemTK(rs.getString(6));
				thongtinNhapdiem.setDiemGK(rs.getString(7));
				thongtinNhapdiem.setDiemTH(rs.getString(8));
				thongtinNhapdiem.setDiemCk(rs.getString(9));
				lisLophocphancantim.add(thongtinNhapdiem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lisLophocphancantim;
	}


	public boolean Nhapdiem(String columUpdate, double diem,String masv,String mamh) {
		String sql = "update [dbo].[BangDiem] set" + columUpdate +"=" +diem +"where [MaSV] like '"+masv+"' and [MaMH] like '" + mamh + "'";
		PreparedStatement ps =null; 
		int n =0;
		try {
			ps = conn.prepareStatement(sql);
			n =ps.executeUpdate() ;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n >0;
	}
	public boolean ThemBangDiem(String masv,String mamh,String malhp) {
		String sql = "insert into [dbo].[BangDiem]([MaSV],[MaMH],[MaLHP])" + "values('"+masv+"','"+mamh+"','"+malhp+"')";

		PreparedStatement ps =null; 
		int n =0;
		try {
			ps = conn.prepareStatement(sql);
			n =ps.executeUpdate() ;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n >0;
	}
	public boolean TimBangDiem(String masv,String mamh) {
		ArrayList<Bangdiem> listBangdiem= new ArrayList<Bangdiem>();
		String sql = "select * from [dbo].[BangDiem]  where [MaSV] like '"+masv+"' and [MaMH] like '"+mamh+"'";
		Bangdiem diem = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				diem =new  Bangdiem();
				diem.setMaSv(rs.getString(1));
				diem.setMaMH(rs.getString(2));
				diem.setMaHP(rs.getString(3));
				diem.setDiemTK(Float.parseFloat(rs.getString(4)));
				diem.setDiemTK(Float.parseFloat(rs.getString(5)));
				diem.setDiemTK(Float.parseFloat(rs.getString(6)));
				diem.setDiemTK(Float.parseFloat(rs.getString(7)));
				listBangdiem.add(diem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (diem!=null) {
			return true;
		}
		else {
			return false;
		}
	}
}

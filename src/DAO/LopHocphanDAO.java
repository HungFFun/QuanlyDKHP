package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Doituong.LophocphanMoi;
import Doituong.Sinhviens;
import DoituongData.ChitietLophocphan;
import DoituongData.Dangkihocphan;
import DoituongData.HocphanDaDangki;
import DoituongData.LopNhapDiem;
import DoituongData.ThongtinLophocphan;
import DoituongData.ThongtinlopGiangvienChuaDangki;


public class LopHocphanDAO {
	public Connection conn;
	public ArrayList<ThongtinLophocphan> list = new ArrayList<ThongtinLophocphan>();

	public LopHocphanDAO () {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=QLDKHP;" + "username=sa;password=123456");
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	
	public ArrayList<LopNhapDiem> getDSLopdangday(String maGV) {
		String sql = "select l.[MaLHP],[TenMonHoc],count([MaSV])as dadangki,[MaGV],[Hocki] from  [dbo].[LopHocPhan] as l left join [dbo].[MonHoc] as m on l.MaMH=m.MaMH join [dbo].[DSLHP] as dslhp on l.MaLHP=dslhp.MaLHP where [MaGV] like '"+maGV+"' group by l.[MaLHP],[TenMonHoc], [MaGV],[Hocki]";
		 ArrayList<LopNhapDiem> listLND = new ArrayList<LopNhapDiem>();
//		 System.out.println(sql);
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				LopNhapDiem  lopNhapDiem = new LopNhapDiem();
				lopNhapDiem.setMaLHP(rs.getString(1));
				lopNhapDiem.setTenMH(rs.getString(2));
				lopNhapDiem.setSoSV(rs.getString(3));
				lopNhapDiem.setMaGV(rs.getString(4));
				lopNhapDiem.setHocki(rs.getString(5));
				listLND.add(lopNhapDiem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listLND;
	}
	public ArrayList<ThongtinLophocphan> getDSThongtinLophocphan(String hocKi, String namHoc,String maSV) {
//		String sql = " select l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],count([MaSV])as dadangki,[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu] from [dbo].[LopHocPhan] as l join [dbo].[MonHoc] as m on l.MaMH=m.MaMH join [dbo].[GiangVien_PDT] as gv on l.MaGV = gv.MaGV join [dbo].[DSLHP] as dslhp on l.MaLHP=dslhp.MaLHP where [Hocki] like '"+hocKi+"' and [NamHoc] like '"+namHoc+"' group by l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu]";
		String sql = " select l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],count([MaSV])as dadangki,[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu]" + 
				"  from [dbo].[LopHocPhan] as l join [dbo].[MonHoc] as m on l.MaMH=m.MaMH " + 
				"  join [dbo].[GiangVien_PDT] as gv on l.MaGV = gv.MaGV join [dbo].[DSLHP] as dslhp on l.MaLHP=dslhp.MaLHP" + 
				"  where [Hocki] like '"+ hocKi +"' and [NamHoc] like '"+ namHoc + "'" + 
				"	and l.[MaLHP] not in (  select dslhp.[MaLHP]" + 
				"   from [dbo].[DSLHP] as dslhp join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP" + 
				"   join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV " + 
				"   where [MaSV] like '"+ maSV +"'and [NamHoc] like '"+namHoc+"'" + "and [Hocki] like '" + hocKi +"' )"+ 
				"  group by l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu]";
//		System.out.println(sql);
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				ThongtinLophocphan lh = new ThongtinLophocphan();
				lh.setMaLHP(rs.getString(1));
				lh.setTenMonhoc(rs.getString(2));
				lh.setTenGV(rs.getString(3));
				lh.setSotinchi(rs.getString(4));
				lh.setSiSoToida(rs.getString(5));
				lh.setDaDangki(rs.getString(6));
				lh.setMaPhonghoc(rs.getString(7));
				lh.setNgayBatdau(rs.getDate(8));
				lh.setNgayKetthuc(rs.getDate(9));
				lh.setTiet(rs.getString(10));
				lh.setThu(rs.getString(11));

				list.add(lh);	

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<ThongtinLophocphan>Timlophocphan(String tenMonhoc, String hk) {
		String sql = "select [MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu] from [dbo].[LopHocPhan] as l join [dbo].[MonHoc] as m on l.MaMH=m.MaMH join [dbo].[GiangVien_PDT] as gv on l.MaGV = gv.MaGV where [TenMonHoc] like N'%" +tenMonhoc+ "%' and [Hocki] like '"+hk+"'";
		ArrayList<ThongtinLophocphan> listDslopcantim = new ArrayList<ThongtinLophocphan>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				ThongtinLophocphan lh = new ThongtinLophocphan();
				lh.setMaLHP(rs.getString(1));
				lh.setTenMonhoc(rs.getString(2));
				lh.setTenGV(rs.getString(3));
				lh.setSotinchi(rs.getString(4));
				lh.setMaPhonghoc(rs.getString(5));
				lh.setNgayBatdau(rs.getDate(6));
				lh.setNgayKetthuc(rs.getDate(7));
				lh.setTiet(rs.getString(8));
				lh.setThu(rs.getString(9));
				listDslopcantim.add(lh);					

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDslopcantim;
	}

	public ChitietLophocphan getChitietLophocphan( String maLophocphan) {
		String sql = "select ([Thu] +N'  tiết '+ [TietDay]) as lichoc,lhp.[MaPhongHoc],[DayNha], [TenGV], [NgayBatDau] from [dbo].[LopHocPhan] as lhp join [dbo].[GiangVien_PDT] as gv  on lhp.MaGV=gv.MaGV  join [dbo].[PhongHoc] as ph on lhp.MaPhongHoc = ph.MaPhongHoc where [MaLHP] like '" + maLophocphan +"'";	

		ChitietLophocphan ctlhp = new ChitietLophocphan();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 

				ctlhp.setLichoc(rs.getString(1));
				ctlhp.setPhonghoc(rs.getString(2));
				ctlhp.setDaynha(rs.getString(3));
				ctlhp.setGiangvien(rs.getString(4));
				ctlhp.setNgayBatdau(rs.getDate(5));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ctlhp;
	}

	
	public ArrayList<HocphanDaDangki> getDSHocphandadangki(String maSinhvien , String namHoc , String hk) {
		String sql = "select dslhp.[MaLHP],[TenMonHoc],[TenGV], ([Thu]+N'  tiết '+[TietDay]) as tiethoc ,[MaPhongHoc],[NgayBatDau] from [dbo].[DSLHP] as dslhp join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV where [MaSV] like '"+maSinhvien+"'and [NamHoc] like '"+namHoc+"'" + "and [Hocki] like '" + hk +"'";
		 ArrayList<HocphanDaDangki> listHPĐK = new ArrayList<HocphanDaDangki>();
//		 System.out.println(sql);
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HocphanDaDangki hp = new HocphanDaDangki();
				hp.setMaLHp(rs.getString(1));
				hp.setTenLophocphan(rs.getString(2));
				hp.setTenGiangvien(rs.getString(3));
				hp.setTietHoc(rs.getString(4));
				hp.setMaPhonghoc(rs.getString(5));
				hp.setNgayBatdau(rs.getDate(6));
				listHPĐK.add(hp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listHPĐK;
	}

	public boolean DangKyHocphan(Dangkihocphan dkhp)
	{
		String sql = "insert into [dbo].[DSLHP] " 
				+ "values (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dkhp.getMaLHP());
			ps.setString(2, dkhp.getMaSinhvien());
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean Huylophocphan (Dangkihocphan hlhp)
	{
		String sql = "delete from [dbo].[DSLHP] where [MaLHP] like '" +hlhp.getMaLHP()+"' and [MaSV] like '"+hlhp.getMaSinhvien()+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}


}

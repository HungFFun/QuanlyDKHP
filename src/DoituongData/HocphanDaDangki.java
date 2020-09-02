package DoituongData;

import java.sql.Date;

public class HocphanDaDangki {
	private String maLHp;
	private String tenLophocphan;
	private String tenGiangvien;
	private String tietHoc;
	private String maPhonghoc;
	private Date ngayBatdau;
	public String getMaLHp() {
		return maLHp;
	}
	public void setMaLHp(String maLHp) {
		this.maLHp = maLHp;
	}
	public String getTenLophocphan() {
		return tenLophocphan;
	}
	public void setTenLophocphan(String tenLophocphan) {
		this.tenLophocphan = tenLophocphan;
	}
	public String getTenGiangvien() {
		return tenGiangvien;
	}
	public void setTenGiangvien(String tenGiangvien) {
		this.tenGiangvien = tenGiangvien;
	}
	public String getTietHoc() {
		return tietHoc;
	}
	public void setTietHoc(String tietHoc) {
		this.tietHoc = tietHoc;
	}
	public String getMaPhonghoc() {
		return maPhonghoc;
	}
	public void setMaPhonghoc(String maPhonghoc) {
		this.maPhonghoc = maPhonghoc;
	}
	public Date getNgayBatdau() {
		return ngayBatdau;
	}
	public void setNgayBatdau(Date ngayBatdau) {
		this.ngayBatdau = ngayBatdau;
	}
	public HocphanDaDangki(String maLHp, String tenLophocphan, String tenGiangvien, String tietHoc, String maPhonghoc,
			Date ngayBatdau) {
		super();
		this.maLHp = maLHp;
		this.tenLophocphan = tenLophocphan;
		this.tenGiangvien = tenGiangvien;
		this.tietHoc = tietHoc;
		this.maPhonghoc = maPhonghoc;
		this.ngayBatdau = ngayBatdau;
	}
	public HocphanDaDangki() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HocphanDaDangki [maLHp=" + maLHp + ", tenLophocphan=" + tenLophocphan + ", tenGiangvien=" + tenGiangvien
				+ ", tietHoc=" + tietHoc + ", maPhonghoc=" + maPhonghoc + ", ngayBatdau=" + ngayBatdau + "]";
	}
	
	
	

}

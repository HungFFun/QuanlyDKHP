package DoituongData;

import java.sql.Date;

public class ChitietLophocphan {
	private String lichoc;
	private String phonghoc;
	private String daynha;
	private String giangvien;
	private Date ngayBatdau;
	public String getLichoc() {
		return lichoc;
	}
	public void setLichoc(String lichoc) {
		this.lichoc = lichoc;
	}
	public String getPhonghoc() {
		return phonghoc;
	}
	public void setPhonghoc(String phonghoc) {
		this.phonghoc = phonghoc;
	}
	public String getDaynha() {
		return daynha;
	}
	public void setDaynha(String daynha) {
		this.daynha = daynha;
	}
	public String getGiangvien() {
		return giangvien;
	}
	public void setGiangvien(String giangvien) {
		this.giangvien = giangvien;
	}
	public Date getNgayBatdau() {
		return ngayBatdau;
	}
	public void setNgayBatdau(Date ngayBatdau) {
		this.ngayBatdau = ngayBatdau;
	}
	public ChitietLophocphan(String lichoc, String phonghoc, String daynha, String giangvien, Date ngayBatdau) {
		super();
		this.lichoc = lichoc;
		this.phonghoc = phonghoc;
		this.daynha = daynha;
		this.giangvien = giangvien;
		this.ngayBatdau = ngayBatdau;
	}
	public ChitietLophocphan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChitietLophocphan [lichoc=" + lichoc + ", phonghoc=" + phonghoc + ", daynha=" + daynha + ", giangvien="
				+ giangvien + ", ngayBatdau=" + ngayBatdau + "]";
	}
	
	

}

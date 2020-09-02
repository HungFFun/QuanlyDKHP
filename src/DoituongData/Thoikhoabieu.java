package DoituongData;

public class Thoikhoabieu {
	private String maHP;
	private String tenmonhoc;
	private String thu;
	private String tiethoc;
	private String phonghoc;
	private String giangvien;
	public String getMaHP() {
		return maHP;
	}
	public void setMaHP(String maHP) {
		this.maHP = maHP;
	}
	public String getTenmonhoc() {
		return tenmonhoc;
	}
	public void setTenmonhoc(String tenmonhoc) {
		this.tenmonhoc = tenmonhoc;
	}
	public String getThu() {
		return thu;
	}
	public void setThu(String thu) {
		this.thu = thu;
	}
	public String getTiethoc() {
		return tiethoc;
	}
	public void setTiethoc(String tiethoc) {
		this.tiethoc = tiethoc;
	}
	public String getPhonghoc() {
		return phonghoc;
	}
	public void setPhonghoc(String phonghoc) {
		this.phonghoc = phonghoc;
	}
	public String getGiangvien() {
		return giangvien;
	}
	public void setGiangvien(String giangvien) {
		this.giangvien = giangvien;
	}
	public Thoikhoabieu(String maHP, String tenmonhoc, String thu, String tiethoc, String phonghoc, String giangvien) {
		super();
		this.maHP = maHP;
		this.tenmonhoc = tenmonhoc;
		this.thu = thu;
		this.tiethoc = tiethoc;
		this.phonghoc = phonghoc;
		this.giangvien = giangvien;
	}
	public Thoikhoabieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Thoikhoabieu [maHP=" + maHP + ", tenmonhoc=" + tenmonhoc + ", thu=" + thu + ", tiethoc=" + tiethoc
				+ ", phonghoc=" + phonghoc + ", giangvien=" + giangvien + "]";
	}

	
	
}

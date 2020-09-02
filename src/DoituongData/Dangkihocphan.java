package DoituongData;

public class Dangkihocphan {
	private String maLHP;
	private String maSinhvien;
	public String getMaLHP() {
		return maLHP;
	}
	public void setMaLHP(String maLHP) {
		this.maLHP = maLHP;
	}
	public String getMaSinhvien() {
		return maSinhvien;
	}
	public void setMaSinhvien(String maSinhvien) {
		this.maSinhvien = maSinhvien;
	}
	public Dangkihocphan(String maLHP, String maSinhvien) {
		super();
		this.maLHP = maLHP;
		this.maSinhvien = maSinhvien;
	}
	public Dangkihocphan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dangkihocphan [maLHP=" + maLHP + ", maSinhvien=" + maSinhvien + "]";
	}
	
	
	
	

}

package Doituong;

public class DSLHP {
	private String maLHP;
	private String maSV;
	public String getMaLHP() {
		return maLHP;
	}
	public void setMaLHP(String maLHP) {
		this.maLHP = maLHP;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public DSLHP(String maLHP, String maSV) {
		super();
		this.maLHP = maLHP;
		this.maSV = maSV;
	}
	public DSLHP() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DSLHP [maLHP=" + maLHP + ", maSV=" + maSV + "]";
	}
	
	

}

package DoituongData;

public class LopNhapDiem {
	private String maLHP;
	private String tenMH;
	private String SoSV;
	private String maGV;
	private String hocki;
	public String getMaLHP() {
		return maLHP;
	}
	public void setMaLHP(String maLHP) {
		this.maLHP = maLHP;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public String getSoSV() {
		return SoSV;
	}
	public void setSoSV(String soSV) {
		SoSV = soSV;
	}
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public String getHocki() {
		return hocki;
	}
	public void setHocki(String hocki) {
		this.hocki = hocki;
	}
	public LopNhapDiem(String maLHP, String tenMH, String soSV, String maGV, String hocki) {
		super();
		this.maLHP = maLHP;
		this.tenMH = tenMH;
		SoSV = soSV;
		this.maGV = maGV;
		this.hocki = hocki;
	}
	public LopNhapDiem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LopNhapDiem [maLHP=" + maLHP + ", tenMH=" + tenMH + ", SoSV=" + SoSV + ", maGV=" + maGV + ", hocki="
				+ hocki + "]";
	}
}

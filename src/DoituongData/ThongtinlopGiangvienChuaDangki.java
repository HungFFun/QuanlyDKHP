package DoituongData;

public class ThongtinlopGiangvienChuaDangki {
	private String maLHP;
	private String tenMonhoc;
	private String sotinchi;
	private String thu;
	private String tietday;
	public String getMaLHP() {
		return maLHP;
	}
	public void setMaLHP(String maLHP) {
		this.maLHP = maLHP;
	}
	public String getTenMonhoc() {
		return tenMonhoc;
	}
	public void setTenMonhoc(String tenMonhoc) {
		this.tenMonhoc = tenMonhoc;
	}
	public String getSotinchi() {
		return sotinchi;
	}
	public void setSotinchi(String sotinchi) {
		this.sotinchi = sotinchi;
	}
	public String getThu() {
		return thu;
	}
	public void setThu(String thu) {
		this.thu = thu;
	}
	public String getTietday() {
		return tietday;
	}
	public void setTietday(String tietday) {
		this.tietday = tietday;
	}
	public ThongtinlopGiangvienChuaDangki(String maLHP, String tenMonhoc, String sotinchi, String thu, String tietday) {
		super();
		this.maLHP = maLHP;
		this.tenMonhoc = tenMonhoc;
		this.sotinchi = sotinchi;
		this.thu = thu;
		this.tietday = tietday;
	}
	public ThongtinlopGiangvienChuaDangki() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ThongtinlopGiangvienChuaDangki [maLHP=" + maLHP + ", tenMonhoc=" + tenMonhoc + ", sotinchi=" + sotinchi
				+ ", thu=" + thu + ", tietday=" + tietday + "]";
	}
	
	
	
}

package DoituongData;

public class DSBangdiem {
	private String tenmonhoc;
	private String maLHP;
	private float thuongki;
	private float giuaki;
	private float diemthuchanh;
	private float cuoiki;
	/**
	 * @return the tenmonhoc
	 */
	public String getTenmonhoc() {
		return tenmonhoc;
	}
	/**
	 * @param tenmonhoc the tenmonhoc to set
	 */
	public void setTenmonhoc(String tenmonhoc) {
		this.tenmonhoc = tenmonhoc;
	}
	/**
	 * @return the maLHP
	 */
	public String getMaLHP() {
		return maLHP;
	}
	/**
	 * @param maLHP the maLHP to set
	 */
	public void setMaLHP(String maLHP) {
		this.maLHP = maLHP;
	}
	/**
	 * @return the thuongki
	 */
	public float getThuongki() {
		return thuongki;
	}
	/**
	 * @param thuongki the thuongki to set
	 */
	public void setThuongki(float thuongki) {
		this.thuongki = thuongki;
	}
	/**
	 * @return the giuaki
	 */
	public float getGiuaki() {
		return giuaki;
	}
	/**
	 * @param giuaki the giuaki to set
	 */
	public void setGiuaki(float giuaki) {
		this.giuaki = giuaki;
	}
	/**
	 * @return the diemthuchanh
	 */
	public float getDiemthuchanh() {
		return diemthuchanh;
	}
	/**
	 * @param diemthuchanh the diemthuchanh to set
	 */
	public void setDiemthuchanh(float diemthuchanh) {
		this.diemthuchanh = diemthuchanh;
	}
	/**
	 * @return the cuoiki
	 */
	public float getCuoiki() {
		return cuoiki;
	}
	/**
	 * @param cuoiki the cuoiki to set
	 */
	public void setCuoiki(float cuoiki) {
		this.cuoiki = cuoiki;
	}
	/**
	 * @param tenmonhoc
	 * @param maLHP
	 * @param thuongki
	 * @param giuaki
	 * @param diemthuchanh
	 * @param cuoiki
	 */
	public DSBangdiem(String tenmonhoc, String maLHP, float thuongki, float giuaki, float diemthuchanh, float cuoiki) {
		super();
		this.tenmonhoc = tenmonhoc;
		this.maLHP = maLHP;
		this.thuongki = thuongki;
		this.giuaki = giuaki;
		this.diemthuchanh = diemthuchanh;
		this.cuoiki = cuoiki;
	}
	/**
	 * 
	 */
	public DSBangdiem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DSBangdiem [tenmonhoc=" + tenmonhoc + ", maLHP=" + maLHP + ", thuongki=" + thuongki + ", giuaki="
				+ giuaki + ", diemthuchanh=" + diemthuchanh + ", cuoiki=" + cuoiki + "]";
	}
	
	
	
}

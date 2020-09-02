package Doituong;

public class Bangdiem {
	private String maSv;
	private String maHP;
	private String maMH;
	private float diemTK;
	private float diemGK;
	private float diemTH;
	private float diemCK;
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public String getMaHP() {
		return maHP;
	}
	public void setMaHP(String maHP) {
		this.maHP = maHP;
	}
	public float getDiemTK() {
		return diemTK;
	}
	public void setDiemTK(float diemTK) {
		this.diemTK = diemTK;
	}
	public float getDiemGK() {
		return diemGK;
	}
	public void setDiemGK(float diemGK) {
		this.diemGK = diemGK;
	}
	public float getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}
	public float getDiemCK() {
		return diemCK;
	}
	public void setDiemCK(float diemCK) {
		this.diemCK = diemCK;
	}
	public Bangdiem(String maSv, String maHP, float diemTK, float diemGK, float diemTH, float diemCK) {
		super();
		this.maSv = maSv;
		this.maHP = maHP;
		this.diemTK = diemTK;
		this.diemGK = diemGK;
		this.diemTH = diemTH;
		this.diemCK = diemCK;
	}
	public Bangdiem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bangdiem [maSv=" + maSv + ", maHP=" + maHP + ", diemTK=" + diemTK + ", diemGK=" + diemGK + ", diemTH="
				+ diemTH + ", diemCK=" + diemCK + "]";
	}
	/**
	 * @return the maMH
	 */
	public String getMaMH() {
		return maMH;
	}
	/**
	 * @param maMH the maMH to set
	 */
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}




}

package Doituong;

import java.sql.Date;

public class LophocphanMoi {
	private String maLHP;
	private String maGV;
	private String maMH;
	private String maPhonghoc;
	private String hocKi;
	private String Namhoc;
	private String soluongSV;
	private Date ngayBatdau;
	private Date ngatKetthuc;
	private String tietday;
	private String thu;
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
	 * @return the maGV
	 */
	public String getMaGV() {
		return maGV;
	}
	/**
	 * @param maGV the maGV to set
	 */
	public void setMaGV(String maGV) {
		this.maGV = maGV;
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
	/**
	 * @return the maPhonghoc
	 */
	public String getMaPhonghoc() {
		return maPhonghoc;
	}
	/**
	 * @param maPhonghoc the maPhonghoc to set
	 */
	public void setMaPhonghoc(String maPhonghoc) {
		this.maPhonghoc = maPhonghoc;
	}
	/**
	 * @return the hocKi
	 */
	public String getHocKi() {
		return hocKi;
	}
	/**
	 * @param hocKi the hocKi to set
	 */
	public void setHocKi(String hocKi) {
		this.hocKi = hocKi;
	}
	/**
	 * @return the namhoc
	 */
	public String getNamhoc() {
		return Namhoc;
	}
	/**
	 * @param namhoc the namhoc to set
	 */
	public void setNamhoc(String namhoc) {
		Namhoc = namhoc;
	}
	/**
	 * @return the soluongSV
	 */
	public String getSoluongSV() {
		return soluongSV;
	}
	/**
	 * @param soluongSV the soluongSV to set
	 */
	public void setSoluongSV(String soluongSV) {
		this.soluongSV = soluongSV;
	}
	/**
	 * @return the ngayBatdau
	 */
	public Date getNgayBatdau() {
		return ngayBatdau;
	}
	/**
	 * @param ngayBatdau the ngayBatdau to set
	 */
	public void setNgayBatdau(Date ngayBatdau) {
		this.ngayBatdau = ngayBatdau;
	}
	/**
	 * @return the ngatKetthuc
	 */
	public Date getNgatKetthuc() {
		return ngatKetthuc;
	}
	/**
	 * @param ngatKetthuc the ngatKetthuc to set
	 */
	public void setNgatKetthuc(Date ngatKetthuc) {
		this.ngatKetthuc = ngatKetthuc;
	}
	/**
	 * @return the tietday
	 */
	public String getTietday() {
		return tietday;
	}
	/**
	 * @param tietday the tietday to set
	 */
	public void setTietday(String tietday) {
		this.tietday = tietday;
	}
	/**
	 * @return the thu
	 */
	public String getThu() {
		return thu;
	}
	/**
	 * @param thu the thu to set
	 */
	public void setThu(String thu) {
		this.thu = thu;
	}
	/**
	 * @param maLHP
	 * @param maGV
	 * @param maMH
	 * @param maPhonghoc
	 * @param hocKi
	 * @param namhoc
	 * @param soluongSV
	 * @param ngayBatdau
	 * @param ngatKetthuc
	 * @param tietday
	 * @param thu
	 */
	public LophocphanMoi(String maLHP, String maGV, String maMH, String maPhonghoc, String hocKi, String namhoc,
			String soluongSV, Date ngayBatdau, Date ngatKetthuc, String tietday, String thu) {
		super();
		this.maLHP = maLHP;
		this.maGV = maGV;
		this.maMH = maMH;
		this.maPhonghoc = maPhonghoc;
		this.hocKi = hocKi;
		Namhoc = namhoc;
		this.soluongSV = soluongSV;
		this.ngayBatdau = ngayBatdau;
		this.ngatKetthuc = ngatKetthuc;
		this.tietday = tietday;
		this.thu = thu;
	}
	/**
	 * 
	 */
	public LophocphanMoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LophocphanMoi [maLHP=" + maLHP + ", maGV=" + maGV + ", maMH=" + maMH + ", maPhonghoc=" + maPhonghoc
				+ ", hocKi=" + hocKi + ", Namhoc=" + Namhoc + ", soluongSV=" + soluongSV + ", ngayBatdau=" + ngayBatdau
				+ ", ngatKetthuc=" + ngatKetthuc + ", tietday=" + tietday + ", thu=" + thu + "]";
	}
	
	
	
	
	
	

}

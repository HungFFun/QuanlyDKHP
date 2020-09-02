package DoituongData;

import java.sql.Date;

public class Quanlylophocphan {
	private String maLHP;
	private String monHoc;
	private String tenGV;
	private String thu;
	private String tietHoc;
	private String phonghoc;
	private String SoluongSV;
	private String Hocki;
	private String Namhoc;
	private Date ngayBatdau;
	private Date ngayKetthuc;
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
	 * @return the monHoc
	 */
	public String getMonHoc() {
		return monHoc;
	}
	/**
	 * @param monHoc the monHoc to set
	 */
	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}
	/**
	 * @return the tenGV
	 */
	public String getTenGV() {
		return tenGV;
	}
	/**
	 * @param tenGV the tenGV to set
	 */
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
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
	 * @return the tietHoc
	 */
	public String getTietHoc() {
		return tietHoc;
	}
	/**
	 * @param tietHoc the tietHoc to set
	 */
	public void setTietHoc(String tietHoc) {
		this.tietHoc = tietHoc;
	}
	/**
	 * @return the phonghoc
	 */
	public String getPhonghoc() {
		return phonghoc;
	}
	/**
	 * @param phonghoc the phonghoc to set
	 */
	public void setPhonghoc(String phonghoc) {
		this.phonghoc = phonghoc;
	}
	/**
	 * @return the soluongSV
	 */
	public String getSoluongSV() {
		return SoluongSV;
	}
	/**
	 * @param soluongSV the soluongSV to set
	 */
	public void setSoluongSV(String soluongSV) {
		SoluongSV = soluongSV;
	}
	/**
	 * @return the hocki
	 */
	public String getHocki() {
		return Hocki;
	}
	/**
	 * @param hocki the hocki to set
	 */
	public void setHocki(String hocki) {
		Hocki = hocki;
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
	 * @return the ngayKetthuc
	 */
	public Date getNgayKetthuc() {
		return ngayKetthuc;
	}
	/**
	 * @param ngayKetthuc the ngayKetthuc to set
	 */
	public void setNgayKetthuc(Date ngayKetthuc) {
		this.ngayKetthuc = ngayKetthuc;
	}
	/**
	 * @param maLHP
	 * @param monHoc
	 * @param tenGV
	 * @param thu
	 * @param tietHoc
	 * @param phonghoc
	 * @param soluongSV
	 * @param hocki
	 * @param namhoc
	 * @param ngayBatdau
	 * @param ngayKetthuc
	 */
	public Quanlylophocphan(String maLHP, String monHoc, String tenGV, String thu, String tietHoc, String phonghoc,
			String soluongSV, String hocki, String namhoc, Date ngayBatdau, Date ngayKetthuc) {
		super();
		this.maLHP = maLHP;
		this.monHoc = monHoc;
		this.tenGV = tenGV;
		this.thu = thu;
		this.tietHoc = tietHoc;
		this.phonghoc = phonghoc;
		SoluongSV = soluongSV;
		Hocki = hocki;
		Namhoc = namhoc;
		this.ngayBatdau = ngayBatdau;
		this.ngayKetthuc = ngayKetthuc;
	}
	/**
	 * 
	 */
	public Quanlylophocphan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Quanlylophocphan [maLHP=" + maLHP + ", monHoc=" + monHoc + ", tenGV=" + tenGV + ", thu=" + thu
				+ ", tietHoc=" + tietHoc + ", phonghoc=" + phonghoc + ", SoluongSV=" + SoluongSV + ", Hocki=" + Hocki
				+ ", Namhoc=" + Namhoc + ", ngayBatdau=" + ngayBatdau + ", ngayKetthuc=" + ngayKetthuc + "]";
	}
	
	
	
	

	
	
	
	
	
	
	

}

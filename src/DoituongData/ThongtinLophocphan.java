package DoituongData;

import java.sql.Date;

public class ThongtinLophocphan {
	private String maLHP;
	private String tenMonhoc;
	private String tenGV;
	private String sotinchi;
	private String siSoToida;
	private String daDangki;
	private String maPhonghoc;
	private Date ngayBatdau;
	private Date ngayKetthuc;
	private String tiet;
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
	 * @return the tenMonhoc
	 */
	public String getTenMonhoc() {
		return tenMonhoc;
	}
	/**
	 * @param tenMonhoc the tenMonhoc to set
	 */
	public void setTenMonhoc(String tenMonhoc) {
		this.tenMonhoc = tenMonhoc;
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
	 * @return the sotinchi
	 */
	public String getSotinchi() {
		return sotinchi;
	}
	/**
	 * @param sotinchi the sotinchi to set
	 */
	public void setSotinchi(String sotinchi) {
		this.sotinchi = sotinchi;
	}
	/**
	 * @return the siSoToida
	 */
	public String getSiSoToida() {
		return siSoToida;
	}
	/**
	 * @param siSoToida the siSoToida to set
	 */
	public void setSiSoToida(String siSoToida) {
		this.siSoToida = siSoToida;
	}
	/**
	 * @return the daDangki
	 */
	public String getDaDangki() {
		return daDangki;
	}
	/**
	 * @param daDangki the daDangki to set
	 */
	public void setDaDangki(String daDangki) {
		this.daDangki = daDangki;
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
	 * @return the tiet
	 */
	public String getTiet() {
		return tiet;
	}
	/**
	 * @param tiet the tiet to set
	 */
	public void setTiet(String tiet) {
		this.tiet = tiet;
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
	 * @param tenMonhoc
	 * @param tenGV
	 * @param sotinchi
	 * @param siSoToida
	 * @param daDangki
	 * @param maPhonghoc
	 * @param ngayBatdau
	 * @param ngayKetthuc
	 * @param tiet
	 * @param thu
	 */
	public ThongtinLophocphan(String maLHP, String tenMonhoc, String tenGV, String sotinchi, String siSoToida,
			String daDangki, String maPhonghoc, Date ngayBatdau, Date ngayKetthuc, String tiet, String thu) {
		super();
		this.maLHP = maLHP;
		this.tenMonhoc = tenMonhoc;
		this.tenGV = tenGV;
		this.sotinchi = sotinchi;
		this.siSoToida = siSoToida;
		this.daDangki = daDangki;
		this.maPhonghoc = maPhonghoc;
		this.ngayBatdau = ngayBatdau;
		this.ngayKetthuc = ngayKetthuc;
		this.tiet = tiet;
		this.thu = thu;
	}
	/**
	 * 
	 */
	public ThongtinLophocphan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ThongtinLophocphan [maLHP=" + maLHP + ", tenMonhoc=" + tenMonhoc + ", tenGV=" + tenGV + ", sotinchi="
				+ sotinchi + ", siSoToida=" + siSoToida + ", daDangki=" + daDangki + ", maPhonghoc=" + maPhonghoc
				+ ", ngayBatdau=" + ngayBatdau + ", ngayKetthuc=" + ngayKetthuc + ", tiet=" + tiet + ", thu=" + thu
				+ "]";
	}
	
	
	
	

}

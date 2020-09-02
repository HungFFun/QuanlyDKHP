package DoituongData;

import java.sql.Date;

public class Lichday {
	private String maLHP;
	private String tenLHP;
	private String sotinchi;

	private String tietday;
	private String phonghoc;
	private String daynha;
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
	 * @return the tenLHP
	 */
	public String getTenLHP() {
		return tenLHP;
	}
	/**
	 * @param tenLHP the tenLHP to set
	 */
	public void setTenLHP(String tenLHP) {
		this.tenLHP = tenLHP;
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
	 * @return the daynha
	 */
	public String getDaynha() {
		return daynha;
	}
	/**
	 * @param daynha the daynha to set
	 */
	public void setDaynha(String daynha) {
		this.daynha = daynha;
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
	public Lichday(String maLHP, String tenLHP, String sotinchi, String tietday, String phonghoc, String daynha,
			Date ngayBatdau, Date ngayKetthuc) {
		super();
		this.maLHP = maLHP;
		this.tenLHP = tenLHP;
		this.sotinchi = sotinchi;
		this.tietday = tietday;
		this.phonghoc = phonghoc;
		this.daynha = daynha;
		this.ngayBatdau = ngayBatdau;
		this.ngayKetthuc = ngayKetthuc;
	}
	public Lichday() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Lichday [maLHP=" + maLHP + ", tenLHP=" + tenLHP + ", sotinchi=" + sotinchi + ", tietday=" + tietday
				+ ", phonghoc=" + phonghoc + ", daynha=" + daynha + ", ngayBatdau=" + ngayBatdau + ", ngayKetthuc="
				+ ngayKetthuc + "]";
	}
	
	
}

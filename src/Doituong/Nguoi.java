package Doituong;

import java.sql.Date;

public class Nguoi {
	private String Ma;
	private String ten;
	private String giotinh;
	private Date ngaysinh;
	private String soDienthoai;
	private String diachi;
	/**
	 * @return the ma
	 */
	public String getMa() {
		return Ma;
	}
	/**
	 * @param ma the ma to set
	 */
	public void setMa(String ma) {
		Ma = ma;
	}
	/**
	 * @return the ten
	 */
	public String getTen() {
		return ten;
	}
	/**
	 * @param ten the ten to set
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}
	/**
	 * @return the giotinh
	 */
	public String getGiotinh() {
		return giotinh;
	}
	/**
	 * @param giotinh the giotinh to set
	 */
	public void setGiotinh(String giotinh) {
		this.giotinh = giotinh;
	}
	/**
	 * @return the ngaysinh
	 */
	public Date getNgaysinh() {
		return ngaysinh;
	}
	/**
	 * @param ngaysinh the ngaysinh to set
	 */
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	/**
	 * @return the soDienthoai
	 */
	public String getSoDienthoai() {
		return soDienthoai;
	}
	/**
	 * @param soDienthoai the soDienthoai to set
	 */
	public void setSoDienthoai(String soDienthoai) {
		this.soDienthoai = soDienthoai;
	}
	/**
	 * @return the diachi
	 */
	public String getDiachi() {
		return diachi;
	}
	/**
	 * @param diachi the diachi to set
	 */
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ma == null) ? 0 : Ma.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nguoi other = (Nguoi) obj;
		if (Ma == null) {
			if (other.Ma != null)
				return false;
		} else if (!Ma.equals(other.Ma))
			return false;
		return true;
	}
	/**
	 * @param ma
	 * @param ten
	 * @param giotinh
	 * @param ngaysinh
	 * @param soDienthoai
	 * @param diachi
	 */
	public Nguoi(String ma, String ten, String giotinh, Date ngaysinh, String soDienthoai, String diachi) {
		super();
		Ma = ma;
		this.ten = ten;
		this.giotinh = giotinh;
		this.ngaysinh = ngaysinh;
		this.soDienthoai = soDienthoai;
		this.diachi = diachi;
	}
	/**
	 * 
	 */
	public Nguoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Nguoi [Ma=" + Ma + ", ten=" + ten + ", giotinh=" + giotinh + ", ngaysinh=" + ngaysinh + ", soDienthoai="
				+ soDienthoai + ", diachi=" + diachi + "]";
	}
	
	

}

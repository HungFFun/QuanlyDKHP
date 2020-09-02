package Doituong;

import java.sql.Date;

public class Giangvien_GiaovuPDT extends Nguoi{
	private String khoa;
	private String trinhdo;
	public String getKhoa() {
		return khoa;
	}
	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}
	public String getTrinhdo() {
		return trinhdo;
	}
	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}
	/**
	 * @param ma
	 * @param ten
	 * @param giotinh
	 * @param ngaysinh
	 * @param soDienthoai
	 * @param diachi
	 * @param khoa
	 * @param trinhdo
	 */
	public Giangvien_GiaovuPDT(String ma, String ten, String giotinh, Date ngaysinh, String soDienthoai, String diachi,
			String khoa, String trinhdo) {
		super(ma, ten, giotinh, ngaysinh, soDienthoai, diachi);
		this.khoa = khoa;
		this.trinhdo = trinhdo;
	}
	/**
	 * 
	 */
	public Giangvien_GiaovuPDT() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ma
	 * @param ten
	 * @param giotinh
	 * @param ngaysinh
	 * @param soDienthoai
	 * @param diachi
	 */
	public Giangvien_GiaovuPDT(String ma, String ten, String giotinh, Date ngaysinh, String soDienthoai,
			String diachi) {
		super(ma, ten, giotinh, ngaysinh, soDienthoai, diachi);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Giangvien_GiaovuPDT [khoa=" + khoa + ", trinhdo=" + trinhdo + "]";
	}	

}

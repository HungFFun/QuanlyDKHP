package Doituong;

import java.sql.Date;
import java.util.GregorianCalendar;

public class Sinhviens extends Nguoi{
	private String malop;
	private String trangthai;
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	/**
	 * @param ma
	 * @param ten
	 * @param giotinh
	 * @param ngaysinh
	 * @param soDienthoai
	 * @param diachi
	 * @param malop
	 * @param trangthai
	 */
	public Sinhviens(String ma, String ten, String giotinh, Date ngaysinh, String soDienthoai, String diachi,
			String malop, String trangthai) {
		super(ma, ten, giotinh, ngaysinh, soDienthoai, diachi);
		this.malop = malop;
		this.trangthai = trangthai;
	}
	/**
	 * 
	 */
	public Sinhviens() {
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
	public Sinhviens(String ma, String ten, String giotinh, Date ngaysinh, String soDienthoai, String diachi) {
		super(ma, ten, giotinh, ngaysinh, soDienthoai, diachi);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Sinhviens [malop=" + malop + ", trangthai=" + trangthai + "]";
	}

	

	

	

}

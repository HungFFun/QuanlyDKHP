package DoituongData;

import java.sql.Date;

public class ThongtinGiangvien {
	private String maGV;
	private String tenGV;
	private String giotinh;
	private Date ngaysinh;
	private String sdt;
	private String khoa;
	private String trinhdo;
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	public String getGiotinh() {
		return giotinh;
	}
	public void setGiotinh(String giotinh) {
		this.giotinh = giotinh;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
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
	public ThongtinGiangvien(String maGV, String tenGV, String giotinh, Date ngaysinh, String sdt, String khoa,
			String trinhdo) {
		super();
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.giotinh = giotinh;
		this.ngaysinh = ngaysinh;
		this.sdt = sdt;
		this.khoa = khoa;
		this.trinhdo = trinhdo;
	}
	public ThongtinGiangvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ThongtinGiangvien [maGV=" + maGV + ", tenGV=" + tenGV + ", giotinh=" + giotinh + ", ngaysinh="
				+ ngaysinh + ", sdt=" + sdt + ", khoa=" + khoa + ", trinhdo=" + trinhdo + "]";
	}
	
	

}

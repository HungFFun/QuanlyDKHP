package DoituongData;

import java.sql.Date;

public class ThongtinSinhvien {
	private String masv;
	private String tensv;
	private String giotinh;
	private Date ngaysinh;
	private String sdt;
	private String diachi;
	private String tenlophoc;
	private String tenkhoa;
	private String nienkhoa;
	private String tranthai;
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getTensv() {
		return tensv;
	}
	public void setTensv(String tensv) {
		this.tensv = tensv;
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
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getTenlophoc() {
		return tenlophoc;
	}
	public void setTenlophoc(String tenlophoc) {
		this.tenlophoc = tenlophoc;
	}
	public String getTenkhoa() {
		return tenkhoa;
	}
	public void setTenkhoa(String tenkhoa) {
		this.tenkhoa = tenkhoa;
	}
	public String getNienkhoa() {
		return nienkhoa;
	}
	public void setNienkhoa(String nienkhoa) {
		this.nienkhoa = nienkhoa;
	}
	public String getTranthai() {
		return tranthai;
	}
	public void setTranthai(String tranthai) {
		this.tranthai = tranthai;
	}
	public ThongtinSinhvien(String masv, String tensv, String giotinh, Date ngaysinh, String sdt, String diachi,
			String tenlophoc, String tenkhoa, String nienkhoa, String tranthai) {
		super();
		this.masv = masv;
		this.tensv = tensv;
		this.giotinh = giotinh;
		this.ngaysinh = ngaysinh;
		this.sdt = sdt;
		this.diachi = diachi;
		this.tenlophoc = tenlophoc;
		this.tenkhoa = tenkhoa;
		this.nienkhoa = nienkhoa;
		this.tranthai = tranthai;
	}
	public ThongtinSinhvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ThongtinSinhvien [masv=" + masv + ", tensv=" + tensv + ", giotinh=" + giotinh + ", ngaysinh=" + ngaysinh
				+ ", sdt=" + sdt + ", diachi=" + diachi + ", tenlophoc=" + tenlophoc + ", tenkhoa=" + tenkhoa
				+ ", nienkhoa=" + nienkhoa + ", tranthai=" + tranthai + "]";
	}	
	
	
	
	

}

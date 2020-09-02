package Doituong;

public class Khoa {
	private String maKhoa, tenKhoa;

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	public Khoa(String maKhoa, String tenKhoa) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
	}

	public Khoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Khoa [maKhoa=" + maKhoa + ", tenKhoa=" + tenKhoa + "]";
	}
	

}

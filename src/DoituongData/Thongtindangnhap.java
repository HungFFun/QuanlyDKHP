package DoituongData;

public class Thongtindangnhap {
	private String ma;
	private String ten;
	private String chucVu;
	
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Thongtindangnhap(String ma, String ten, String chucVu) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.chucVu = chucVu;
	}
	public Thongtindangnhap() {
		super();
	}
	@Override
	public String toString() {
		return "Thongtindangnhap [ma=" + ma + ", ten=" + ten + ", chucVu=" + chucVu + "]";
	}
	
	

}

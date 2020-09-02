package Doituong;

public class Monhoc {
	private String maMH;
	private String tenMH;
	private int soTinchi;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maMH == null) ? 0 : maMH.hashCode());
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
		Monhoc other = (Monhoc) obj;
		if (maMH == null) {
			if (other.maMH != null)
				return false;
		} else if (!maMH.equals(other.maMH))
			return false;
		return true;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public int getSoTinchi() {
		return soTinchi;
	}
	public void setSoTinchi(int soTinchi) {
		this.soTinchi = soTinchi;
	}
	public Monhoc(String maMH, String tenMH, int soTinchi) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.soTinchi = soTinchi;
	}
	public Monhoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Monhoc [maMH=" + maMH + ", tenMH=" + tenMH + ", soTinchi=" + soTinchi + "]";
	}
	
	

}

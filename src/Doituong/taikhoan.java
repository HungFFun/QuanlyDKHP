package Doituong;

public class taikhoan {
	private String maTK;
	private String matkhau;
	private String chucvu;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTK == null) ? 0 : maTK.hashCode());
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
		taikhoan other = (taikhoan) obj;
		if (maTK == null) {
			if (other.maTK != null)
				return false;
		} else if (!maTK.equals(other.maTK))
			return false;
		return true;
	}
	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public taikhoan(String maTK, String matkhau, String chucvu) {
		super();
		this.maTK = maTK;
		this.matkhau = matkhau;
		this.chucvu = chucvu;
	}
	public taikhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "taikhoan [maTK=" + maTK + ", matkhau=" + matkhau + ", chucvu=" + chucvu + "]";
	}
	
	

}

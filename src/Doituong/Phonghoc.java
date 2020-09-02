package Doituong;

public class Phonghoc {
	private String maPH;
	private String ghichu;
	private String daynha;
	public String getMaPH() {
		return maPH;
	}
	public void setMaPH(String maPH) {
		this.maPH = maPH;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public String getDaynha() {
		return daynha;
	}
	public void setDaynha(String daynha) {
		this.daynha = daynha;
	}
	public Phonghoc(String maPH, String ghichu, String daynha) {
		super();
		this.maPH = maPH;
		this.ghichu = ghichu;
		this.daynha = daynha;
	}
	public Phonghoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Phonghoc [maPH=" + maPH + ", ghichu=" + ghichu + ", daynha=" + daynha + "]";
	}
	
	
	

}

package Model;

public class NhaCC {
	private String MaNCC;
    private String TenNhaCC;
    private String DiaChi;
    private String SDT;
    
	public NhaCC() {
		super();
	}

	public NhaCC(String maNCC, String tenNhaCC, String diaChi, String sDT) {
		super();
		MaNCC = maNCC;
		TenNhaCC = tenNhaCC;
		DiaChi = diaChi;
		SDT = sDT;
	}

	public String getMaNCC() {
		return MaNCC;
	}

	public void setMaNCC(String maNCC) {
		MaNCC = maNCC;
	}

	public String getTenNhaCC() {
		return TenNhaCC;
	}

	public void setTenNhaCC(String tenNhaCC) {
		TenNhaCC = tenNhaCC;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}
    

}

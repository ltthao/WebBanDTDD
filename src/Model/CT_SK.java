package Model;

public class CT_SK {
	private String MaSK;
    private String MaLSP;
    private String TenLSP;
    private float KhuyenMai;
    
	public CT_SK() {
		super();
	}

	public CT_SK(String maSK, String maLSP, float khuyenMai, String tenLSP) {
		super();
		MaSK = maSK;
		MaLSP = maLSP;
		KhuyenMai = khuyenMai;
		TenLSP = tenLSP;
	}

	public String getTenLSP() {
		return TenLSP;
	}

	public void setTenLSP(String tenLSP) {
		TenLSP = tenLSP;
	}

	public String getMaSK() {
		return MaSK;
	}

	public void setMaSK(String maSK) {
		MaSK = maSK;
	}

	public String getMaLSP() {
		return MaLSP;
	}

	public void setMaLSP(String maLSP) {
		MaLSP = maLSP;
	}

	public float getKhuyenMai() {
		return KhuyenMai;
	}

	public void setKhuyenMai(float khuyenMai) {
		KhuyenMai = khuyenMai;
	}
    
}

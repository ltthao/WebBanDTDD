package Model;

public class PhieuNhap {
	private String MaPN;
    private String MaNCC;
    private String TenNCC;
    private String MaNV;
    private String TenNV;
    private String NgayNhap;
    
	public PhieuNhap() {
		super();
	}

	public PhieuNhap(String maPN, String maNCC, String maNV, String ngayNhap, String tenNCC, String tenNV) {
		super();
		MaPN = maPN;
		MaNCC = maNCC;
		MaNV = maNV;
		NgayNhap = ngayNhap;
		TenNCC = tenNCC;
		TenNV = tenNV;
	}

	public String getTenNCC() {
		return TenNCC;
	}

	public void setTenNCC(String tenNCC) {
		TenNCC = tenNCC;
	}

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	public String getMaPN() {
		return MaPN;
	}

	public void setMaPN(String maPN) {
		MaPN = maPN;
	}

	public String getMaNCC() {
		return MaNCC;
	}

	public void setMaNCC(String maNCC) {
		MaNCC = maNCC;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getNgayNhap() {
		return NgayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		NgayNhap = ngayNhap;
	}
	
    
}

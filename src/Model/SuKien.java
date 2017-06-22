package Model;

public class SuKien {
	private String MaSK;
    private String TenSK;
    private String MoTaSK;
    private String NgayBD;
    private String NgayKT;
    private String MaNV;
    private float KhuyenMai;
    private String TenNV;
    private String TenLSP;
    private String MaLSP;
    
	public SuKien() {
		super();
	}

	public SuKien(String maSK, String tenSK, String moTaSK, String ngayBD, String ngayKT, String maNV,
			String tenNV, float khuyenMai, String tenLSP, String maLSP) {
		super();
		MaSK = maSK;
		TenSK = tenSK;
		MoTaSK = moTaSK;
		NgayBD = ngayBD;
		NgayKT = ngayKT;
		MaNV = maNV;
		TenNV = tenNV;
		KhuyenMai = khuyenMai;
		TenLSP = tenLSP;
		MaLSP = maLSP;
	}

	public String getTenLSP() {
		return TenLSP;
	}

	public void setTenLSP(String tenLSP) {
		TenLSP = tenLSP;
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

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	public String getMaSK() {
		return MaSK;
	}

	public void setMaSK(String maSK) {
		MaSK = maSK;
	}

	public String getTenSK() {
		return TenSK;
	}

	public void setTenSK(String tenSK) {
		TenSK = tenSK;
	}

	public String getMoTaSK() {
		return MoTaSK;
	}

	public void setMoTaSK(String moTaSK) {
		MoTaSK = moTaSK;
	}

	public String getNgayBD() {
		return NgayBD;
	}

	public void setNgayBD(String ngayBD) {
		NgayBD = ngayBD;
	}

	public String getNgayKT() {
		return NgayKT;
	}

	public void setNgayKT(String ngayKT) {
		NgayKT = ngayKT;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	
}

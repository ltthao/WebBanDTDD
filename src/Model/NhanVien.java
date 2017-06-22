package Model;

public class NhanVien {

	private String MaNV;
	private String TenNV;
	private String SDT;
	private String DiaChi;
	private String GioiTinh;
	private float Luong;
	private String NgSinh;
	private String TaiKhoan;
	private String MatKhau;
	private String MaLoaiNV;
	private String TenLoaiNV;

	public NhanVien() {
		super();
	}

	public NhanVien(String maNV, String tenNV, String sDT, String diaChi, String gioiTinh, float luong, String ngSinh,
			String maLoaiNV, String tenLoaiNV,String taiKhoan,String matKhau) {
		super();
		MaNV = maNV;
		TenNV = tenNV;
		SDT = sDT;
		DiaChi = diaChi;
		GioiTinh = gioiTinh;
		Luong = luong;
		NgSinh = ngSinh;
		MaLoaiNV = maLoaiNV;
		TenLoaiNV = tenLoaiNV;
		TaiKhoan = taiKhoan;
		MatKhau = matKhau;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public float getLuong() {
		return Luong;
	}

	public void setLuong(float luong) {
		Luong = luong;
	}

	public String getNgSinh() {
		return NgSinh;
	}

	public void setNgSinh(String ngSinh) {
		NgSinh = ngSinh;
	}

	public String getMaLoaiNV() {
		return MaLoaiNV;
	}

	public void setMaLoaiNV(String maLoaiNV) {
		MaLoaiNV = maLoaiNV;
	}

	public String getTenLoaiNV() {
		return TenLoaiNV;
	}

	public void setTenLoaiNV(String tenLoaiNV) {
		TenLoaiNV = tenLoaiNV;
	}
	public String getTaiKhoan() {
		return TaiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

}

package Model;

public class KhachHang {
	private String MaKH;
    private String TenKH;
    private String SDT;
    private String DiaChi;
    private String Email;
    
	public KhachHang() {
		super();
	}

	public KhachHang(String maKH, String tenKH, String sDT, String diaChi, String email) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		SDT = sDT;
		DiaChi = diaChi;
		Email = email;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getTenKH() {
		return TenKH;
	}

	public void setTenKH(String tenKH) {
		TenKH = tenKH;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	
}

package Model;

public class CT_PN {
	private String MaPN;
    private String MaSP;
    private float SLNhap;
    private float GiaNhap;
    private float GiaBan;
    private float ThanhTien;
    private String TenSP;
    
	public CT_PN() {
		super();
	}

	public CT_PN(String maPN, String maSP, float sLNhap, float giaNhap, float thanhTien, String tenSP,
			float giaBan) {
		super();
		MaPN = maPN;
		MaSP = maSP;
		SLNhap = sLNhap;
		GiaNhap = giaNhap;
		ThanhTien = thanhTien;
		TenSP = tenSP;
		GiaBan = giaBan;
	}

	public float getGiaBan() {
		return GiaBan;
	}

	public void setGiaBan(float giaBan) {
		GiaBan = giaBan;
	}

	public String getMaPN() {
		return MaPN;
	}

	public void setMaPN(String maPN) {
		MaPN = maPN;
	}

	public String getMaSP() {
		return MaSP;
	}

	public void setMaSP(String maSP) {
		MaSP = maSP;
	}

	public float getSLNhap() {
		return SLNhap;
	}

	public void setSLNhap(float sLNhap) {
		SLNhap = sLNhap;
	}

	public float getGiaNhap() {
		return GiaNhap;
	}

	public void setGiaNhap(float giaNhap) {
		GiaNhap = giaNhap;
	}

	public float getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(float thanhTien) {
		ThanhTien = thanhTien;
	}

	public String getTenSP() {
		return TenSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	
}

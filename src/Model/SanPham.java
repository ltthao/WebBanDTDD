package Model;

public class SanPham {
	private String MaSP;
    private String TenSP;
    private double SoLuong;
    private double GiaBan;
    private String GiaBanFormat;
    private String ManHinh;
    private String CPU;
    private String RAM;
    private String HeDieuHanh;
    private String Sim;
    private String CameraTruoc;
    private String CameraSau;
    private String BoNhoTrong;
    private String HoTroTheNho;
    private String Pin;
    private String MaNCC;
    private String TenNCC;
    private String MaHSX;
    private String TenHSX;
    private String MaLSP;
    private String TenLSP;
    private String HinhSP;
    private String MoTaSP;
    private String HinhAnh2;
    private String DanhGiaSP;
    private String HinhAnh3;
    
    
	public SanPham() {
		super();
	}


	public SanPham(String maSP, String tenSP, double soLuong, double giaBan, String manHinh, String cPU, String rAM,
			String heDieuHanh, String sim, String cameraTruoc, String cameraSau, String boNhoTrong, String hoTroTheNho,
			String pin, String maNCC, String maHSX, String maLSP, String hinhSP, String moTaSP, String hinhAnh2,
			String danhGiaSP, String hinhAnh3, String tenNCC, String tenHSX, String tenLSP, String giaBanFormat) {
		super();
		MaSP = maSP;
		TenSP = tenSP;
		SoLuong = soLuong;
		GiaBan = giaBan;
		ManHinh = manHinh;
		CPU = cPU;
		RAM = rAM;
		HeDieuHanh = heDieuHanh;
		Sim = sim;
		CameraTruoc = cameraTruoc;
		CameraSau = cameraSau;
		BoNhoTrong = boNhoTrong;
		HoTroTheNho = hoTroTheNho;
		Pin = pin;
		MaNCC = maNCC;
		MaHSX = maHSX;
		MaLSP = maLSP;
		HinhSP = hinhSP;
		MoTaSP = moTaSP;
		HinhAnh2 = hinhAnh2;
		DanhGiaSP = danhGiaSP;
		HinhAnh3 = hinhAnh3;
		TenNCC = tenNCC;
		TenHSX = tenHSX;
		TenLSP = tenLSP;
		GiaBanFormat = giaBanFormat;
	}


	public String getGiaBanFormat() {
		return GiaBanFormat;
	}


	public void setGiaBanFormat(String giaBanFormat) {
		GiaBanFormat = giaBanFormat;
	}


	public String getTenNCC() {
		return TenNCC;
	}


	public void setTenNCC(String tenNCC) {
		TenNCC = tenNCC;
	}


	public String getTenHSX() {
		return TenHSX;
	}


	public void setTenHSX(String tenHSX) {
		TenHSX = tenHSX;
	}


	public String getTenLSP() {
		return TenLSP;
	}


	public void setTenLSP(String tenLSP) {
		TenLSP = tenLSP;
	}


	public String getMaSP() {
		return MaSP;
	}


	public void setMaSP(String maSP) {
		MaSP = maSP;
	}


	public String getTenSP() {
		return TenSP;
	}


	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}


	public double getSoLuong() {
		return SoLuong;
	}


	public void setSoLuong(double soLuong) {
		SoLuong = soLuong;
	}


	public double getGiaBan() {
		return GiaBan;
	}


	public void setGiaBan(double giaBan) {
		GiaBan = giaBan;
	}


	public String getManHinh() {
		return ManHinh;
	}


	public void setManHinh(String manHinh) {
		ManHinh = manHinh;
	}


	public String getCPU() {
		return CPU;
	}


	public void setCPU(String cPU) {
		CPU = cPU;
	}


	public String getRAM() {
		return RAM;
	}


	public void setRAM(String rAM) {
		RAM = rAM;
	}


	public String getHeDieuHanh() {
		return HeDieuHanh;
	}


	public void setHeDieuHanh(String heDieuHanh) {
		HeDieuHanh = heDieuHanh;
	}


	public String getSim() {
		return Sim;
	}


	public void setSim(String sim) {
		Sim = sim;
	}


	public String CameraTruoc() {
		return CameraTruoc;
	}


	public void setCameraTruoc(String cameraTruoc) {
		CameraTruoc = cameraTruoc;
	}


	public String getCameraTruoc() {
		return CameraTruoc;
	}


	public String getCameraSau() {
		return CameraSau;
	}


	public void setCameraSau(String cameraSau) {
		CameraSau = cameraSau;
	}


	public String getBoNhoTrong() {
		return BoNhoTrong;
	}


	public void setBoNhoTrong(String boNhoTrong) {
		BoNhoTrong = boNhoTrong;
	}


	public String getHoTroTheNho() {
		return HoTroTheNho;
	}


	public void setHoTroTheNho(String hoTroTheNho) {
		HoTroTheNho = hoTroTheNho;
	}


	public String getPin() {
		return Pin;
	}


	public void setPin(String pin) {
		Pin = pin;
	}


	public String getMaNCC() {
		return MaNCC;
	}


	public void setMaNCC(String maNCC) {
		MaNCC = maNCC;
	}


	public String getMaHSX() {
		return MaHSX;
	}


	public void setMaHSX(String maHSX) {
		MaHSX = maHSX;
	}


	public String getMaLSP() {
		return MaLSP;
	}


	public void setMaLSP(String maLSP) {
		MaLSP = maLSP;
	}


	public String getHinhSP() {
		return HinhSP;
	}


	public void setHinhSP(String hinhSP) {
		HinhSP = hinhSP;
	}


	public String getMoTaSP() {
		return MoTaSP;
	}


	public void setMoTaSP(String moTaSP) {
		MoTaSP = moTaSP;
	}


	public String getHinhAnh2() {
		return HinhAnh2;
	}


	public void setHinhAnh2(String hinhAnh2) {
		HinhAnh2 = hinhAnh2;
	}


	public String getDanhGiaSP() {
		return DanhGiaSP;
	}


	public void setDanhGiaSP(String danhGiaSP) {
		DanhGiaSP = danhGiaSP;
	}


	public String getHinhAnh3() {
		return HinhAnh3;
	}


	public void setHinhAnh3(String hinhAnh3) {
		HinhAnh3 = hinhAnh3;
	}

	
}

package Model;

public class LoaiSP {
	private String MaLSP;
    private String TenLoaiSP;
    
	public LoaiSP() {
		super();
	}

	public LoaiSP(String maLSP, String tenLoaiSP) {
		super();
		MaLSP = maLSP;
		TenLoaiSP = tenLoaiSP;
	}

	public String getMaLSP() {
		return MaLSP;
	}

	public void setMaLSP(String maLSP) {
		MaLSP = maLSP;
	}

	public String getTenLoaiSP() {
		return TenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		TenLoaiSP = tenLoaiSP;
	}
    

}

package Model;

public class LoaiNV {
	private String MaLoaiNV;
    private String TenLoaiNV;
    
	public LoaiNV() {
		super();
	}

	public LoaiNV(String maLoaiNV, String tenLoaiNV) {
		super();
		MaLoaiNV = maLoaiNV;
		TenLoaiNV = tenLoaiNV;
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
	
    

}

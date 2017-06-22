package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LoaiNVDao;
import Dao.NhanVienDao;
import Model.KhachHang;
import Model.LoaiNV;
import Model.NhanVien;

/**
 * Servlet implementation class TaiKhoanController
 */
@WebServlet("/TaiKhoanController")
public class TaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TaiKhoanController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		NhanVienDao nvDao= new NhanVienDao();
		LoaiNVDao lnvDao= new LoaiNVDao();
		LoaiNV lnv= new LoaiNV();
		NhanVien nv=new NhanVien();
		String command = request.getParameter("command");
		String maNV= request.getParameter("MaNV");
		
		String url="", error="", type="";
		
		try{
			switch(command){
				case "delete":
					System.out.println("Vào delete nhân viên");
					boolean g=nvDao.deleteNhanVien(maNV);
				
					if(g)
					{
						type = "deletenv_1";
						error="Thành công";	
					}					
					else
					{
						type = "deletenv_1";
						error="Thất bại";
					}
						
					url="WebDT/11Admin.jsp?type="+type;
					System.out.println(error+"__________"+url);
					break;
				case "update":
					System.out.println("Vào update");
					nv = nvDao.getNhanVien(maNV);
					nv.setTenNV(request.getParameter("tennv"));
					nv.setSDT(request.getParameter("sdt"));
					nv.setDiaChi(request.getParameter("diachi"));
					nv.setGioiTinh(request.getParameter("gtinh"));
					nv.setNgSinh(request.getParameter("ngsinh"));
					nv.setLuong(Float.parseFloat(request.getParameter("luong")));
					lnv = lnvDao.getLoaiNVByChucVu(request.getParameter("chucvu"));
					nv.setMaLoaiNV(lnv.getMaLoaiNV());
					System.out.println(nv.getMaNV()+"_______"+nv.getTenNV()+"_____"+nv.getSDT()+"_______"+nv.getDiaChi());
					System.out.println(nv.getNgSinh()+"_______"+nv.getLuong()+"_____"+nv.getTenLoaiNV()+"_______"+nv.getMaLoaiNV());
					if(nvDao.updateNhanVien(nv))
					{
						error="Update successful!";
						type = "updateTT_1";
					}
					else
					{
						type = "updateTT_0";
						error="Update fail!";
					}
						
					System.out.println(error);
					url="WebDT/11Admin.jsp?type="+type;
					break;
				case "insert":
					System.out.println("Vào insert");

					nv.setTenNV(request.getParameter("tennv"));
					nv.setSDT(request.getParameter("sdt"));
					nv.setDiaChi(request.getParameter("diachi"));
					nv.setGioiTinh(request.getParameter("gtinh"));
					nv.setLuong(Float.parseFloat(request.getParameter("luong")));
					nv.setNgSinh(request.getParameter("ngsinh"));
					lnv = lnvDao.getLoaiNVByChucVu(request.getParameter("chucvu"));
					nv.setMaLoaiNV(lnv.getMaLoaiNV());
					nv.setTaiKhoan(request.getParameter("taikhoan"));
					nv.setMatKhau(request.getParameter("matkhau"));
					
					String manv="";
					NhanVien nv2 = new NhanVien();
					nv2 = nvDao.getNV_DaTT(nv);
					if(nv2.getMaNV() != null)
					{ 
						type = "insertnv_0";
						System.out.println("Đã tồn tài khách hàng này !");
						 manv = nv2.getMaNV();
						 error="Insert fail!";
					 }
					else
					{
						if(nvDao.insertNhanVien(nv))
						{
							type = "insertnv_1";
							nv2 = nvDao.getNV_DaTT(nv); manv = nv2.getMaNV();
							System.out.println("Thêm nhân viên mới thành công: MaKH= "+ manv);
							error="Insert successful!";
						}
					}
					url="WebDT/11Admin.jsp?type="+type;
					System.out.println(error+"__________"+url);
					break;
				
			}
			
		}catch(Exception e){
			error="Xảy ra lỗi ngẫu nhiên!";
		}
		
		request.setAttribute("error", error);
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

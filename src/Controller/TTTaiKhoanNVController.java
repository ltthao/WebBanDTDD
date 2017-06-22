package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.LoaiNVDao;
import Dao.NhanVienDao;
import HtmlEncode.HtmlEncoder;
import Model.LoaiNV;
import Model.NhanVien;

/**
 * Servlet implementation class TTTaiKhoanNVController
 */
@WebServlet("/TTTaiKhoanNVController")
public class TTTaiKhoanNVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TTTaiKhoanNVController() {
        super();
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
				case "doimk":
					System.out.println("Vào đổi mk");
					NhanVien nv1= new NhanVien();
					String manv1=request.getParameter("MaNV");
					nv1=nvDao.getNhanVien(manv1);
					String mk=request.getParameter("pass");
					System.out.println(mk+"____"+nv1.getMatKhau());
					if(mk.equals(nv1.getMatKhau()))
					{	System.out.println("Mật Khẩu cũ khớp");
						nv1.setMatKhau(request.getParameter("npass"));
						if(nvDao.DoiMatKhau(nv1))
						{
							type = "doimk_1";
							System.out.println("Vào update mật khẩu");
							error="Thành công";
							System.out.println(nv1.getMatKhau());
						}
					}
					else
					{
						type = "doimk_0";
						error="Thất bại";
					}
						
					url="WebDT/7NhanVienPage.jsp?type="+type;
					System.out.println(error+"__________"+url);
					break;
				case "update":
					System.out.println("Vào update");
					HttpSession session = request.getSession();
					NhanVien nv_test=nvDao.getNhanVienByTaiKhoan(session.getAttribute("user").toString());
					System.out.println("Ma tk test ="+nv_test.getMaNV()+"----------tk chinh="+maNV);
					if(nv_test.getMaNV().equals(maNV))
					{
						nv = nvDao.getNhanVien(maNV);
						nv.setMaNV(maNV);
						nv.setTenNV(HtmlEncoder.encode(request.getParameter("ten")));
						nv.setSDT(HtmlEncoder.encode(request.getParameter("sdt")));
						nv.setDiaChi(HtmlEncoder.encode(request.getParameter("diachi")));
						nv.setNgSinh(HtmlEncoder.encode(request.getParameter("ngsinh")));
						System.out.println(nv.getMaNV()+"________"+nv.getTenNV()+"____"+nv.getSDT()+"____"+nv.getDiaChi()+"_________"+nv.getNgSinh());
						if(nvDao.updateTT(nv))
						{
							type = "updateTT_1";
							error="Thành công";
						}
							
						else
						{
							type = "updateTT_0";
							error="Thất bại";
						}
					}else{
						type = "updateTT_0";
						error="Thất bại";
					}
					
					System.out.println(error);
					url="WebDT/7NhanVienPage.jsp?type="+type;
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

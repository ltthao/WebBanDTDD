package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.KhachHangDao;
import Model.KhachHang;

/**
 * Servlet implementation class KhachHangController
 */
@WebServlet("/KhachHangController")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		KhachHangDao crt= new KhachHangDao();
		KhachHang kh=new KhachHang();
		String command = request.getParameter("command");
		String maKH= request.getParameter("MaKH");
		
		String url="", error="", type="";
		
		try{
			switch(command){
				case "delete":
					System.out.println("Vào delete");
					boolean g=crt.deleteKhachHang(maKH);
				
					if(g)			
					{
						type = "xoakh_1";
						error="Thành công";		
					}				
					else
					{
						type = "xoakh_0";
						error="Thất bại";
					}
					url="WebDT/7NhanVienPage.jsp?type="+type;
					System.out.println(error+"__________"+url);
					break;
				case "update":
					System.out.println("Vào update");
					kh = crt.getKhachHang(maKH);
					kh.setTenKH(request.getParameter("tenKH"));
					kh.setSDT(request.getParameter("sdt"));
					kh.setDiaChi(request.getParameter("diachi"));
					kh.setEmail(request.getParameter("email"));
					if(crt.updateKhachHang(kh))
					{
						type = "suattkh_1";
						error="Update Khach Hang successful!";
					}
					else
					{
						type = "suattkh_0";
						error="Update Khach Hang fail!";
					}
					url="WebDT/7NhanVienPage.jsp?type="+type;
					System.out.println(error+"__________"+url);
					break;
				case "insert":
					KhachHang kh2 = new KhachHang();
					String MaKH = "";
					System.out.println("Vào insert 2");
					
					kh.setTenKH(request.getParameter("tenKH"));
					kh.setSDT(request.getParameter("sdt"));
					kh.setDiaChi(request.getParameter("diachi"));
					kh.setEmail(request.getParameter("email"));
					
					kh2 = crt.getKH_DaTT(kh);
					if(kh2.getMaKH() != null)
					{ 
						type = "themkh_0";
						System.out.println("Đã tồn tài khách hàng này !");
					 MaKH = kh2.getMaKH();}
					else
					{
						if(crt.insertKhachHang(kh))
						{
							type = "themkh_1";
							kh2 = crt.getKH_DaTT(kh); MaKH=kh2.getMaKH();
							System.out.println("Thêm khách hàng mới thành công: MaKH= "+MaKH);
						}
					}
					System.out.println(MaKH+"______"+kh.getTenKH()+"_____"+kh.getSDT()+"_____"+kh.getEmail());
					url="WebDT/7NhanVienPage.jsp?type="+type;
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

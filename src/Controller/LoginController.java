package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Dao.LoaiNVDao;
import Dao.NhanVienDao;
import HtmlEncode.HtmlEncoder;
import Model.LoaiNV;
import Model.NhanVien;
import Tools.MD5;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		NhanVien nv=null;
		HttpSession session = request.getSession();
        String userInfo = (String) session.getAttribute("user");
        if(userInfo == null){
        	
        }
		String url="", error="", type="";
		
		try{
		
			System.out.println("Vào login");
			String user=request.getParameter("user");
			
			String mk=MD5.encryption(request.getParameter("pass"));
			nv=nvDao.login(user,mk);
			System.out.println(nv.getTaiKhoan()+"____"+nv.getMaLoaiNV());
			
			
			if(nv.getTenNV()!=null)
			{
				if(nv.getMaLoaiNV().equals("1"))
				{	
					error="Thành công";
					url="WebDT/7NhanVienPage.jsp";
					System.out.println("chuyen huong____"+url);
				}
				else if(nv.getMaLoaiNV().equals("2"))
				{
					error="Thành công";
					url="WebDT/9QuanLyPage.jsp";
				}
				else if(nv.getMaLoaiNV().equals("3"))
				{
					url="WebDT/11Admin.jsp";
				}
				else
					url="WebDT/0trangChu.jsp";
				session.setAttribute("user", user);
			}
			else
			{
				url="WebDT/0trangChu.jsp";
				error="Thất bại";
				
			}				
			
		}catch(Exception e){
			error="Xảy ra lỗi ngẫu nhiên!";
		}
		System.out.println("chuyen huong____"+url);
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

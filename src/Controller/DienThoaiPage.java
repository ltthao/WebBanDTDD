package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.HDBHDao;
import Dao.KhachHangDao;
import Dao.NhanVienDao;
import Dao.PhieuNhapDao;
import Dao.SanPhamDao;
import Dao.SuKienDao;

/**
 * Servlet implementation class XoaHoiDong_Servlet
 */
@WebServlet("/DienThoaiPage")
public class DienThoaiPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HDBHDao hdDao= new HDBHDao(); 
	KhachHangDao khDao=new KhachHangDao();
	NhanVienDao nvDao=new NhanVienDao();
	SanPhamDao spDao = new SanPhamDao();
	SuKienDao skDao = new SuKienDao();
	PhieuNhapDao pnDAO = new PhieuNhapDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DienThoaiPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getParameter("command");
		String maHD= request.getParameter("MaHD");
		System.out.println("Nhu cc vậy");
		String url="", error="";
		
		try{
			switch(command){
				case "delete":
					
					break;
			}
			
		}catch(Exception e){
			error="Xảy ra lỗi ngẫu nhiên!";
		}
//		request.setAttribute("error", error);
//		response.sendRedirect("quanlyPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LoaiNVDao;
import Dao.NhanVienDao;
import Dao.SuKienDao;
import Model.KhachHang;
import Model.LoaiNV;
import Model.NhanVien;
import Model.SuKien;

/**
 * Servlet implementation class TaiKhoanController
 */
@WebServlet("/SuKienController")
public class SuKienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SuKienController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		SuKienDao skDao = new SuKienDao();
		NhanVienDao nvDao= new NhanVienDao();
		LoaiNVDao lnvDao= new LoaiNVDao();
		String MaSK= request.getParameter("MaSK");
		String command = request.getParameter("command");
		SuKien sk = new SuKien();
		
		String url="", error="", type="";
		
		try{
			switch(command){
				case "deleteSK":
					System.out.println("Vào delete sự kiện");
					if(skDao.deleteSuKien(MaSK))
						type="deleteSK_1";
					else
						type="deleteSK_0";
					break;
				case "updateSK":
					System.out.println("Vào update sự kiện");
					sk = skDao.getSuKien_ByMaSK(MaSK);
					sk.setTenSK(request.getParameter("TenSK"));
					sk.setNgayBD(request.getParameter("NgayBD"));
					sk.setNgayKT(request.getParameter("NgayKT"));
					sk.setMoTaSK(request.getParameter("MoTaSK"));
					sk.setMaLSP(request.getParameter("LoaiSP"));
					sk.setKhuyenMai(Float.parseFloat(request.getParameter("KhuyenMai")));
					if(skDao.updateSuKien(sk))
						type="updateSK_1";
					else
						type="updateSK_0";
					
					break;
				case "insertSK":
					System.out.println("Vào insert sự kiện");
					sk.setTenSK(request.getParameter("TenSK"));
					sk.setNgayBD(request.getParameter("NgayBD"));
					sk.setNgayKT(request.getParameter("NgayKT"));
					sk.setMoTaSK(request.getParameter("MoTaSK"));
					sk.setMaLSP(request.getParameter("LoaiSP"));
					sk.setKhuyenMai(Float.parseFloat(request.getParameter("KhuyenMai")));	
					sk.setMaNV(request.getParameter("MaNV"));
					if(skDao.insertSuKien(sk))
						type="insertSK_1";
					else
						type="insertSK_0";	
					
					break;
				
			}
			
		}catch(Exception e){
			error="Xảy ra lỗi ngẫu nhiên!";
		}
		url = "WebDT/9QuanLyPage.jsp?type="+type;
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

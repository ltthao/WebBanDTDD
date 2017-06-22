package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CT_PNDao;
import Dao.HDBHDao;
import Dao.NhanVienDao;
import Dao.PhieuNhapDao;
import Dao.SanPhamDao;
import Model.NhanVien;
import Model.SanPham;

/**
 * Servlet implementation class NhanVienController
 */
@WebServlet("/SanPhamController")
public class SanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SanPhamDao spDAO = new SanPhamDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamController() {
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
		String MaSP= request.getParameter("MaSP");
		System.out.println("Vào sản phẩm controller với MASP= "+MaSP);
		String url="", error="", type="";
		SanPham sp = new SanPham();
		try{
			switch(command){
				case "deleteSP":
						System.out.println("Vào delete sản phẩm");
						if(spDAO.deleteSanPham(MaSP))
							type = "deleteSP_1";
						else
							type = "deleteSP_0";
						System.out.println(error);
					break;
				case "updateSP":
						System.out.println("Vào update sản phẩm thành công");
						if(request.getParameter("Loai").equals("DT_Tablet"))
							 sp = spDAO.getSanPham(MaSP);
						if(request.getParameter("Loai").equals("PhuKien"))
							sp = spDAO.getPhuKien(MaSP);
						sp.setTenSP(request.getParameter("TenSP").toString());
						
						sp.setSoLuong(Double.parseDouble(request.getParameter("SoLuong").toString()));
						sp.setGiaBan(Double.parseDouble(request.getParameter("GiaBan").toString()));
						sp.setHinhSP(request.getParameter("HinhSP").toString());
						sp.setMaNCC(request.getParameter("MaNCC").toString());
						sp.setHinhAnh2(request.getParameter("HinhAnh2").toString());
						sp.setHinhAnh3(request.getParameter("HinhAnh3").toString());
						sp.setMoTaSP(request.getParameter("MoTaSP").toString());
						sp.setDanhGiaSP(request.getParameter("DanhGiaSP").toString());
						sp.setMaLSP(request.getParameter("LoaiSP").toString());
						System.out.println(sp.getTenSP());
						if(request.getParameter("Loai").equals("DT_Tablet"))
						{
							sp.setMaHSX(request.getParameter("MaHSX").toString());
							sp.setManHinh(request.getParameter("ManHinh").toString());
							sp.setHeDieuHanh(request.getParameter("HeDieuHanh").toString());
							sp.setCameraTruoc(request.getParameter("cameraTruoc").toString());
							sp.setCPU(request.getParameter("CPU").toString());
							sp.setSim(request.getParameter("Sim").toString());
							sp.setCameraSau(request.getParameter("cameraSau").toString());
							sp.setRAM(request.getParameter("RAM").toString());
							sp.setPin(request.getParameter("Pin").toString());
							sp.setBoNhoTrong(request.getParameter("BoNhoTrong").toString());
						}
						
						
						if(spDAO.updateSanPham(sp))
							type="updateSP_1";
						else
							type="updateSP_0";
						
					break;
				case "insertSP":
					System.out.println("Vào insert sản phẩm thành công!");
					sp.setTenSP(request.getParameter("TenSP").toString());
					sp.setSoLuong(Double.parseDouble(request.getParameter("SoLuong").toString()));
					sp.setGiaBan(Double.parseDouble(request.getParameter("GiaBan").toString()));
					sp.setHinhSP(request.getParameter("HinhSP").toString());
					sp.setMaNCC(request.getParameter("MaNCC").toString());
					sp.setHinhAnh2(request.getParameter("HinhAnh2").toString());
					sp.setHinhAnh3(request.getParameter("HinhAnh3").toString());
					sp.setMoTaSP(request.getParameter("MoTaSP").toString());
					sp.setDanhGiaSP(request.getParameter("DanhGiaSP").toString());
					sp.setMaLSP(request.getParameter("LoaiSP").toString());
					System.out.println(sp.getTenSP()+"__MaNCC:"+sp.getMaNCC()+"__LSP:"+sp.getMaLSP());
					if(request.getParameter("Loai").equals("DT_Tablet"))
					{
						sp.setMaHSX(request.getParameter("MaHSX").toString());
						sp.setManHinh(request.getParameter("ManHinh").toString());
						sp.setHeDieuHanh(request.getParameter("HeDieuHanh").toString());
						sp.setCameraTruoc(request.getParameter("cameraTruoc").toString());
						sp.setCPU(request.getParameter("CPU").toString());
						sp.setSim(request.getParameter("Sim").toString());
						sp.setCameraSau(request.getParameter("cameraSau").toString());
						sp.setRAM(request.getParameter("RAM").toString());
						sp.setPin(request.getParameter("Pin").toString());
						sp.setBoNhoTrong(request.getParameter("BoNhoTrong").toString());
					}
					if(spDAO.insertSanPham(sp))
						type = "insertSP_1";
					else
						type = "insertSP_0";
					break;
				
			}
			
		}
		catch(Exception e){
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

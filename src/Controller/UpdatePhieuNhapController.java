package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CT_PNDao;
import Dao.LoaiNVDao;
import Dao.NhanVienDao;
import Dao.PhieuNhapDao;
import Dao.SanPhamDao;
import Dao.SuKienDao;
import Model.CT_PN;
import Model.KhachHang;
import Model.LoaiNV;
import Model.NhanVien;
import Model.PhieuNhap;
import Model.SuKien;

/**
 * Servlet implementation class TaiKhoanController
 */
@WebServlet("/UpdatePhieuNhapController")
public class UpdatePhieuNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdatePhieuNhapController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		SanPhamDao spDAO = new SanPhamDao();
		PhieuNhapDao pnDAO = new PhieuNhapDao();
		CT_PNDao ctpnDAO = new CT_PNDao();
		CT_PN ctpn = new CT_PN();
		String MaPN = request.getParameter("MaPN");
		String command = request.getParameter("command");
		String MaSP = "";
		if(request.getParameter("MaSP")!=null)
			MaSP = request.getParameter("MaSP");
		PhieuNhap pn = new PhieuNhap();
		
		String url="", error="", type="";
		
		try{
			switch(command){
				case "updateCTPN":
					System.out.println("Vào update chi tiết phiết nhập thành công");
					ctpn = ctpnDAO.getCTPN(MaPN, MaSP);
					boolean flag = true, flag2 = true;
					float slm,slc;
					ctpn.setSLNhap(Float.parseFloat(request.getParameter("SLNhap")));	
					ctpn.setGiaNhap(Float.parseFloat(request.getParameter("GiaNhap")));
					System.out.println("ok");
//					String MaSP_new = request.getParameter("MaSP_update");
//					if(MaSP == MaSP_new)
//					{
//						flag = spDAO.thaydoiSL_SP(MaSP, slm - slc);
//						System.out.println("Sản phẩm cũ tăng số lượng "+MaSP+"__SPM:"+MaSP_new);
//					}
//					else
//					{
//						flag = spDAO.thaydoiSL_SP(MaSP_new, slm);
//						flag2 = spDAO.thaydoiSL_SP(MaSP, -slc);
//						System.out.println("sản phẩm mới giảm sản phẩm cũ, tăng sản phẩm mới");
//					}
//					if(flag)
//					{
//						if(ctpnDAO.updateCTPN(ctpn, MaSP_new))
//						{
//							type="updateCTPN_1";
//						}
//						else
//						{
//							type="updateCTPN_0";
//						}
//					}	
					url="WebDT/10QuanLy_CTPN.jsp?MaPN="+MaPN+"&type="+type;
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

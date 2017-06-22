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
@WebServlet("/NhapHangController")
public class NhapHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NhapHangController() {
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
				case "deletePN":
					System.out.println("Vào delete phiếu nhập");
					ArrayList<CT_PN> list = new ArrayList<CT_PN>();
					list = pnDAO.getListCTPN_ByPN(MaPN);
					for(int i=0;i<list.size();i++)
					{
						if(!spDAO.thaydoiSL_SP(list.get(i).getMaSP(),-list.get(i).getSLNhap()))
						{	
							System.out.println("Hồi số lượng thất bại");
							break;
						}
					}
					if(pnDAO.deletePN(MaPN))
						type="deletePN_1";
					else
						type="deletePN_0";
					url = "WebDT/9QuanLyPage.jsp?type="+type;
					break;
				case "updatePN":
					System.out.println("Vào update sự kiện");
					
					
					break;
				case "insertPN":
					System.out.println("Vào insert sự kiện");
					ArrayList<PhieuNhap> list2 = new ArrayList<PhieuNhap>();
					PhieuNhapDao pnDao = new PhieuNhapDao();
					list2 = pnDao.getListPhieuNhap();
					int temp=0;
					int kq = 1;
					while(kq<=list2.size())
					{
						if(kq != Integer.parseInt(list2.get(kq-1).getMaPN()))
							break;
						kq++;
					}
					if(pnDAO.insertPN(request.getParameter("MaNV")))
					{
						type="insertPN_1";
						url="WebDT/10QuanLy_CTPN.jsp?MaPN="+kq+"&type="+type;
					}
					else
					{
						type="insertPN_0";
						url = "WebDT/9QuanLyPage.jsp?type="+type;
					}
					
					
					break;
				case "deleteCTPN":
					System.out.println("Vào delete chi tiết phiết nhập thành công");
					ctpn = ctpnDAO.getCTPN(MaPN, MaSP);
					float sl = ctpn.getSLNhap();
					if(spDAO.thaydoiSL_SP(MaSP, -sl))
					{
						if(ctpnDAO.deleteCTPN(MaPN, MaSP))
						{
							type="deleteCTPN_1";
						}
						else
						{
							type="deleteCTPN_0";
							if(spDAO.thaydoiSL_SP(MaSP,sl))
								System.out.println("Hoàn số lượng thành công");
						}
					}
					url="WebDT/10QuanLy_CTPN.jsp?MaPN="+MaPN+"&type="+type;
					break;
				case "updateCTPN":
					System.out.println("Vào update chi tiết phiếu nhập thành công");
					boolean flag = true, flag2 = true;
					float slm,slc;
					ctpn = ctpnDAO.getCTPN(MaPN, MaSP);
					slc = ctpn.getSLNhap();
					slm = Float.parseFloat(request.getParameter("SLNhap"));
					ctpn.setSLNhap(Float.parseFloat(request.getParameter("SLNhap")));	
					ctpn.setGiaNhap(Float.parseFloat(request.getParameter("GiaNhap")));
					String MaSP_new = request.getParameter("MaSP_update");
					if(MaSP == MaSP_new)
					{
						flag = spDAO.thaydoiSL_SP(MaSP, slm - slc);
						System.out.println("Sản phẩm cũ tăng số lượng "+MaSP+"__SPM:"+MaSP_new);
					}
					else
					{
						flag = spDAO.thaydoiSL_SP(MaSP_new, slm);
						flag2 = spDAO.thaydoiSL_SP(MaSP, -slc);
						System.out.println("sản phẩm mới giảm sản phẩm cũ, tăng sản phẩm mới");
					}
					if(flag)
					{
						if(ctpnDAO.updateCTPN(ctpn, MaSP_new))
						{
							type="updateCTPN_1";
						}
						else
						{
							type="updateCTPN_0";
						}
					}	
					url="WebDT/10QuanLy_CTPN.jsp?MaPN="+MaPN+"&type="+type;
					break;
					
				case "insertCTPN":
					System.out.println("Vào insert chi tiết phiết nhập thành công");
					ctpn.setMaPN(request.getParameter("MaPN"));
					ctpn.setMaSP(request.getParameter("MaSP_new"));
					ctpn.setSLNhap(Float.parseFloat(request.getParameter("SLNhap")));
					ctpn.setGiaNhap(Float.parseFloat(request.getParameter("GiaNhap")));
					if(ctpnDAO.insertCTPN(ctpn))
					{
						if(spDAO.thaydoiSL_SP(ctpn.getMaSP(), ctpn.getSLNhap()))
							type="insertCTPN_1";
					}
					else
						type="insertCTPN_0";
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

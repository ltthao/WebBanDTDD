package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CT_PNDao;
import Dao.HDBHDao;
import Dao.LoaiSPDao;
import Model.CT_PN;
import Model.HDBH;
import Model.LoaiSP;
import Model.SanPham;

/**
 * Servlet implementation class ThongKeController
 */
@WebServlet("/ThongKeController")
public class ThongKeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HDBHDao hdDao=new HDBHDao();
	LoaiSPDao lspDao=new LoaiSPDao();
	CT_PNDao ctpnDao= new CT_PNDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongKeController() {
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
		String tk="";
		String url="", error="";
			
			try{
				switch(command){
					case "ThongKe":
						HDBH hd=new HDBH();
						CT_PN pn=new CT_PN();
						LoaiSP lsp=new LoaiSP();
						String ngayLap1=request.getParameter("NgayLap1");
						String ngayLap2=request.getParameter("NgayLap2");
						String TKTheo=request.getParameter("TKTheo");
						String LocTheo=request.getParameter("LocTheo");
						float sum=0,sum2=0;
						for(HDBH hd2: hdDao.getListHDBH_HangSX(TKTheo, ngayLap1, ngayLap2, LocTheo))
							sum +=(hd2.getGiaBan()*hd2.getSLBan());
						
						for(CT_PN pn2: ctpnDao.getListPhieuNhap_TKe(TKTheo, ngayLap1, ngayLap2, LocTheo))
							sum2 +=(pn2.getGiaNhap()*pn2.getSLNhap());
						url="WebDT/7NhanVienPage.jsp?ngay1="+ngayLap1+"&ngay2="+ngayLap2+"&TKTheo="+TKTheo+"&LocTheo="+LocTheo+"&SumBan="+sum+"&SumNhap="+sum2;
						System.out.println("vào thống kê ok");
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

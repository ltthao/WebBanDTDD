package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CT_PNDao;
import Dao.HDBHDao;
import Dao.KhachHangDao;
import Dao.NhanVienDao;
import Dao.PhieuNhapDao;
import Dao.SanPhamDao;
import Dao.SuKienDao;
import Model.HDBH;
import Model.KhachHang;
import Model.NhanVien;
import Model.SanPham;
import Model.SuKien;

/**
 * Servlet implementation class NhanVienController
 */
@WebServlet("/MuaHangController")
public class MuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SanPhamDao spDAO = new SanPhamDao();
	SuKienDao skDAO = new SuKienDao();
	KhachHangDao khDAO=new KhachHangDao();
	HDBHDao hdbhDAO = new HDBHDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuaHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String url = "",error="";
		String command = request.getParameter("command");
		String loai = request.getParameter("Loai");
		String MaSP= request.getParameter("MaSP");
		String SoLuong = request.getParameter("SoLuongSP");
		String HoTen = request.getParameter("HoTen");
		String SDT= request.getParameter("SDT");
		
		String regex = "[0-9]+";
		if(SDT.matches(regex))
		{
			String Email = request.getParameter("Email");
			String DiaChi = request.getParameter("DiaChi");
			SuKien sk = new SuKien();
			SanPham sp = new SanPham();
			if(loai.equals("sanpham"))
				sp = spDAO.getSanPham(MaSP);
			else
				sp = spDAO.getPhuKien(MaSP);
			sk = skDAO.getSuKien();
			if(sk.getMaSK() == null)
			{
				System.out.println("Không có sự kiện diễn ra");
			}
			else
			{
				if(sk.getMaLSP().equals(sp.getMaLSP()))
				{
					sp.setGiaBan(sp.getGiaBan()*(1-sk.getKhuyenMai()/100));
					System.out.println("Sự kiện "+sk.getTenSK()+" đang diễn ra "+sk.getTenLSP()+" với "+sk.getKhuyenMai()+" %");
					System.out.println("Giá SP "+sp.getTenSP()+" còn "+sp.getGiaBan());
				}
				else
					System.out.println("Có sự kiện nhưng sản phẩm không trong diện giảm giá");
			}
			System.out.println("Vào mua hang Controller");
			System.out.println(MaSP+"___________"+SoLuong+"___MALSP:"+sp.getMaLSP());
			 url="WebDT/12MuaHangTC.jsp?MaSP="+MaSP+"&SoLuong="+SoLuong; error="";
			try{
				switch(command){
					case "insert":
							System.out.println("Vào insert thành công!");
							String MaKH = "";
							KhachHang kh = new KhachHang();
							KhachHang kh2 = new KhachHang();
							kh.setTenKH(HoTen);
							kh.setDiaChi(DiaChi);
							kh.setSDT(SDT);
							kh.setEmail(Email);
							kh2 = khDAO.getKH_DaTT(kh);
							if(kh2.getMaKH() != null)
							{ System.out.println("Đã tồn tài khách hàng này !");
							 MaKH = kh2.getMaKH();}
							else
							{
								if(khDAO.insertKhachHang(kh))
								{
									kh2 = khDAO.getKH_DaTT(kh); MaKH=kh2.getMaKH();
									System.out.println("Thêm khách hàng mới thành công: MaKH= "+MaKH);
								}
							}
							HDBH hd = new HDBH();
							hd.setMaKH(MaKH);
							hd.setMaSP(sp.getMaSP());
							hd.setSLBan(Float.parseFloat(SoLuong));
							hd.setGiaBan(sp.getGiaBan());
							hd.setTrangThai("1");
							if(hdbhDAO.insertHDBH(hd))
								System.out.println("Thêm hóa đơn thành công!");
							
						break;
					case "update":
						
						break;
					
				}
				
			}
			catch(Exception e){
				error="Xảy ra lỗi ngẫu nhiên!";
			}
			
		}
		else{
			url = "WebDT/0trangChu.jsp";
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

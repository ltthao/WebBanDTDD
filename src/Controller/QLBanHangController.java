package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.HDBHDao;
import Dao.SanPhamDao;
import Model.HDBH;
import Model.SanPham;
/**
 * Servlet implementation class QLBanHangController
 */
@WebServlet("/QLBanHangController")
public class QLBanHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QLBanHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HDBHDao hdDao= new HDBHDao();
		SanPhamDao spDao=new SanPhamDao();
		HDBH hd=new HDBH();
		String command = request.getParameter("command");
		String maHD= request.getParameter("MaHD");
		String maSP=request.getParameter("MaSP");
		String maNV=request.getParameter("MaNV");
		
		String url="", error="", type="";
		
		try{
			switch(command){
				case "delete":
					System.out.println("Vào delete");
					
					HDBH hdbh=hdDao.getHDBH(maHD);
					System.out.println(hdbh.getMaKH());
					SanPham sp=spDao.getSanPham(maSP);
					double sl=sp.getSoLuong()+hdbh.getSLBan() ;
					System.out.println(sl+"____"+sp.getSoLuong()+"_____"+hdbh.getSLBan()+"____"+hdbh.getMaHD());	
					sp.setSoLuong(sl);
					
					if(spDao.updateSoLuong(sp))
						error="Update SoLuong Successful!";
					boolean g=hdDao.deleteHDBH(maHD);
					if(g){
						type = "deleteHD_1";
						error="Delete HDBH Successful!";	}
					
					else
					{
						type = "deleteHD_0";
						error="Thất bại";}
					url="WebDT/7NhanVienPage.jsp?type="+type;
					System.out.println(error+"__________"+url);
					break;
				case "check":
					System.out.println("Vào phê duyệt");
					String xuly = request.getParameter("xuly");
					
					if(xuly.equals("check1"))
					{
						HDBH hdbh1=hdDao.getHDBH(maHD);
						SanPham sp1=spDao.getSanPham(maSP);
						if(sp1.getSoLuong()==0)
						{
							type = "check1_0";
							System.out.println("Sản phẩm không còn trong kho");
						}
						if(sp1.getSoLuong()<hdbh1.getSLBan())
						{
							type = "check1_0";
							System.out.println("Sản phẩm không còn đủ số lượng");
						}
						if(sp1.getSoLuong()>=hdbh1.getSLBan())
						{
							
							double sl1=sp1.getSoLuong()-hdbh1.getSLBan() ;
							System.out.println(sl1+"____"+sp1.getSoLuong()+"_____"+hdbh1.getSLBan()+"____"+hdbh1.getMaHD());	
							sp1.setSoLuong(sl1);
							if(spDao.updateSoLuong(sp1))
								error="Update So Luong successful";
							System.out.println("Xác nhận thành công");
							hdbh1.setTrangThai("2");
							if(hdDao.updateTrangThai(hdbh1))
							{
								type = "check1_1";
								error="Update Trang Thai successful!";
							}
							System.out.println("Xác nhận tt");
							hdbh1.setMaNV(maNV);
							if(hdDao.updateNhanVien(hdbh1))
								error="Update Nhan Vien successful!";	
							System.out.println("Xác nhận nv");
							
						}
					}
					
					if(xuly.equals("check2"))
					{
						System.out.println("check2");
						HDBH hdbh2=hdDao.getHDBH(maHD);
						hdbh2.setTrangThai("3");
						if(hdDao.updateTrangThai(hdbh2))
						{
							type = "check2_1";
							error="Update trang thái thành công";
						}
						else
						{
							type = "check2_0";
							error="Thất bại";
						}
					}
						
					else
						error="Thất bại";
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

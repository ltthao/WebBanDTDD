package Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Dao.NhanVienDao;
import Model.NhanVien;

@WebFilter("/*")
public class AuthFilter implements Filter {
    private List<String> whiteURLs;

    public void init(FilterConfig filterConfig) throws ServletException {
        // Hard code for white list URLs
        whiteURLs = new ArrayList<String>();
        whiteURLs.add("/WebDT/7NhanVienPage.jsp");
        whiteURLs.add("/WebDT/8nhanvien_CTHD.jsp");
        whiteURLs.add("/WebDT/10QuanLy_CTPN.jsp");
        whiteURLs.add("/WebDT/11Admin.jsp");
        whiteURLs.add("/WebDT/9QuanLyPage.jsp");
        whiteURLs.add("/WebDT/9QuanLyPage1.jsp");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getRequestURI().substring(request.getContextPath().length());
        if (checkWhiteURL(path)) {
        	HttpSession session = request.getSession();
            String userInfo = (String) session.getAttribute("user");
            if (userInfo != null) {
            {
            	boolean isAllow = true;
            	NhanVienDao nvDao = new NhanVienDao();
            	NhanVien nv = nvDao.getNhanVienByTaiKhoan(userInfo);
            	
            	if(nv.getMaLoaiNV().equals("1")){   // Nhan vien
            		if(!path.contains("/WebDT/7NhanVienPage.jsp") || !path.contains("/WebDT/8nhanvien_CTHD.jsp")){
            			isAllow = false;
            		}else{
            			isAllow = true;
            		}
            	}
            	else if(nv.getMaLoaiNV().equals("2"))  { // Quan ly
            		if(!path.contains("/WebDT/9QuanLyPage.jsp") || 
            				!path.contains("/WebDT/9QuanLyPage1.jsp") || !path.contains("/WebDT/10QuanLy_CTPN.jsp")){
            			isAllow = false;
            		}else{
            			isAllow = true;
            		}
            	}else if(nv.getMaLoaiNV().equals("3")) { // Admin
            		if(!path.contains("/WebDT/11Admin.jsp")){
            			isAllow = false;
            		}else{
            			isAllow = true;
            		}
            	}else{
            		RequestDispatcher rd = request.getRequestDispatcher("/WebDT/LoginRequired.jsp");
                    rd.forward(req, resp);
            	}
            	
            	if(isAllow)
            		chain.doFilter(req, resp);
            	else
            	{
            		String url = "";
            		switch(nv.getMaLoaiNV()){
            		case "1": url = "/WebDT/7NhanVienPage.jsp"; break;
            		case "2": url = "/WebDT/9QuanLyPage.jsp"; break;
            		case "3": url = "/WebDT/11Admin.jsp"; break;
            		}
            		
            		path = url;
            		RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(req, resp);
            	}
            }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/WebDT/LoginRequired.jsp");
                rd.forward(req, resp);
            }
            
        } else {
        	chain.doFilter(req, resp);
        }
    }

    public void destroy() {
    }

    private boolean checkWhiteURL(String path) {
        boolean isWhiteURL = false;
        for (String whiteURL : whiteURLs) {
            isWhiteURL = "/".equals(path) || path.contains(whiteURL) ? true : false;
            if (isWhiteURL)
                break;
        }
        return isWhiteURL;
    }
}


package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connect.DBConnect;
import Model.CT_PN;
import Model.PhieuNhap;
import Model.SanPham;
import Model.SuKien;

public class PhieuNhapDao {
	public ArrayList<PhieuNhap> getListPhieuNhap() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM PhieuNhap inner join NhanVien on PhieuNhap.MaNV=NhanVien.MaNV"+
        " order by cast(MaPN as decimal)";
        
        ArrayList<PhieuNhap> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	PhieuNhap pn = new PhieuNhap();
            	pn.setMaPN(rs.getString("MaPN"));
            	pn.setTenNV(rs.getString("NhanVien.TenNV"));
            	pn.setMaNV(rs.getString("NhanVien.MaNV"));
            	pn.setNgayNhap(rs.getString("NgayNhap"));
            	list.add(pn);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public boolean deletePNByMaNV(String maNV) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM PhieuNhap WHERE MaNV = ?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,maNV );
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	
	public ArrayList<CT_PN> getListCTPN_ByPN(String MaPN) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM CT_PN where MaPN='"+MaPN+"'";
        
        ArrayList<CT_PN> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	CT_PN ctpn = new CT_PN();
            	ctpn.setMaSP(MaPN);
            	ctpn.setMaSP(rs.getString("MaSP"));
            	ctpn.setSLNhap(rs.getFloat("SLNhap"));
            	ctpn.setGiaNhap(rs.getFloat("GiaNhap"));
            	list.add(ctpn);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public boolean deletePN(String MaPN) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM PhieuNhap WHERE MaPN = ?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,MaPN );
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	
	public boolean insertPN(String MaNV) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		ArrayList<PhieuNhap> list = new ArrayList<PhieuNhap>();
		PhieuNhapDao pnDao = new PhieuNhapDao();
		list = pnDao.getListPhieuNhap();
		int temp=0;
		int kq = 1;
		while(kq<=list.size())
		{
			if(kq != Integer.parseInt(list.get(kq-1).getMaPN()))
				break;
			kq++;
		}
		String sql = "insert into PhieuNhap values (?,?,?)";
		try {
			  PreparedStatement ps = (PreparedStatement) cons.prepareCall(sql);
		      ps.setString(1,Integer.toString(kq));
		      ps.setString(2,MaNV);
		      ps.setDate(3,date);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(SuKienDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	 public static void main(String[] args) throws SQLException, ParseException {
		 PhieuNhapDao pnDAO = new PhieuNhapDao();
//		 for(CT_PN pn:pnDAO.getListCTPN_ByPN("2"))
//		 {
//			 System.out.println(pn.getMaSP()+"____"+pn.getSLNhap());
//		 }
		 if(pnDAO.insertPN("5"))
			 System.out.println("thanh cong");
	    }

}

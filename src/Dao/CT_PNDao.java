package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connect.DBConnect;
import Model.CT_PN;
import Model.NhanVien;
import Model.SanPham;

public class CT_PNDao {
	public ArrayList<CT_PN> getListCT_PN() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM CT_PN";
        
        ArrayList<CT_PN> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	CT_PN ctpn = new CT_PN();
            	ctpn.setMaPN(rs.getString("MaPN"));
            	ctpn.setMaSP(rs.getString("MaSP"));
            	ctpn.setSLNhap(rs.getFloat("SLNhap"));
            	ctpn.setGiaNhap(rs.getFloat("GiaNhap"));
            	ctpn.setThanhTien(rs.getFloat("ThanhTien"));
            	list.add(ctpn);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<CT_PN> getListCT_PN_LoaiSP(String tenLSP) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT CT_PN.MaSP,TenSP,SLNhap,GiaNhap,(GiaNhap*SLNhap) as ThanhTien FROM  CT_PN,LoaiSP,SanPham where "+
       "SanPham.MaLSP=LoaiSP.MaLSP and SanPham.MaSP=CT_PN.MaSP and TenLoaiSP='"+tenLSP+"'";
        
        ArrayList<CT_PN> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	CT_PN ctpn = new CT_PN();
            	ctpn.setMaPN(rs.getString("MaPN"));
            	ctpn.setMaSP(rs.getString("CT_PN.MaSP"));
            	ctpn.setTenSP(rs.getString("TenSP"));
            	ctpn.setSLNhap(rs.getFloat("SLNhap"));
            	ctpn.setGiaNhap(rs.getFloat("GiaNhap"));
            	ctpn.setThanhTien(rs.getFloat("ThanhTien"));
            	list.add(ctpn);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<CT_PN> getListCT_PN_NhaCC(String tenNCC) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT CT_PN.MaSP,TenSP,SLNhap,GiaNhap,(GiaNhap*SLNhap) as ThanhTien FROM   CT_PN,NhaCC,SanPham where "+
       "SanPham.MaNCC=NhaCC.MaNCC and SanPham.MaSP=CT_PN.MaSP and TenNhaCC='"+tenNCC+"'";
        
        ArrayList<CT_PN> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	CT_PN ctpn = new CT_PN();
            	ctpn.setMaPN(rs.getString("MaPN"));
            	ctpn.setMaSP(rs.getString("CT_PN.MaSP"));
            	ctpn.setTenSP(rs.getString("TenSP"));
            	ctpn.setSLNhap(rs.getFloat("SLNhap"));
            	ctpn.setGiaNhap(rs.getFloat("GiaNhap"));
            	ctpn.setThanhTien(rs.getFloat("ThanhTien"));
            	list.add(ctpn);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<CT_PN> getListCT_PN_HangSX(String hangSX) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT CT_PN.MaSP,TenSP,SLNhap,GiaNhap,(GiaNhap*SLNhap) as ThanhTien FROM  CT_PN,HangSX,SanPham where "+
       "SanPham.MaHSX=HangSX.MaHSX and SanPham.MaSP=CT_PN.MaSP and TenHangSX='"+hangSX+"'";
        
        ArrayList<CT_PN> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	CT_PN ctpn = new CT_PN();
            	ctpn.setMaPN(rs.getString("MaPN"));
            	ctpn.setMaSP(rs.getString("CT_PN.MaSP"));
            	ctpn.setTenSP(rs.getString("TenSP"));
            	ctpn.setSLNhap(rs.getFloat("SLNhap"));
            	ctpn.setGiaNhap(rs.getFloat("GiaNhap"));
            	ctpn.setThanhTien(rs.getFloat("ThanhTien"));
            	list.add(ctpn);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<CT_PN> getListCTPN_ByMaPN(String MaPN) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM CT_PN inner join SanPham on CT_PN.MaSP=SanPham.MaSP "
        		+"where CT_PN.MaPN = '"+MaPN+"'";
        
        ArrayList<CT_PN> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	CT_PN ctpn = new CT_PN();
            	ctpn.setMaPN(rs.getString("MaPN"));
            	ctpn.setMaSP(rs.getString("SanPham.MaSP"));
            	ctpn.setSLNhap(rs.getFloat("SLNhap"));
            	ctpn.setGiaNhap(rs.getFloat("GiaNhap"));
            	ctpn.setTenSP(rs.getString("SanPham.TenSP"));
            	ctpn.setGiaBan(rs.getFloat("SanPham.GiaBan"));
            	list.add(ctpn);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public boolean deleteCTPN(String MaPN, String MaSP) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "DELETE FROM CT_PN WHERE MaPN = ? and MaSP=?";
		try {
			  PreparedStatement ps = (PreparedStatement) cons.prepareCall(sql);
		      ps.setString(1,MaPN);
		      ps.setString(2,MaSP);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(SuKienDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public boolean updateCTPN(CT_PN ctpn, String MaSP_new) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update CT_PN set MaSP= ?, SLNhap = ?, GiaNhap =? WHERE MaPN = ? and MaSP=?";
		try {
			  PreparedStatement ps = (PreparedStatement) cons.prepareCall(sql);
		      ps.setString(1,MaSP_new);
		      ps.setFloat(2,ctpn.getSLNhap());
		      ps.setFloat(3,ctpn.getGiaNhap());
		      ps.setString(4,ctpn.getMaPN());
		      ps.setString(5,ctpn.getMaSP());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(CT_PNDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public boolean insertCTPN(CT_PN ctpn) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "insert into CT_PN values (?,?,?,?)";
		try {
			  PreparedStatement ps = (PreparedStatement) cons.prepareCall(sql);
		      ps.setString(1,ctpn.getMaPN());
		      ps.setString(2,ctpn.getMaSP());
		      ps.setFloat(3,ctpn.getSLNhap());
		      ps.setFloat(4,ctpn.getGiaNhap());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(CT_PNDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public CT_PN getCTPN(String MaPN, String MaSP) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "select * from CT_PN inner join SanPham on CT_PN.MaSP=SanPham.MaSP "+
        " where MaPN='"+MaPN+"' and CT_PN.MaSP='"+MaSP+"'";
        CT_PN ctpn = new CT_PN();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ctpn.setMaPN(MaPN);
            	ctpn.setMaSP(MaSP);
            	ctpn.setSLNhap(rs.getFloat("SLNhap"));
            	ctpn.setGiaNhap(rs.getFloat("CT_PN.GiaNhap"));
            	ctpn.setGiaBan(rs.getFloat("SanPham.GiaBan"));
            	ctpn.setTenSP(rs.getString("SanPham.TenSP"));
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ctpn;
    }
	
	public   ArrayList<CT_PN> getListPhieuNhap_TKe(String TKTheo,String ngayLap1, String ngayLap2,String TTLoc) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT CT_PN.MaSP,TenSP,SLNhap,CT_PN.GiaNhap "
        		+"FROM  CT_PN,HangSX,SanPham,NhaCC,LoaiSP,PhieuNhap "+
        		" where SanPham.MaHSX=HangSX.MaHSX and SanPham.MaSP=CT_PN.MaSP and SanPham.MaNCC=NhaCC.MaNCC "+
                " and PhieuNhap.MaPN=CT_PN.MaPN and SanPham.MaLSP=LoaiSP.MaLSP "+
        		"  and NgayNhap>='"+ngayLap1+"' and NgayNhap<='"+ngayLap2+"' " +
        		" and SanPham.MaSP=CT_PN.MaSP and "+TKTheo+" Like '%"+TTLoc+"%' ";
   
        ArrayList<CT_PN> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	CT_PN pn = new CT_PN();
            	
            	pn.setMaSP(rs.getString("CT_PN.MaSP"));
            	pn.setTenSP(rs.getString("TenSP"));
            	pn.setSLNhap(rs.getFloat("SLNhap"));
            	pn.setGiaNhap(rs.getFloat("CT_PN.GiaNhap"));
            	list.add(pn);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	
	 public static void main(String[] args) throws SQLException, ParseException  {
		 CT_PNDao nvDAO = new CT_PNDao();
//		 for(CT_PN nv:nvDAO.getListCTPN_ByMaPN("1"))
//		 {
//			 System.out.println(nv.getTenSP()+"____"+Math.round(nv.getGiaBan()));
//		 }
		 CT_PN ctpn = new CT_PN();
		 System.out.println(ctpn.getTenSP()+"___"+ctpn.getGiaBan()+"___"+ctpn.getGiaNhap());
		 ctpn.setSLNhap(25);
		 ctpn.setGiaNhap(100);
		 ctpn.setMaSP("2");
		 ctpn.setMaPN("1");
		 if(nvDAO.insertCTPN(ctpn))
			 System.out.println("thanh cong");
	    }

}

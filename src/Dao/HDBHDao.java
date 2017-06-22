package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

import Connect.DBConnect;
import Model.HDBH;
import Model.KhachHang;

public class HDBHDao {
	public ArrayList<HDBH> getListHDBH() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM HDBH left outer join NhanVien on HDBH.MaNV=NhanVien.MaNV,KhachHang ,SanPham "+
        		"where HDBH.MaKH=KhachHang.MaKH and HDBH.MaSP=SanPham.MaSP "
        		+ " order by cast(HDBH.MaHD as decimal) ";
        
        ArrayList<HDBH> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	HDBH hd = new HDBH();
            	hd.setMaHD(rs.getString("MaHD"));
            	hd.setMaKH(rs.getString("KhachHang.MaKH"));
            	hd.setMaNV(rs.getString("NhanVien.MaNV"));
            	hd.setMaSP(rs.getString("SanPham.MaSP"));
            	hd.setSLBan(rs.getDouble("SLBan"));
            	hd.setGiaBan(rs.getDouble("GiaBan"));
            	hd.setNgayLap(rs.getString("NgayLap"));
            	hd.setTrangThai(rs.getString("TrangThai"));
            	hd.setTenSP(rs.getString("TenSP"));
            	hd.setTenKH(rs.getString("TenKH"));
            	hd.setTenNV(rs.getString("TenNV"));
            	
            	list.add(hd);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	public ArrayList<HDBH> getListHDBH_TheoTrangThai(String TrangThai) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM HDBH left outer join NhanVien on HDBH.MaNV=NhanVien.MaNV,KhachHang,SanPham "+
        		"where HDBH.MaKH=KhachHang.MaKH and HDBH.MaSP=SanPham.MaSP "
        		+"and TrangThai='"+TrangThai+"' order by cast(HDBH.MaHD as decimal)";
        ArrayList<HDBH> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	HDBH hd = new HDBH();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getDouble("GiaBan"));
            	hd.setMaHD(rs.getString("MaHD"));
            	hd.setMaKH(rs.getString("KhachHang.MaKH"));
            	hd.setMaNV(rs.getString("NhanVien.MaNV"));
            	hd.setMaSP(rs.getString("SanPham.MaSP"));
            	hd.setSLBan(rs.getDouble("SLBan"));
            	hd.setGiaBanFormat(GiaBanFormat);
            	hd.setGiaBan(rs.getDouble("GiaBan"));
            	hd.setNgayLap(rs.getString("NgayLap"));
            	hd.setTenSP(rs.getString("TenSP"));
            	hd.setTenKH(rs.getString("TenKH"));
            	hd.setTenNV(rs.getString("TenNV"));
            	
            	list.add(hd);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public HDBH getHDBH(String maHD) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM HDBH left outer join NhanVien on HDBH.MaNV=NhanVien.MaNV,KhachHang,SanPham "+
        		"where HDBH.MaKH=KhachHang.MaKH and HDBH.MaSP=SanPham.MaSP  "
        		+"and MaHD='"+maHD+"'";
        HDBH hd = new HDBH();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getDouble("GiaBan"));
            	hd.setMaHD(rs.getString("MaHD"));
            	hd.setMaKH(rs.getString("KhachHang.MaKH"));
            	hd.setMaNV(rs.getString("NhanVien.MaNV"));
            	hd.setMaSP(rs.getString("SanPham.MaSP"));
            	hd.setSLBan(rs.getDouble("SLBan"));
            	hd.setGiaBanFormat(GiaBanFormat);
            	hd.setGiaBan(rs.getDouble("GiaBan"));
            	hd.setNgayLap(rs.getString("NgayLap"));
            	hd.setTenSP(rs.getString("TenSP"));
            	hd.setTenKH(rs.getString("TenKH"));
            	hd.setTenNV(rs.getString("TenNV"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hd;
    }
	public boolean deleteHDBH(String maHD) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM HDBH WHERE MaHD = ?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,maHD );
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	public boolean deleteHDBHByKH(String maKH) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM HDBH WHERE MaKH = ?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,maKH );
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	public boolean deleteHDBHByNV(String maNV) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM HDBH WHERE MaNV = ?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,maNV );
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	public boolean updateTrangThai(HDBH hd) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update HDBH set TrangThai=? where MaHD=?";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,hd.getTrangThai());
			ps.setString(2, hd.getMaHD());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(HDBHDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public boolean updateNhanVien(HDBH hd) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update HDBH set MaNV=? where MaHD=?";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,hd.getMaNV());
			ps.setString(2, hd.getMaHD());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(HDBHDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public boolean insertHDBH(HDBH hd) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		ArrayList<HDBH> list = new ArrayList<HDBH>();
		HDBHDao hdDao = new HDBHDao();
		list = hdDao.getListHDBH();
		int temp=0;
		int kq = 1;
		while(kq<=list.size())
		{
			if(kq != Integer.parseInt(list.get(kq-1).getMaHD()))
				break;
			kq++;
		}
		String sql = "insert into HDBH values(?,?,?,?,?,?,?,?)";
		try {
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1, Integer.toString(kq));
			ps.setString(2, hd.getMaKH());
			ps.setString(3, hd.getMaNV());
			ps.setString(4, hd.getMaSP());
			ps.setDouble(5, hd.getSLBan());
			ps.setDouble(6, hd.getGiaBan());
			ps.setDate(7, date);
			ps.setString(8, hd.getTrangThai());
			
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(KhachHangDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}

	public ArrayList<HDBH> getListHDBH_HangSX(String TKTheo,String ngayLap1, String ngayLap2,String TTLoc) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT HDBH.MaSP,TenSP,SLBan,HDBH.GiaBan "
        		+"FROM  HDBH,HangSX,SanPham,NhaCC,LoaiSP "+
        		" where SanPham.MaHSX=HangSX.MaHSX and SanPham.MaSP=HDBH.MaSP and SanPham.MaNCC=NhaCC.MaNCC "+
                " and SanPham.MaLSP=LoaiSP.MaLSP "+
        		" and TrangThai='3' and NgayLap>='"+ngayLap1+"' and NgayLap<='"+ngayLap2+"' " +
        		" and SanPham.MaSP=HDBH.MaSP and "+TKTheo+" Like '%"+TTLoc+"%' ";
        
        ArrayList<HDBH> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	HDBH hd = new HDBH();
            	
            	hd.setMaSP(rs.getString("HDBH.MaSP"));
            	hd.setTenSP(rs.getString("TenSP"));
            	hd.setSLBan(rs.getDouble("SLBan"));
            	hd.setGiaBan(rs.getDouble("HDBH.GiaBan"));
            	list.add(hd);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public static void main(String[] args) throws ParseException{
		HDBHDao a=new HDBHDao();		

		HDBH hd = new HDBH();
		HDBH hd2=a.getHDBH("7");
			System.out.println(hd2.getMaHD());
			

//		hd.setMaKH("3");
//		hd.setMaSP("1");
//		hd.setSLBan(2);
//		hd.setGiaBan(27000000);
//		hd.setTrangThai("1");
//		
//		if(a.insertHDBH(hd))
//			System.out.println("thanh cong");
		
//		ArrayList<HDBH> list = new ArrayList<HDBH>();
//		HDBHDao hdDao = new HDBHDao();
//		list = hdDao.getListHDBH();
//		int temp=0;
//		int kq = 1;
//		while(kq<=list.size())
//		{
//			System.out.println(list.get(kq-1).getMaHD());
//			if(kq != Integer.parseInt(list.get(kq-1).getMaHD()))
//				break;
//			kq++;
//		}
//		System.out.println(list.size());
	}
}

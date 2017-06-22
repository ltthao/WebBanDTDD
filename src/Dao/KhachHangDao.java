package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

import Connect.DBConnect;
import Model.HDBH;
import Model.KhachHang;
import Model.NhanVien;

public class KhachHangDao {
	public KhachHang getKhachHang(String maKH) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM KhachHang where MaKH='"+maKH+"'";
        KhachHang kh = new KhachHang();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
            	kh.setMaKH(rs.getString("MaKH"));
            	kh.setTenKH(rs.getString("TenKH"));
            	kh.setSDT(rs.getString("SDT"));
            	kh.setDiaChi(rs.getString("DiaChi"));
            	kh.setEmail(rs.getString("Email"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kh;
    }
	public ArrayList<KhachHang> getListKhachHang() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM KhachHang order by cast(MaKH as decimal)";
        
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	KhachHang kh = new KhachHang();
            	kh.setMaKH(rs.getString("MaKH"));
            	kh.setTenKH(rs.getString("TenKH"));
            	kh.setSDT(rs.getString("SDT"));
            	kh.setDiaChi(rs.getString("DiaChi"));
            	kh.setEmail(rs.getString("Email"));
            	list.add(kh);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public boolean deleteKhachHang(String maKH) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,maKH );
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	public boolean updateKhachHang(KhachHang kh) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update KhachHang set TenKH=?, SDT=?, DiaChi=?, Email=? where MaKH=?";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,kh.getTenKH());
			ps.setString(2, kh.getSDT());
			ps.setString(3,kh.getDiaChi());
			ps.setString(4, kh.getEmail());
			ps.setString(5, kh.getMaKH());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(KhachHangDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	public boolean insertKhachHang(KhachHang kh) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		KhachHangDao khDao = new KhachHangDao();
		list = khDao.getListKhachHang();
		int temp=0;
		int kq = 1;
		while(kq<=list.size())
		{
			if(kq != Integer.parseInt(list.get(kq-1).getMaKH()))
				break;
			kq++;
		}
		String sql = "insert into KhachHang values(?,?,?,?,?)";
		try {

			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1, Integer.toString(kq));
			ps.setString(2,kh.getTenKH());
			ps.setString(3, kh.getSDT());
			ps.setString(4,kh.getDiaChi());
			ps.setString(5, kh.getEmail());
			
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(KhachHangDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	public KhachHang getKH_DaTT(KhachHang kh) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM KhachHang where TenKH='"+kh.getTenKH()+"' and SDT='"+
        kh.getSDT()+"' and DiaChi='"+kh.getDiaChi()+"'";
        KhachHang kh2 = new KhachHang();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
            	kh2.setMaKH(rs.getString("MaKH"));
            	kh2.setTenKH(rs.getString("TenKH"));
            	kh2.setSDT(rs.getString("SDT"));
            	kh2.setDiaChi(rs.getString("DiaChi"));
            	kh2.setEmail(rs.getString("Email"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kh2;
    }
	
	public static void main(String[] args) throws ParseException{
		KhachHangDao khDAO=new KhachHangDao();		
		KhachHang kh = new KhachHang();
		KhachHang kh2 = new KhachHang();
		kh.setTenKH("Lê Thị ");
		kh.setDiaChi("Bình Dương");
		kh.setEmail("lxtriet@gmail.com");
		kh.setSDT("0962385344");
		
//		if(khDAO.insertKhachHang(kh))
//			System.out.println("thanh cong");
		kh2 = khDAO.getKH_DaTT(kh);
		if(kh2.getMaKH() != null)
			System.out.println("da ton tai");
		else
			System.out.println("chua ton tai");
	}

}

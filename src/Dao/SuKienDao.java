package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connect.DBConnect;
import Model.SanPham;
import Model.SuKien;

public class SuKienDao {
	public ArrayList<SuKien> getListSuKien() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM SuKien inner join LoaiSP on SuKien.MaLSP=LoaiSP.MaLSP"+
        " order by cast(MaSK as decimal)";
        
        ArrayList<SuKien> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SuKien sk = new SuKien();
            	sk.setMaSK(rs.getString("MaSK"));
            	sk.setTenSK(rs.getString("TenSK"));
            	sk.setMoTaSK(rs.getString("MoTaSK"));
            	sk.setNgayBD(rs.getString("NgayBD"));
            	sk.setNgayKT(rs.getString("NgayKT"));
            	sk.setMaNV(rs.getString("MaNV"));
            	sk.setMaLSP(rs.getString("LoaiSP.MaLSP"));
            	sk.setTenLSP(rs.getString("LoaiSP.TenLoaiSP"));
            	sk.setKhuyenMai(rs.getFloat("KhuyenMai"));
            	
            	list.add(sk);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public SuKien getSuKien() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "select *"
        		+" from loaisp inner join sukien on loaisp.MaLSP=sukien.MaLSP"+
        		" where sukien.NgayBD <= current_date() and sukien.NgayKT> current_date()";
        
        SuKien sk= new SuKien();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {        
            	sk.setMaSK(rs.getString("sukien.MaSK"));
            	sk.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sk.setMoTaSK(rs.getString("sukien.MoTaSK"));
            	sk.setNgayBD(rs.getString("NgayBD"));
            	sk.setNgayKT(rs.getString("NgayKT"));
            	sk.setKhuyenMai(rs.getFloat("KhuyenMai"));
            	sk.setTenSK(rs.getString("TenSK"));
            	sk.setTenLSP(rs.getString("TenLoaiSP"));
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sk;
    }
	
	public SuKien getSuKien_ByMaSK(String MaSK) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "select *"
        		+" from loaisp inner join sukien on loaisp.MaLSP=sukien.MaLSP"+
        		" where MaSK='"+MaSK+"'";
        
        SuKien sk= new SuKien();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {        
            	sk.setMaSK(rs.getString("sukien.MaSK"));
            	sk.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sk.setMoTaSK(rs.getString("sukien.MoTaSK"));
            	sk.setNgayBD(rs.getString("NgayBD"));
            	sk.setNgayKT(rs.getString("NgayKT"));
            	sk.setKhuyenMai(rs.getFloat("KhuyenMai"));
            	sk.setTenSK(rs.getString("TenSK"));
            	sk.setTenLSP(rs.getString("TenLoaiSP"));
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sk;
    }
	
	
	public String FormatNumber(Float number){
		DecimalFormat myFormatter = new DecimalFormat("###,###");
		return myFormatter.format(number);
	}
	public String FormatNumber(int number){
		DecimalFormat myFormatter = new DecimalFormat("###,###");
		return myFormatter.format(number);
	}
	public String FormatNumber(double number){
		DecimalFormat myFormatter = new DecimalFormat("###,###");
		return myFormatter.format(number);
	}
	
	public boolean deleteSuKien(String MaSK) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "DELETE FROM SuKien WHERE MaSK = ?";
		try {
			  PreparedStatement ps = (PreparedStatement) cons.prepareCall(sql);
		      ps.setString(1,MaSK);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(SuKienDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public boolean updateSuKien(SuKien sk) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );  
		java.util.Date myDate = format.parse(sk.getNgayBD());
		java.sql.Date ngbd = new java.sql.Date( myDate.getTime() );
		java.util.Date myDate2 = format.parse(sk.getNgayKT());
		java.sql.Date ngkt = new java.sql.Date( myDate2.getTime() );
		String sql = "update SuKien set TenSK=?, NgayBD=?, NgayKT=?, MoTaSK=?,"+
		" MaLSP=?,KhuyenMai=? WHERE MaSK = ?";
		try {
			  PreparedStatement ps = (PreparedStatement) cons.prepareCall(sql);
		      ps.setString(1,sk.getTenSK());
		      ps.setDate(2,ngbd);
		      ps.setDate(3,ngkt);
		      ps.setString(4,sk.getMoTaSK());
		      ps.setString(5,sk.getMaLSP());
		      ps.setFloat(6,sk.getKhuyenMai());
		      ps.setString(7,sk.getMaSK());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(SuKienDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public boolean insertSuKien(SuKien sk) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );  
		java.util.Date myDate = format.parse(sk.getNgayBD());
		java.sql.Date ngbd = new java.sql.Date( myDate.getTime() );
		java.util.Date myDate2 = format.parse(sk.getNgayKT());
		java.sql.Date ngkt = new java.sql.Date( myDate2.getTime() );
		ArrayList<SuKien> list = new ArrayList<SuKien>();
		SuKienDao skDao = new SuKienDao();
		list = skDao.getListSuKien();
		int temp=0;
		int kq = 1;
		while(kq<=list.size())
		{
			if(kq != Integer.parseInt(list.get(kq-1).getMaSK()))
				break;
			kq++;
		}
		String sql = "insert into SuKien values (?,?,?,?,?,?,?,?)";
		try {
			  PreparedStatement ps = (PreparedStatement) cons.prepareCall(sql);
		      ps.setString(1,Integer.toString(kq));
		      ps.setString(2,sk.getTenSK());
		      ps.setString(3,sk.getMoTaSK());
		      ps.setDate(4,ngbd);
		      ps.setDate(5,ngkt);
		      ps.setString(6,sk.getMaNV());
		      ps.setString(7,sk.getMaLSP());
		      ps.setFloat(8,sk.getKhuyenMai());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(SuKienDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	 public static void main(String[] args) throws SQLException, ParseException {
		SuKien sk = new SuKien();
		SuKienDao skDAO = new SuKienDao();
//		sk = skDAO.getSuKien_ByMaSK("1");
//		sk.setTenSK("Khuyến mãi 10% cho các sản phẩm điện thoại");
//		if(skDAO.updateSuKien(sk))
//			System.out.println("Thanh cong");
		sk.setTenSK("Tháng 2018");
		sk.setNgayBD("2016-12-5");
		sk.setNgayKT("2018-12-1");
		if(skDAO.getSuKien() != null)
		{
			if(skDAO.insertSuKien(sk))
				System.out.println("thanh cong");
		}
		else
			System.out.println("Đang có sự kiện khác trong thời gian này");
			
	 }

}

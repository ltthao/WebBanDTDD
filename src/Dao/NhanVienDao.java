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
import Model.KhachHang;
import Model.NhanVien;

public class NhanVienDao {
	public ArrayList<NhanVien> getListNhanVien() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM NhanVien inner join LoaiNV on NhanVien.MaLoaiNV=LoaiNV.MaLoaiNV";
        
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	NhanVien nv = new NhanVien();
            	nv.setMaNV(rs.getString("MaNV"));
            	nv.setTenNV(rs.getString("TenNV"));
            	nv.setGioiTinh(rs.getString("GioiTinh"));
            	nv.setNgSinh(rs.getString("NgSinh"));
            	nv.setDiaChi(rs.getString("DiaChi"));
            	nv.setSDT(rs.getString("SDT"));
            	nv.setLuong(rs.getFloat("Luong"));
            	nv.setTaiKhoan(rs.getString("TaiKhoan"));
            	nv.setMatKhau(rs.getString("MatKhau"));
            	nv.setTenLoaiNV(rs.getString("TenLoaiNV"));
            	nv.setMaLoaiNV(rs.getString("MaLoaiNV"));
            	list.add(nv);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public NhanVien getNhanVien(String maNV) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM NhanVien inner join LoaiNV on NhanVien.MaLoaiNV=LoaiNV.MaLoaiNV and MaNV='"+maNV+"'";
        
        NhanVien nv= new NhanVien();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {        
            	nv.setMaNV(rs.getString("MaNV"));
            	nv.setTenNV(rs.getString("TenNV"));
            	nv.setGioiTinh(rs.getString("GioiTinh"));
            	nv.setNgSinh(rs.getString("NgSinh"));
            	nv.setDiaChi(rs.getString("DiaChi"));
            	nv.setSDT(rs.getString("SDT"));
            	nv.setLuong(rs.getFloat("Luong"));
            	nv.setTaiKhoan(rs.getString("TaiKhoan"));
            	nv.setMatKhau(rs.getString("MatKhau"));
            	nv.setMaLoaiNV(rs.getString("MaLoaiNV"));
            	nv.setTenLoaiNV(rs.getString("TenLoaiNV"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }
	
	public NhanVien getNhanVienByTaiKhoan(String TaiKhoan) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM NhanVien inner join LoaiNV on NhanVien.MaLoaiNV=LoaiNV.MaLoaiNV " +
        "where TaiKhoan='"+TaiKhoan+"'";
        
        NhanVien nv= new NhanVien();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {        
            	nv.setMaNV(rs.getString("MaNV"));
            	nv.setTenNV(rs.getString("TenNV"));
            	nv.setGioiTinh(rs.getString("GioiTinh"));
            	nv.setNgSinh(rs.getString("NgSinh"));
            	nv.setDiaChi(rs.getString("DiaChi"));
            	nv.setSDT(rs.getString("SDT"));
            	nv.setLuong(rs.getFloat("Luong"));
            	nv.setMaLoaiNV(rs.getString("NhanVien.MaLoaiNV"));
            	nv.setTenLoaiNV(rs.getString("LoaiNV.TenLoaiNV"));
            	nv.setTaiKhoan(rs.getString("TaiKhoan"));
            	nv.setMatKhau(rs.getString("MatKhau"));
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }
	
	public NhanVien getNhanVienByID(String manv) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM NhanVien inner join LoaiNV on NhanVien.MaLoaiNV=LoaiNV.MaLoaiNV " +
        "where MaNV='"+manv+"'";
        
        NhanVien nv= new NhanVien();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {        
            	nv.setMaNV(rs.getString("MaNV"));
            	nv.setTenNV(rs.getString("TenNV"));
            	nv.setGioiTinh(rs.getString("GioiTinh"));
            	nv.setNgSinh(rs.getString("NgSinh"));
            	nv.setDiaChi(rs.getString("DiaChi"));
            	nv.setSDT(rs.getString("SDT"));
            	nv.setLuong(rs.getFloat("Luong"));
            	nv.setMaLoaiNV(rs.getString("NhanVien.MaLoaiNV"));
            	nv.setTenLoaiNV(rs.getString("LoaiNV.TenLoaiNV"));
            	nv.setTaiKhoan(rs.getString("TaiKhoan"));
            	nv.setMatKhau(rs.getString("MatKhau"));
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }
	
	public NhanVien login(String TaiKhoan,String password) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM NhanVien inner join LoaiNV on NhanVien.MaLoaiNV=LoaiNV.MaLoaiNV " +
        "where TaiKhoan=? and MatKhau=?";
        
        NhanVien nv= new NhanVien();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, TaiKhoan);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {        
            	nv.setMaNV(rs.getString("MaNV"));
            	nv.setTenNV(rs.getString("TenNV"));
            	nv.setGioiTinh(rs.getString("GioiTinh"));
            	nv.setNgSinh(rs.getString("NgSinh"));
            	nv.setDiaChi(rs.getString("DiaChi"));
            	nv.setSDT(rs.getString("SDT"));
            	nv.setLuong(rs.getFloat("Luong"));
            	nv.setMaLoaiNV(rs.getString("NhanVien.MaLoaiNV"));
            	nv.setTenLoaiNV(rs.getString("LoaiNV.TenLoaiNV"));
            	nv.setTaiKhoan(rs.getString("TaiKhoan"));
            	nv.setMatKhau(rs.getString("MatKhau"));
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }
	
	
	
	public NhanVien geNhanVienChuVu(String maNV) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM NhanVien,LoaiNV where NhanVien.MaLoaiNV=LoaiNV.MaLoaiNV and MaNV=?";
        
        NhanVien nv = new NhanVien();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	nv.setMaNV(rs.getString("MaNV"));
            	nv.setTenNV(rs.getString("TenNV"));
            	nv.setGioiTinh(rs.getString("GioiTinh"));
            	nv.setNgSinh(rs.getString("NgSinh"));
            	nv.setDiaChi(rs.getString("DiaChi"));
            	nv.setSDT(rs.getString("SDT"));
            	nv.setLuong(rs.getFloat("Luong"));
            	nv.setTenLoaiNV(rs.getString("TenLoaiNV"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }
	
	public boolean deleteNhanVien(String maNV) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,maNV );
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	public boolean updateNhanVien(NhanVien nv) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update NhanVien set TenNV=?, SDT=?, DiaChi=?, GioiTinh=?, NgSinh=?, Luong=?, "
				+ " MaLoaiNV=? where MaNV=?";
		try {
			SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" );  
			java.util.Date myDate = format.parse(nv.getNgSinh());
			java.sql.Date ngsinh = new java.sql.Date( myDate.getTime() );
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1, nv.getTenNV());
			ps.setString(2, nv.getSDT());
			ps.setString(3,nv.getDiaChi());
			ps.setString(4, nv.getGioiTinh());
			ps.setDate(5,ngsinh);
			ps.setFloat(6, nv.getLuong());
			ps.setString(7, nv.getMaLoaiNV());
			ps.setString(8,nv.getMaNV());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(NhanVienDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	public boolean updateTT(NhanVien nv) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update NhanVien set TenNV=?, SDT=?, DiaChi=?, NgSinh=?  "
				+ " where MaNV=?";
		try {
			SimpleDateFormat format = new SimpleDateFormat( "yyyy-dd-MM" );  
			java.util.Date myDate = format.parse(nv.getNgSinh());
			java.sql.Date ngsinh = new java.sql.Date( myDate.getTime() );
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1, nv.getTenNV());
			ps.setString(2, nv.getSDT());
			ps.setString(3,nv.getDiaChi());
			ps.setDate(4,ngsinh);
			ps.setString(5,nv.getMaNV());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(NhanVienDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	public boolean DoiMatKhau(NhanVien nv) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update NhanVien set MatKhau=? where MaNV=?";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1, nv.getMatKhau());
			ps.setString(2, nv.getMaNV());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(NhanVienDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	public boolean insertNhanVien(NhanVien nv) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		NhanVienDao nvDao = new NhanVienDao();
		list = nvDao.getListNhanVien();
		int temp=0;
		int kq = 1;
		while(kq<=list.size())
		{
			if(kq != Integer.parseInt(list.get(kq-1).getMaNV()))
				break;
			kq++;
		}
		String sql = "insert into NhanVien values(?,?,?,?,?,?,?,?,?,?)";
		try {

			SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" );  
			java.util.Date myDate = format.parse(nv.getNgSinh());
			java.sql.Date ngsinh = new java.sql.Date( myDate.getTime() );
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1, Integer.toString(kq));
			ps.setString(2, nv.getTenNV());
			ps.setString(3, nv.getSDT());
			ps.setString(4,nv.getDiaChi());
			ps.setString(5, nv.getGioiTinh());
			ps.setFloat(6, nv.getLuong());
			ps.setDate(7,ngsinh);
			ps.setString(8,nv.getTaiKhoan());
			ps.setString(9,nv.getMatKhau());
			ps.setString(10, nv.getMaLoaiNV());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(NhanVienDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	public NhanVien getNV_DaTT(NhanVien nv) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM NhanVien inner join LoaiNV on NhanVien.MaLoaiNV=LoaiNV.MaLoaiNV "
        		+ " where TenNV='"+nv.getTenNV()+"' and SDT='"+nv.getSDT()+"' and NgSinh='"+nv.getNgSinh()+"'";
        NhanVien nv2 = new NhanVien();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
            	nv.setMaNV(rs.getString("MaNV"));
            	nv.setTenNV(rs.getString("TenNV"));
            	nv.setGioiTinh(rs.getString("GioiTinh"));
            	nv.setNgSinh(rs.getString("NgSinh"));
            	nv.setDiaChi(rs.getString("DiaChi"));
            	nv.setSDT(rs.getString("SDT"));
            	nv.setLuong(rs.getFloat("Luong"));
            	nv.setMaLoaiNV(rs.getString("NhanVien.MaLoaiNV"));
            	nv.setTenLoaiNV(rs.getString("LoaiNV.TenLoaiNV"));
            	nv.setTaiKhoan(rs.getString("TaiKhoan"));
            	nv.setMatKhau(rs.getString("MatKhau"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv2;
    }
	 public static void main(String[] args) throws SQLException {
		 NhanVienDao nvDAO = new NhanVienDao();
		 for(NhanVien nv:nvDAO.getListNhanVien())
		 {
			 System.out.println(nv.getMaLoaiNV()+"____"+nv.getTenLoaiNV());
		 }
	    }

}

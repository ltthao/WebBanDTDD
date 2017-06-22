package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.DBConnect;
import Model.CT_PN;
import Model.LoaiNV;
import Model.NhanVien;

public class LoaiNVDao {
	public ArrayList<LoaiNV> getListLoaiNV() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM LoaiNV";
        
        ArrayList<LoaiNV> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	LoaiNV lnv = new LoaiNV();
            	lnv.setMaLoaiNV(rs.getString("MaLoaiNV"));
            	lnv.setTenLoaiNV(rs.getString("TenLoaiNV"));
            	list.add(lnv);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<LoaiNV> getListLoaiNVChucVU() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT distinct TenLoaiNV FROM LoaiNV";
        
        ArrayList<LoaiNV> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	LoaiNV lnv = new LoaiNV();
            	lnv.setTenLoaiNV(rs.getString("TenLoaiNV"));
            	list.add(lnv);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public LoaiNV getLoaiNVByChucVu(String tenLoaiNV) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM LoaiNV where TenLoaiNV=?";
        
        LoaiNV nv = new LoaiNV();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, tenLoaiNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	nv.setMaLoaiNV(rs.getString("MaLoaiNV"));
            	nv.setTenLoaiNV(rs.getString("TenLoaiNV"));     	
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }
	 public static void main(String[] args) throws SQLException {
		 LoaiNVDao nvDAO = new LoaiNVDao();
		LoaiNV nv=nvDAO.getLoaiNVByChucVu("Nhân viên bán hàng");
		
		System.out.println(nv.getMaLoaiNV()+"____"+nv.getTenLoaiNV());

	    }


}

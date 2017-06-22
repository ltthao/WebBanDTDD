package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import Connect.DBConnect;
import Model.HangSX;
import Model.NhaCC;
import Model.SuKien;

public class HangSXDao {
	public ArrayList<HangSX> getListHangSX() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM HangSX";
        
        ArrayList<HangSX> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	HangSX hsx = new HangSX();
            	hsx.setMaHSX(rs.getString("MaHSX"));
            	hsx.setTenHangSX(rs.getString("TenHangSX"));
            	list.add(hsx);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public static void main(String[] args) throws SQLException, ParseException {
		SuKien sk = new SuKien();
		SuKienDao skDAO = new SuKienDao();
		NhaCCDao nccDao = new NhaCCDao();
		for(NhaCC ncc : nccDao.getListNhaCC())
			System.out.println(ncc.getTenNhaCC());
	 }


}

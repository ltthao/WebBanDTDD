package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.DBConnect;
import Model.CT_SK;

public class CT_SKDao {
	public ArrayList<CT_SK> getListCT_SK() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM SuKien";
        
        ArrayList<CT_SK> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	CT_SK ctsk = new CT_SK();
            	ctsk.setMaSK(rs.getString("MaSK"));
            	ctsk.setMaLSP(rs.getString("MaLSP"));
            	ctsk.setKhuyenMai(rs.getFloat("KhuyenMai"));
            	list.add(ctsk);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

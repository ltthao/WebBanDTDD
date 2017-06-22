package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.DBConnect;
import Model.LoaiSP;

public class LoaiSPDao {
	public ArrayList<LoaiSP> getListLoaiSP() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM LoaiSP order by cast(MaLSP as decimal)";
        
        ArrayList<LoaiSP> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	LoaiSP lsp = new LoaiSP();
            	lsp.setMaLSP(rs.getString("MaLSP"));
            	lsp.setTenLoaiSP(rs.getString("TenLoaiSP"));
            	list.add(lsp);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}

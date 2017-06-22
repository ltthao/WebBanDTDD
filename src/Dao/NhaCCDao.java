package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import Connect.DBConnect;
import Model.NhaCC;
import Model.SuKien;

public class NhaCCDao {
	public ArrayList<NhaCC> getListNhaCC() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM NhaCC order by cast(MaNCC as decimal) ";
        
        ArrayList<NhaCC> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	NhaCC ncc = new NhaCC();
            	ncc.setMaNCC(rs.getString("MaNCC"));
            	ncc.setTenNhaCC(rs.getString("TenNhaCC"));
            	ncc.setSDT(rs.getString("SDT"));
            	ncc.setDiaChi(rs.getString("DiaChi"));
            	list.add(ncc);
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

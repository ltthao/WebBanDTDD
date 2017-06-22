package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connect.DBConnect;
import Model.HDBH;
import Model.HangSX;
import Model.LoaiSP;
import Model.NhaCC;
import Model.SanPham;
import Model.SuKien;

public class SanPhamDao {
	
	public ArrayList<SanPham> getListSP()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC "+
        		" and sanpham.MaLSP=loaisp.MaLSP  order by cast(MaSP as decimal)";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<SanPham> getListSP_Tablet_Top8()  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='2'"
        		+" limit 8";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<SanPham> getListSP_Top9()  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='1'"
        		+" limit 9";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	// DienThoai DAO BEGIN
	public ArrayList<SanPham> getListSP_DienThoai()  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and "+
        		" sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='1' order by cast(MaSP as decimal)";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<SanPham> getListSP_DienThoai_TheoHangSX(String HangSX)  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='1'"
        		+ " and TenHangSX='"+HangSX+"'";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<SanPham> getListSP_DienThoai_TheoGia(float GiaNho, float GiaLon)  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='1'"
        		+ " and GiaBan >='"+GiaNho+"' and GiaBan<='"+GiaLon+"' order by GiaBan asc";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<SanPham> getListSP_DienThoai_SX(String LoaiSX)  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='1'"
        		+" order by GiaBan "+LoaiSX;
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	// END DienThoai DAO
	
	// Tablet DAO begin
	public ArrayList<SanPham> getListSP_Tablet()  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and "+
        		" sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='2' order by cast(MaSP as decimal)";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<SanPham> getListSP_Tablet_TheoGia(float GiaNho, float GiaLon)  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='2'"
        		+ " and GiaBan >='"+GiaNho+"' and GiaBan<='"+GiaLon+"' order by GiaBan asc";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<SanPham> getListSP_Tablet_TheoHangSX(String HangSX)  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='2'"
        		+ " and TenHangSX='"+HangSX+"'";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<SanPham> getListSP_Tablet_ThapdenCao()  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='2'"
        		+" order by GiaBan asc";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<SanPham> getListSP_Tablet_CaodenThap()  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='2'"
        		+" order by GiaBan desc";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	//end Tablet DAO
	
	// Phu kien DAO // begin
	public ArrayList<SanPham> getListSP_PhuKien()  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,nhacc,loaisp" +
        		" where sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and "+
        		" loaisp.MaLSP='3' order by cast(MaSP as decimal)";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<SanPham> getListSP_PhuKien_CaodenThap()  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,nhacc,loaisp" +
        		" where sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='3' "+
        		"order by sanpham.GiaBan desc";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<SanPham> getListSP_PhuKien_ThapdenCao()  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,nhacc,loaisp" +
        		" where sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='3' "+
        		"order by sanpham.GiaBan asc";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<SanPham> getListSP_PhuKien_LoaiPK(String TenLoai)  throws SQLException{

        Connection cons = DBConnect.getConnecttion();
        String sql ="select * from sanpham,nhacc,loaisp" +
        		" where sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP and loaisp.MaLSP='3' "+
        		"and TenSP like '%"+TenLoai+"%'";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));
            	list.add(sp);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	// end phu kien DAO
	
	public SanPham getSanPham(String maSP) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "select * from sanpham,hangsx,nhacc,loaisp" +
        		" where sanpham.MaHSX=hangsx.MaHSX and sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP"
        		+ " and sanpham.MaSP='"+maSP+"'";
        SanPham sp = new SanPham();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            	sp.setMaHSX(rs.getString("hangsx.MaHSX"));
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	sp.setTenHSX(rs.getString("hangsx.TenHangSX"));
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));	
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }
	
	public SanPham getPhuKien(String maSP) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "select * from sanpham,nhacc,loaisp" +
        		" where sanpham.MaNCC=nhacc.MaNCC and sanpham.MaLSP=loaisp.MaLSP"
        		+ " and sanpham.MaSP='"+maSP+"'";
        SanPham sp = new SanPham();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	sp.setManHinh(rs.getString("ManHinh"));
            	sp.setCPU(rs.getString("CPU"));
            	sp.setRAM(rs.getString("RAM"));
            	sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            	sp.setSim(rs.getString("Sim"));
            	sp.setCameraTruoc(rs.getString("CameraTruoc"));
            	sp.setCameraSau(rs.getString("CameraSau"));
            	sp.setBoNhoTrong(rs.getString("BoNhoTrong"));
            	sp.setHoTroTheNho(rs.getString("HoTroTheNho"));
            	sp.setPin(rs.getString("Pin"));
            	sp.setMaNCC(rs.getString("nhacc.MaNCC"));
            
            	sp.setMaLSP(rs.getString("loaisp.MaLSP"));
            	sp.setHinhSP(rs.getString("HinhSP"));
            	sp.setMoTaSP(rs.getString("MoTaSP"));
            	sp.setHinhAnh2(rs.getString("HinhAnh2"));
            	sp.setDanhGiaSP(rs.getString("DanhGiaSP"));
            	sp.setHinhAnh3(rs.getString("HinhAnh3"));
            	
            	sp.setTenNCC(rs.getString("nhacc.TenNhaCC"));
            	sp.setTenLSP(rs.getString("loaisp.TenLoaiSP"));	
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }
	
	public boolean deleteSanPham(String MaSP) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "DELETE FROM SanPham WHERE MaSP = ?";
		try {
			  PreparedStatement ps = (PreparedStatement) cons.prepareCall(sql);
		      ps.setString(1,MaSP);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(SanPhamDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public boolean updateSanPham(SanPham sp) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update sanpham set TenSP = ? , SoLuong = ?, GiaBan = ?, ManHinh = ?, CPU = ?, "+
				" RAM = ?, HeDieuHanh = ?, Sim = ? , CameraTruoc = ?, CameraSau = ? , "+
				" BoNhoTrong = ?, HoTroTheNho = ? , Pin = ?, MaNCC = ?, MaHSX = ?, MaLSP = ?, "+
				" HinhSP = ?, MoTaSP = ?,HinhAnh2 = ?, DanhGiaSP = ?, HinhAnh3 = ? where MaSP = ?";
		try {
			  PreparedStatement ps = (PreparedStatement) cons.prepareCall(sql);
		      ps.setString(1,sp.getTenSP());
		      ps.setDouble(2,sp.getSoLuong());
		      ps.setDouble(3,sp.getGiaBan());
		      ps.setString(4,sp.getManHinh());
		      ps.setString(5,sp.getCPU());
		      ps.setString(6,sp.getRAM());
		      ps.setString(7,sp.getHeDieuHanh());
		      ps.setString(8,sp.getSim());
		      ps.setString(9,sp.getCameraTruoc());
		      ps.setString(10,sp.getCameraSau());
		      ps.setString(11,sp.getBoNhoTrong());
		      ps.setString(12,sp.getHoTroTheNho());
		      ps.setString(13,sp.getPin());
		      ps.setString(14,sp.getMaNCC());
		      ps.setString(15,sp.getMaHSX());
		      ps.setString(16,sp.getMaLSP());
		      ps.setString(17,sp.getHinhSP());
		      ps.setString(18,sp.getMoTaSP());
		      ps.setString(19,sp.getHinhAnh2());
		      ps.setString(20,sp.getDanhGiaSP());
		      ps.setString(21,sp.getHinhAnh3());
		      ps.setString(22,sp.getMaSP());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(SanPhamDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public boolean insertSanPham(SanPham sp) throws ParseException, SQLException {
		Connection cons = DBConnect.getConnecttion();
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		SanPhamDao spDao = new SanPhamDao();
		list = spDao.getListSP();
		int temp=0;
		int kq = 1;
		while(kq<=list.size())
		{
			if(kq != Integer.parseInt(list.get(kq-1).getMaSP()))
				break;
			kq++;
		}
		String sql = "insert into sanpham values (?,?,?,?,?,?,?,? ,?,? ,?,? ,?,?,?,?,?,?,?,?,? ,?)";
		try {
			  PreparedStatement ps = (PreparedStatement) cons.prepareCall(sql);
			  ps.setString(1,Integer.toString(kq));
		      ps.setString(2,sp.getTenSP());
		      ps.setDouble(3,sp.getSoLuong());
		      ps.setDouble(4,sp.getGiaBan());
		      ps.setString(5,sp.getManHinh());
		      ps.setString(6,sp.getCPU());
		      ps.setString(7,sp.getRAM());
		      ps.setString(8,sp.getHeDieuHanh());
		      ps.setString(9,sp.getSim());
		      ps.setString(10,sp.getCameraTruoc());
		      ps.setString(11,sp.getCameraSau());
		      ps.setString(12,sp.getBoNhoTrong());
		      ps.setString(13,sp.getHoTroTheNho());
		      ps.setString(14,sp.getPin());
		      ps.setString(15,sp.getMaNCC());
		      ps.setString(16,sp.getMaHSX());
		      ps.setString(17,sp.getMaLSP());
		      ps.setString(18,sp.getHinhSP());
		      ps.setString(19,sp.getMoTaSP());
		      ps.setString(20,sp.getHinhAnh2());
		      ps.setString(21,sp.getDanhGiaSP());
		      ps.setString(22,sp.getHinhAnh3());
		      
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(SanPhamDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public ArrayList<NhaCC> getListNCC_1NCC(String MaNCC) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM NhaCC where MaNCC<> '"+MaNCC+"'";
        
        ArrayList<NhaCC> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	NhaCC ncc = new NhaCC();
            	ncc.setMaNCC(rs.getString("MaNCC"));
            	ncc.setTenNhaCC(rs.getString("TenNhaCC"));
            	ncc.setDiaChi(rs.getString("DiaChi"));
            	ncc.setSDT(rs.getString("SDT"));
            	list.add(ncc);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<HangSX> getListHSX_1HSX(String MaHSX) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM HangSX where MaHSX<> '"+MaHSX+"'";
        
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
	
	public ArrayList<LoaiSP> getListLoaiSP_1LoaiSP(String MaLoaiSP) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM LoaiSP where MaLSP<> '"+MaLoaiSP+"'";
        
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
	
	public ArrayList<SanPham> getListSP_1SP(String MaSP) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM SanPham where MaSP<> '"+MaSP+"'";
        
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham();
            	DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            	String GiaBanFormat = myFormatter.format(rs.getFloat("GiaBan"));
            	sp.setGiaBanFormat(GiaBanFormat);
            	sp.setMaSP(rs.getString("MaSP"));
            	sp.setTenSP(rs.getString("TenSP"));
            	sp.setSoLuong(rs.getFloat("SoLuong"));
            	sp.setGiaBan(rs.getFloat("GiaBan"));
            	list.add(sp);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public boolean updateSoLuong(SanPham sp) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update SanPham set SoLuong=? where MaSP=?";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setDouble(1,sp.getSoLuong());
			ps.setString(2, sp.getMaSP());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(SanPhamDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	
	
	public boolean thaydoiSL_SP(String MaSP, float SoLuong) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update SanPham set SoLuong = SoLuong + ? WHERE MaSP = ?";
		try {
			  PreparedStatement ps = (PreparedStatement) cons.prepareCall(sql);
		      ps.setFloat(1,SoLuong);
		      ps.setString(2,MaSP);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(SanPhamDao.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	 public static void main(String[] args) throws SQLException, ParseException {
		 SanPhamDao spDAO = new SanPhamDao();
//		 for(SanPham sp:spDAO.getListSP_PhuKien())
//		 {
//			 System.out.println(sp.getTenSP()+"____"+sp.getGiaBan());
//		 }
		 
//		 SanPham sp1 = spDAO.getSanPham("10");
//			SanPham sp2 = spDAO.getSanPham("15");
//			SanPham  = spDAO.getSanPham("20");
//			SanPham sp4 = spDAO.getSanPham("25");
//		 System.out.println(sp1.getTenSP()+"_____"+sp2.getTenSP()+"_____"+sp3.getTenSP());
//		 SanPham sp1 = spDAO.getPhuKien("33");
//			
//		 System.out.println(sp1.getMaLSP());
//		 SanPham sp = spDAO.getSanPham("10");
//		 sp.setTenSP("Trieets");
//		 if(spDAO.updateSanPham(sp))
//			 System.out.println("thanhf coong");
//	    }
		SanPham sp = new SanPham();
		sp.setTenSP("triết");
		if(spDAO.thaydoiSL_SP("10",-5))
			System.out.println("Thành công");
	 }

}

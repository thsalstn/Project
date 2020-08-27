package team.t.t.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.t.t.dto.RecordDTO;

public class RecordDAO {
	private static RecordDAO instance = new RecordDAO();
	
	public static RecordDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception{
	  
		String dbURL = "jdbc:mysql://database-1.c5sjjrxl4o4s.ap-northeast-2.rds.amazonaws.com:3306/test_db";
		String dbID = "admin";
		String dbPassword = "alstn123";
		Class.forName("com.mysql.jdbc.Driver"); 
		return DriverManager.getConnection(dbURL, dbID, dbPassword);
	}
	
	public List<RecordDTO> list(String id, int start, int end){
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			con = getConnection();
			
			sql = "select * from ( ";
			sql += "select @ROWNUM := @ROWNUM + 1 AS NUM , r.* ";
			sql += "from (select @ROWNUM := 0) no, (";
			sql += "select r.*, p.PSYC_TYPE from ";
			sql += "record r, ";
			sql += "(select * from psychological) p ";
			sql += "where r.MEM_ID = ? ";
			sql += "and p.PSYC_NO = r.PSYC_NO ";
			sql += "order by r.RECO_TIME desc) r) list ";
			sql += "where NUM >= ? and NUM <= ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			System.out.println(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RecordDTO record = new RecordDTO();
				record.setNUM(rs.getInt("NUM"));
				record.setMEM_ID(rs.getString("MEM_ID"));
				record.setPSYC_NO(rs.getInt("PSYC_NO"));
				record.setRECO_TIME(rs.getDate("RECO_TIME"));
				record.setDETI_GRADE(rs.getString("DETI_GRADE"));
				record.setPSYC_TYPE(rs.getString("PSYC_TYPE"));
				
				list.add(record);
			}
			
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(con != null) {
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return list;
	}
	
	public int getCount(String id) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select count(*) from record ";
			sql += "where mem_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(con != null) {
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
		return result;
	}
	
	public List<Integer> countrecord(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int event = 0;
		String sql = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<Integer>();
				
		try {
			con = getConnection();
			
			sql = "select count(*) as count ";
			sql += "from record ";
			sql += "where mem_id = ? ";
			sql += "group by psyc_no";
			
			sql = "select * from ";
			sql += "(select count(*) as m from record where mem_id = ? and psyc_no = 1) m, ";
			sql += "(select count(*) as s from record where mem_id = ? and psyc_no = 2) s, "; 
			sql += "(select count(*) as d from record where mem_id = ? and psyc_no = 3) d, "; 
			sql += "(select count(*) as a from record where mem_id = ? and psyc_no = 4) a, ";
			sql += "(select count(*) as g from record where mem_id = ? and psyc_no = 5) g ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			pstmt.setString(3, id);
			pstmt.setString(4, id);
			pstmt.setString(5, id);
			
			System.out.println(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("m"));
				list.add(rs.getInt("s"));
				list.add(rs.getInt("d"));
				list.add(rs.getInt("a"));
				list.add(rs.getInt("g"));
			}
			
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(con != null) {
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return list;
	}
}
package team.t.t.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.simple.JSONObject;

import team.t.t.dto.CounselorLoginDTO;
import team.t.t.service.JdbcUtil;

public class CounselorLoginDAO {

	private static CounselorLoginDAO instance = new CounselorLoginDAO();

	public static CounselorLoginDAO getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {

		String dbURL = "jdbc:mysql://database-1.c5sjjrxl4o4s.ap-northeast-2.rds.amazonaws.com:3306/test_db";
		String dbID = "admin";
		String dbPassword = "alstn123";
		Class.forName("com.mysql.jdbc.Driver"); 
		return DriverManager.getConnection(dbURL, dbID, dbPassword);
	}
	
	// Counselor 회원 가입
	public int insertCounselor(CounselorLoginDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println(dto.getCoun_name());
		int result = 0;
		try {
			con = getConnection();

			String sql = "insert into counselor values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getCoun_id());
			pstmt.setString(2, dto.getCoun_pw());
			pstmt.setString(3, dto.getCoun_name());
			pstmt.setString(4, dto.getCoun_birth());
			pstmt.setString(5, dto.getCoun_post());
			pstmt.setString(6, dto.getCoun_addr());
			pstmt.setString(7, dto.getCoun_addr2());
			pstmt.setString(8, dto.getCoun_tel());
			pstmt.setString(9, dto.getCoun_phone());
			pstmt.setString(10, dto.getCoun_email());
			pstmt.setString(11, dto.getCoun_dept());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		return result;
	}

	
	// counselor 아이디 중복검사
	public int CounidCheck(String cid) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = getConnection();
			String sql = "select * from counselor where coun_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}
			String sql1 = "select * from member where mem_id=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);

		}
		return result;
	}

	

	// counselor 정보 검색
	public CounselorLoginDTO selectCoun(String cid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CounselorLoginDTO dto = new CounselorLoginDTO();
		try {

			con = getConnection();
			String sql = "select * from counselor where coun_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setCoun_id(rs.getString(1));
				dto.setCoun_pw(rs.getString(2));
				dto.setCoun_name(rs.getString(3));
				dto.setCoun_birth(rs.getString(4));
				dto.setCoun_post(rs.getString(5));
				dto.setCoun_addr(rs.getString(6));
				dto.setCoun_addr2(rs.getString(7));
				dto.setCoun_tel(rs.getString(8));
				dto.setCoun_phone(rs.getString(9));
				dto.setCoun_email(rs.getString(10));
				dto.setCoun_dept(rs.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		return dto;
	}

	

	// counselor 정보 수정
	public int updateCounselor(CounselorLoginDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		String sql;
		try {
			con = getConnection();

			sql = "update counselor set coun_name=?, coun_birth=?, coun_post=?, coun_addr=?, coun_addr2=?, coun_tel=?, coun_phone=?, coun_email=?, coun_dept=?  where coun_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getCoun_name());
			pstmt.setString(2, dto.getCoun_birth());
			pstmt.setString(3, dto.getCoun_post());
			pstmt.setString(4, dto.getCoun_addr());
			pstmt.setString(5, dto.getCoun_addr2());
			pstmt.setString(6, dto.getCoun_tel());
			pstmt.setString(7, dto.getCoun_phone());
			pstmt.setString(8, dto.getCoun_email());
			pstmt.setString(9, dto.getCoun_dept());
			pstmt.setString(10, dto.getCoun_id());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}

		return result;
	}


	// counselor비밀번호 변경
	public int cpwUpdate(String cid, String cpw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = getConnection();
			String sql = "update counselor set coun_pw=? where coun_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cpw);
			pstmt.setString(2, cid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		return result;
	}

	

	// counselor 탈퇴
	public int deleteCoun(String cid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {

			con = getConnection();
			String sql = "delete from counselor where coun_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cid);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}

		return result;
	}

	// counselor 아이디 비밀번호 찾기
	public List<CounselorLoginDTO> coun_id_pw_Select(String cname, String cemail) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CounselorLoginDTO dto = null;
		List<CounselorLoginDTO> list = new ArrayList<CounselorLoginDTO>();
		try {
			con = getConnection();
			String sql = "select * from counselor where coun_name=? and coun_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cname);
			pstmt.setString(2, cemail);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				dto = new CounselorLoginDTO();
				dto.setCoun_id(rs.getString("coun_id"));
				dto.setCoun_pw(rs.getString("coun_pw"));
				list.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		return list;
	}

//	public int socialInfoCk(String code) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int result = 0;
//		
//		try {
//			con = getConnection();
//			String sql = "select * from member where MEM_CODE = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, code);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				result = 1;
//			}else {
//				result = -1;
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//			JdbcUtil.close(con);
//		}		
//		return result;
//	}
//	
//	public int naverInfo(JSONObject resObj) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int result = 0;
//		
//		try {
//			con = getConnection();
//			String sql = "insert into social values(?,?,?,?,?,?)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1,(String)resObj.get("id") );
//			pstmt.setString(2, (String)resObj.get("name"));
//			pstmt.setString(3, (String)resObj.get("age"));
//			pstmt.setString(4, (String)resObj.get("gender"));
//			pstmt.setString(5, (String)resObj.get("birthday"));
//			pstmt.setString(6, "NAVER");
//		   result=pstmt.executeUpdate();
//		
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//			JdbcUtil.close(con);
//		}		
//		return result;
//	}
}

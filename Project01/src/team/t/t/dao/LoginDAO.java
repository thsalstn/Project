package team.t.t.dao;
import java.sql.Connection;
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

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;
import team.t.t.service.JdbcUtil;



public class LoginDAO {

	private static LoginDAO instance = new LoginDAO();

	public static LoginDAO getInstance() {
		return instance;
	}

	private Connection getConnection() throws NamingException, SQLException {

		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");

		return ds.getConnection();
	}

	// 회원 가입
	public int insertMember(LoginDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println(dto.getMem_name());
		int result = 0;
		try {
			con = getConnection();

			String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMem_id());
			pstmt.setString(2, dto.getMem_pw());
			pstmt.setString(3, dto.getMem_name());
			pstmt.setString(4, dto.getMem_birth());
			pstmt.setInt(5, dto.getMem_post());
			pstmt.setString(6, dto.getMem_addr());
			pstmt.setString(7, dto.getMem_addr2());
			pstmt.setString(8, dto.getMem_tel());
			pstmt.setString(9, dto.getMem_phone());
			pstmt.setString(10, dto.getMem_email());
			pstmt.setInt(11, dto.getMem_social());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		return result;
	}

	// 아이디 중복검사
	public int idCheck(String id) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = getConnection();
			String sql = "select * from member where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}
			
			String sql1 = "select * from counselor where coun_id=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			
			if(rs.next()) {
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

	// 회원 정보 검색
	public LoginDTO selectMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		LoginDTO dto = new LoginDTO();
		try {

			con = getConnection();
			String sql = "select * from member where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setMem_id(rs.getString(1));
				dto.setMem_pw(rs.getString(2));
				dto.setMem_name(rs.getString(3));
				dto.setMem_birth(rs.getString(4));
				dto.setMem_post(rs.getInt(5));
				dto.setMem_addr(rs.getString(6));
				dto.setMem_addr2(rs.getString(7));
				dto.setMem_tel(rs.getString(8));
				dto.setMem_phone(rs.getString(9));
				dto.setMem_email(rs.getString(10));
				dto.setMem_social(rs.getInt(11));
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

	// 회원 정보 수정
	public int updateMember(LoginDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
	

		String sql;
		try {
			con = getConnection();

			sql = "update member set mem_name=?, mem_birth=?, mem_post=?, mem_addr=?, mem_addr2=?, mem_tel=?, mem_phone=?, mem_email=?  where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMem_name());
			pstmt.setString(2, dto.getMem_birth());
			pstmt.setInt(3, dto.getMem_post());
			pstmt.setString(4, dto.getMem_addr());
			pstmt.setString(5, dto.getMem_addr2());
			pstmt.setString(6, dto.getMem_tel());
			pstmt.setString(7, dto.getMem_phone());
			pstmt.setString(8, dto.getMem_email());
			pstmt.setString(9, dto.getMem_id());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}

		return result;
	}
	// 회원 정보 수정
		public int updateNMember(LoginDTO dto) {
			Connection con = null;
			PreparedStatement pstmt = null;
			int result = 0;
			String sql;
			try {
				con = getConnection();

				sql = "update member set  mem_email=?  where mem_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getMem_email());
				pstmt.setString(2, dto.getMem_id());

				result = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(pstmt);
				JdbcUtil.close(con);
			}

			return result;
		}
	// 비밀번호 변경
	public int pwUpdate(String id, String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = getConnection();
			String sql = "update member set mem_pw=? where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		return result;
	}

	// 회원 탈퇴
	public int deleteMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {

			con = getConnection();
			String sql = "delete from member where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}

		return result;
	}

	// 아이디 찾기
	public List<LoginDTO> id_Select(String name, String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LoginDTO dto = null;
		List<LoginDTO> list = new ArrayList<LoginDTO>();
		try {
			con = getConnection();
			String sql = "select * from member where mem_name=? and mem_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				dto = new LoginDTO();
				dto.setMem_id(rs.getString("mem_id"));
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

	public int pw_Select(LoginDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnection();
			String sql = "select * from member where mem_id=? and mem_email = ? and mem_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMem_id());
			pstmt.setString(2, dto.getMem_email());
			pstmt.setString(3, dto.getMem_name());
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
	public int googleInfo(JSONObject jsonObj) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		System.out.println((String) jsonObj.get("name").toString());
		try {
			con = getConnection();
			String sql = "insert into social (MEM_ID, MEM_NAME, MEM_social) values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, (String) jsonObj.get("sub").toString());
			pstmt.setString(2, (String) jsonObj.get("name").toString());
			pstmt.setString(3, "GOOGLE");
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}

		return result;
	}
}

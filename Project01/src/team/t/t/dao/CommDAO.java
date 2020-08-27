package team.t.t.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.t.t.dto.CommDTO;

public class CommDAO {
	
	private static CommDAO instance = new CommDAO();
	
	public static CommDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		String dbURL = "jdbc:mysql://database-1.c5sjjrxl4o4s.ap-northeast-2.rds.amazonaws.com:3306/test_db";
		String dbID = "admin";
		String dbPassword = "alstn123";
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(dbURL, dbID, dbPassword);
	}
	
	// 댓글 갯수
			public int getCount(int BOAR_NO) {
				int result = 0;
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					con = getConnection();
					String sql = "select count(*) from comment where CBOAR_NO = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, BOAR_NO);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						result = rs.getInt(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (rs != null)
						try {
							rs.close();
						} catch (Exception e) {
						}
					if (pstmt != null)
						try {
							pstmt.close();
						} catch (Exception e) {
						}
					if (con != null)
						try {
							con.close();
						} catch (Exception e) {
						}
				}

				return result;

			}
		// 댓글목록
		public List<CommDTO> comm_list(int BOAR_NO){
			List<CommDTO> comm_list = new ArrayList<CommDTO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				String sql="select * from comment where CBOAR_NO=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, BOAR_NO);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					CommDTO model = new CommDTO();
					model.setCOMM_NO(rs.getInt("COMM_NO"));
					model.setMEM_ID(rs.getString("MEM_ID"));
					model.setCOMM_DATE(rs.getDate("COMM_DATE"));
					model.setCOMM_CONT(rs.getString("COMM_CONT"));
					
					comm_list.add(model);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (rs != null)
					try {
						rs.close();
					} catch (Exception e) {
					}
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}
			}
			return comm_list;
		}
		
		
		// 댓글 작성
		public int comm_insert(CommDTO comm) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = getConnection();
				String sql="insert into comment(MEM_ID,COMM_DATE,COMM_CONT,CBOAR_NO) values(?,now(),?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, comm.getMEM_ID());
				pstmt.setString(2, comm.getCOMM_CONT());
				pstmt.setInt(3, comm.getCBOAR_NO());
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}
			}
			return result;
		}
		
		// 댓글 수정
		public int commUpdate(CommDTO comm) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				String sql="update comment set COMM_CONT=?, COMM_DATE=now() where CBOAR_NO=? and COMM_NO=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, comm.getCOMM_CONT());
				pstmt.setInt(2, comm.getCBOAR_NO());
				pstmt.setInt(3, comm.getCOMM_NO());
				
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}                                                       
			}
			return result;
		}
		
		// 댓글 삭제
		
		public int commDelete(int COMM_NO) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				String sql = "delete from comment where COMM_NO=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, COMM_NO);
				
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}                            
			}
			return result;
		}
}

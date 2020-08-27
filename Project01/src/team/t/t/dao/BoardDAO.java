package team.t.t.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import team.t.t.dto.CBoardDTO;
import team.t.t.dto.BoardDTO;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception {

		String dbURL = "jdbc:mysql://database-1.c5sjjrxl4o4s.ap-northeast-2.rds.amazonaws.com:3306/test_db";
		String dbID = "admin";
		String dbPassword = "alstn123";
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(dbURL, dbID, dbPassword);

	}

	// 글 작성
	public int boardinsert(BoardDTO board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql = "insert into board values(?,?,?,?,now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board.getBOAR_NO());
			pstmt.setString(2, board.getMEM_ID());
			pstmt.setString(3, board.getBOAR_TITLE());
			pstmt.setString(4, board.getBOAR_CONT());
			pstmt.setInt(5, 0);
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

	// 글갯수
	public int getCount(HashMap<String, Object> listOp) {
		int result = 0;
		String op = (String) listOp.get("op");
		String sc = (String) listOp.get("sc");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("op:" + op);

		try {
			con = getConnection();

			if (op == null) {
				String sql = "select count(*) from board";
				pstmt = con.prepareStatement(sql);
			} else if (op.equals("0")) {
				String sql = "select count(*) from board where BOAR_TITLE like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, '%' + sc + '%');
			} else if (op.equals("1")) {
				String sql = "select count(*) from board where BOAR_CONT like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, '%' + sc + '%');
			} else if (op.equals("2")) {

				String sql = "select count(*) from board where BOAR_TITLE like ? or BOAR_CONT like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, '%' + sc + '%');
				pstmt.setString(2, '%' + sc + '%');
			} else if (op.equals("3")) {
				String sql = "select count(*) from board where MEM_ID like ?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, '%' + sc + '%');
			}
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

	// 글목록
	public List<BoardDTO> list(HashMap<String, Object> listOp) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String op = (String) listOp.get("op");
		String sc = (String) listOp.get("sc");
		int start = (Integer) listOp.get("start");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			if (op == null) { // 전체글
				String sql = "select * from board order by boar_no desc limit ?,10";

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, start);

			} else if (op.equals("0")) { // 제목으로 검색
				String sql = "select * from board where BOAR_TITLE like ? order by boar_no desc limit ?,10";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + sc + "%");
				pstmt.setInt(2, start);

			} else if (op.equals("1")) { // 내용으로 검색
				String sql = "select * from board where BOAR_CONT like ? order by boar_no desc limit ?,10";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + sc + "%");
				pstmt.setInt(2, start);

			} else if (op.equals("2")) { // 제목+내용으로 검색
				String sql = "select * from board where BOAR_TITLE like ? or BOAR_CONT like ? order by boar_no desc limit ?,10";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + sc + "%");
				pstmt.setString(2, "%" + sc + "%");
				pstmt.setInt(3, start);

			} else if (op.equals("3")) { // 아이디로 검색
				String sql = "select * from board where MEM_ID like ? order by boar_no desc limit ?,10";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + sc + "%");
				pstmt.setInt(2, start);

			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBOAR_NO(rs.getInt("BOAR_NO"));
				board.setMEM_ID(rs.getString("MEM_ID"));
				board.setBOAR_TITLE(rs.getString("BOAR_TITLE"));
				board.setBOAR_CONT(rs.getString("BOAR_CONT"));
				board.setBOAR_TIME(rs.getDate("BOAR_TIME"));
				board.setBOAR_COUN(rs.getInt("BOAR_COUN"));

				list.add(board);
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

		return list;

	}

	// 조회수 증가
	public void countUpdate(int BOAR_NO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update board set BOAR_COUN=BOAR_COUN+1 where BOAR_NO=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, BOAR_NO);
			pstmt.executeUpdate();

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

	}

	// 상세페이지
	public BoardDTO getCont(int BOAR_NO) {
		BoardDTO board = new BoardDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();

			String sql = "select * from board where BOAR_NO=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, BOAR_NO);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board.setBOAR_NO(rs.getInt("BOAR_NO"));
				board.setMEM_ID(rs.getString("MEM_ID"));
				board.setBOAR_TITLE(rs.getString("BOAR_TITLE"));
				board.setBOAR_CONT(rs.getString("BOAR_CONT"));
				board.setBOAR_TIME(rs.getDate("BOAR_TIME"));
				board.setBOAR_COUN(rs.getInt("BOAR_COUN"));
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

		return board;
	}

	// 글 수정
	public int boardUpdate(BoardDTO board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update board set BOAR_TITLE=?,BOAR_CONT=?,BOAR_TIME=now() where BOAR_NO=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBOAR_TITLE());
			pstmt.setString(2, board.getBOAR_CONT());
			pstmt.setInt(3, board.getBOAR_NO());

			System.out.println(sql);
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

	// 글 삭제
	public int boardDelete(int BOAR_NO) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql = "delete from board where BOAR_NO=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, BOAR_NO);
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

	// 상담사 글목록
	public List<CBoardDTO> clist(HashMap<String, Object> listOpt) {

		List<CBoardDTO> clist = new ArrayList<CBoardDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String opt = (String) listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등 )
		String condition = (String) listOpt.get("condition"); // 검색내용
		int start = (Integer) listOpt.get("startRow");
		int end = (Integer) listOpt.get("endRow");

		try {
			con = getConnection();

//			String sql="select * from (select @ROWNUM := @ROWNUM + 1 AS rnum, board.* from "
//					  + " (select @ROWNUM := 0) ro, (select * from board order by BOAR_NO) board) bo"
//					  + " where rnum>=? and rnum<=?";

			if (opt == null) {
				sql = "select * from cboard limit ?, 10";

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, start);
//		       		pstmt.setInt(2, end);     		

			} else if (opt.equals("0")) { // 제목 검색
				sql = "select * from cboard where CBOAR_TITLE like ? limit ?,10";

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, start);

			} else if (opt.equals("1")) { // 내용 검색
				sql = "select * from cboard where CBOAR_CONT like ? limit ?,10";

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, start);
			} else if (opt.equals("2")) { // 제목 + 내용 검색
				sql = "select * from cboard where CBOAR_TITLE like ? or CBOAR_CONT like ? limit ?,10";

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setString(2, "%" + condition + "%");
				pstmt.setInt(3, start);
			} else if (opt.equals("3")) { // 글쓴이 검색
				sql = "select * from cboard where COUN_ID like ? limit ?,10";

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, start);
			}
			System.out.println("*** start: " + start);
			System.out.println("*** sql: " + sql);
			System.out.println("*** opt: " + opt);
			System.out.println("*** condition: " + condition);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CBoardDTO board = new CBoardDTO();
				board.setCBOAR_NO(rs.getInt("CBOAR_NO"));
				board.setCOUN_ID(rs.getString("COUN_ID"));
				board.setCBOAR_TITLE(rs.getString("CBOAR_TITLE"));
				board.setCBOAR_CONT(rs.getString("CBOAR_CONT"));
				board.setCBOAR_TIME(rs.getDate("CBOAR_TIME"));
				board.setCBOAR_COUN(rs.getInt("CBOAR_COUN"));

				clist.add(board);
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

		return clist;
	}

	// 글작성 : 원문작성
	public int cboardinsert(CBoardDTO cboard) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "insert into cboard(COUN_ID, CBOAR_TITLE, CBOAR_CONT, CBOAR_TIME, CBOAR_COUN ) values(?,?,?,sysdate(),?)";
//				String sql="insert into board() values(?, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cboard.getCOUN_ID());
			pstmt.setString(2, cboard.getCBOAR_TITLE());
			pstmt.setString(3, cboard.getCBOAR_CONT());
			pstmt.setInt(4, 0);
			result = pstmt.executeUpdate(); // SQL문 실행

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
	
	// 글 수정
		public int cupdate(CBoardDTO cboard) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				String sql = "update cboard set CBOAR_TITLE=?, CBOAR_CONT=? where CBOAR_NO=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cboard.getCBOAR_TITLE());
				pstmt.setString(2, cboard.getCBOAR_CONT());
				pstmt.setInt(3, cboard.getCBOAR_NO());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt!=null) try { pstmt.close();}catch(Exception  e) {}
				if(con!=null) try { con.close();}catch(Exception  e) {}
			}
			
			return result;
		}
		
		// 조회수 증가
		public void ccountUpdate(int CBOAR_NO) {
			Connection con = null;
			PreparedStatement pstmt = null;
			System.out.println("*****조회수 증가*****");

			try {
				con = getConnection();

				String sql = "update cboard set CBOAR_COUN=CBOAR_COUN+1 where CBOAR_NO=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, CBOAR_NO);
				pstmt.executeUpdate();

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

		}
		
		// 총 데이터 갯수 구하기
		public int cgetCount(HashMap<String, Object> listOpt) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			String opt = (String)listOpt.get("opt"); //검색옵션(제목, 내용, 글쓴이 등 )
			String condition = (String)listOpt.get("condition"); //검색내용
			int start = (Integer) listOpt.get("startRow");		
			int end = (Integer) listOpt.get("endRow");	
			
			
			try {
				con = getConnection();
				
				
				if(opt == null) {
//					sql = "select count(*) from board limit ?, 10";		
					sql = "select count(*) from cboard";		
					
		       		pstmt = con.prepareStatement(sql);
//		       		pstmt.setInt(1, start);
//		       		pstmt.setInt(2, end);     		
		       		
				}else if(opt.equals("0")) { // 제목 검색
					sql = "select count(*) from cboard where CBOAR_TITLE like ?";
					
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1, "%"+condition+"%");
//					pstmt.setInt(2, start);				
							
				}else if(opt.equals("1")) { // 내용 검색
					sql = "select count(*) from cboard where CBOAR_CONT like ?";
					
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1, "%"+condition+"%");
//					pstmt.setInt(2, start);
				}else if(opt.equals("2")) { // 제목 + 내용 검색
					sql = "select count(*) from cboard where CBOAR_TITLE like ? or CBOAR_CONT like ?";
					
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1, "%"+condition+"%");
					pstmt.setString(2, "%"+condition+"%");
		//			pstmt.setInt(3, start);
				}else if(opt.equals("3")) { //글쓴이 검색
					sql = "select count(*) from cboard where COUN_ID like ?";
					
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1, "%"+condition+"%");
//					pstmt.setInt(2, start);
				}
				
//				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
//					result = rs.getInt(1);
					result = rs.getInt("count(*)");
				}			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs!=null) try { rs.close();}catch(Exception  e) {}
				if(pstmt!=null) try { pstmt.close();}catch(Exception  e) {}
				if(con!=null) try { con.close();}catch(Exception  e) {}
			}		
			
			return result;
		}

		// 상세페이지
		public CBoardDTO getcCont(int CBOAR_NO) {
			CBoardDTO cboard = new CBoardDTO();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();

				String sql = "select * from cboard where CBOAR_NO=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, CBOAR_NO);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					cboard.setCBOAR_NO(rs.getInt("CBOAR_NO"));
					cboard.setCOUN_ID(rs.getString("COUN_ID"));
					cboard.setCBOAR_TITLE(rs.getString("CBOAR_TITLE"));
					cboard.setCBOAR_CONT(rs.getString("CBOAR_CONT"));
					cboard.setCBOAR_TIME(rs.getDate("CBOAR_TIME"));
					cboard.setCBOAR_COUN(rs.getInt("CBOAR_COUN"));
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

			return cboard;
		}
		
		public int cdelete(int CBOAR_NO) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
					
			try {
				con = getConnection();
				String sql = "delete from cboard where CBOAR_NO = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, CBOAR_NO);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) try { pstmt.close();} catch (Exception e) {}
				if(con != null) try { con.close();} catch (Exception e) {}
			}
			
			return result;
		}

	// 글 수정
	public int update(BoardDTO board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql = "update board set BOAR_TITLE=?, BOAR_CONT=? where BOAR_NO=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBOAR_TITLE());
			pstmt.setString(2, board.getBOAR_CONT());
			pstmt.setInt(3, board.getBOAR_NO());
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

	// 총 데이터 갯수 구하기
	public int getCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
//					result = rs.getInt("count(*)");
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

	public int delete(int BOAR_NO) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql = "delete from board where BOAR_NO = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, BOAR_NO);
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

	public List<BoardDTO> myWrite(String id, int startRow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO dto = null;
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			con = getConnection();
			String sql = "select * from board where mem_id=? order by BOAR_NO desc limit ?,5";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new BoardDTO();
				dto.setBOAR_NO(rs.getInt("BOAR_NO"));
				dto.setMEM_ID(rs.getString("MEM_ID"));
				dto.setBOAR_TITLE(rs.getString("BOAR_TITLE"));
				dto.setBOAR_CONT(rs.getString("BOAR_CONT"));
				dto.setBOAR_TIME(rs.getDate("BOAR_TIME"));
				dto.setBOAR_COUN(rs.getInt("BOAR_COUN"));
				list.add(dto);

			}
		} catch (Exception e) {
			// TODO: handle exception
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
		return list;
	}

	// 마이페이지 내 게시글 카운트 수
	public int myWrite_Count(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnection();
			String sql = "select count(*) from board  where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
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
	
	public String check(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String addr = null;
		
		try {
			con = getConnection();
			String sql = "select count(*) from counselor where coun_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
			
			System.out.println(sql);
			
			if(result == 0) {
				addr = "/WEB-INF/views/content/loginfalse.jsp";
			}else {
				addr = "/WEB-INF/views/content/cboard_write.jsp";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
		
		return addr;
	}

}
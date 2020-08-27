package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.BoardDTO;

public class BoardWrite implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO board = new BoardDTO();
		
		board.setMEM_ID(request.getParameter("MEM_ID"));;
		board.setBOAR_TITLE(request.getParameter("BOAR_TITLE"));
		board.setBOAR_CONT(request.getParameter("BOAR_CONT"));		
		
		int result = dao.boardinsert(board);
		if(result == 1) {
			System.out.println("insert성공");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardList.do");
		return forward;
	}

}

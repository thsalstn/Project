 package team.t.t.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.BoardDTO;

public class BoardList implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 출력할 페이지
		int page = 1;
	
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// 검색조건과 검색내용
		String op = request.getParameter("op");
		String sc = request.getParameter("sc");
		
		int start = (page - 1) * 10;
		
		HashMap<String , Object> listOp = new HashMap<String, Object>();
		listOp.put("op", op);
		listOp.put("sc", sc);
		listOp.put("start", start);
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO board = new BoardDTO();
		int listcount = dao.getCount(listOp);
		List<BoardDTO> boardlist = dao.list(listOp);
		
		// 전체 페이지 수 
		int pageCount = (int)(listcount/10.0 + 0.9);
		
		// 시작 페이지 번호
		int startPage = (int)(page/5.0 + 0.8)*5-4;
		
		// 마지막 페이지 번호
		int endPage = startPage + 4;
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("page", page);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("board", board);
		request.setAttribute("op", op);
		request.setAttribute("sc", sc);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/content/board.jsp");
		
		return forward;
	}

}

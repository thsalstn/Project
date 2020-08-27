package team.t.t.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.service.ActionForward;
import team.t.t.dto.CBoardDTO;

public class CBoardList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		System.out.println("CBoardList");		
		
		int page = 1;			// 현재 페이지 번호
		int limit = 10;			// 한 화면에 출력할 데이터 갯수
		
		// 검색조건과 검색내용 가져오기
		String opt = null;
		String condition = null;		
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			if(page < 0) page = 1;			
		}
		
		if(request.getParameter("opt") != null) {
			opt = request.getParameter("opt");
		}
		
		if(request.getParameter("condition") != null) {
			condition = request.getParameter("condition");
		}
		
		int startRow = (page-1) * limit;
		int endRow = page * limit;
		
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		listOpt.put("opt", opt);
		listOpt.put("condition", condition);
		listOpt.put("startRow", startRow);
		listOpt.put("endRow", endRow);
		
		BoardDAO dao = BoardDAO.getInstance();
		int clistcount = dao.cgetCount(listOpt);		// 총 데이터 갯수
		System.out.println("clistcount:"+clistcount);
		
//		List<BoardDTO> boardlist = dao.clist(startRow, endRow);
		List<CBoardDTO> cboardlist = dao.clist(listOpt);
		System.out.println("cboardlist:"+cboardlist);
		
		// 총 페이지수
		int pageCount =clistcount/limit + ((clistcount%limit==0) ? 0 : 1);
		
		int startPage = ((page - 1)/10) * limit + 1;  // 1,  11, 21,...
		int endPage = startPage + 10 - 1 ;			  // 10, 20, 30,...
		
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("page", page);
		request.setAttribute("clistcount", clistcount);
		request.setAttribute("cboardlist", cboardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);	
		request.setAttribute("opt", opt);	
		request.setAttribute("condition", condition);	
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/content/cboard.jsp");
		
		return forward;
	}
	
}

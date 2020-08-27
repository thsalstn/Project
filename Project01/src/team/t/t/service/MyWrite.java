package team.t.t.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.BoardDTO;

public class MyWrite implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MyWrite");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int page = 1;
		int limit = 5;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		int startRow = (page - 1) * limit;

		BoardDAO dao = BoardDAO.getInstance();		
		int listCount = dao.myWrite_Count(id);

		List<BoardDTO> list = dao.myWrite(id, startRow);

		int pageCount = listCount / limit + ((listCount % limit == 0) ? 0 : 1);
		int startPage = ((page - 1) / 10) * limit + 1;
		int endPage = startPage + 10 - 1;

		if (endPage > pageCount)
			endPage = pageCount;
		request.setAttribute("page", page);
		request.setAttribute("listCount", listCount);
		request.setAttribute("list", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
	
		ActionForward forward = new ActionForward();
		forward.setPath("/content/my_write.jsp");
		return forward;
	}

}

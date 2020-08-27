package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.BoardDAO;

public class CBoardWrite implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CBoardWrite");
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		
		BoardDAO dao = BoardDAO.getInstance();
		String result = dao.check(id);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath(result);
		return forward;
	}

}

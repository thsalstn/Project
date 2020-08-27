package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.CBoardDTO;

public class CBoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("*** CBoardModifyAction ***");
		int CBOAR_NO = Integer.parseInt(request.getParameter("CBOAR_NO"));
		String page = request.getParameter("page");
		
		BoardDAO dao = BoardDAO.getInstance();
		CBoardDTO cboard = dao.getcCont(CBOAR_NO);
		
		request.setAttribute("cboard", cboard);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/content/cboard_modify.jsp");		
		
		return forward;
	}

}

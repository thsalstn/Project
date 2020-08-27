package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.CBoardDTO;

public class CBoardDetail implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("*** CBoardDetail ***");
		int CBOAR_NO = Integer.parseInt(request.getParameter("CBOAR_NO"));
		System.out.println("CBOARD_NO: " + CBOAR_NO);
		String page = request.getParameter("page");

		BoardDAO dao = BoardDAO.getInstance();
		dao.countUpdate(CBOAR_NO); //조회수 증가
		CBoardDTO cboard = dao.getcCont(CBOAR_NO);

		// 줄바꿈
		String CBOAR_CONT = cboard.getCBOAR_CONT().replace("\n", "<br>");
		request.setAttribute("CBOAR_CONT", CBOAR_CONT);

		request.setAttribute("cboard", cboard);
		request.setAttribute("page", page);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/content/cboard_detail.jsp");
		
		return forward;
	}

}
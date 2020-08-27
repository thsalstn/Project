package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.CBoardDTO;

public class CBoardModify implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("*** CBoardModify ***");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int CBOAR_NO = Integer.parseInt(request.getParameter("CBOAR_NO"));
		String page = request.getParameter("page");		
		
		CBoardDTO cboard = new CBoardDTO();
		cboard.setCBOAR_NO(CBOAR_NO);
		cboard.setCBOAR_TITLE(request.getParameter("CBOAR_TITLE"));
		cboard.setCBOAR_CONT(request.getParameter("CBOAR_CONT"));
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.cupdate(cboard);
		if(result == 1) System.out.println("수정 성공");
		else System.out.println("수정 실패");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/CBoardDetail.do?CBOAR_NO=" + CBOAR_NO + "&page" + page);
		
		return forward;
	}

}














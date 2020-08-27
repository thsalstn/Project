package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;

public class CBoardDelete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("*** CBoardDelete ***");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int CBOAR_NO = Integer.parseInt(request.getParameter("CBOAR_NO"));
		String page = request.getParameter("page");
		String COUN_PW = request.getParameter("COUN_PW");
		String COUN_ID = request.getParameter("COUN_ID");
		System.out.println("");
		
		BoardDAO dao = BoardDAO.getInstance();
//		BoardDTO old = dao.getCont(BOAR_NO);
		
		String path = request.getRealPath("cboardupload");
		System.out.println("path: " + path);
		
		
//		<c:if> ${empty sessionScope.id}
//		if(old.getMEM_ID().equals(MEM_ID)){
//			int result = dao.delete(BOAR_NO);
//			if(result == 1) { System.out.println("삭제 성공"); }
//		}else {
//			System.out.println("비밀번호가 일치하지 않습니다.");
//		}
		int result = dao.cdelete(CBOAR_NO);
		if(result == 1) System.out.println("삭제 성공");
		else System.out.println("삭제 실패");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/CBoardList.do");		
		
		return forward;
	}

}
























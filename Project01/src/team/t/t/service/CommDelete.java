package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.CommDAO;

public class CommDelete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommDelete");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("BOAR_NO:"+request.getParameter("BOAR_NO"));
		System.out.println("COMM_NO:"+request.getParameter("COMM_NO"));
		
		int BOAR_NO = Integer.parseInt(request.getParameter("BOAR_NO"));
		int COMM_NO = Integer.parseInt(request.getParameter("COMM_NO"));

		String page = request.getParameter("page");
		System.out.println("page:"+page);
		
		
		CommDAO cdao = new CommDAO();
		int result = cdao.commDelete(COMM_NO);
		if(result == 1) {
			System.out.println("삭제 성공");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardDetail.do?BOAR_NO="+BOAR_NO+"&page="+page);
		return forward;
	}

}

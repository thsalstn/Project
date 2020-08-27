package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;

public class Member_EmailCh implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Member_EmailCh");
		String id = request.getParameter("mem_id");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("아이디 : " + id);
		System.out.println("NUM : " + num);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
		ActionForward forward = new ActionForward();
		
		
		switch (num) {
		case 2:
			forward.setPath("member_info_Nupdate_form.do");			
			break;
		case 3:
			forward.setPath("member_Ndelete.do");			
			break;

		}
		
		return forward;
	}

}

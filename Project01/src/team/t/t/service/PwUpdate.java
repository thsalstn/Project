package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import team.t.t.dao.LoginDAO;

public class PwUpdate implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("PwUpdate");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String pw = SHA256Util.getEncrypt(request.getParameter("mem_pw"));		
		String str = request.getParameter("str");
		int result = 0;		
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		System.out.println("str" + str);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		LoginDAO dao = LoginDAO.getInstance();
		ActionForward forward = new ActionForward();
		result = dao.pwUpdate(id, pw);
		
		if(result == 1) {
			if(str.equals("1")) {
				forward.setPath("/mypage.do");							
			}else {
				forward.setPath("/loginForm.do");												
			}
		}else {
			out.println("<script>");
        	out.println("alert('업데이트 실패')");
        	out.println("history.go(-1)");
        	out.println("</script>");
        	out.close();
		}
		return forward;
	}

}

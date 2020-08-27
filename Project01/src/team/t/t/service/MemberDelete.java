package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dto.LoginDTO;
import team.t.t.dao.LoginDAO;

public class MemberDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=utf-8 ");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String id = request.getParameter("mem_id");
		System.out.println("아이디 " + id);
		
		
		String pw =SHA256Util.getEncrypt(request.getParameter("mem_pw"));		
		System.out.println("비밀번호" + pw);
    
		LoginDAO dao = LoginDAO.getInstance();
		LoginDTO dto = new LoginDTO();
		
		dto = dao.selectMember(id);

		
		if (pw.equals(dto.getMem_pw())) {

			dao.deleteMember(id);
			session.invalidate();
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		} else {
			
			System.out.println("비밀번호 틀림");
			out.println("<script>");
			// out.println("document.getElementById('mypw').text('ssss')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/loginForm.do");
		return forward;
	}

}

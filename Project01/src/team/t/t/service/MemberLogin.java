package team.t.t.service;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.LoginDAO;
import team.t.t.dao.RecordDAO;
import team.t.t.dto.LoginDTO;

public class MemberLogin implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = -1;
		int num = 0;
		System.out.println("MemberLogin");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8 ");
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();

		String id = request.getParameter("id");
		String pw = SHA256Util.getEncrypt(request.getParameter("pw"));
		String cook = request.getParameter("login-cookie");

		System.out.println("아이디: " + id);
		System.out.println("비밀번호 : " + pw);
		System.out.println("쿠키 정보 " + cook);
		LoginDAO dao = LoginDAO.getInstance();
		LoginDTO dto = new LoginDTO();
		dto = dao.selectMember(id);

		if (!pw.equals(dto.getMem_pw())) {
			request.setAttribute("result", result);
			forward.setPath("/loginForm.do");

		} else {
			RecordDAO rdao = RecordDAO.getInstance();
			num = rdao.getCount(id);
			session.setAttribute("id", id);
			session.setAttribute("name", dto.getMem_name());
			session.setAttribute("social", dto.getMem_social());
			session.setAttribute("record", num);
			if (cook != null) {
				Cookie cookie = new Cookie("id", id);
				cookie.setMaxAge(365 * 24 * 60 * 60);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			
			forward.setPath("/loginSec.do");

		}
		return forward;
	}

}

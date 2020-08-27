package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.LoginDAO;
import team.t.t.dao.RecordDAO;
import team.t.t.dto.LoginDTO;

public class CookLogin implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CookLogin");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8 ");
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		Cookie[] cookie = request.getCookies();
		String id = null;
		int num = 0;
		if (cookie != null) {
			for (Cookie c : cookie) {
				if (c.getName().equals("id")) {

					session.setAttribute("id", c.getValue());
					id = c.getValue();
				}
			}
		}
		LoginDAO dao = LoginDAO.getInstance();
		LoginDTO dto = new LoginDTO();
		dto = dao.selectMember(id);
		RecordDAO rdao = RecordDAO.getInstance();
		num = rdao.getCount(id);
		session.setAttribute("id", id);
		session.setAttribute("name", dto.getMem_name());
		session.setAttribute("social", dto.getMem_social());
		session.setAttribute("record", num);
		System.out.println("쿠키 아이디" + id);
		forward.setPath("/loginSec.do");

		return forward;
	}

}

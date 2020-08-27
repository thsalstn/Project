package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dto.LoginDTO;
import team.t.t.dao.LoginDAO;

public class MemberNDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text.html;charset=utf-8 ");
		HttpSession session = request.getSession();
		String id = request.getParameter("mem_id");
		System.out.println("아이디 " + id);
		LoginDAO dao = LoginDAO.getInstance();

		dao.selectMember(id);
		dao.deleteMember(id);
		session.invalidate();

		ActionForward forward = new ActionForward();
		forward.setPath("/loginForm.do");
		return forward;
	}
}

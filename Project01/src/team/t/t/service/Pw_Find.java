package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;



public class Pw_Find implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Pw_Find");
		HttpSession session = request.getSession();
		int result = 0;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8 ");
		PrintWriter out = response.getWriter();
		LoginDTO dto = new LoginDTO();
		LoginDAO dao = LoginDAO.getInstance();
		String id = request.getParameter("pw_find_auth_id");
		String name = request.getParameter("pw_find_auth_name");
		String email = request.getParameter("pw_find_auth_email");
		dto.setMem_id(id);
		dto.setMem_email(email);
		dto.setMem_name(name);
		result = dao.pw_Select(dto);

		if (result != 1) {
			out.println("<script>");
			out.println("alert('입력된 값이 잘못되었습니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			return null;
		}
		session.setAttribute("id", id);
		request.setAttribute("str",2);
		ActionForward forward = new ActionForward();
		forward.setPath("/content/member_npw_update_form.jsp?");
		return forward;
	}

}

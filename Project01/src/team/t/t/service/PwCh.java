package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dto.LoginDTO;
import team.t.t.dao.LoginDAO;

public class PwCh implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("PwCh");
		String id = request.getParameter("mem_id");
		String pw =SHA256Util.getEncrypt(request.getParameter("mem_pw"));
		int num = Integer.parseInt(request.getParameter("num"));

		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		System.out.println("NUM : " + num);

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		LoginDAO dao = LoginDAO.getInstance();
		LoginDTO dto = new LoginDTO();
		ActionForward forward = new ActionForward();
		dto = dao.selectMember(id);
		
		if (!pw.equals(dto.getMem_pw())) {
			System.out.println("비밀번호 틀림");
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			return null;
		}

		switch (num) {
		case 1:
			forward.setPath("/content/member_npw_update_form.jsp");
					
			break;
		case 2:
			forward.setPath("member_info_update_form.do");
			
			break;
		case 3:
			forward.setPath("member_delete.do");
			
			break;

		}

		return forward;
	}

}

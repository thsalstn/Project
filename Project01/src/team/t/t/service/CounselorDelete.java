package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dto.CounselorLoginDTO;
import team.t.t.dao.CounselorLoginDAO;

public class CounselorDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=utf-8 ");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String cid = request.getParameter("coun_id");
		System.out.println("c아이디 " + cid);
		
		
		String cpw = request.getParameter("coun_pw");		
		System.out.println("c비밀번호" + cpw);
    
		CounselorLoginDAO dao = CounselorLoginDAO.getInstance();
		CounselorLoginDTO dto = new CounselorLoginDTO();
		
		dto = dao.selectCoun(cid);

		
		if (cpw.equals(dto.getCoun_pw())) {

			dao.deleteCoun(cid);
			session.invalidate();
			Cookie cookie = new Cookie("id", cid);
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
		forward.setPath("/cloginForm.do");
		return forward;
	}

}

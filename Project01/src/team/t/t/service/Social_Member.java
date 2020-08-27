package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;

public class Social_Member implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Social_Member");
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
        
		LoginDTO dto = new LoginDTO();
		LoginDAO dao = LoginDAO.getInstance();
		dto.setMem_id((String) request.getAttribute("social_id"));
		dto.setMem_name((String) request.getAttribute("name"));
		dto.setMem_email((String) request.getAttribute("email"));
		dto.setMem_social((Integer) request.getAttribute("mem_social"));
		dao.insertMember(dto);
		forward.setPath("/loginSec.do");
		session.setAttribute("id", dto.getMem_id());
		session.setAttribute("name", dto.getMem_name());
		session.setAttribute("social", dto.getMem_social());
		return forward;
	}

}

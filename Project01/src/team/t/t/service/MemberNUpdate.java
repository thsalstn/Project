package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;

public class MemberNUpdate implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	System.out.println("MemberNUpdate");
	request.setCharacterEncoding("utf-8");     
	LoginDTO dto = new LoginDTO();

	dto.setMem_id(request.getParameter("mem_id"));
    System.out.println(request.getParameter("mem_social"));
	dto.setMem_email(request.getParameter("mem_email1") + "@" + request.getParameter("mem_email2"));
	dto.setMem_social(Integer.parseInt(request.getParameter("mem_social")));

	LoginDAO dao = LoginDAO.getInstance();
	dao.updateNMember(dto);
	
	ActionForward forward = new ActionForward();
	forward.setPath("/mypage.do");
	return forward;
	}

}

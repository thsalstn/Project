package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dto.LoginDTO;
import team.t.t.dao.LoginDAO;

public class MemberUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("MemberUpdate");
		
		request.setCharacterEncoding("utf-8");     
		LoginDTO dto = new LoginDTO();

		dto.setMem_id(request.getParameter("mem_id"));
		dto.setMem_pw(request.getParameter("mem_pw"));
		dto.setMem_name(request.getParameter("mem_name"));
		dto.setMem_post(Integer.parseInt(request.getParameter("mem_post")));
		dto.setMem_addr(request.getParameter("mem_addr1"));
		dto.setMem_addr2(request.getParameter("mem_addr2"));
		dto.setMem_birth(request.getParameter("mem_birth") + "-" + request.getParameter("mem_month") + "-"
				+ request.getParameter("mem_day"));		
		dto.setMem_tel(request.getParameter("mem_tel1") + "-" + request.getParameter("mem_tel2") + "-"
				+ request.getParameter("mem_tel3"));
		dto.setMem_phone(request.getParameter("mem_phone1") + "-" + request.getParameter("mem_phone2") + "-"
				+ request.getParameter("mem_phone3"));
		dto.setMem_email(request.getParameter("mem_email1") + "@" + request.getParameter("mem_email2"));
		dto.setMem_social(Integer.parseInt(request.getParameter("mem_social")));
	
		LoginDAO dao = LoginDAO.getInstance();
		dao.updateMember(dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/mypage.do");
		return forward;
	}

}

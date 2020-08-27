package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dto.CounselorLoginDTO;
import team.t.t.dao.CounselorLoginDAO;


public class cUpdate_Be_Info implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("cUpdate_Be_Info");
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();

		String cid =  (String) session.getAttribute("id");
	
		CounselorLoginDAO dao = CounselorLoginDAO.getInstance();
		CounselorLoginDTO dto = new CounselorLoginDTO();
		dto = dao.selectCoun(cid);
		
		String cb [] = dto.getCoun_birth().split("-");
		String cp [] = dto.getCoun_phone().split("-");
		String ct [] = dto.getCoun_tel().split("-");
		String ce [] = dto.getCoun_email().split("@");
					
		request.setAttribute("counselor", dto);		
		request.setAttribute("phone", cp);
		request.setAttribute("tel", ct);
		request.setAttribute("birth", cb);
		request.setAttribute("email", ce);
		
		
		
		forward.setPath("/content/counselor_update_form.jsp");

		return forward;
	}

}

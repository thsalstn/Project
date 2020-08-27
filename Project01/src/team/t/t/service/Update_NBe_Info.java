package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;

public class Update_NBe_Info implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Update_NBe_Info");
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();

		String id =  (String) session.getAttribute("id");
	

		LoginDAO dao = LoginDAO.getInstance();
		LoginDTO dto = new LoginDTO();
		dto = dao.selectMember(id);
		String e [] = dto.getMem_email().split("@");
					
		request.setAttribute("member", dto);		
		request.setAttribute("email", e);
		
		
		
		forward.setPath("/content/member_Nupdate_form.jsp");

		return forward;
	}

}

package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;

public class Local implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Local");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		LoginDAO dao = LoginDAO.getInstance();
		LoginDTO dto = new LoginDTO();
		dto = dao.selectMember(id);
		String addr[] = dto.getMem_addr().split("\\s");
		System.out.println(addr[0]);
		System.out.println(dto.getMem_addr());
		request.setAttribute("addr", dto.getMem_addr());
		request.setAttribute("addrsub", addr);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/content/local_form.jsp");
		return forward;
	}

}

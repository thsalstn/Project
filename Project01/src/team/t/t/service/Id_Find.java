package team.t.t.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.LoginDAO;
import team.t.t.dto.LoginDTO;



public class Id_Find implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Id_Find");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String name = request.getParameter("id_find_auth_name");
		String email = request.getParameter("id_find_auth_email");
		System.out.println(name);
		System.out.println(email);
            
		LoginDAO dao = LoginDAO.getInstance();
		List<LoginDTO> list = new ArrayList<LoginDTO>();
		list = dao.id_Select(name, email);
		
		session.setAttribute("list", list);
		session.setAttribute("mail", email);

		
		ActionForward forward = new ActionForward();
		forward.setPath("/mailCode.do");
		return forward;
	}

}

package team.t.t.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dto.CounselorLoginDTO;
import team.t.t.dto.LoginDTO;
import team.t.t.dao.CounselorLoginDAO;
import team.t.t.dao.LoginDAO;

public class cId_Pw_Find implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("cId_Pw_Find");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String cname = request.getParameter("cid_pw_find_auth_name");
		String cemail = request.getParameter("cid_pw_find_auth_email");
		System.out.println(cname);
		System.out.println(cemail);
            
		CounselorLoginDAO dao = CounselorLoginDAO.getInstance();
		List<CounselorLoginDTO> clist = new ArrayList<CounselorLoginDTO>();
		clist = dao.coun_id_pw_Select(cname, cemail);
		
		session.setAttribute("list", clist);
		session.setAttribute("mail", cemail);

		
		ActionForward forward = new ActionForward();
		forward.setPath("/content/mailCode.do");
		return forward;
	}

}

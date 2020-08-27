package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dto.CounselorLoginDTO;
import team.t.t.dao.CounselorLoginDAO;

public class cPwCh implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("cPwCh");
		String cid = request.getParameter("coun_id");
		String cpw = request.getParameter("coun_pw");
		int cnum = Integer.parseInt(request.getParameter("cnum"));

		System.out.println("c아이디 : " + cid);
		System.out.println("c비밀번호 : " + cpw);
		System.out.println("cNUM : " + cnum);

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		CounselorLoginDAO dao = CounselorLoginDAO.getInstance();
		CounselorLoginDTO dto = new CounselorLoginDTO();
		ActionForward forward = new ActionForward();
		dto = dao.selectCoun(cid);

		if (!cpw.equals(dto.getCoun_pw())) {
			System.out.println("비밀번호 틀림");
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			return null;
		}

		switch (cnum) {
		case 1:
			forward.setPath("/content/counselor_npw_update_form.jsp");
					
			break;
		case 2:
			forward.setPath("counselor_info_update_form.do");
			
			break;
		case 3:
			forward.setPath("counselor_delete.do");
			
			break;

		}

		return forward;
	}

}

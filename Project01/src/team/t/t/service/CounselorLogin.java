package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.CounselorLoginDAO;
import team.t.t.dto.CounselorLoginDTO;

public class CounselorLogin implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = -1;
		System.out.println("CounselorLogin");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8 ");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();

		String cid = request.getParameter("cid");
		String cpw = SHA256Util.getEncrypt(request.getParameter("cpw"));
		String cCook = request.getParameter("clogin-cookie");

		System.out.println("아이디: " + cid);
		System.out.println("비밀번호 : " + cpw);
		System.out.println("쿠키 정보 " + cCook);
		CounselorLoginDAO dao = CounselorLoginDAO.getInstance();
		CounselorLoginDTO dto = new CounselorLoginDTO();
		dto = dao.selectCoun(cid);

		if (!cpw.equals(dto.getCoun_pw())) {
			request.setAttribute("result", result);
			forward.setPath("/cloginform.do");

		} else {
			LoginManager lm = LoginManager.getInstance();
			if (lm.checkSession(cid) == 1) {
				//forward.setPath("/loginoverlap.do");
				//return forward;
			}
			lm.setSession(session, cid);
			session.setAttribute("id", cid);
			session.setAttribute("name", dto.getCoun_name());
			session.setAttribute("num", 1);

			if (cCook != null) {
				Cookie ccookie = new Cookie("cid", cid);
				ccookie.setMaxAge(365 * 24 * 60 * 60);
				ccookie.setPath("/");
				response.addCookie(ccookie);
			}

			
			
			forward.setPath("/loginSec.do");
		}
		return forward;
	}

}

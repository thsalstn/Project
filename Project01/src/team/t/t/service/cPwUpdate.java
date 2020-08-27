package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.CounselorLoginDAO;

public class cPwUpdate implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("cPwUpdate");
		String cid = request.getParameter("coun_id");
		String cpw = request.getParameter("coun_pw");		
		int result = 0;		
		System.out.println("아이디 : " + cid);
		System.out.println("비밀번호 : " + cpw);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		CounselorLoginDAO dao = CounselorLoginDAO.getInstance();
		ActionForward forward = new ActionForward();
		result = dao.cpwUpdate(cid, cpw);
		
		if(result == 1) {
			
			forward.setPath("/counpage.do");
		}else {
			out.println("<script>");
        	out.println("alert('��й�ȣ ���濡 �����Ͽ����ϴ�')");
        	out.println("history.go(-1)");
        	out.println("</script>");
        	out.close();
		}
        
		return forward;
	}

}

package team.t.t.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.CounselorLoginDAO;

public class cIdCheck implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("cIdCheck");
		
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String cid = request.getParameter("cid");
		System.out.println("cid :" + cid);
		
		
		CounselorLoginDAO dao = CounselorLoginDAO.getInstance();
		int result = dao.CounidCheck(cid);
		System.out.println(result);		
		out.println(result);
		return null ;
	}

}

package team.t.t.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.CommDAO;
import team.t.t.dto.CommDTO;

public class CommList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommList");
		
		int BOAR_NO = Integer.parseInt(request.getParameter("BOAR_NO"));
		String page = request.getParameter("page");
		System.out.println("BOAR_NO:"+BOAR_NO);
		System.out.println("page:"+page);
		
//		댓글 목록 구하기		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");			
		System.out.println("id:"+id);

		
		CommDAO cdao = new CommDAO();

		// 댓글 갯수
		int comm_listcount = cdao.getCount(BOAR_NO);
		System.out.println("comm_listcount : "+comm_listcount);
		
		List<CommDTO> comm_list = cdao.comm_list(BOAR_NO);
		System.out.println("comm_list:"+comm_list);
		
		request.setAttribute("BOAR_NO", BOAR_NO);
		request.setAttribute("page", page);
		request.setAttribute("comm_list", comm_list);
		request.setAttribute("comm_listcount", comm_listcount);
	

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/content/commentList.jsp");
		return forward;
	}

}

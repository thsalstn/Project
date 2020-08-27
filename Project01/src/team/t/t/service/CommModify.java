package team.t.t.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.CommDAO;
import team.t.t.dto.CommDTO;

public class CommModify implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("CommModify");
		
		String page = request.getParameter("page");
		System.out.println("COMM_NO:"+request.getParameter("COMM_NO"));
		System.out.println("COMM_CONT:"+request.getParameter("COMM_CONT"));
		System.out.println("CBOAR_NO:"+request.getParameter("CBOAR_NO"));
		
		CommDTO comm = new CommDTO();
		comm.setCOMM_NO(Integer.parseInt(request.getParameter("COMM_NO")));
		comm.setCOMM_CONT(request.getParameter("COMM_CONT"));
		comm.setCBOAR_NO(Integer.parseInt(request.getParameter("CBOAR_NO")));
		
		CommDAO cdao = new CommDAO();
		int result = cdao.commUpdate(comm); // 댓글 수정
		
		//**************************************************
		int comm_page = 1;
		int start = (comm_page - 1) * 10;
		if(request.getParameter("comm_page")!= null) {
			comm_page = Integer.parseInt(request.getParameter("comm_page"));
		}		

		// 댓글 갯수
		int comm_listcount = cdao.getCount(comm.getCBOAR_NO());
		System.out.println("comm_listcount : "+comm_listcount);		
		
		request.setAttribute("comm_listcount", comm_listcount);
		//****************************************************
		
		List list = cdao.comm_list(comm.getCBOAR_NO());
		request.setAttribute("comm_list", list);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardDetail.do?BOAR_NO="+comm.getCBOAR_NO()+"&page="+page);

		return forward;
	}

}

package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.CommDAO;
import team.t.t.dto.CommDTO;

public class CommInsert implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
//		int BOAR_NO = Integer.parseInt(request.getParameter("BOAR_NO"));
		String page = request.getParameter("page");
//		System.out.println("BOAR_NO:"+BOAR_NO);
		System.out.println("page:"+page);
		
		
		  CommDAO cdao = new CommDAO(); 
		  CommDTO comm = new CommDTO();
		  
		  comm.setMEM_ID(request.getParameter("MEM_ID"));
		  comm.setCOMM_CONT(request.getParameter("COMM_CONT"));
		  comm.setCBOAR_NO(Integer.parseInt(request.getParameter("CBOAR_NO")));
		  
		  System.out.println("CBOAR_NO:"+comm.getCBOAR_NO());
		  System.out.println("MEM_ID:"+comm.getMEM_ID());
		  System.out.println("COMM_CONT:"+comm.getCOMM_CONT());
		  
		  
		  // 댓글입력 
		  int result = cdao.comm_insert(comm); 
		  if(result == 1) {
			  System.out.println("댓글 달기 성공"); 
		  }
		 
		  // request.setAttribute("page", page);
		  
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./BoardDetail.do?BOAR_NO="+comm.getCBOAR_NO()+"&page="+page);
		return forward;
	}
	
}

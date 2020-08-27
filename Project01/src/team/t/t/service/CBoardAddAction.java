package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dao.BoardDAO;
import team.t.t.dto.CBoardDTO;

public class CBoardAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		CBoardDTO cboard = new CBoardDTO();
		cboard.setCOUN_ID(request.getParameter("COUN_ID"));
		cboard.setCBOAR_TITLE(request.getParameter("CBOAR_TITLE"));
		cboard.setCBOAR_CONT(request.getParameter("CBOAR_CONT"));
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.cboardinsert(cboard);
		if(result == 1) {
			System.out.println("*** insert 완료 ***");
		}else {
			System.out.println("*** insert 실패 ***");
			System.out.println("result: " + result);
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./CBoardList.do");		
		
		return forward;
	}

}

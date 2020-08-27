package team.t.t.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.RecordDAO;
import team.t.t.dto.RecordDTO;

public class Record implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = null;
		HttpSession session = request.getSession();
		int page = 1;			// 현재 페이지 번호
		int limit = 10;			// 한 화면에 출력할 데이터 갯수
		int sum = 0;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		
		id = (String)session.getAttribute("id");

		RecordDAO dao = new RecordDAO();
		
		int listcount = dao.getCount(id);
		
		int pageCount =listcount/limit + ((listcount%limit==0) ? 0 : 1);
		
		int startPage = ((page - 1)/10) * limit + 1;  // 1,  11, 21,...
		int endPage = startPage + 10 - 1 ;			  // 10, 20, 30,...
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		
		//페이지 이동 및 데이터 이동
		List<RecordDTO> list = dao.list(id, startRow, endRow);
		List<Integer> count = dao.countrecord(id);
		
		for(int s : count) {
			sum += s;
		}
		
		int MBTI = count.get(0);
		int stress = count.get(1);
		int depression = count.get(2);
		int alcohol = count.get(3);
		int game = count.get(4);
		
		request.setAttribute("sum", sum);
		request.setAttribute("MBTI", MBTI);
		request.setAttribute("stress", stress);
		request.setAttribute("depression", depression);
		request.setAttribute("alcohol", alcohol);
		request.setAttribute("game", game);
		request.setAttribute("recordlist", list);
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/content/record.jsp");
		//페이지 이동 및 데이터 이동
		return forward;
	}
}
package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Resultsee implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int check = Integer.parseInt(request.getParameter("check"));
		String point = request.getParameter("point");
		String map = "/WEB-INF/views/result/";
		
		if(check == 1) {
			map += "MBTI";
		}else if(check == 2) {
			map += "stress";
		}else if(check == 3) {
			map += "depression";
		}else if(check == 4) {
			map += "alcohol";
		}else if(check == 5) {
			map += "game";
		}
		
		map += point;
		map += ".jsp";
		
		System.out.println(map);
		//페이지 이동 및 데이터 이동
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath(map);
		//페이지 이동 및 데이터 이동
		return forward;
	}
}
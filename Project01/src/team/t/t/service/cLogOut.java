package team.t.t.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class cLogOut implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    
		System.out.println("cLogOut");
		HttpSession session = request.getSession();
		session.invalidate();
		
		Cookie[] cookie = request.getCookies();
		
		if(cookie != null) {
			for(Cookie c : cookie) {
				
				if(c.getName().equals("cid")) {
					c.setMaxAge(0);
					c.setPath("/");
					response.addCookie(c);
				}
			}
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("/Main.do");
		return forward;
	}

}

package team.t.t.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KakaoLogOut implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("KakaoLogOut");
		 HttpSession session = request.getSession();
		 String token =(String) session.getAttribute("token");
		 System.out.println(token);
		 String apiURL ="https://kapi.kakao.com/v1/user/logout";
		
		 try {
			 String header = "Bearer "+token; 
			 URL url = new URL(apiURL);
			 HttpURLConnection con =(HttpURLConnection)url.openConnection();
			 con.setRequestMethod("POST");
			 con.setRequestProperty("Authorization", header);
			 
			 int responseCode = con.getResponseCode();
			 
			 BufferedReader br = null;
			 System.out.println("responseCode"+responseCode);
			 if(responseCode == 200) {
				 br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			 }
			 String inputLine;
			 StringBuffer sb = new StringBuffer();
			 if((inputLine = br.readLine()) != null) {
				 sb.append(inputLine);
			 }
			 br.close();
			System.out.println(sb);
			 
		 }catch (Exception e) {
			// TODO: handle exception
		}
		
			ActionForward forward = new ActionForward();
			forward.setPath("/logOut.do");
 		return forward;
	}

}

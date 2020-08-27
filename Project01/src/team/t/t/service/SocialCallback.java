package team.t.t.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class SocialCallback implements Action {

	public String access_token = "";
	public String refresh_token = "";

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("SocialCallback");
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		
		
		
		String clientId = "COB9GO2ONu4VeTkUjkmY";
		String clientSecret = "4v19vJfJF7";
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String redirectURI = URLEncoder.encode("http://15.164.165.19:8080/Project01/naverLogin.do", "UTF-8");
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;

		String st = (String) session.getAttribute("token");
		
		System.out.println("네이버 세션 토큰 값 :" + st);
		if (st == null) {
			try {
				URL url = new URL(apiURL);

				HttpURLConnection con = (HttpURLConnection) url.openConnection();

				con.setRequestMethod("GET");
				int responseCode = con.getResponseCode();
				BufferedReader br;
				System.out.println("responseCode=" + responseCode);
				if (responseCode == 200) {
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				} else {
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}

				String inputLine;
				StringBuffer sb = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {

					sb.append(inputLine);
				}
				br.close();
				if (responseCode == 200) {

					JSONParser parsing = new JSONParser();
					JSONObject jsonobj = (JSONObject) parsing.parse(sb.toString());

					access_token = (String) jsonobj.get("access_token");
					refresh_token = (String) jsonobj.get("refresh_token");

					request.setAttribute("access_token", access_token);
					request.setAttribute("refresh_token", refresh_token);

				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}else {
			request.setAttribute("access_token", st);
			
		}
		
		forward.setPath("/naverinfo.do");
		return forward;
	}

}
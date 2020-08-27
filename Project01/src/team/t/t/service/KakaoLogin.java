package team.t.t.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class KakaoLogin implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("KakaoLogin");

		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		
		String code = request.getParameter("code");
		String access_token = "";
		String refresh_token = "";
		String apiURL = "https://kauth.kakao.com/oauth/token";
		String st = (String) session.getAttribute("access_token");
		
		System.out.println("카카오세션 토큰 값 :" + st);
		if (st == null) {
			try {

				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				con.setDoOutput(true);

				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
				StringBuilder sb = new StringBuilder();
				sb.append("grant_type=authorization_code");
				sb.append("&client_id=6c5e0f5424602dd8ffaff610fa2940f7");
				sb.append("&redirect_uri=http://15.164.165.19:8080/Project01/kakaologin.do");
				sb.append("&code=" + code);
				bw.write(sb.toString());
				bw.flush();

				int responseCode = con.getResponseCode();

				BufferedReader br;
				if (responseCode == 200) {
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				} else {
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				String inputLine = "";
				String result = "";

				while ((inputLine = br.readLine()) != null) {
					result += inputLine;
				}
				br.close();
				bw.close();

				JSONParser parsing = new JSONParser();
				JSONObject jsonobj = (JSONObject) parsing.parse(result);
                 
				access_token = (String) jsonobj.get("access_token");
				System.out.println("로그인 토큰 : " +access_token);
				refresh_token = (String) jsonobj.get("refresh_token");
				request.setAttribute("access_token", access_token);
				request.setAttribute("refresh_token", refresh_token);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			request.setAttribute("access_token", st);
			
		}
		
		forward.setPath("/kakaoinfo.do");
		return forward;
	}

}

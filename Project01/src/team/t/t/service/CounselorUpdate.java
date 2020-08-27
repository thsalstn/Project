package team.t.t.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.t.t.dto.CounselorLoginDTO;
import team.t.t.dao.CounselorLoginDAO;

public class CounselorUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("CounselorUpdate");
		
		request.setCharacterEncoding("utf-8");     
		CounselorLoginDTO dto = new CounselorLoginDTO();

		dto.setCoun_id(request.getParameter("coun_id"));
		dto.setCoun_pw(request.getParameter("coun_pw"));
		dto.setCoun_name(request.getParameter("coun_name"));
		dto.setCoun_post(request.getParameter("coun_post"));
		dto.setCoun_addr(request.getParameter("coun_addr1"));
		dto.setCoun_addr2(request.getParameter("coun_addr2"));
		dto.setCoun_birth(request.getParameter("coun_birth") + "-" + request.getParameter("coun_month") + "-"
				+ request.getParameter("coun_day"));		
		dto.setCoun_tel(request.getParameter("Coun_tel1") + "-" + request.getParameter("Coun_tel2") + "-"
				+ request.getParameter("coun_tel3"));
		dto.setCoun_phone(request.getParameter("coun_phone1") + "-" + request.getParameter("coun_phone2") + "-"
				+ request.getParameter("coun_phone3"));
		dto.setCoun_email(request.getParameter("coun_email1") + "@" + request.getParameter("coun_email2"));
		dto.setCoun_dept(request.getParameter("coun_dept"));
		System.out.println(dto.getCoun_id());
		System.out.println(dto.getCoun_pw());
		System.out.println(dto.getCoun_name());
		System.out.println(dto.getCoun_birth());
		System.out.println(dto.getCoun_tel());
		System.out.println(dto.getCoun_phone());
		System.out.println(dto.getCoun_post());
		System.out.println(dto.getCoun_addr());
		System.out.println(dto.getCoun_addr2());
		System.out.println(dto.getCoun_email());
		CounselorLoginDAO dao = CounselorLoginDAO.getInstance();
		dao.updateCounselor(dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/counselorpage.do");
		return forward;
	}

}

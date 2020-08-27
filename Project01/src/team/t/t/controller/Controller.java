package team.t.t.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.dao.CounselorLoginDAO;
import team.t.t.dao.LoginDAO;
import team.t.t.dto.CounselorLoginDTO;
import team.t.t.dto.LoginDTO;
import team.t.t.service.Action;
import team.t.t.service.ActionForward;
import team.t.t.service.Alcohol;
import team.t.t.service.Alcoholcheck;
import team.t.t.service.BoardDelete;
import team.t.t.service.BoardDetail;
import team.t.t.service.BoardList;
import team.t.t.service.BoardModify;
import team.t.t.service.BoardModifyForm;
import team.t.t.service.BoardWrite;
import team.t.t.service.CBoardAddAction;
import team.t.t.service.CBoardDelete;
import team.t.t.service.CBoardDetail;
import team.t.t.service.CBoardList;
import team.t.t.service.CBoardModify;
import team.t.t.service.CBoardModifyAction;
import team.t.t.service.CBoardWrite;
import team.t.t.service.CodeCheck;
import team.t.t.service.CommDelete;
import team.t.t.service.CommInsert;
import team.t.t.service.CommList;
import team.t.t.service.CommModify;
import team.t.t.service.CookLogin;
import team.t.t.service.Counselor;
import team.t.t.service.CounselorDelete;
import team.t.t.service.CounselorLogin;
import team.t.t.service.CounselorUpdate;
import team.t.t.service.Depression;
import team.t.t.service.Depressioncheck;
import team.t.t.service.Game;
import team.t.t.service.Gamecheck;
import team.t.t.service.GoogleInfo;
import team.t.t.service.GoogleToken;
import team.t.t.service.IdCheck;
import team.t.t.service.Id_Find;
import team.t.t.service.KakaoInfo;
import team.t.t.service.KakaoLogOut;
import team.t.t.service.KakaoLogin;
import team.t.t.service.Local;
import team.t.t.service.LogOut;
import team.t.t.service.MBTI;
import team.t.t.service.MBTIcheck;
import team.t.t.service.MailCode;
import team.t.t.service.Member;
import team.t.t.service.MemberDelete;
import team.t.t.service.MemberLogin;
import team.t.t.service.MemberNDelete;
import team.t.t.service.MemberNUpdate;
import team.t.t.service.MemberUpdate;
import team.t.t.service.Member_EmailCh;
import team.t.t.service.MyWrite;
import team.t.t.service.NaverInfo;
import team.t.t.service.PwCh;
import team.t.t.service.PwUpdate;
import team.t.t.service.Pw_Find;
import team.t.t.service.Record;
import team.t.t.service.Recorddetail;
import team.t.t.service.Resultsee;
import team.t.t.service.SocialCallback;
import team.t.t.service.SocialLogin;
import team.t.t.service.Social_Member;
import team.t.t.service.Stress;
import team.t.t.service.Stresscheck;
import team.t.t.service.Update_Be_Info;
import team.t.t.service.Update_NBe_Info;
import team.t.t.service.cIdCheck;
import team.t.t.service.cLogOut;
import team.t.t.service.cPwCh;
import team.t.t.service.cPwUpdate;
import team.t.t.service.cUpdate_Be_Info;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("requestURI: " + requestURI);
		System.out.println("contextPath: " + contextPath);
		System.out.println("command: " + command);

		Action action = null;
		ActionForward forward = null;
		// 게시판 목록
		if (command.equals("/BoardList.do")) {
			try {
				action = new BoardList();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 게시판 글
		} else if (command.equals("/BoardWrite.do")) {
			try {
				action = new BoardWrite();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 게시판 폼
		} else if (command.equals("/BoardForm.do")) {

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/content/boardform.jsp");
			// 상세페이지
		} else if (command.equals("/BoardDetail.do")) {
			try {
				action = new BoardDetail();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 댓글 갯수 + 목록
		} else if (command.equals("/CommList.do")) {
			try {
				action = new CommList();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 댓글 입력
		} else if (command.equals("/CommInsert.do")) {
			try {
				action = new CommInsert();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 게시판 수정폼
		} else if (command.equals("/BoardModifyForm.do")) {
			try {
				action = new BoardModifyForm();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 게시판 수정
		} else if (command.equals("/BoardModify.do")) {
			try {
				action = new BoardModify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 게사판 삭제
		} else if (command.equals("/BoardDelete.do")) {
			try {
				action = new BoardDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 댓글
		} else if (command.equals("/CommModify.do")) {
			try {
				action = new CommModify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 댓글 삭제
		} else if (command.equals("/CommDelete.do")) {
			try {
				action = new CommDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 검사 페이지
		} else if (command.equals("/CheckList.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/content/psychological.jsp");
			// 메인 페이지
		} else if (command.equals("/Main.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/content/main.jsp");
			// 심리검사 페이지
		} else if (command.equals("/MBTI.do")) {
			try {
				action = new MBTI();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Stress.do")) {
			try {
				action = new Stress();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Depression.do")) {
			try {
				action = new Depression();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Alcohol.do")) {
			try {
				action = new Alcohol();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Game.do")) {
			try {
				action = new Game();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 심리검사 페이지
			// 심리검사 결과 페이지
		} else if (command.equals("/MBTIcheck.do")) {
			try {
				action = new MBTIcheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Stresscheck.do")) {
			try {
				action = new Stresscheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Depressioncheck.do")) {
			try {
				action = new Depressioncheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Alcoholcheck.do")) {
			try {
				action = new Alcoholcheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Gamecheck.do")) {
			try {
				action = new Gamecheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 심리검사 결과 페이지
			// 결과 페이지
		} else if (command.equals("/Record.do")) {
			try {
				action = new Record();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 결과 상세 페이지
		} else if (command.equals("/Recorddetail.do")) {
			try {
				action = new Recorddetail();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/resultsee.do")) {
			try {
				action = new Resultsee();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 상담사 게시판 목록
		} else if (command.equals("/CBoardList.do")) {
			try {
				action = new CBoardList();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 게시판 상세페이지
		} else if (command.equals("/CBoardDetail.do")) {
			try {
				action = new CBoardDetail();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 글작성 폼
		} else if (command.equals("/CBoardForm.do")) {
			try {
				action = new CBoardWrite();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 글작성
		} else if (command.equals("/CBoardAddAction.do")) {
			try {
				action = new CBoardAddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 글 수정 폼
		} else if (command.equals("/CBoardModifyAction.do")) {
			try {
				action = new CBoardModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 글 수정
		} else if (command.equals("/CBoardModify.do")) {
			try {
				action = new CBoardModify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 삭제 폼
		} else if (command.equals("/CBoardDeleteAction.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/content/cboard_delete.jsp");
			// 게시글 삭제
		} else if (command.equals("/CBoardDelete.do")) {
			try {
				action = new CBoardDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 댓글 폼
		}

		// 로그인 폼
		if (command.equals("/loginForm.do")) {
			try {
				action = new SocialLogin();
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 로그인
		if (command.equals("/login.do")) {
			try {

				action = new MemberLogin();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 쿠키 로그인
		if (command.equals("/cooklogin.do")) {
			try {
				action = new CookLogin();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 로그인 성공시 로그인 페이지로 이동
		if (command.equals("/loginSec.do")) {

			forward = new ActionForward();
			forward.setPath("/content/main.jsp");

		}
		// 네이버 로그인
		if (command.equals("/naverLogin.do")) {
			try {
				action = new SocialCallback();
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 네이버 정보
		if (command.equals("/naverinfo.do")) {
			try {
				action = new NaverInfo();
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 카카오 로그인
		if (command.equals("/kakaologin.do")) {
			try {
				action = new KakaoLogin();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 카카오 정보
		if (command.equals("/kakaoinfo.do")) {
			try {
				action = new KakaoInfo();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // 카카오 로그아웃
		if (command.equals("/kakaologOut.do")) {
			try {
				action = new KakaoLogOut();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 구글 로그인
		if (command.equals("/googleinfo.do")) {
			try {
				action = new GoogleInfo();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// 구글 로그인
		if (command.equals("/googleLogin.do")) {
			try {
				action = new GoogleToken();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// 인증 메일 폼
		if (command.equals("/mailcheck.do")) {
			try {
				request.setAttribute("mail", request.getParameter("mail"));
				forward = new ActionForward();
				forward.setPath("/content/memberAuth.jsp");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 메일 인증 코드 발송
		if (command.equals("/mailCode.do")) {
			try {
				action = new MailCode();
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 메일 인증코드를 체크 함
		if (command.equals("/codeCheck.do")) {
			try {
				action = new CodeCheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// 회원 가입 이용약관
		if (command.equals("/memberform_join.do"))
			try {

				forward = new ActionForward();
				forward.setPath("/content/member_join_treaty.jsp");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// 회원 가입 폼
		if (command.equals("/memberform.do"))
			try {

				forward = new ActionForward();
				forward.setPath("/content/memberform.jsp");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		// 회원가입
		if (command.equals("/member.do"))
			try {
				action = new Member();
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// 소셜 회원가입
		if (command.equals("/social_member.do"))
			try {
				action = new Social_Member();
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// 아이디 중복검사
		if (command.equals("/idCheck.do")) {

			try {
				action = new IdCheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// 로그아웃
		if (command.equals("/logOut.do")) {
			try {
				action = new LogOut();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 접속 아이디 종류 구분
		if (command.equals("/member_pw_ck_form.do")) {
			try {

				HttpSession session = request.getSession();
				int num = (Integer) session.getAttribute("social");

				forward = new ActionForward();
				if (num == 1) {
					forward.setPath("/content/member_pw_ck_form.jsp");
				} else {
					LoginDAO dao = LoginDAO.getInstance();
					LoginDTO dto = dao.selectMember((String) session.getAttribute("id"));
					String e[] = dto.getMem_email().split("@");

					request.setAttribute("email", e);
					forward.setPath("/content/member_Ndelete_form.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// 마이 페이지 폼
		if (command.equals("/mypage.do")) {
			try {

				forward = new ActionForward();
				forward.setPath("/content/mypageform.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 내 정보 수정 폼
		if (command.equals("/member_info_update_form.do")) {
			try {
				action = new Update_Be_Info();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (command.equals("/member_info_Nupdate_form.do")) {
			try {
				action = new Update_NBe_Info();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 내 정보 수정
		if (command.equals("/member_update.do")) {
			try {
				action = new MemberUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (command.equals("/member_Nupdate.do")) {
			try {
				action = new MemberNUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 현재 비밀번호로 본인 확인 (체크)
		if (command.equals("/member_pw_ck.do")) {
			try {
				action = new PwCh();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (command.equals("/member_EmailCh.do")) {
			try {
				action = new Member_EmailCh();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 비밀번호 업데이트
		if (command.equals("/member_pw_update.do")) {
			try {

				action = new PwUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 내 게시판 쓴 목록
				if (command.equals("/my_write.do")) {
					try {

						action = new MyWrite();
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		// 내 주위 상담소
		if (command.equals("/local.do")) {
			try {

				action = new Local();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 아이디 찾기 폼
		if (command.equals("/id_find_form.do")) {
			try {
				forward = new ActionForward();
				forward.setPath("/content/id_find_form.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 아이디 찾기
		if (command.equals("/id_find.do")) {
			try {
				action = new Id_Find();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 비밀번호 찾기 폼
		if (command.equals("/pw_find_form.do")) {
			try {
				forward = new ActionForward();
				forward.setPath("/content/pw_find_form.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 비밀번호 찾기
		if (command.equals("/pw_find.do")) {
			try {
				action = new Pw_Find();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 회원 탈퇴
		if (command.equals("/member_delete.do")) {
			try {
				action = new MemberDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (command.equals("/member_Ndelete.do")) {
			try {
				action = new MemberNDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (command.equals("/inproduce.do")) {
			try {
				forward = new ActionForward();				
				forward.setPath("/content/inproduce.jsp");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// --------------------------------------------------------------------------------------//
		// counselor login 폼
		if (command.equals("/cloginform.do")) {
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/content/cloginform.jsp");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// counselor 로그인
		if (command.equals("/clogin.do")) {
			try {
				action = new CounselorLogin();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 로그인 성공시 로그인 페이지로 이동(counselor)
		if (command.equals("/cloginSec.do")) {

			forward = new ActionForward();
			forward.setPath("/Main.do");

		}
		// 회원 가입 이용약관(counselor)
		if (command.equals("/counselorform_join.do")) {
			try {

				forward = new ActionForward();
				forward.setPath("/content/counselor_join_treaty.jsp");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// counselor 가입 폼
		if (command.equals("/counselorform.do")) {
			try {

				forward = new ActionForward();
				forward.setPath("/content/counselorform.jsp");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// c회원가입
		if (command.equals("/counselor.do")) {
			try {
				action = new Counselor();
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// c아이디 중복검사
		if (command.equals("/cidCheck.do")) {

			try {
				action = new cIdCheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// counselor로그아웃
		if (command.equals("/clogOut.do")) {
			try {
				action = new cLogOut();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// counselor 마이 페이지 폼
		if (command.equals("/counselorpage.do")) {
			try {

				forward = new ActionForward();
				forward.setPath("/Main.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// counselor 정보 수정 폼
		if (command.equals("/counselor_info_update_form.do")) {
			try {
				action = new cUpdate_Be_Info();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// counselor 정보 수정
		if (command.equals("/counselor_update.do")) {
			try {
				action = new CounselorUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// counselor비밀번호 변경 폼
		if (command.equals("/counselor_pw_ck_form.do")) {
			try {

				HttpSession session = request.getSession();
				String num = (String) session.getAttribute("social");
				System.out.println(session.getAttribute("social"));
				forward = new ActionForward();
				if (num.equals("1")) {
					forward.setPath("/content/counselor_pw_ck_form.jsp");
				} else {
					CounselorLoginDAO dao = CounselorLoginDAO.getInstance();
					CounselorLoginDTO dto = dao.selectCoun((String) session.getAttribute("cid"));
					String e[] = dto.getCoun_email().split("@");
					request.setAttribute("email", e);
					forward.setPath("/content/counselor_Ndelete_form.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// counselor 현재 비밀번호로 본인 확인 (체크)
		if (command.equals("/counselor_pw_ck.do")) {
			try {
				action = new cPwCh();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// counselor 비밀번호 업데이트
		if (command.equals("/counselor_pw_update.do")) {
			try {

				action = new cPwUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// counselor 아이디나 비밀번호 찾기 폼
		if (command.equals("/cid_pw_find_form.do")) {
			try {
				forward = new ActionForward();
				forward.setPath("/content/cid_pw_find_form.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Counselor 아이디 비밀번호 찾기
		if (command.equals("/cid_pw_find.do")) {
			try {
				forward = new ActionForward();
				forward.setPath("/cid_pw_find.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Counselor 회원 탈퇴 폼
		if (command.equals("/counselor_delete_form.do")) {
			try {
				HttpSession session = request.getSession();
				String num = (String) session.getAttribute("dept");
				System.out.println(session.getAttribute("dept"));
				forward = new ActionForward();
				if (num.equals("1")) {
					forward.setPath("/content/counselor_delete_form.jsp");
				} else {
					CounselorLoginDAO dao = CounselorLoginDAO.getInstance();
					CounselorLoginDTO dto = dao.selectCoun((String) session.getAttribute("cid"));
					String e[] = dto.getCoun_email().split("@");
					request.setAttribute("email", e);
					forward.setPath("/content/counselor_Ndelete_form.jsp");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// counselor 탈퇴
		if (command.equals("/counselor_delete.do")) {
			try {
				action = new CounselorDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) { // redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			} else { // dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	} // doProcess() end

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("get");
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("post");
		process(request, response);

	}

}

package com.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.project.member.model.excetion.MemberException;
import com.kh.project.member.model.service.MemberService;
import com.kh.project.member.model.vo.Member;

@SessionAttributes("loginUser")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@RequestMapping(value="loginView.me", method=RequestMethod.GET)
	public String loginView() {

		return "login";
	}
	/***********파라미터 전송 방식***************/
//	1. jsp/servlet 방식 : HttpServletRequest이용	
//	@RequestMapping(value="login.me",method=RequestMethod.POST)
//	public String login(HttpServletRequest request) {
//		
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		
//		System.out.println(id);
//		System.out.println(pwd);
//		
//		return null;
//	}
//	2. @RequestParam이용
//	@RequestMapping(value="login.me",method=RequestMethod.POST)
//	public String login(@RequestParam(value="id",defaultValue="hello") String id,@RequestParam("pwd") String pwd,
//			@RequestParam(value="test",required=false) String test) {
//		System.out.println(id + pwd);
//		
//		return null;
//	}
//	
////	3. @RequestParam 생략	
//	@RequestMapping(value="login.me",method=RequestMethod.POST)
//	public String login(String id,String pwd,
//			@RequestParam(value="test",required=false) String test) {
//		System.out.println(id + pwd);
//		
//		return null;
//	}
//	
//		4.@ModelAttribute이용 
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public String login(@ModelAttribute Member m) {
//		System.out.println(m);
//		return null;
//	}
//		5.@ModelAttribute 생략
//
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public String login(Member m) {
//		//결합도가 높다 확인하기
//		//1. 매 요청마다 새로운 객체가 만들어짐
//		//2. 클래스 명을 변경할 때 직접적인 영향을 받음
//		Member loginUser =mService.login(m);
//		
//		
//		return null;
//	}
//
	/*부에 데이터를 전달하는 방법*/
////	1. Model 사용
//	@RequestMapping(value="login.me",method=RequestMethod.POST)
//	public String login(Member m, Model model,HttpSession session ) {
//		Member loginUser =mService.login(m);
//		if(loginUser !=null) {
//			session.setAttribute("loginUser", loginUser);
//			return "../home";
//		}else {
//			model.addAttribute("msg", "로그인 실패 ");
//			return "../common/errorPage";
//		}
//	}
//	
//
//		2.ModelAndView 사용 :Model + view	
	
//	@RequestMapping(value="login.me",method=RequestMethod.POST)
//	public ModelAndView login(Member m, ModelAndView mv,HttpSession session ) {
//		Member loginUser =mService.login(m);
//		if(loginUser !=null) {
//			session.setAttribute("loginUser", loginUser);
//			mv.setViewName("redirect:home.do");
//			
//			
//			return mv;
//		}else {
//			mv.addObject("msg","로그인 실패");
//			mv.setViewName("../common/errorPage");
//		}
//		return mv;
//	}
	
//  3. session에 저장할 떄 @SessionAttributes 사용	
//	@RequestMapping(value="login.me",method=RequestMethod.POST)
//	public String login(Member m, Model model ) {
//		Member loginUser =mService.login(m);
//		if(loginUser !=null) {
//			model.addAttribute("loginUser", loginUser);
//			return "redirect:home.do";
//			
//		}else {
////			model.addAttribute("msg","로그인 실패");
////			return "../common/errorPage";
//			
//			throw new MemberException("로그인에 실패하였습니다.");
//		}
//	}
//	@RequestMapping("logout.me")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:home.do";
//	} SessionAttribute 어노테이션을 사용하면 위의 코드로는 세션아웃이 안됨.
	
	//세션 등록을 어노테이션으로 사용할 경우 위의 방법으로 세션 아웃을 시켜야 함!
	@RequestMapping("logout.me")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:home.do";
	}
	//회원가입 페이지 이동
	@RequestMapping("enroll.me")
	public String enroll() {
		return "enroll";
	}
	
	
	//암호화 후 로그인
	@RequestMapping(value="login.me",method=RequestMethod.POST)
	public String login(Member m, Model model ) {
		Member loginUser =mService.login(m);
		
		System.out.println(bcrypt.encode(m.getPwd()));
		
		if(bcrypt.matches(m.getPwd(), loginUser.getPwd())) {
			model.addAttribute("loginUser", loginUser);
			return "redirect:home.do";
			
		}else {
//			model.addAttribute("msg","로그인 실패");
//			return "../common/errorPage";
			
			throw new MemberException("로그인에 실패하였습니다.");
		}
	}
	
	
	@RequestMapping("insertMember.me")
	public String insertMember(@ModelAttribute Member m,@RequestParam("emailId") String emailId,@RequestParam("emailDomain") String emailDomain ) {
		System.out.println(m);
		//부족한 부분 n가지
		//1. 한글깨짐
		//2. 이메일 null
		//3. 평문 비밀번호 노출
		
		String email=null;
		if(!emailId.trim().equals("")) {
			email=emailId+"@"+emailDomain;
		}
		m.setEmail(email);
		String encPwd=bcrypt.encode(m.getPwd());
		m.setPwd(encPwd);
		int result = mService.insertMember(m);
		if(result>0) {
			return "redirect:home.do";
		}else {
			throw new MemberException("회원가입실패");
		}
		
	}
	
	
	
}

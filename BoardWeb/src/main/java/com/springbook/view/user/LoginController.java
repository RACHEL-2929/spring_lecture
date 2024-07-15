package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@GetMapping("/login.do")
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("test1234");
		return "login.jsp";
	}
	@PostMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}
		else
			return "login.jsp";
	}

	/*@Override public ModelAndView handleRequest(HttpServletRequest request,
	  HttpServletResponse response) { System.out.println("�α��� ó��");
	  
	  //1. ����� �Է� ���� ���� String id = request.getParameter("id"); String password =
	  request.getParameter("password");
	  
	  //2. DB ���� ó�� UserVO vo = new UserVO(); vo.setId(id);
	  vo.setPassword(password);
	  
	  UserDAO userDAO = new UserDAO(); UserVO user = userDAO.getUser(vo);
	  
	  //3. ȭ�� �׺���̼� ModelAndView mav = new ModelAndView(); if(user != null) {
	  mav.setViewName("redirect:getBoardList.do"); }else

	{
		mav.setViewName("login.jsp");
	}return mav;
}*/

}
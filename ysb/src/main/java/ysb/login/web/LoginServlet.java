package ysb.login.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

import ysb.ddit.encrypt.kisa.seed.KISA_SEED_CBC;
import ysb.login.service.LoginService;
import ysb.login.service.LoginServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//post방식일때 인코딩 
		response.setContentType("text/html; charset=utf-8");
		
		LoginServiceInf loginService = new LoginService();
		Map<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("std_id", request.getParameter("std_id"));
		loginInfo.put("pass", request.getParameter("pass"));
		HttpSession session = request.getSession();
		
		boolean b = false; //나중에 로그인 실패하면 그런 사람 없다고 알려주고싶어서 일단 만들어보는 boolean 변수
		if(b = loginService.getStudent(loginInfo)){
			session.setAttribute("std_id", request.getParameter("std_id"));
			request.getServletContext().setAttribute("boardList", loginService.getBoardList());
			request.getRequestDispatcher("/main/main.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
	}
}

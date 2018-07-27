package ysb.board.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ysb.board.service.BoardService;
import ysb.board.service.BoardServiceInf;
import ysb.login.service.LoginService;
import ysb.model.PostsVo;

/**
 * Servlet implementation class ViewBoardServlet
 */
@WebServlet("/viewBoard")
public class ViewBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf bService = new BoardService();
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		Map<String, Object> pageMap = new HashMap<String, Object>();
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int pageSize = request.getParameter("pageSize")==null?10:Integer.parseInt(request.getParameter("pageSize"));
		pageMap.put("page", page);
		pageMap.put("pageSize", pageSize);
		pageMap.put("board_title", request.getParameter("board_title"));
		pageMap.put("board_id", board_id);
		Map<String, Object> resultMap = bService.getPostsList(pageMap);
		List<PostsVo> postsList = (List<PostsVo>)resultMap.get("postsList");
		String pageNavi = (String)resultMap.get("pageNavi");
		request.setAttribute("postsList", postsList);
		request.setAttribute("pageNavi", pageNavi);
		request.setAttribute("board_title", request.getParameter("board_title"));
		request.setAttribute("board_id", request.getParameter("board_id"));
		request.getRequestDispatcher("/board/viewBoard.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//post방식일때 인코딩 
		response.setContentType("text/html; charset=utf-8");
		doGet(request, response);
	}

}

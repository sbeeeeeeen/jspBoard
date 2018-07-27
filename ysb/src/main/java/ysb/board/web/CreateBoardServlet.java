package ysb.board.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ysb.board.service.BoardService;
import ysb.board.service.BoardServiceInf;
import ysb.login.service.LoginService;

/**
 * Servlet implementation class CreateBoard
 */
@WebServlet("/createBoard")
public class CreateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		BoardServiceInf bService = new BoardService();
		
		Map<String, Object> board = new HashMap<String, Object>();
		board.put("board_id", Integer.parseInt(request.getParameter("board_id")==""?"0":request.getParameter("board_id")));
		board.put("board_title", request.getParameter("title"));
		board.put("board_status", request.getParameter("selectUse"));
		String buttonType = request.getParameter("buttonType");
		if(buttonType.equals("insert")){
			bService.insertBoard(board);
		}else if(buttonType.equals("update")){
			bService.updateBoard(board);
		}
		request.getServletContext().setAttribute("boardList", new LoginService().getBoardList());
		response.sendRedirect("/board/createBoard.jsp");
	}


}

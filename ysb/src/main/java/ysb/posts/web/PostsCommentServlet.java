package ysb.posts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ysb.model.PostsCommentVo;
import ysb.model.PostsVo;
import ysb.posts.service.PostsService;
import ysb.posts.service.PostsServiceInf;

/**
 * Servlet implementation class PostsCommentServlet
 */
@WebServlet("/postsComment")
public class PostsCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostsServiceInf pService = new PostsService();
		int posts_id = Integer.parseInt(request.getParameter("posts_id"));
		request.setAttribute("posts_id", request.getParameter("posts_id"));
		request.setAttribute("board_id", request.getParameter("board_id"));
		request.setAttribute("board_title", request.getParameter("board_title"));
		
		String division = request.getParameter("division");
		if(division.equals("insertcom")){
			PostsCommentVo com = new PostsCommentVo();
			String com_content = request.getParameter("comContent");
			com.setCom_content(com_content.length()>500?com_content.substring(0, 500):com_content);
			com.setPosts_id(posts_id);
			com.setStd_id((String)request.getSession().getAttribute("std_id"));
			com.setCom_status("Y");
			pService.insertPostsComment(com);
		}else if(division.equals("deletecom")){
			pService.updatePostsComment(Integer.parseInt(request.getParameter("com_id")));
		}else if(division.equals("postsDelete")){
			pService.deletePosts(posts_id);
			request.getRequestDispatcher("/viewBoard").forward(request, response);
			return;
		}else if(division.equals("rePostWrite")){
			request.setAttribute("posts", pService.getPostsInfo(posts_id));
			request.setAttribute("division", "re");
			request.getRequestDispatcher("/posts/postsWrite.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/postsDetail").forward(request, response);
	}
       
}

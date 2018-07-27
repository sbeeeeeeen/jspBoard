package ysb.posts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ysb.file.service.FileService;
import ysb.model.FileAttachmentVo;
import ysb.model.PostsVo;
import ysb.posts.service.PostsService;

/**
 * Servlet implementation class PostsEditServlet
 */
@WebServlet("/postsEdit")
public class PostsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int posts_id = Integer.parseInt(request.getParameter("posts_id"));
		PostsVo posts = new PostsService().getPostsInfo(posts_id);
		request.setAttribute("posts", posts);
		request.setAttribute("board_id", request.getParameter("board_id"));
		request.setAttribute("board_title", request.getParameter("board_title"));
		request.setAttribute("fileList", new FileService().fileList(posts_id));
		request.getRequestDispatcher("/posts/postsWrite.jsp").forward(request, response);
	}
}

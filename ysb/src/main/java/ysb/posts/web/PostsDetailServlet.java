package ysb.posts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ysb.file.service.FileService;
import ysb.model.PostsCommentVo;
import ysb.model.PostsVo;
import ysb.posts.service.PostsService;
import ysb.posts.service.PostsServiceInf;

/**
 * Servlet implementation class PostsDetailServlet
 */
@WebServlet("/postsDetail")
public class PostsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostsServiceInf pService = new PostsService();
		int posts_id = Integer.parseInt(request.getParameter("posts_id"));
		PostsVo posts = pService.getPostsInfo(posts_id);
		request.setAttribute("posts", posts);
		List<PostsCommentVo> postsCommentList = pService.getPostsCommentInfo(posts_id);
		request.setAttribute("postCommentList", postsCommentList);
		request.setAttribute("fileList", new FileService().fileList(posts_id));
		request.getRequestDispatcher("/posts/postsDetail.jsp").forward(request, response);
	}

}

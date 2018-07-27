package ysb.posts.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ysb.file.service.FileService;
import ysb.file.web.FileUtil;
import ysb.model.FileAttachmentVo;
import ysb.model.PostsCommentVo;
import ysb.model.PostsVo;
import ysb.posts.service.PostsService;
import ysb.posts.service.PostsServiceInf;

/**
 * Servlet implementation class PostsUpdateServlet
 */
@WebServlet("/postsUpdate")
@MultipartConfig(maxFileSize=1024*1000*5, maxRequestSize=1024*1000*16)
public class PostsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//post방식일때 인코딩 
		response.setContentType("text/html; charset=utf-8");
		
		int posts_id = 0;
		PostsServiceInf pService = new PostsService();
		String division = request.getParameter("division");
		PostsVo posts = new PostsVo();
		posts.setPosts_title(request.getParameter("posts_title"));
		posts.setPosts_content(request.getParameter("smarteditor"));
		if(division.equals("new")){
			//새글, 답글
			posts.setPosts_id(posts_id=pService.getPostsNewId());
			posts.setStd_id((String)request.getSession().getAttribute("std_id"));
			posts.setBoard_id(Integer.parseInt(request.getParameter("board_id")));
			String posts_pno = request.getParameter("posts_pno");
			posts.setPosts_pno(posts_pno!=null?Integer.parseInt(posts_pno):0);
			String posts_gno = request.getParameter("posts_gno");
			posts.setPosts_gno(posts_gno==null?posts_id:Integer.parseInt(posts_gno));
			pService.insertPosts(posts);
		}else {
			//수정
			posts.setPosts_gno(Integer.parseInt(request.getParameter("posts_gno")));
			posts.setPosts_id(posts_id=Integer.parseInt(request.getParameter("posts_id")));
			pService.updatePosts(posts);
		}
		
		Collection<Part> parts = request.getParts();
		uploadFile(parts, posts_id);
		
		List<PostsCommentVo> postsCommentList = pService.getPostsCommentInfo(posts_id);
		request.setAttribute("posts", pService.getPostsInfo(posts_id));
		request.setAttribute("postCommentList", postsCommentList);
		request.setAttribute("board_id", request.getParameter("board_id"));
		request.setAttribute("board_title", request.getParameter("board_title"));
		request.setAttribute("fileList", new FileService().fileList(posts_id));
		request.getRequestDispatcher("/posts/postsDetail.jsp").forward(request, response);
	}
	
	private void uploadFile(Collection<Part> parts, int posts_id) throws IOException{
		for(Part part : parts){
			String contentType = part.getContentType();
			if(contentType!=null){
				long size = part.getSize();
				if(size>0){
					String contentDisposition = part.getHeader("Content-Disposition");
					String pic = FileUtil.getFileName(contentDisposition);
					String picpath = FileUtil.fileUploadPath;
					String picname = UUID.randomUUID().toString();
					
					FileAttachmentVo file = new FileAttachmentVo();
					file.setPosts_id(posts_id);
					file.setFile_name(picname);
					file.setFile_route(picpath);
					file.setFile_upload_name(pic);
					new FileService().insertFile(file);
					
					part.write(picpath + File.separator + picname);
					part.delete();
				}
			}
		}
	}

}

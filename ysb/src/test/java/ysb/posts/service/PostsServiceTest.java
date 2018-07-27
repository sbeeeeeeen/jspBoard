package ysb.posts.service;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ysb.model.PostsCommentVo;
import ysb.model.PostsVo;

public class PostsServiceTest {
	private PostsServiceInf pService;
	
	@Before
	public void setup(){
		pService = new PostsService();
	}
	
	@Test
	public void getPostsInfTest(){
		PostsVo posts = pService.getPostsInfo(1);
		assertEquals(posts.getPosts_id(), 1);
	}
	
	@Test
	public void getPostsCommentInfoTest(){
		List<PostsCommentVo> postscommentList = pService.getPostsCommentInfo(1);
		assertEquals(2, postscommentList.size());
	}
	
	@Test
	public void insertPostsCommentTest(){
		PostsCommentVo com = new PostsCommentVo();
		com.setPosts_id(1);
		com.setCom_content("내용");
		com.setStd_id(Integer.toString(11));
		com.setCom_status("Y");
		int cnt = pService.insertPostsComment(com);
		assertEquals(1, cnt);
	}
	
	@Test
	public void updatePostsCommentTest(){
		int cnt = pService.updatePostsComment(1);
		assertEquals(1, cnt);
	}
	
	@Test
	public void deletePostsTest(){
		int cnt = pService.deletePosts(1);
		assertEquals(1, cnt);
	}
	
	@Test
	public void updatePosts(){
		PostsVo posts = new PostsVo();
		posts.setPosts_title("test");
		posts.setPosts_content("test");
		posts.setPosts_id(1);
		int cnt = pService.updatePosts(posts);
		assertEquals(1, cnt);
		
	}
	
	@Test
	public void getPostsNewId(){
		int cnt = pService.getPostsNewId();
		assertEquals(cnt, 36);
	}

}

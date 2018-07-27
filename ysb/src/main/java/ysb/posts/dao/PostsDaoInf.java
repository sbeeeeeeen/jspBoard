package ysb.posts.dao;

import java.util.List;

import ysb.model.PostsCommentVo;
import ysb.model.PostsVo;

public interface PostsDaoInf {
	/**
	* Method : getPostsInf
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC16
	* 변경이력 :
	* @param posts_id
	* @return
	* Method 설명 : id에 해당하는 게시글 정보 가져오기
	*/
	PostsVo getPostsInfo(int posts_id);
	
	/**
	* Method : getPostsCommentInfo
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC16
	* 변경이력 :
	* @param posts_id
	* @return
	* Method 설명 : 게시글 id에 해당하는 댓글 리스트 가져오기
	*/
	List<PostsCommentVo> getPostsCommentInfo(int posts_id);
	
	/**
	* Method : insertPostsComment
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC16
	* 변경이력 :
	* @param com
	* @return
	* Method 설명 : 댓글 저장혀
	*/
	int insertPostsComment(PostsCommentVo com);
	
	/**
	* Method : deletePostsComment
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC16
	* 변경이력 :
	* @param com_id
	* @return
	* Method 설명 : 댓글을 삭제하는척하면서 비활성화시키기
	*/
	int updatePostsComment(int com_id);
	
	/**
	* Method : updatePosts
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC16
	* 변경이력 :
	* @param posts_id
	* @return
	* Method 설명 : 게시글 삭제시켜주는척하면서 비활성화시키기
	*/
	int deletePosts(int posts_id);
	
	/**
	* Method : insertPosts
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC16
	* 변경이력 :
	* @param posts
	* @return
	* Method 설명 : 게시물 저장해주기 ~ 
	*/
	int insertPosts(PostsVo posts);
	
	/**
	* Method : updatePosts
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC16
	* 변경이력 :
	* @param posts
	* @return
	* Method 설명 : 게시물 수정해주기 ~
	*/
	int updatePosts(PostsVo posts);
	
	/**
	* Method : updatePosts
	* 최초작성일 : 2018. 7. 21.
	* 작성자 : PC16
	* 변경이력 :
	* @param posts
	* @return
	* Method 설명 : insert하고나서 상세조회 페이지로 넘기려고 만드는 메서드 ㅡㅡ 별루다..
	* 지금 페이지 아이디중 제일 큰 값 +1 해옴 ~
	*/
	int getPostsNewId();

}

package ysb.posts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ysb.model.PostsCommentVo;
import ysb.model.PostsVo;
import ysb.mybatis.SqlMapSessionFactory;

public class PostsDao implements PostsDaoInf{
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public PostsVo getPostsInfo(int posts_id) {
		SqlSession session = sqlSessionFactory.openSession();
		PostsVo posts = (PostsVo)session.selectOne("posts.getPostsInfo", posts_id);
		session.close();
		return posts;
	}

	@Override
	public List<PostsCommentVo> getPostsCommentInfo(int posts_id) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostsCommentVo> postsCommentList = session.selectList("posts.getPostsCommentInfo", posts_id);
		session.close();
		return postsCommentList;
	}

	@Override
	public int insertPostsComment(PostsCommentVo com) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("posts.insertPostsComment", com);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int updatePostsComment(int com_id) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("posts.deletePostsComment", com_id);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int deletePosts(int posts_id) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("posts.deletePosts", posts_id);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int insertPosts(PostsVo posts) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("posts.insertPosts", posts);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int updatePosts(PostsVo posts) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("posts.updatePosts", posts);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int getPostsNewId() {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("posts.getPostsNewId");
		session.close();
		return cnt;
	}

}

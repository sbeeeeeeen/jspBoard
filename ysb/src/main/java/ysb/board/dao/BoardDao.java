package ysb.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ysb.model.BoardVo;
import ysb.model.PostsVo;
import ysb.mybatis.SqlMapSessionFactory;

public class BoardDao implements BoardDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	@Override
	public int insertBoard(Map<String, Object> board) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("board.insertBoard", board);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int updateBoard(Map<String, Object> board) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("board.updateBoard", board);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public List<PostsVo> getPostsList(Map<String, Object> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostsVo> postList = session.selectList("board.getPostsList", map);
		session.close();
		return postList;
	}

	@Override
	public int getPostsCnt(int board_id) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("board.getPostsCnt", board_id);
		session.close();
		return cnt;
	}

}

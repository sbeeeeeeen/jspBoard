package ysb.login.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ysb.model.BoardVo;
import ysb.mybatis.SqlMapSessionFactory;

public class LoginDao implements LoginDaoInf{
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	@Override
	public boolean getStudent(Map<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession();
		boolean b = (int)session.selectOne("board.getStudent", map)==1?true:false;
		session.close();
		return b;
	}

	@Override
	public List<BoardVo> getBoardList() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getBoardList");
		session.close();
		return boardList;
	}

}

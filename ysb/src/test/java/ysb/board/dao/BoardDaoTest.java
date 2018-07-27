package ysb.board.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ysb.model.PostsVo;

public class BoardDaoTest {
	private BoardDaoInf bDao;
	
	@Before
	public void setup(){
		bDao = new BoardDao();
	}

	@Test
	public void InsertBoardTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_title", "TEST");
		map.put("board_status", "Y");
		
		int cnt = bDao.insertBoard(map);
		
		assertEquals(1, cnt);
	}
	
	@Test
	public void updateBoardTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_id", 3);
		map.put("board_title", "TEST2");
		map.put("board_status", "Y");
		
		int cnt = bDao.updateBoard(map);
		
		assertEquals(1, cnt);
	}
	
	@Test
	public void getPostsListTest(){
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("page", 1);
		pageMap.put("pageSize", 10);
		pageMap.put("board_title", "자유게시판");
		pageMap.put("board_id", 1);
		List<PostsVo> posts = bDao.getPostsList(pageMap);
		assertEquals(posts.size(), 10);
	}
	
	@Test
	public void getPostsCnt(){
		int cnt = bDao.getPostsCnt(1);
		
		assertEquals(cnt, 35);
	}
	
}

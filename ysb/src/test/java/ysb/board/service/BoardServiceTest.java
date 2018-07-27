package ysb.board.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ysb.board.service.BoardService;
import ysb.board.service.BoardServiceInf;
import ysb.model.PostsVo;

public class BoardServiceTest {
	private BoardServiceInf bService;
	
	@Before
	public void setup(){
		bService = new BoardService();
	}
	

	@Test
	public void UpdateBoardTest() {
		/***Given***/
		Map<String, Object> board = new HashMap<String, Object>();
		board.put("board_id", 1);
		board.put("board_title", "자유,,게시,.,판");
		board.put("board_status", "N");

		/***When***/
		int cnt = bService.updateBoard(board);

		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void insertPostsTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_title", "TEST");
		map.put("board_status", "Y");
		
		int cnt = bService.insertBoard(map);
		
		assertEquals(1, cnt);
		
	}
	
	//List<PostsVo> getPostsList(int board_id)

}

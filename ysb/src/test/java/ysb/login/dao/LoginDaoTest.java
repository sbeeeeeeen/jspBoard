package ysb.login.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ysb.model.BoardVo;

public class LoginDaoTest {
	private LoginDaoInf lDao;
	
	@Before
	public void setup(){
		lDao = new LoginDao();
	}

	@Test
	public void getStudentTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("std_id", "20");
		map.put("pass", "880371bc2f67b8c3e32fe54b9515ece8");
		
		boolean b = lDao.getStudent(map);
		
		assertEquals(true, b);
	}
	
	@Test
	public void getBoardListTest(){
		List<BoardVo> boardList = lDao.getBoardList();
		assertEquals(boardList.size(), 4);
	}

}

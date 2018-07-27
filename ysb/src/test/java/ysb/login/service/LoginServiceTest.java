package ysb.login.service;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ysb.login.service.LoginService;
import ysb.login.service.LoginServiceInf;
import ysb.model.BoardVo;


public class LoginServiceTest {
	private LoginServiceInf loginService;
	
	@Before
	public void setup(){
		loginService = new LoginService();
	}

	@Test
	public void loginTest() {
		/***Given***/
		Map<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("std_id", "20");
		loginInfo.put("pass", "1234");

		/***When***/
		boolean b = loginService.getStudent(loginInfo);

		/***Then***/
		assertEquals(true, b);
	}
	
	@Test
	public void getBoardListTest(){
		List<BoardVo> boardList = loginService.getBoardList();
		assertEquals(boardList.size(), 4);
	}

}

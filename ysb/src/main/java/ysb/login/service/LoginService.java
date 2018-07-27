package ysb.login.service;

import java.util.List;
import java.util.Map;

import ysb.ddit.encrypt.kisa.seed.KISA_SEED_CBC;
import ysb.login.dao.LoginDao;
import ysb.login.dao.LoginDaoInf;
import ysb.model.BoardVo;

public class LoginService implements LoginServiceInf{
	private LoginDaoInf lDao = new LoginDao();

	@Override
	public boolean getStudent(Map<String, String> map) {
		map.put("pass", KISA_SEED_CBC.Encrypt(map.get("pass")));
		return lDao.getStudent(map);
	}

	@Override
	public List<BoardVo> getBoardList() {
		return lDao.getBoardList();
	}

}

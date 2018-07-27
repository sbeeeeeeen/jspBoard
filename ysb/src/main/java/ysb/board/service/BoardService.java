package ysb.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ysb.board.dao.BoardDao;
import ysb.board.dao.BoardDaoInf;
import ysb.model.BoardVo;
import ysb.model.PostsVo;

public class BoardService implements BoardServiceInf {
	BoardDaoInf bDao = new BoardDao();

	@Override
	public int insertBoard(Map<String, Object> board) {
		return bDao.insertBoard(board);
	}

	@Override
	public int updateBoard(Map<String, Object> board) {
		return bDao.updateBoard(board);
	}

	@Override
	public Map<String, Object> getPostsList(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<PostsVo> postsList = bDao.getPostsList(map);
		resultMap.put("postsList", postsList);
		resultMap.put("pageNavi", makePageNavi((int)map.get("board_id"), (int)map.get("page"), (int)map.get("pageSize"), (String)map.get("board_title")));
		
		return resultMap;
	}
	
	private String makePageNavi(int board_id, int page, int pageSize, String board_title){
		StringBuffer pageNaviStr = new StringBuffer();
		int count=1;
		int pageCnt = bDao.getPostsCnt(board_id);
		int temp = pageCnt;
		
		pageNaviStr.append("<li><a href=\"/viewBoard?board_title="+board_title+"&board_id="+board_id+"&page="+1+"&pageSize="+pageSize+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;&laquo;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/viewBoard?board_title="+board_title+"&board_id="+board_id+"&page="+(page==1?1:page-1)+"&pageSize="+pageSize+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		while(true){
			if(temp>0){
				temp-=pageSize;
				pageNaviStr.append((count==page?"<li class=\"active\">":"<li>")+"<a href=/viewBoard?board_title="+board_title+"&board_id="+board_id+"&page="+count+"&pageSize="+pageSize+">"+count+++"</a></li>");
				continue;
			}
			pageNaviStr.append("<li><a href=\"/viewBoard?board_title="+board_title+"&board_id="+board_id+"&page="+(page==count-1?page:page+1)+"&pageSize="+pageSize+"\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
			pageNaviStr.append("<li><a href=\"/viewBoard?board_title="+board_title+"&board_id="+board_id+"&page="+(count-1)+"&pageSize="+pageSize+"\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;&raquo;</span></a></li>");
			return pageNaviStr.toString();
		}
	}

}

package ysb.board.dao;

import java.util.List;
import java.util.Map;

import ysb.model.BoardVo;
import ysb.model.PostsVo;

public interface BoardDaoInf {
	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC16
	* 변경이력 :
	* @param board
	* @return
	* Method 설명 : 게시판 생성
	*/
	int insertBoard(Map<String, Object> board);
	
	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC16
	* 변경이력 :
	* @param board
	* @return
	* Method 설명 : 게시판 수정
	*/
	int updateBoard(Map<String, Object> board);
	
	/**
	* Method : getPostsList
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC16
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 게시판의 게시글 리스트 가져오기
	*/
	List<PostsVo> getPostsList(Map<String, Object> map);
	
	/**
	* Method : getPostsCnt
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC16
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	int getPostsCnt(int board_id);
}

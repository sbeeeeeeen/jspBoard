package ysb.model;

public class BoardVo {
	private int board_id;
	private String board_title;
	private String board_status;
	
	public BoardVo(){
		
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_status() {
		return board_status;
	}

	public void setBoard_status(String board_status) {
		this.board_status = board_status;
	}

	@Override
	public String toString() {
		return "BoardVo [board_id=" + board_id + ", board_title=" + board_title
				+ ", board_status=" + board_status + "]";
	}
	
}

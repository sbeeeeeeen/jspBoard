package ysb.model;

import java.util.Date;

public class PostsVo {
	private int posts_id;
	private int board_id;
	private String std_id;
	private String posts_title;
	private String posts_content;
	private Date posts_date;
	private String posts_status;
	private int posts_pno;
	private int posts_gno;
	
	public PostsVo(){
		
	}

	public int getPosts_id() {
		return posts_id;
	}

	public void setPosts_id(int posts_id) {
		this.posts_id = posts_id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getPosts_title() {
		return posts_title;
	}

	public void setPosts_title(String posts_title) {
		this.posts_title = posts_title;
	}

	public String getPosts_content() {
		return posts_content;
	}

	public void setPosts_content(String posts_content) {
		this.posts_content = posts_content;
	}

	public Date getPosts_date() {
		return posts_date;
	}

	public void setPosts_date(Date posts_date) {
		this.posts_date = posts_date;
	}

	public String getPosts_status() {
		return posts_status;
	}

	public void setPosts_status(String posts_status) {
		this.posts_status = posts_status;
	}

	public int getPosts_pno() {
		return posts_pno;
	}

	public void setPosts_pno(int posts_pno) {
		this.posts_pno = posts_pno;
	}

	public int getPosts_gno() {
		return posts_gno;
	}

	public void setPosts_gno(int posts_gno) {
		this.posts_gno = posts_gno;
	}

	@Override
	public String toString() {
		return "PostsVo [posts_id=" + posts_id + ", board_id=" + board_id
				+ ", std_id=" + std_id + ", posts_title=" + posts_title
				+ ", posts_content=" + posts_content + ", posts_date="
				+ posts_date + ", posts_status=" + posts_status
				+ ", posts_pno=" + posts_pno + ", posts_gno=" + posts_gno + "]";
	}
	
}

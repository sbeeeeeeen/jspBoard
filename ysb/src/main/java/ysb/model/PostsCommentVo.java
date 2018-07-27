package ysb.model;

import java.util.Date;

public class PostsCommentVo {
	private int com_id;
	private int posts_id;
	private String std_id;
	private String com_content;
	private Date com_date;
	private String com_status;
	
	public PostsCommentVo(){
		
	}
	
	public int getPosts_id() {
		return posts_id;
	}
	public void setPosts_id(int posts_id) {
		this.posts_id = posts_id;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getCom_content() {
		return com_content;
	}
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
	public Date getCom_date() {
		return com_date;
	}
	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}
	public String getCom_status() {
		return com_status;
	}
	public void setCom_status(String com_status) {
		this.com_status = com_status;
	}

	public int getCom_id() {
		return com_id;
	}

	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	
	@Override
	public String toString() {
		return "PostsCommentVo [com_id=" + com_id + ", posts_id=" + posts_id
				+ ", std_id=" + std_id + ", com_content=" + com_content
				+ ", com_date=" + com_date + ", com_status=" + com_status + "]";
	}
	
	
}

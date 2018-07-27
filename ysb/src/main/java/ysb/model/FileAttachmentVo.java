package ysb.model;

public class FileAttachmentVo {
	private int file_id;
	private int posts_id;
	private String file_upload_name;
	private String file_route;
	private String file_name;
	
	public FileAttachmentVo(){
		
	}
	
	public int getPosts_id() {
		return posts_id;
	}
	public void setPosts_id(int posts_id) {
		this.posts_id = posts_id;
	}
	public String getFile_upload_name() {
		return file_upload_name;
	}
	public void setFile_upload_name(String file_upload_name) {
		this.file_upload_name = file_upload_name;
	}
	public String getFile_route() {
		return file_route;
	}
	public void setFile_route(String file_route) {
		this.file_route = file_route;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	@Override
	public String toString() {
		return "FileAttachmentVo [file_id=" + file_id + ", posts_id="
				+ posts_id + ", file_upload_name=" + file_upload_name
				+ ", file_route=" + file_route + ", file_name=" + file_name
				+ "]";
	}
	
	
}

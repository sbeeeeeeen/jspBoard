package ysb.file.service;

import java.util.List;

import ysb.model.FileAttachmentVo;

public interface FileServiceInf {
	/**
	* Method : insertFile
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC16
	* 변경이력 :
	* @param file
	* @return
	* Method 설명 : fileVo 넣기 ~~ 
	*/
	int insertFile(FileAttachmentVo file);
	
	/**
	* Method : fileList
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC16
	* 변경이력 :
	* @param posts_id
	* @return
	* Method 설명 : fileList 가져오기 ~ 
	*/
	List<FileAttachmentVo> fileList(int posts_id);
}

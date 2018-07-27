package ysb.file.service;

import java.util.List;

import ysb.file.dao.FileDao;
import ysb.file.dao.FileDaoInf;
import ysb.model.FileAttachmentVo;

public class FileService implements FileServiceInf{
	private FileDaoInf fDao = new FileDao();
	
	@Override
	public int insertFile(FileAttachmentVo file) {
		return fDao.insertFile(file);
	}

	@Override
	public List<FileAttachmentVo> fileList(int posts_id) {
		return fDao.fileList(posts_id);
	}

}

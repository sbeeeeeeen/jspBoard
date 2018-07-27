package ysb.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ysb.model.FileAttachmentVo;
import ysb.mybatis.SqlMapSessionFactory;

public class FileDao implements FileDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public int insertFile(FileAttachmentVo file) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("file.insertFile", file);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public List<FileAttachmentVo> fileList(int posts_id) {
		SqlSession session = sqlSessionFactory.openSession();
		List<FileAttachmentVo> fileList = session.selectList("file.getFileList", posts_id);
		session.close();
		return fileList;
	}

}

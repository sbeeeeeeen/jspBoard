package ysb.file.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ysb.model.FileAttachmentVo;

public class FileDaoTest {
	private FileDaoInf fDao ;
	
	@Before
	public void setup(){
		fDao = new FileDao();
	}
	
	@Test
	public void FileListTest() {
		List<FileAttachmentVo> fileList = fDao.fileList(32);
		assertEquals(1, fileList.size());
	}

}

package ysb.file.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ysb.model.FileAttachmentVo;

public class FileServiceTest {
	private FileServiceInf fService;
	@Before
	public void setup(){
		fService = new FileService();
	}

	@Test
	public void FileListTest() {
		List<FileAttachmentVo> fileList = fService.fileList(32);
		assertEquals(1, fileList.size());
	}

}

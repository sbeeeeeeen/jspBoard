package ysb.file.web;

public class FileUtil {
	
	//파일 업로드 경로
	public final static String fileUploadPath = "C:\\ddit\\W\\A_TeachingMaterial\\7.JspSpring\\fileUpload";

	/**
	* Method : getFileName
	* 최초작성일 : 2018. 7. 16.
	* 작성자 : PC16
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : part의 Content-Disposition header로부터 업로드 파일명을 리턴한다
	* ex : form-data; name="uploadFile"; filename="sally.png"
	* return : sally.png
	*/
	public static String getFileName(String contentDisposition){
		String[] temp = contentDisposition.split("; ");
		String result = "";
		for(String str : temp){
			if(str.contains("filename")){
				result = str.substring(str.indexOf("=\"")+2, str.length()-1);
			}
		}
		return result;
	}
	

}

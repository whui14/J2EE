package hostel_world.action;

import com.opensymphony.xwork2.Action;
import hostel_world.model.Hostel;
import hostel_world.service.HostelService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


@Repository
public class HostelRegisterAction extends BaseAction implements Action{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private HostelService hostelService;
	private Hostel hostel;
	private String birthday;


	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;
	

	public String execute() throws Exception {
		
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-mm-dd");
		
		Date t=sim.parse(birthday);
		
		hostel.setTime(t);

		hostel.setPass(0);

		System.out.println(hostel.getName());

		/**上传房间图片*/

		String RealPath="E:/大三/J2EE与中间件/HostelWorld/WebContent/hPicture";

		File file=new File(RealPath);

		if(!file.exists()){
			file.mkdirs();
		}

		FileUtils.copyFile(uploadFile, new File(file,uploadFileFileName));//上传海报
		String path="hPicture/"+uploadFileFileName;
		hostel.setPictureurl(path);

//		System.out.println(hostel.getAddress());
//		System.out.println(hostel.getHostelName());
//		System.out.println(hostel.getId());
//		System.out.println(hostel.getIntroduction());
//		System.out.println(hostel.getName());
//		System.out.println(hostel.getPass());
//		System.out.println(hostel.getPassword());
//		System.out.println(hostel.getTime());
//		System.out.println(hostel.getTelephone());
//		System.out.println(hostel.getPictureurl());
		hostelService.register(hostel);
		
		
		return SUCCESS;
	}

	public String enterRegister(){
		return SUCCESS;
	}


	public Hostel getHostel() {
		return hostel;
	}



	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}
	
	
	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}


}

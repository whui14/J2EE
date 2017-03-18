package hostel_world.action;

import com.opensymphony.xwork2.Action;
import hostel_world.model.Hostel;
import hostel_world.model.RoomPlan;
import hostel_world.service.RoomPlanService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Repository
public class CreateRoomPlanAction extends BaseAction implements Action{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RoomPlanService planService;
	private RoomPlan plan;
	private String airTime;
	private String endTime;
	private String breakfast;
	private String person;
	private String cancel;
	private String price;
	private String title;
	private String type;

	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String execute() throws Exception {
		/**
		 * 将输入结果进行一些转换
		 */
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Hostel hostel = (Hostel) session.get("hostel");

		System.out.println(airTime+"~~~~~~~~~~~~~~~~~");
		
		Date t=sim.parse(airTime);
		
		System.out.println(t+"~~~~~~~~~~~~~~~~~");
		plan = new RoomPlan();

		plan.setTitle(title);
		plan.setType(type);
		plan.setAirTime(t);
		t=sim.parse(endTime);
		plan.setEndTime(t);
		Double iPrice=Double.parseDouble(price);
		plan.setPrice(iPrice);
		int iBreakfast=Integer.parseInt(breakfast);
		plan.setBreakfast(iBreakfast);
		int iPerson=Integer.parseInt(person);
		plan.setPerson(iPerson);
		int iCancel=Integer.parseInt(cancel);
		plan.setCancel(iCancel);
		int hid=hostel.getId();
		plan.setHid(hid);
		plan.setState(0);
		
		/**上传房间图片*/
		
		String RealPath="E:/大三/J2EE与中间件/HostelWorld/WebContent/post";
		
		File file=new File(RealPath);
		
		if(!file.exists()){
			file.mkdirs();
		}
		
		FileUtils.copyFile(uploadFile, new File(file,uploadFileFileName));//上传海报
		String path="post/"+uploadFileFileName;
		plan.setPosturl(path);
		planService.createNewRoomPlan(plan);
		return SUCCESS;
	}
	
	public String enterCreateRoomPlan(){
		return SUCCESS;
	}

	public String getAirTime() {
		return airTime;
	}

	public void setAirTime(String airTime) {
		this.airTime = airTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public RoomPlan getPlan() {
		return plan;
	}

	public void setPlan(RoomPlan plan) {
		this.plan = plan;
	}

	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
}

package hostel_world.action;

import com.opensymphony.xwork2.Action;
import hostel_world.model.Hostel;
import hostel_world.model.HostelPlan;
import hostel_world.service.HostelPlanService;
import hostel_world.service.HostelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModifyHostelPlanAction extends BaseAction implements Action{

	@Autowired
	private HostelService hostelService;
	@Autowired
	private HostelPlanService hostelPlanService;
	private Hostel hostel;
	private HostelPlan hostelPlan;
	private String time;

	public int getSub() {
		return sub;
	}

	public void setSub(int sub) {
		this.sub = sub;
	}

	private int sub;


	public String execute() throws Exception {
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-mm-dd");
		System.out.print(time);

		Date t=sim.parse(time);
		
		hostel.setTime(t);
		
		Hostel hostel_=(Hostel)session.get("hostel");
		hostel.setId(hostel_.getId());
		hostel.setName(hostel_.getName());
		hostel.setPassword(hostel_.getPassword());
		hostel.setPictureurl(hostel_.getPictureurl());
		hostel.setPass(4);

		HostelPlan hostelPlan = new HostelPlan();
		BeanUtils.copyProperties(hostel, hostelPlan);
		hostelPlanService.addHostelPlan(hostelPlan);
		hostelService.setPassValue(hostel.getId(), 4);//update database
		hostel_.setPass(4);
		session.put("hostel", hostel_);
		return SUCCESS;
	}
	


	public String enterModifyProfile(){
		
		return SUCCESS;
	}

	/**
	 *
	 * 根据按钮跳转
	 */
	public String enterModify(){
		//0是继续修改，1是取消修改，2是正常修改
		Hostel hostel = (Hostel) session.get("hostel");
		if(sub==0){
			HostelPlan hostelPlanInfo = hostelPlanService.getHostelPlanInfo(hostel.getId());
			session.put("hostelPlan", hostelPlanInfo);
			return "continue";
		}
		if(sub==1){
			hostelService.setPassValue(hostel.getId(), 1);//update database
			hostel.setPass(1);
			session.put("hostel", hostel);//update session
			hostelPlanService.deletePlanInfo(hostel.getId());
			session.put("hostelPlan", null);
			return "cancel";
		}
		if(sub==2){
			return "change";
		}
		return "fail";
	}


//	public String enterContinueModifyPlan(){
//		Hostel hostel = (Hostel) session.get("hostel");
//
//	}

	public String continueModifyPlan() throws Exception {
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-mm-dd");
		System.out.print(time);

		Date t=sim.parse(time);

		hostelPlan.setTime(t);

		HostelPlan hostel_=(HostelPlan) session.get("hostelPlan");

		hostelPlan.setId(hostel_.getId());
		hostelPlan.setName(hostel_.getName());
		hostelPlan.setPassword(hostel_.getPassword());
		hostelPlan.setPass(4);
		hostelPlanService.updateHostelPlan(hostelPlan);//update plan in database

		hostelService.setPassValue(hostel_.getId(), 4);//update database
		Hostel hostel = (Hostel) session.get("hostel");
		hostel.setPass(4);
		session.put("hostel", hostel);//update session
		session.put("hostelPlan", hostelPlan);

		return SUCCESS;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

}

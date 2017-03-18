package hostel_world.action;


import hostel_world.model.list.HostelList;
import hostel_world.service.HostelPlanService;
import hostel_world.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CheckHostelPlanAction extends BaseAction{

	@Autowired
	private HostelService hostelServiceBean;
	@Autowired
	private HostelPlanService hostelPlanServiceBean;
	private int hostelId;
	private int sub;

	public String execute(){
		HostelList hostelList=new HostelList();
		hostelList.setHostelList(hostelServiceBean.getUncheckedHostelPlan());
		session.put("hostelList", hostelList);
		return "checkHostel";
	}
	
	public String processPlan(){
		System.out.println(sub+"--------------------------------");
		
		if(sub==0){
			System.out.println("废弃计划"+"~~~~~~~~~~");
			hostelServiceBean.vetoPlan(hostelId);   //说明否决了计划
		}else{

			hostelServiceBean.publishHostelPlan(hostelId);

			
		}
		
		/**更新要显示的待审核列表*/
		HostelList planList=new HostelList();
		planList.setHostelList(hostelServiceBean.getUncheckedHostelPlan());
		session.put("hostelList", planList);
		
		return SUCCESS;
	}


	public int getHostelId() {
		return hostelId;
	}

	public void setHostelId(int hostelId) {
		this.hostelId = hostelId;
	}

	public int getSub() {
		return sub;
	}

	public void setSub(int sub) {
		this.sub = sub;
	}
	
	
}

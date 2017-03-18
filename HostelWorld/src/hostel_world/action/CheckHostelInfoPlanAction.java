package hostel_world.action;


import hostel_world.model.list.HostelPlanList;
import hostel_world.service.HostelPlanService;
import hostel_world.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CheckHostelInfoPlanAction extends BaseAction{

	@Autowired
	private HostelPlanService hostelPlanServiceBean;
	@Autowired
	private HostelService hostelServiceBean;
	private int hostelId;
	private int sub;

	public String execute(){
		HostelPlanList hostelList=new HostelPlanList();
		hostelList.setHostelPlanList(hostelPlanServiceBean.getUncheckedHostelPlan());
		session.put("hostelPlanList", hostelList);
		return "checkHostelInfo";
	}
	
	public String processPlan(){
		System.out.println(sub+"--------------------------------");

		if(sub==0){
			System.out.println("废弃计划"+"~~~~~~~~~~");
			hostelPlanServiceBean.vetoPlan(hostelId);   //说明否决了计划
			hostelServiceBean.setPassValue(hostelId,-2);

		}else{

			hostelPlanServiceBean.publishHostelPlan(hostelId);

			
		}
		
		/**更新要显示的待审核列表*/
		HostelPlanList planList=new HostelPlanList();
		planList.setHostelPlanList(hostelPlanServiceBean.getUncheckedHostelPlan());
		session.put("hostelPlanList", planList);
		
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

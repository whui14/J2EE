package hostel_world.action;

import java.util.List;

import hostel_world.model.list.PlanList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hostel_world.model.Plan;
import hostel_world.service.PlanService;

import com.opensymphony.xwork2.Action;

@Repository
public class ModifyPlanAction extends BaseAction implements Action{
	@Autowired
	private PlanService planServiceBean;
	
	
	private int planId;
	private int sub;
	
	public String execute() throws Exception {
		/**废弃计划*/
		if(sub==0){
			planServiceBean.abandonPlan(planId);
		}else{
			Plan plan=planServiceBean.getPlanInfo(planId);
			session.put("plan", plan);
			return "modify";
		}
		return SUCCESS;
	}
	
	public String enterModify(){
		List list=planServiceBean.getUnpassedPlan();
		PlanList planList=new PlanList();
		planList.setPlanList(list);
		session.put("planList", planList);
		return SUCCESS;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getSub() {
		return sub;
	}

	public void setSub(int sub) {
		this.sub = sub;
	}
	
	

}

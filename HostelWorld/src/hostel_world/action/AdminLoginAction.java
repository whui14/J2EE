package hostel_world.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hostel_world.service.PlanService;

import com.opensymphony.xwork2.Action;

@Repository
public class AdminLoginAction extends BaseAction implements Action{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private PlanService planServiceBean;
	
	private int identity =0;
	
	public String execute() throws Exception {
		
//		if(identity==1){
//			return "server";
//		}else{
//		/**
//			PlanList planList=new PlanList();
//			planList.setPlanList(planServiceBean.getUncheckedPlan());
//			session.put("planList", planList);
//		**/
			return "manager";
//		}
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}



}

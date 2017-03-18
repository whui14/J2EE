package hostel_world.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hostel_world.service.PlanService;

import com.opensymphony.xwork2.Action;
@Repository
public class PlanAction implements Action{
	@Autowired
	private PlanService planServiceBean;
	
	public String execute() throws Exception {
		return null;
	}

}

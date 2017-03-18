package hostel_world.model.list;

import java.io.Serializable;
import java.util.List;

import hostel_world.model.Plan;

public class PlanList  implements Serializable{
	private List planList;

	public List getPlanList() {
		return planList;
	}

	public void setPlanList(List planList) {
		this.planList = planList;
	}
	
	public Plan getPlanList(int index){
		return (Plan)planList.get(index);
	}
}

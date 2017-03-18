package hostel_world.model.list;

import java.util.List;

public class PlanIdList {
	private List planIdList;

	public List getPlanIdList() {
		return planIdList;
	}

	public void setPlanIdList(List planIdList) {
		this.planIdList = planIdList;
	}
	
	public int getPlanIdList(int index){
		return (Integer)planIdList.get(index);
	}
}

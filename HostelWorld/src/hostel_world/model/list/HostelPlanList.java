package hostel_world.model.list;

import hostel_world.model.HostelPlan;

import java.io.Serializable;
import java.util.List;

public class HostelPlanList implements Serializable{
	private List HostelPlanList;

	public List getHostelPlanList() {
		return HostelPlanList;
	}

	public void setHostelPlanList(List hostelPlanList) {
		HostelPlanList = hostelPlanList;
	}

	public HostelPlan getHostelPlanList(int index){
		return (HostelPlan)HostelPlanList.get(index);
	}

}

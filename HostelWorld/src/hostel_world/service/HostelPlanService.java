package hostel_world.service;



import hostel_world.model.Hostel;
import hostel_world.model.HostelPlan;

import java.util.List;

public interface HostelPlanService {

	/**
	 * 经理审核确认客栈申请
	 * @param id
	 */
	public void publishHostelPlan(Integer id);

	/**
	 * 经理审核否决某客栈申请
	 * @param id
	 */
	public void vetoPlan(Integer id);
	
	/**
	 * 获得已经审核通过的客栈申请
	 * @return
	 */
	public HostelPlan getPassedHostelPlan();
	/**
	 * 获得未通过审核的客栈申请
	 * @return
	 */
	public HostelPlan getUnpassedHostelPlan(Integer id);
	/**
	 * 获得待审核的客栈申请
	 * @return
	 */
	public List<Object> getUncheckedHostelPlan();
	/**
	 * 根据客栈申请的id获得客栈的详细信息
	 * @param id
	 * @return
	 */
	public HostelPlan getHostelPlanInfo(Integer id);

	void addHostelPlan(HostelPlan hostelPlan);

	void updateHostelPlan(HostelPlan hostelPlan);

	void deletePlanInfo(Integer id);
		
}

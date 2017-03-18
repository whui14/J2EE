package hostel_world.dao;

import hostel_world.model.HostelPlan;

import java.util.List;

public interface HostelPlanDao {

	/**
	 * 经理审核确认发布客栈申请
	 * @param id
	 */
	public void publishPlan(Integer id);
	/**
	 * 经理审核否决某客栈申请
	 * @param id
	 */
	public void vetoPlan(Integer id);
	/**
	 * 客栈更改客栈申请
	 * @param plan
	 */
	public void modifyPlan(HostelPlan plan);
	/**
	 * 客栈更改客栈申请
	 * @param plan
	 */
	public void addPlan(HostelPlan plan);

	/**
	 * 得到已经通过审核的客栈
	 * @return
	 */
	public HostelPlan getPassedPlan();
	/**
	 * 客栈获得未通过审核的客栈
	 * @return
	 */
	public HostelPlan getUnpassedPlan(Integer id);
	/**
	 * 获得待审核的客栈
	 * @return
	 */
	public List<Object> getUncheckedPlan();
	/**
	 * 根据id获得修改的详细信息
	 * @param id
	 * @return
	 */
	public HostelPlan getPlanInfo(Integer id);

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public void deletePlanInfo(Integer id);

	void updateHostelPlan(HostelPlan hostelPlan);

}

























package hostel_world.service;

import hostel_world.model.RoomPlan;

import java.util.List;

public interface RoomPlanService {
	/**
	 * 管理员创建新的放映计划
	 * @param plan
	 */
	public void createNewRoomPlan(RoomPlan plan);
	/**
	 * 经理审核确认发布放映计划
	 * @param id
	 */
	public void publishRoomPlan(Integer id);
	/**
	 * 管理员修改放映计划
	 * @param plan
	 */
	public void modifyRoomPlan(RoomPlan plan);
	/**
	 * 经理审核否决某放映计划
	 * @param id
	 */
	public void vetoRoomPlan(Integer id);
	/**
	 * 管理员删除无效的放映计划
	 * @param id
	 */
	public void abandonRoomPlan(Integer id);
	
	/**
	 * 获得已经审核通过的放映计划
	 * @return
	 */
	public List<Object> getPassedRoomPlan();
	/**
	 * 获得未通过审核的放映计划
	 * @return
	 */
	public List<Object> getUnpassedRoomPlan();
	/**
	 * 获得待审核的放映计划
	 * @return
	 */
	public List<Object> getUncheckedRoomPlan(Integer id);
	/**
	 * 根据放映计划的id获得计划的详细信息
	 * @param id
	 * @return
	 */
	public RoomPlan getRoomPlanInfo(Integer id);
	/**
	 * 得到正在上映的电影列表
	 * @return
	 */
	public List getFilmList();
	/**
	 * 返回某部电影的将要上映的计划
	 * @param title
	 * @return
	 */
	public List getCurrentRoomPlan(String title);
	/**
	 * 返回还没上映的上映计划ID
	 * @return
	 */
	public List getCurrentRoomPlanId();
		
}

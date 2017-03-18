package hostel_world.dao;

import hostel_world.model.RoomPlan;

import java.util.List;

public interface RoomPlanDao {
	/**
	 * 客栈管理员创建新的计划
	 * @param plan
	 */
	public void addRoomPlan(RoomPlan plan);
	/**
	 * 经理审核确认发布计划
	 * @param id
	 */
	public void publishRoomPlan(Integer id);
	/**
	 * 经理审核否决某计划
	 * @param id
	 */
	public void vetoRoomPlan(Integer id);
	/**
	 * 客栈管理员更改计划
	 * @param plan
	 */
	public void modifyRoomPlan(RoomPlan plan);
	/**
	 * 管理员废弃不再使用的计划
	 * @param id
	 */
	public void abandonRoomPlan(Integer id);
	/**
	 * 处理已经上架的计划
	 */
	public void overdueRoomPlan();
	/**
	 * 得到已经通过审核的计划
	 * @return
	 */
	public List<Object> getPassedRoomPlan();
	/**
	 * 获得未通过审核的计划
	 * @return
	 */
	public List<Object> getUnpassedRoomPlan();
	/**
	 * 获得待审核的计划
	 * @return
	 */
	public List<Object> getUncheckedRoomPlan(Integer id);
	/**
	 * 根据计划的id获得计划的详细信息
	 * @param id
	 * @return
	 */
	public RoomPlan getRoomPlanInfo(Integer id);
	/**
	 * 返回还在出售的房间
	 * @return
	 */
	public List getFilmList();
	/**
	 * 返回某个房型的将要出售的计划
	 * @param title
	 * @return
	 */
	public List getCurrentRoomPlan(String title);
	/**
	 * 返回还没出售的房型计划id
	 * @return
	 */
	public List getCurrentRoomPlanId();
}

























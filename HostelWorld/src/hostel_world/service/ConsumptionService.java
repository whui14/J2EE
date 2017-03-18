package hostel_world.service;

import java.util.List;

import hostel_world.model.Plan;

public interface ConsumptionService {
	/**
	 * 预定房间
	 */
	public void buyTicket(Plan plan, int amount, int uid, double afterCount);
	/**
	 * 返回用户所有的消费记录
	 * @param uid
	 * @return
	 */
	public List getAllRecord(Integer uid);
}

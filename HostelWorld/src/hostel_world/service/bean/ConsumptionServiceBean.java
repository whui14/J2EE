package hostel_world.service.bean;

import java.util.List;

import hostel_world.dao.ConsumptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hostel_world.model.Plan;
import hostel_world.service.ConsumptionService;

@Service
public class ConsumptionServiceBean implements ConsumptionService{
	@Autowired
	private ConsumptionDao consumptionDaoImpl;
	
	public void buyTicket(Plan plan, int amount, int uid, double afterCount) {
		consumptionDaoImpl.buyTicket(plan, amount, uid,afterCount);
		
	}

	
	public List getAllRecord(Integer uid) {
		return consumptionDaoImpl.getAllRecord(uid);
	}

}

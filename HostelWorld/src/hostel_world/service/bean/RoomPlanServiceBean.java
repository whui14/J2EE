package hostel_world.service.bean;

import hostel_world.dao.FilmDao;
import hostel_world.dao.RoomPlanDao;
import hostel_world.dao.SeatDao;
import hostel_world.model.Film;
import hostel_world.model.RoomPlan;
import hostel_world.service.RoomPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomPlanServiceBean implements RoomPlanService {
	@Autowired
	private RoomPlanDao planDaoImpl;
	@Autowired
	private FilmDao filmDaoImpl;
	@Autowired
	private SeatDao seatDaoImpl;
	
	
	public void createNewRoomPlan(RoomPlan plan) {
		planDaoImpl.addRoomPlan(plan);
	}

	
	public void publishRoomPlan(Integer id) {
		planDaoImpl.publishRoomPlan(id);
		seatDaoImpl.addNewSeat(id);
	}

	
	public void modifyRoomPlan(RoomPlan plan) {
		planDaoImpl.modifyRoomPlan(plan);
	}

	
	public void vetoRoomPlan(Integer id) {
		planDaoImpl.vetoRoomPlan(id);
	}

	
	public void abandonRoomPlan(Integer id) {
		planDaoImpl.abandonRoomPlan(id);
	}


	public List<Object> getPassedRoomPlan() {
		return planDaoImpl.getPassedRoomPlan();
	}

	
	public List<Object> getUnpassedRoomPlan() {
		return planDaoImpl.getUnpassedRoomPlan();
	}

	
	public List<Object> getUncheckedRoomPlan(Integer id) {
		return planDaoImpl.getUncheckedRoomPlan(id);
	}

	
	public RoomPlan getRoomPlanInfo(Integer id) {
		return planDaoImpl.getRoomPlanInfo(id);
	}


	public List getCurrentRoomPlan(String title) {
		return planDaoImpl.getCurrentRoomPlan(title);
	}


	
	public List getCurrentRoomPlanId() {
		return planDaoImpl.getCurrentRoomPlanId();
	}

}

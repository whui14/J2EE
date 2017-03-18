package hostel_world.service.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hostel_world.dao.SeatDao;
import hostel_world.model.Seat;
import hostel_world.service.SeatService;


@Service
public class SeatServiceBean implements SeatService {
	@Autowired
	private SeatDao seatDaoImpl;
	
	
	public void addNewSeat(int pid) {
		seatDaoImpl.addNewSeat(pid);
	}

	
	public Seat getSeat(Integer pid) {
		return seatDaoImpl.getSeat(pid);
	}


	public void setbook(int id, int row, int col) {
		seatDaoImpl.setbook(id, row, col);
	}

}

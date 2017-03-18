package hostel_world.service.bean;

import hostel_world.dao.SeatDao;
import hostel_world.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hostel_world.model.TicketManage;
import hostel_world.dao.TicketManageDao;

@Service
public class TicketServiceBean implements TicketService {
	@Autowired
	private TicketManageDao ticketManageDaoImpl;
	@Autowired
	private SeatDao seatDaoImpl;
	
	public void createTicketManage(TicketManage ticketManage) {
		ticketManageDaoImpl.createTicketManage(ticketManage);
	}

	
	public TicketManage getTicketMange(int pid) {
		return ticketManageDaoImpl.getTicketManage(pid);
	}

	
	public void soldTicket(int pid, int amount) {
		ticketManageDaoImpl.soldTicket(pid, amount);
	}


	
	public void setbook(int id, int row, int col) {
		seatDaoImpl.setbook(id, row, col);
		
	}



}

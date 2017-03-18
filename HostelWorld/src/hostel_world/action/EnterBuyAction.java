package hostel_world.action;

import hostel_world.model.Seat;
import hostel_world.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hostel_world.model.TicketManage;
import hostel_world.model.Plan;
import hostel_world.service.PlanService;
import hostel_world.service.SeatService;

import com.opensymphony.xwork2.Action;

@Repository
public class EnterBuyAction extends BaseAction implements Action{
	
	@Autowired
	private TicketService ticketService;
	@Autowired
	private PlanService planServiceBean;
	@Autowired
	private SeatService seatServiceBean;

	private int planId;
	
	public String execute() throws Exception {
		TicketManage ticketManage=ticketService.getTicketMange(planId);
		Plan plan=planServiceBean.getPlanInfo(planId);
		Seat seat=seatServiceBean.getSeat(planId);
		
		session.put("seat", seat);
		
		String s=seat.getBooked();
		session.put("book", s);
		session.put("price",plan.getPrice());
		
		session.put("ticketManage", ticketManage);
		session.put("plan", plan);		
		return SUCCESS;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

}

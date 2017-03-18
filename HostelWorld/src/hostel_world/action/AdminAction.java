package hostel_world.action;

import hostel_world.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.Action;


@Repository
public class AdminAction implements Action{
	@Autowired
	private TicketService ticketService;
	
	
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	public String adminHomePage(){
		return SUCCESS;
	}
	
	public String managerHomePage(){
		return SUCCESS;
	}

}

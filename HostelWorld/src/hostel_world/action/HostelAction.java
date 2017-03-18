package hostel_world.action;

import com.opensymphony.xwork2.Action;

import hostel_world.model.Hostel;
import hostel_world.model.HostelAccount;
import hostel_world.model.Room;
import hostel_world.model.list.RoomList;
import hostel_world.service.HostelAccountService;
import hostel_world.service.HostelService;
import hostel_world.service.RoomPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HostelAction extends BaseAction  implements Action{
	@Autowired
	private HostelService hostelServiceBean;
	@Autowired
	private HostelAccountService hostelAccountServiceBean;
	@Autowired
	private RoomPlanService roomServiceBean;

	public String execute() throws Exception {
		Hostel hostel = (Hostel)session.get("hostel");
		//银行卡好像还未实现
//		HostelAccount account = hostelAccountServiceBean.getHostelAccount(hostel.getId());
		List list=roomServiceBean.getUncheckedRoomPlan(hostel.getId());

		RoomList roomList=new RoomList();
		roomList.setRoomList(list);

		
//		session.put("hostelAccount", account);
		session.put("roomList", roomList);

		return SUCCESS;
	}
	
	public String hostelInfo(){
		Hostel hostel=(Hostel) session.get("hostel");
//		HostelAccount account = hostelAccountServiceBean.getHostelAccount(hostel.getId());
//		session.put("account", account);
		return SUCCESS;
	}
	
	public String userSet(){
		return SUCCESS;
	}
	


	
}

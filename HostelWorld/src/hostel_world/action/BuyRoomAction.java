package hostel_world.action;

import java.util.List;

import hostel_world.model.*;
import hostel_world.model.list.PlanList;
import hostel_world.model.list.RoomList;
import hostel_world.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.Action;

@Repository
public class BuyRoomAction extends BaseAction implements Action{
	@Autowired
	private PlanService planServiceBean;
	@Autowired
	private ConsumptionService consumptionServiceBean;
	@Autowired
	private TicketService ticketServiceBean;	
	@Autowired
	private AnswerService answerServiceBean;
	@Autowired
	private AccountService accountServiceBean;
	@Autowired
	private SeatService seatServiceBean;
	@Autowired
	private RoomPlanService roomPlanServiceBean;
	@Autowired
	private HostelService hostelServiceBean;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;
//	private int amount;
	private String info;

	//预定房间要用到的数据，需要建成数据库？
	private int planId;
	private int days;
	private int roomCount;
	private String start;
	private String end;
	
	public String execute() throws Exception {
		List list=roomPlanServiceBean.getUncheckedRoomPlan(id);
		RoomList roomList = new RoomList();
		roomList.setRoomList(list);
		Hostel hostel = hostelServiceBean.getHostelById(id);
		session.put("hostel",hostel);
		session.put("roomList",roomList);

		return SUCCESS;
	}
	
	
	
	public String buyRoom(){
		User user=(User)session.get("user");
		int uid=user.getId();
		Account account=accountServiceBean.getAccount(uid);
		int val=account.getRank();
		double count=10.0;
		switch(val){
		case 1: count=9.5; break;
		case 2: count=9.0; break;
		case 3: count=8.5; break;
		case 4: count=8.0; break;
		}
		
//		RoomPlan plan=(RoomPlan)session.get("roomPlan");
		RoomPlan plan=roomPlanServiceBean.getRoomPlanInfo(planId);

//		int roomPerson = plan.getPerson();
//		int realPe = 1;
//		if(roomCount % roomPerson == 0){
//			realPe = roomCount / roomPerson;
//		}
//		else {
//			realPe = roomCount / roomPerson + 1;
//		}
		/**计算折扣后总价*/
		double afterCount=plan.getPrice()*days*roomCount*count/10;
		
		
		session.put("count", count);//折扣，打几折
		session.put("afterCount", afterCount);//打完折后的价格
		session.put("days",days );//预住天数
		session.put("roomCount",roomCount );//预购房间数
		session.put("total", days*roomCount*plan.getPrice());//未打折前价格
		session.put("roomPlan",plan);

		
		return SUCCESS;
	}

	
	public String afterCount(){
		User user=(User)session.get("user");
//		RoomPlan plan_=(RoomPlan)session.get("roomPlan");
//		int amount=(int)session.get("amount");
		int uid_=user.getId();

		double afterCount=(Double)session.get("afterCount");
		Account account=accountServiceBean.getAccount(uid_);
		
		boolean boo=accountServiceBean.consume(account.getId(), afterCount);      //改变用户账户中的记录
		
		if(!boo){
			return "nsf";
		}

		return SUCCESS;
	}
	

	public PlanService getPlanServiceBean() {
		return planServiceBean;
	}

	public void setPlanServiceBean(PlanService planServiceBean) {
		this.planServiceBean = planServiceBean;
	}




	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}
	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}
}

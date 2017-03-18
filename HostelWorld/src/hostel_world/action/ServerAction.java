package hostel_world.action;

import java.util.List;

import hostel_world.model.list.PlanList;
import hostel_world.service.AccountService;
import hostel_world.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hostel_world.model.list.PaymentList;
import hostel_world.model.Account;
import hostel_world.model.Plan;
import hostel_world.model.TicketManage;
import hostel_world.model.User;
import hostel_world.model.list.ConsumptionList;
import hostel_world.model.list.FilmList;
import hostel_world.service.ConsumptionService;
import hostel_world.service.PlanService;
import hostel_world.service.TicketService;
import hostel_world.service.UserService;

import com.opensymphony.xwork2.Action;

@Repository
public class ServerAction extends BaseAction implements Action{
	@Autowired
	private PlanService planServiceBean;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private ConsumptionService consumptionServiceBean;
	@Autowired
	private PaymentService paymentServiceBean;
	@Autowired
	private UserService userServiceBean;
	@Autowired
	private AccountService accountServiceBean;
	
	private String filmName;
	private int planId;	
	private String uid;
	
	public String execute() throws Exception {
		FilmList filmList=new FilmList();
		filmList.setFilmList(planServiceBean.getFilmList());
		session.put("filmList", filmList);
		return SUCCESS;
	}
	
	public String filmInfo(){
		List list=planServiceBean.getCurrentPlan(filmName);
		PlanList planList=new PlanList();
		planList.setPlanList(list);
		session.put("planList",planList);
		return "filmInfo";
	}

	public String enterSale(){
		TicketManage ticketManage=ticketService.getTicketMange(planId);
		Plan plan=planServiceBean.getPlanInfo(planId);
		session.put("ticketManage", ticketManage);
		session.put("plan", plan);
		return "sale";
	}
	
	
	public String enterSearch(){
		return SUCCESS;
	}
	
	public String searchResult(){
		
		int uid_=Integer.parseInt(uid);
		Account account=accountServiceBean.getAccount(uid_);
		
		if(account==null){
			return "noInfo";
		}
		
		User user=(User)userServiceBean.getUserById(uid_);
		List list=consumptionServiceBean.getAllRecord(uid_);
		ConsumptionList consumptionList=new ConsumptionList();
		consumptionList.setConsumptionList(list);
		List pay_list=paymentServiceBean.getAllRecords(uid_);
		PaymentList paymentList=new PaymentList();
		paymentList.setPaymentList(pay_list);
		
		session.put("user", user);
		session.put("account", account);
		session.put("consumptionList", consumptionList);
		session.put("paymentList",paymentList);
		
		return SUCCESS;
	}
	
	public String enterDown(){
		return SUCCESS;
	}
	
	public String downFilm(){
		return SUCCESS;
	}
	
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	
	

}

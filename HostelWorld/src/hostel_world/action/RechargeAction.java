package hostel_world.action;

import java.util.Map;


import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hostel_world.model.Account;
import hostel_world.model.User;
import hostel_world.model.list.FilmList;
import hostel_world.service.AccountService;
import hostel_world.service.PaymentService;
import hostel_world.service.PlanService;

import com.opensymphony.xwork2.Action;
@Repository
public class RechargeAction implements Action,SessionAware{
	@Autowired
	private AccountService accountServiceBean;
	@Autowired
	private PaymentService paymentServiceBean;
	@Autowired
	private PlanService planServiceBean;
	
	private Map<String,Object> sessionMap;
	
	private String amount;
	

	//enterRecharge
	public String execute() throws Exception {
		User user=(User)sessionMap.get("user");
		/**等到用户的account*/
		Account account=accountServiceBean.getAccount(user.getId());
		if(account.getBankAccount().trim().isEmpty()){
			return "bindCard";
		}
		sessionMap.put("account", account);
		return "recharge";
	}

	
	public String recharge(){
		Account account=(Account)sessionMap.get("account");
		Double amount_=Double.parseDouble(amount);
		accountServiceBean.recharge(account, amount_);
		paymentServiceBean.addNewPayment(account, amount_);
		 boolean boo=accountServiceBean.isValid(account.getUid());
		 
		 if(!boo){
			 return "invalid";
		 }
		
		FilmList filmList=new FilmList();
		filmList.setFilmList(planServiceBean.getFilmList());
		sessionMap.put("filmList", filmList);
		
		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap=arg0;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}

}

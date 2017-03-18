package hostel_world.action;

import java.util.Map;

import hostel_world.model.Account;
import hostel_world.model.User;
import hostel_world.service.AccountService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.Action;

@Repository
public class BindBankCardAction implements Action,SessionAware{
	@Autowired
	private AccountService accountServiceBean;
	
	private Map<String,Object> sessionMap;
	
	private String cardNumber;
	
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String execute() throws Exception {
		User user=(User)sessionMap.get("user");
		Account account=accountServiceBean.getAccount(user.getId());
		accountServiceBean.bindBankCard(account, cardNumber);
		return SUCCESS;
	}

	
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap=arg0;
		
	}

}

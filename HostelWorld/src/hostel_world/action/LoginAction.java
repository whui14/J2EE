package hostel_world.action;

import java.util.Map;

import hostel_world.model.Hostel;
import hostel_world.model.HostelAccount;
import hostel_world.service.*;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hostel_world.model.Account;
import hostel_world.model.list.FilmList;
import hostel_world.model.User;

import com.opensymphony.xwork2.Action;

@Repository
public class LoginAction implements Action,SessionAware{
	@Autowired
	private UserService userService;
	@Autowired
	private PlanService planServiceBean;
	@Autowired
	private AccountService accountServiceBean;

	@Autowired
	private HostelService hostelService;

	@Autowired
	private HostelAccountService hostelAccountServiceBean;

	private Map<String,Object> sessionMap;


	private int identity;
	private String name;
	private String password;
	private int sub;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 登录成功
	 * 登录失败
	 */
	public String execute() throws Exception {

		
		if(sub==0){
			return "register";
		}
		if(sub==2){
			return "hostelregister";
		}
		
		

		if(identity==1) {
			User user = userService.login(name, password);

			if (user == null) {
				return "failure";
			}

			sessionMap.put("user", user);

			Account account = accountServiceBean.getAccount(user.getId());
			sessionMap.put("account", account);
			boolean boo = accountServiceBean.isValid(user.getId());

			if (!boo) {
				return "invalid";
			}

			FilmList filmList = new FilmList();
			filmList.setFilmList(planServiceBean.getFilmList());
			sessionMap.put("filmList", filmList);

			return "success";
		} else{
			Hostel hostel = hostelService.login(name,password);
			if (hostel == null) {
				return "failure";
			}

			sessionMap.put("hostel", hostel);
			HostelAccount account = hostelAccountServiceBean.getHostelAccount(hostel.getId());
			sessionMap.put("hostelaccount", account);
			return "hostel";
		}
	}

//	public String test(){
//		int a = 0;
//		if(a == 0){
//			return "fail";
//		}
//		else{
//			return SUCCESS;
//		}
//	}
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap=arg0;
		
	}

	public int getSub() {
		return sub;
	}

	public void setSub(int sub) {
		this.sub = sub;
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}


}

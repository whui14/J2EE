package hostel_world.dao.impl;

import java.util.List;

import hostel_world.dao.ConsumptionDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hostel_world.model.Consumption;
import hostel_world.model.Plan;

@Repository
public class ConsumptionDaoImpl implements ConsumptionDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.openSession();
	}
	
	public void buyTicket(Plan plan,int amount,int uid,double afterCount) {       //记录消费记录
		Consumption consumption=new Consumption();
		consumption.setAmount(amount);      //数量
		consumption.setItem(plan.getTitle());
		consumption.setPlanId(plan.getId());
		consumption.setPrice(plan.getPrice());
		consumption.setUid(uid);   //用户	
		consumption.setTotalFee(afterCount);
		getSession().save(consumption);
		
	}

	
	public List getAllRecord(Integer uid) {
		String hql="from Consumption c where c.uid=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0, uid);
		List list=query.list();
		return list;
	}

	
	public List getAllPlanId(Integer uid) {
		String hql="select c.planId from Consumption c where c.uid=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0, uid);
		List list=query.list();
		return list;
	}

}

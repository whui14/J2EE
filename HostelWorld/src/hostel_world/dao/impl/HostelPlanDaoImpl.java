package hostel_world.dao.impl;

import hostel_world.dao.HostelPlanDao;
import hostel_world.model.HostelPlan;
import hostel_world.model.Hostel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class HostelPlanDaoImpl implements HostelPlanDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.openSession();
	}

	
	public void publishPlan(Integer id) {    //发布计划
//		System.out.println(id);
		String hql="update HostelPlan p set p.pass=1 where p.id=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0,id);
		query.executeUpdate();


	}


	public void vetoPlan(Integer id) {  //否决计划
		String hql="update HostelPlan p set p.pass=-2 where p.id=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0,id);
		query.executeUpdate();

	}


	public void modifyPlan(HostelPlan plan) {
		String hql="update HostelPlan p set p.hostelName=?,p.telephone=?,p.address=?,p.time=?,p.introduction=?,p.pass=? where p.id=?";
		Query query=getSession().createQuery(hql);
		query.setString(0, plan.getHostelName());
		query.setString(1, plan.getTelephone());
		query.setString(2, plan.getAddress());
		query.setTimestamp(3, plan.getTime());
		query.setString(4, plan.getIntroduction());
		query.setInteger(5, 0);
		query.setInteger(6, plan.getId());
		query.executeUpdate();


	}


	public void addPlan(HostelPlan plan){
//		String hql = "insert into hostelplan (id, name, password, hostelname, telephone, address, time, introduction, pictureurl, pass ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		Query query=getSession().createSQLQuery(hql);
//		query.setInteger(0,)
//		query.setString(1, plan.getName());
//		Transaction transaction = getSession().beginTransaction();
		getSession().save(plan);
//		transaction.commit();
		}

	
	public HostelPlan getPassedPlan() {
		String hql="from HostelPlan p where p.pass=1";
		Query query=getSession().createQuery(hql);
		List list=query.list();
		return (HostelPlan)list.get(0);
	}



	public HostelPlan getUnpassedPlan(Integer id) {
		String hql="from HostelPlan p where p.pass=-2 and p.id=?";
		Query query=getSession().createQuery(hql);
		List list=query.list();
		return (HostelPlan)list.get(0);
	}

	
	public List<Object> getUncheckedPlan() {
		String hql="from HostelPlan p where p.pass=4";
		Query query=getSession().createQuery(hql);
		List list=query.list();
		return list;
	}

	
	public HostelPlan getPlanInfo(Integer id) {
		HostelPlan plan=(HostelPlan) getSession().get(Hostel.class,id);
		return plan;
	}

	
	public List getFilmList() {
		//overduePlan();
		String hql="select distinct p.hostelName from Hostel p where p.pass=1";
		Query query=getSession().createQuery(hql);
		List list=query.list();
		return list;
	}
	public void deletePlanInfo(Integer id){
		String hql="delete HostelPlan p where p.id=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0,id);
		query.executeUpdate();
	}

	@Override
	public void updateHostelPlan(HostelPlan hostelPlan) {
		getSession().update(hostelPlan);
	}


}

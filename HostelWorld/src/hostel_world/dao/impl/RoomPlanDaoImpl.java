package hostel_world.dao.impl;



import hostel_world.dao.RoomPlanDao;
import hostel_world.model.RoomPlan;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class RoomPlanDaoImpl implements RoomPlanDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.openSession();
	}
	
	public void addRoomPlan(RoomPlan plan) {
		getSession().save(plan);
	}


	public void publishRoomPlan(Integer id) {    //发布计划
		String hql="update RoomPlan p set p.state=1 where p.id=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0,id);
		query.executeUpdate();

	}

	
	public void vetoRoomPlan(Integer id) {  //否决计划
		String hql="update RoomPlan p set p.state=-1 where p.id=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0,id);
		query.executeUpdate();

	}


	public void modifyRoomPlan(RoomPlan plan) {
		String hql="update RoomPlan p set p.hid=?,p.title=?,p.breakfast=?,p.type=?,p.person=?,p.cancel=?,p.price=?,p.state=? where p.id=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0, plan.getHid());
		query.setString(1, plan.getTitle());
		query.setInteger(2, plan.getBreakfast());
		query.setString(3, plan.getType());
		query.setInteger(4, plan.getPerson());
		query.setInteger(5, plan.getCancel());
		query.setDouble(6, plan.getPrice());
		query.setInteger(7, 0);
		query.setInteger(8, plan.getId());
		query.executeUpdate();

	}

	
	public void abandonRoomPlan(Integer id) {
		/**
		RoomPlan p=(RoomPlan)getSession().get(RoomPlan.class,id);
		if(p!=null){
			getSession().delete(p);
		}
		**/
		String hql="delete from RoomPlan p where p.id=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0, id);
		query.executeUpdate();
	}

	
	public void overdueRoomPlan() {
		/**得到当前的时间戳*/
		Timestamp d= new Timestamp(System.currentTimeMillis());
		String hql="update RoomPlan p set p.state=2 where p.airTime<?";
		Query query=getSession().createQuery(hql);
		query.setTimestamp(0, d);
		query.executeUpdate();
	}

	
	public List<Object> getPassedRoomPlan() {
		String hql="from RoomPlan p where p.state=1";
		Query query=getSession().createQuery(hql);
		List list=query.list();
		return list;
	}

	
	public List<Object> getUnpassedRoomPlan() {
		String hql="from RoomPlan p where p.state=-1";
		Query query=getSession().createQuery(hql);
		List list=query.list();
		return list;
	}

	
	public List<Object> getUncheckedRoomPlan(Integer id) {
		String hql="from RoomPlan p where p.id=?";
		Query query=getSession().createQuery(hql);
		List list=query.list();
		return list;
	}

	
	public RoomPlan getRoomPlanInfo(Integer id) {
		RoomPlan plan=(RoomPlan)getSession().get(RoomPlan.class,id);
		return plan;
	}

	
	public List getFilmList() {
		//overdueRoomPlan();
		String hql="select distinct p.title from RoomPlan p where p.state=1";
		Query query=getSession().createQuery(hql);
		List list=query.list();
		return list;
	}

	
	public List getCurrentRoomPlan(String title) {
		String hql="from RoomPlan p where p.title=? and p.state=1";
		Query query=getSession().createQuery(hql);
		query.setString(0, title);
		List list=query.list();
		return list;
	}

	
	public List getCurrentRoomPlanId() {
		String hql="select p.id from RoomPlan p";
		Query query=getSession().createQuery(hql);
		List list=query.list();
		return list;
	}

}

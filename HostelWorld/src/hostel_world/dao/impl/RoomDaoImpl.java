package hostel_world.dao.impl;


import hostel_world.dao.RoomDao;
import hostel_world.model.Room;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RoomDaoImpl implements RoomDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.openSession();
	}
	
	
	
	public Room getRoom(String title) {
		String hql="from Room f where f.title=?";
		Query query=(Query) getSession().createQuery(hql);
		query.setString(0, title);
		List list=query.list();
		Room room=(Room)list.get(0);
		return room;
	}

	
	public void addNewRoom(Room room) {
		getSession().save(room);

	}

	
	public boolean searchRoom(String title) {
		String hql="from Room f where f.title=?";
		Query query=(Query) getSession().createQuery(hql);
		query.setString(0, title);
		List list=query.list();
		if(list.size()==0){
			return false;
		}
		return true;
	}

}

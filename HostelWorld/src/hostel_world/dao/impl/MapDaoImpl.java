package hostel_world.dao.impl;

import java.util.List;

import hostel_world.dao.MapDao;
import hostel_world.model.QuestionMap;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MapDaoImpl implements MapDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.openSession();
	}
	
	
	
	public void addNewMap(QuestionMap map) {
		getSession().save(map);
	}

	
	public List getQuestion(int pid) {
		String hql="select q.qid from Question q where q.pid=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0, pid);
		List list=query.list();
		return list;
	}

}

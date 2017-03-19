package hostel_world.dao.impl;

import hostel_world.dao.HostelDao;
import hostel_world.model.Hostel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HostelDaoImpl implements HostelDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public Session getSession(){
        return this.sessionFactory.openSession();
    }

    public void Save(Hostel hostel) {
        System.out.println(hostel.getAddress());
        System.out.println(hostel.getHostelName());
        System.out.println(hostel.getId());
        System.out.println(hostel.getIntroduction());
        System.out.println(hostel.getName());
        System.out.println(hostel.getPass());
        System.out.println(hostel.getPassword());
        System.out.println(hostel.getTime());
        System.out.println(hostel.getTelephone());
        System.out.println(hostel.getPictureurl());
        getSession().save(hostel);

    }

    public Hostel getHostel(String name, String password) {
        String hql="from Hostel h  where name=? and password=?";

        Query query=getSession().createQuery(hql);
        query.setString(0,name);
        query.setString(1, password);
        List list=query.list();

        if(list.size()!=0){
            Hostel hostel=(Hostel)list.get(0);
            return hostel;
        }
        return null;
    }

    public Hostel geyHostelById(Integer id) {
        return (Hostel)getSession().get(Hostel.class, id);
    }

    public void modifyProfile(Hostel hostel) {

        Hostel hostel_=(Hostel)getSession().get(Hostel.class, hostel.getId());
        hostel_.setAddress(hostel.getAddress());
        hostel_.setHostelName(hostel.getHostelName());
        hostel_.setIntroduction(hostel.getIntroduction());
        hostel_.setTelephone(hostel.getTelephone());
        hostel_.setTime(hostel.getTime());
        hostel_.setPictureurl(hostel.getPictureurl());
        getSession().update(hostel_);
    }

    @Override
    public void enterModifyWaiting(Integer id) {
        String hql = "Update Hostel h set h.pass = 4 where h.id = ?";
        Query query=getSession().createQuery(hql);
        query.setInteger(0, id);
        query.executeUpdate();
    }

    @Override
    public void setPassValue(Integer id, Integer value) {
        String hql = "Update Hostel h set h.pass = ? where h.id = ?";
        Query query=getSession().createQuery(hql);
        query.setInteger(0, value);
        query.setInteger(1, id);
        query.executeUpdate();
    }

    @Override
    public List<Object> getUncheckedHostelPlan() {
        String hql="from Hostel p where p.pass=0";
        Query query=getSession().createQuery(hql);
        List list=query.list();
        return list;
    }

    @Override
    public void publishHostelPlan(Integer id) {
        String hql="update Hostel p set p.pass=1 where p.id=?";
        Query query=getSession().createQuery(hql);
        query.setInteger(0,id);
        query.executeUpdate();
    }

    @Override
    public void vetoPlan(Integer id) {
        String hql="update Hostel p set p.pass=-1 where p.id=?";
        Query query=getSession().createQuery(hql);
        query.setInteger(0,id);
        query.executeUpdate();
    }

    @Override
    public List<Object> getAllHostel() {
        String hql="from Hostel p where p.pass=1";
        Query query=getSession().createQuery(hql);
        List list=query.list();
        return list;
    }


}

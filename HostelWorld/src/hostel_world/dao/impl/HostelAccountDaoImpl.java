package hostel_world.dao.impl;

import hostel_world.dao.HostelAccountDao;
import hostel_world.model.HostelAccount;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class HostelAccountDaoImpl implements HostelAccountDao{
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public Session getSession(){
        return this.sessionFactory.openSession();
    }


    public void addNewHostelAccount(HostelAccount hostel_account) {
        getSession().save(hostel_account);
    }


    public void bindBankCard(HostelAccount hostel_account, String bankAccount) {

        String hql="update HostelAccount h set h.bankAccount=? where h.id=?";
        Query query=getSession().createQuery(hql);
        query.setString(0, bankAccount);
        query.setInteger(1, hostel_account.getId());
        query.executeUpdate();
    }


    public void getIntegration(Integer id, int integration) {
        HostelAccount account=(HostelAccount)getSession().get(HostelAccount.class, id);
        int total=integration+account.getIntegration();
        String hql="update HostelAccount h set h.integration=? where h.id=?";
        Query query=getSession().createQuery(hql);
        query.setInteger(0, total);
        query.setInteger(1, id);
        query.executeUpdate();
    }


    public void exchangeCredit(Integer id) {

        HostelAccount account=(HostelAccount)getSession().get(HostelAccount.class, id);
        double amount=account.getIntegration()/10;
        account.setIntegration(0);
        account.setBalance(account.getBalance()+amount);
        String hql="update HostelAccount h set h.integration=0,h.balance=? where h.id=?";
        Query query=getSession().createQuery(hql);
        query.setDouble(0, account.getBalance());
        query.setInteger(1, id);
        query.executeUpdate();
    }


    public boolean consume(Integer id, double amount) {
        HostelAccount account=(HostelAccount)getSession().get(HostelAccount.class, id);
        if(account.getBalance()<amount){
            return false;
        }

        int integration=(int)amount;
        account.setIntegration(account.getIntegration()+integration);
        account.setBalance(account.getBalance()-amount);
        String hql="update HostelAccount h set h.integration=?,h.balance=? where h.id=?";
        Query query=getSession().createQuery(hql);
        query.setInteger(0, account.getIntegration());
        query.setDouble(1, account.getBalance());
        query.setInteger(2, id);
        query.executeUpdate();


        return true;
    }


    public boolean ifCardBeBinded(Integer id) {
        return false;
    }


    public void recharge(HostelAccount hostel_account, double amount) {

        HostelAccount iAccount=(HostelAccount)getSession().get(HostelAccount.class, hostel_account.getId());
        /**
         * 更新会员账号的金额
         */
        iAccount.setBalance(iAccount.getBalance()+amount);
        if(amount>=200.0){
            /**
             * 激活会员号
             */
            iAccount.setIsValid(1);
            /**
             * 根据用户交纳金额度设置用户等级
             */
            int rank=iAccount.getRank();
            if(amount<=300.0){
                iAccount.setRank(Math.max(rank, 1));
            }else if(amount<=500.0){
                iAccount.setRank(Math.max(rank, 2));
            }else if(amount<=1000.0){
                iAccount.setRank(Math.max(rank, 3));
            }else{
                iAccount.setRank(Math.max(rank, 4));
            }
            /**
             * 更新会员上一次有效缴费时间
             */
            Timestamp d=new Timestamp(System.currentTimeMillis());
            iAccount.setLastTime(d);
        }

        String hql="update HostelAccount h set h.isValid=?,h.rank=?,h.lastTime=?,h.balance=? where h.id=?";
        Query query=getSession().createQuery(hql);
        query.setInteger(0, iAccount.getIsValid());
        query.setInteger(1, iAccount.getRank());
        query.setTimestamp(2, iAccount.getLastTime());
        query.setDouble(3,  iAccount.getBalance());
        query.setInteger(4, hostel_account.getId());
        query.executeUpdate();
    }


    public HostelAccount getHostelAccount(Integer hid) {
        String hql="from HostelAccount h where h.hid=?";
        Query query=getSession().createQuery(hql);
        query.setInteger(0, hid);
        List list=query.list();
        if(list.size()==0){
            return null;
        }
        HostelAccount account=(HostelAccount)list.get(0);
        return account;
    }


    public boolean isValid(Integer hid) {
        overDueAccount(hid);
        String hql="from HostelAccount h where h.hid=?";
        Query query=getSession().createQuery(hql);
        query.setInteger(0, hid);
        List list=query.list();
        HostelAccount account=(HostelAccount)list.get(0);

        if(account.getIsValid()==0){
            return false;
        }
        return true;
    }


    public void overDueAccount(Integer hid) {

        String hql="from HostelAccount h where h.hid=?";
        Query query=getSession().createQuery(hql);
        query.setInteger(0, hid);
        List list=query.list();
        HostelAccount account=(HostelAccount)list.get(0);
        if(account.getIsValid()==1){
            Timestamp d1=new Timestamp(System.currentTimeMillis());
            Timestamp d2=account.getLastTime();
            if(((d1.getTime()-d2.getTime())/1000/60/60/24/365)>=1){
                hql="update HostelAccount h set h.isValid=0 where h.hid=?";
                query=getSession().createQuery(hql);
                query.setInteger(0, hid);
                query.executeUpdate();
            }
        }
    }
}

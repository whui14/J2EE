package hostel_world.service.bean;


import hostel_world.dao.AccountDao;
import hostel_world.dao.HostelDao;
import hostel_world.model.Account;
import hostel_world.model.Hostel;
import hostel_world.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelServiceBean implements HostelService {

    @Autowired
    private HostelDao hostelDaoImpl;
    @Autowired
    private AccountDao accountDaoImpl;

    public HostelDao getHostelDaoImpl() {
        return hostelDaoImpl;
    }
    public void setHostelDaoImpl(HostelDao hostelDaoImpl) {
        this.hostelDaoImpl = hostelDaoImpl;
    }

    public boolean register(Hostel hostel) {
        this.hostelDaoImpl.Save(hostel);
        Hostel atHostel=this.hostelDaoImpl.getHostel(hostel.getName(), hostel.getPassword());
        Account account=new Account();
        account.setUid(atHostel.getId());
        account.setRank(0);
        account.setBalance(0.00);
        account.setBankAccount("");
        account.setIsValid(0);
        account.setLastTime(null);
        account.setIntegration(0);
        this.accountDaoImpl.addNewAccount(account);
        return true;
    }


    public Hostel login(String name, String password) {
        return this.hostelDaoImpl.getHostel(name, password);
    }


    public void modifyProfile(Hostel hostel) {

        hostelDaoImpl.modifyProfile(hostel);
    }


    public Hostel getHostelById(Integer id) {
        return hostelDaoImpl.geyHostelById(id);
    }

    @Override
    public void enterModifyWaiting(Integer id) {
        hostelDaoImpl.enterModifyWaiting(id);
    }

    @Override
    public List<Object> getUncheckedHostelPlan() {
        return hostelDaoImpl.getUncheckedHostelPlan();
    }

    @Override
    public void publishHostelPlan(Integer id) {
        hostelDaoImpl.publishHostelPlan(id);
    }

    @Override
    public void vetoPlan(Integer id) {
        hostelDaoImpl.vetoPlan(id);
    }

    @Override
    public void setPassValue(Integer id, Integer value) {
        hostelDaoImpl.setPassValue(id, value);
    }

}

package hostel_world.service.bean;


import hostel_world.dao.HostelAccountDao;
import hostel_world.model.HostelAccount;
import hostel_world.service.HostelAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostelAccountServiceBean implements HostelAccountService {
    @Autowired
    private HostelAccountDao accountDaoImpl;


    public HostelAccount getHostelAccount(Integer hid) {
        return accountDaoImpl.getHostelAccount(hid);
    }


    public void bindBankCard(HostelAccount account, String cardNumber) {
        accountDaoImpl.bindBankCard(account, cardNumber);
    }


    public void recharge(HostelAccount account, double amount) {
        accountDaoImpl.recharge(account, amount);
    }


    public void getIntegration(Integer id, int credit) {

        accountDaoImpl.getIntegration(id, credit);
    }


    public void exchangeCredit(Integer id) {
        accountDaoImpl.exchangeCredit(id);
    }


    public boolean consume(Integer id, double amount) {
        return accountDaoImpl.consume(id, amount);
    }


    public boolean ifCardBeBinded(Integer id) {
        return accountDaoImpl.isValid(id);
    }


    public boolean isValid(Integer hid) {
        return accountDaoImpl.isValid(hid);

    }


    public void overDueHostelAccount(Integer hid) {

        accountDaoImpl.overDueAccount(hid);
    }
}

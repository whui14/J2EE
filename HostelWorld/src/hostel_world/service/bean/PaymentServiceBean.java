package hostel_world.service.bean;

import java.util.List;

import hostel_world.dao.PaymentDao;
import hostel_world.model.Account;
import hostel_world.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceBean implements PaymentService {
	@Autowired
	private PaymentDao paymentDaoImpl;
	
	
	public void addNewPayment(Account account, double fee) {
		paymentDaoImpl.payFee(account, fee);

	}

	public List getAllRecords(Integer uid) {
		return paymentDaoImpl.getAllRecords(uid);

	}

}

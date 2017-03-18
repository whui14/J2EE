package hostel_world.service;


import hostel_world.model.HostelAccount;

public interface HostelAccountService {
    /**
     * 根据用户的id或者对应的HostelAccount
     * @param hid
     * @return
     */
    public HostelAccount getHostelAccount(Integer hid);
    /**
     * 会员给账号绑定银行卡
     * @param account
     * @param cardNumber
     */
    public void bindBankCard(HostelAccount account,String cardNumber);
    /**
     * 会员给账号充值
     * @param account
     * @param amount
     */
    public void recharge(HostelAccount account,double amount);
    /**
     * 用户获得积分
     * @param id
     * @param credit
     */
    public void getIntegration(Integer id,int credit);
    /**
     * 将用户的积分兑换为卡金额
     * @param id
     */
    public void exchangeCredit(Integer id);  //5个积分兑换1元RMB
    /**
     * 用户消费
     * @param amount
     * @return
     */
    public boolean consume(Integer id,double amount);  //如果卡里余额不足返回false
    /**
     * 判断账号是否已经绑定银行卡
     * @param id
     * @return
     */
    public boolean ifCardBeBinded(Integer id);
    /**
     * 判断会员号是否到期
     * @param hid
     * @return
     */
    public boolean isValid(Integer hid);
    /**
     * 过期账户
     * @param hid
     */
    public void overDueHostelAccount(Integer hid);


}

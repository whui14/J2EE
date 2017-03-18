package hostel_world.dao;

import hostel_world.model.HostelAccount;

public interface HostelAccountDao {
    /**
     * 新的客栈注册
     * @param hostel_account
     */
    public void addNewHostelAccount(HostelAccount hostel_account);
    /**
     * 用户绑定银行卡
     * @param hostel_account
     * @param bankAccount
     */
    public void bindBankCard(HostelAccount hostel_account,String bankAccount);
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
    public void exchangeCredit(Integer id);  //5个积分兑换1元
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
     * 用户向会员卡中充值
     * @param hostel_account
     * @param amount
     */
    public void recharge(HostelAccount hostel_account,double amount);
    /**
     * 返回会员的账户信息
     * @param hid
     * @return
     */
    public HostelAccount getHostelAccount(Integer hid);
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
    public void overDueAccount(Integer hid);
}

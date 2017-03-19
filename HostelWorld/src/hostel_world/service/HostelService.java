package hostel_world.service;


import hostel_world.model.Hostel;

import java.util.List;

public interface HostelService {
    /**
     * 注册新客栈
     * @return
     */
    public boolean register(Hostel hostel);
    /**
     * 客栈管理员登录
     * @return
     */
    public Hostel login(String name,String password);
    /**
     * 修改客栈资料
     * @param hostel
     */
    public void modifyProfile(Hostel hostel);
    /**
     *
     * @param id
     * @return
     */
    public Hostel getHostelById(Integer id);

    void enterModifyWaiting(Integer id);

    /**
     * 获得待审核的客栈申请
     * @return
     */
    public List<Object> getUncheckedHostelPlan();

    /**
     * 经理审核确认客栈申请
     * @param id
     */
    public void publishHostelPlan(Integer id);

    /**
     * 经理审核否决某客栈申请
     * @param id
     */
    public void vetoPlan(Integer id);

    void setPassValue(Integer id, Integer value);
    /**
     * 获得已经通过的客栈申请
     * @return
     */
    public List<Object> getPassedHostelPlan();
}

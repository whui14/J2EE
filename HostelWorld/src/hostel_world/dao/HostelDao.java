package hostel_world.dao;

import hostel_world.model.Hostel;

import java.util.List;

public interface HostelDao {
    /**
     * 保存新的客栈管理员
     * @param hostel
     */
    public void Save(Hostel hostel);
    /**
     * 登录使用
     * @param id
     * @param password
     * @return
     */
    public Hostel getHostel(String id,String password);
    /**
     * 根据Id返回id
     * @param id
     * @return
     */
    public Hostel geyHostelById(Integer id);
    /**
     *
     * @param hostel
     */
    public void modifyProfile(Hostel hostel);

    void enterModifyWaiting(Integer id);

    void setPassValue(Integer id, Integer value);

    List<Object> getUncheckedHostelPlan();

    void publishHostelPlan(Integer id);

    void vetoPlan(Integer id);

    /**
     * 得到所有的Hostel
     * @return
     */
    List<Object> getAllHostel();
}

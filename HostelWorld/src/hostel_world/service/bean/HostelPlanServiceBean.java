package hostel_world.service.bean;


import hostel_world.dao.HostelDao;
import hostel_world.dao.HostelPlanDao;
import hostel_world.model.Hostel;
import hostel_world.model.HostelPlan;
import hostel_world.service.HostelPlanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelPlanServiceBean implements HostelPlanService {
    @Autowired
    private HostelDao hostelDaoImpl;
    @Autowired
    private HostelPlanDao hostelPlanDaoImpl;


    public void publishHostelPlan(Integer id) {

        HostelPlan planInfo = hostelPlanDaoImpl.getPlanInfo(id);
        planInfo.setPass(1);
        Hostel hostel = new Hostel();
        BeanUtils.copyProperties(planInfo, hostel);
        hostelDaoImpl.modifyProfile(hostel);
        hostelPlanDaoImpl.deletePlanInfo(id);
    }


    public void vetoPlan(Integer id) {
        hostelPlanDaoImpl.vetoPlan(id);
    }

    public HostelPlan getPassedHostelPlan() {
        return hostelPlanDaoImpl.getPassedPlan();
    }



    public HostelPlan getUnpassedHostelPlan(Integer id) {
        return hostelPlanDaoImpl.getUnpassedPlan(id);
    }


    public List<Object> getUncheckedHostelPlan() {
        return hostelPlanDaoImpl.getUncheckedPlan();
    }


    public HostelPlan getHostelPlanInfo(Integer id) {
        return hostelPlanDaoImpl.getPlanInfo(id);
    }

    @Override
    public void addHostelPlan(HostelPlan hostelPlan) {
        hostelPlanDaoImpl.addPlan(hostelPlan);
    }

    @Override
    public void updateHostelPlan(HostelPlan hostelPlan) {
        hostelPlanDaoImpl.updateHostelPlan(hostelPlan);
    }

    @Override
    public void deletePlanInfo(Integer id) {
        hostelPlanDaoImpl.deletePlanInfo(id);
    }
}

package hostel_world.service.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hostel_world.dao.FilmDao;
import hostel_world.dao.PlanDao;
import hostel_world.dao.SeatDao;
import hostel_world.model.Film;
import hostel_world.model.Plan;
import hostel_world.service.PlanService;

@Service
public class PlanServiceBean implements PlanService {
	@Autowired
	private PlanDao planDaoImpl;
	@Autowired
	private FilmDao filmDaoImpl;
	@Autowired
	private SeatDao seatDaoImpl;
	
	
	public void createNewPlan(Plan plan) {
		planDaoImpl.addPlan(plan);
		
		if(!filmDaoImpl.searchFilm(plan.getTitle())){//假如当前电影尚未存入数据库 则添加新的电影信息
			Film film=new Film();
			film.setTitle(plan.getTitle());
			film.setDirector(plan.getDirector());
			film.setDuration(plan.getDuration());
			film.setFirstRunTime(plan.getFirstRunTime());
			film.setLanguage(plan.getLanguage());
			film.setType(plan.getType());
			film.setPosturl(plan.getPosturl());
			
			filmDaoImpl.addNewFilm(film);
		}
	}

	
	public void publishPlan(Integer id) {
		planDaoImpl.publishPlan(id);
		seatDaoImpl.addNewSeat(id);
	}

	
	public void modifyPlan(Plan plan) {
		planDaoImpl.modifyPlan(plan);
	}

	
	public void vetoPlan(Integer id) {
		planDaoImpl.vetoPlan(id);
	}

	
	public void abandonPlan(Integer id) {
		planDaoImpl.abandonPlan(id);
	}

	
	public List<Object> getPassedPlan() {
		return planDaoImpl.getPassedPlan();
	}

	
	public List<Object> getUnpassedPlan() {
		return planDaoImpl.getUnpassedPlan();
	}

	
	public List<Object> getUncheckedPlan() {
		return planDaoImpl.getUncheckedPlan();
	}

	
	public Plan getPlanInfo(Integer id) {
		return planDaoImpl.getPlanInfo(id);
	}

	public List getFilmList() {
		List list=planDaoImpl.getFilmList();
		List filmList=new ArrayList();
		for(int i=0;i<list.size();i++){
			String title=(String)list.get(i);
			Film film=filmDaoImpl.getFilm(title);
			filmList.add(film);
		}
		return filmList;
	}

	public List getCurrentPlan(String title) {
		return planDaoImpl.getCurrentPlan(title);
	}


	
	public List getCurrentPlanId() {
		return planDaoImpl.getCurrentPlanId();
	}

}

package hostel_world.service.bean;

import hostel_world.dao.FilmDao;
import hostel_world.dao.RoomPlanDao;
import hostel_world.dao.SeatDao;
import hostel_world.model.Film;
import hostel_world.model.RoomPlan;
import hostel_world.service.RoomPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomPlanServiceBean implements RoomPlanService {
	@Autowired
	private RoomPlanDao planDaoImpl;
	@Autowired
	private FilmDao filmDaoImpl;
	@Autowired
	private SeatDao seatDaoImpl;
	
	
	public void createNewRoomPlan(RoomPlan plan) {
		planDaoImpl.addRoomPlan(plan);
		
//		if(!filmDaoImpl.searchFilm(plan.getTitle())){//假如当前电影尚未存入数据库 则添加新的电影信息
//			Film film=new Film();
//			film.setTitle(plan.getTitle());
//			film.setDirector(plan.getDirector());
//			film.setDuration(plan.getDuration());
//			film.setFirstRunTime(plan.getFirstRunTime());
//			film.setLanguage(plan.getLanguage());
//			film.setType(plan.getType());
//			film.setPosturl(plan.getPosturl());
//
//			filmDaoImpl.addNewFilm(film);
//		}
	}

	
	public void publishRoomPlan(Integer id) {
		planDaoImpl.publishRoomPlan(id);
		seatDaoImpl.addNewSeat(id);
	}

	
	public void modifyRoomPlan(RoomPlan plan) {
		planDaoImpl.modifyRoomPlan(plan);
	}

	
	public void vetoRoomPlan(Integer id) {
		planDaoImpl.vetoRoomPlan(id);
	}

	
	public void abandonRoomPlan(Integer id) {
		planDaoImpl.abandonRoomPlan(id);
	}


	public List<Object> getPassedRoomPlan() {
		return planDaoImpl.getPassedRoomPlan();
	}

	
	public List<Object> getUnpassedRoomPlan() {
		return planDaoImpl.getUnpassedRoomPlan();
	}

	
	public List<Object> getUncheckedRoomPlan(Integer id) {
		return planDaoImpl.getUncheckedRoomPlan(id);
	}

	
	public RoomPlan getRoomPlanInfo(Integer id) {
		return planDaoImpl.getRoomPlanInfo(id);
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

	public List getCurrentRoomPlan(String title) {
		return planDaoImpl.getCurrentRoomPlan(title);
	}


	
	public List getCurrentRoomPlanId() {
		return planDaoImpl.getCurrentRoomPlanId();
	}

}

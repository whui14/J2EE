package hostel_world.service.bean;

import java.util.List;

import hostel_world.model.Question;
import hostel_world.model.QuestionMap;
import hostel_world.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hostel_world.dao.MapDao;
import hostel_world.dao.QuestionDao;

@Service
public class QuestionServiceBean implements QuestionService {
	@Autowired
	private QuestionDao questionDaoImpl;
	@Autowired
	private MapDao mapDaoImpl;
	
	public int addNewQuestion(Question question) {
		return questionDaoImpl.addNewQuestion(question);

	}

	public Question getQuestion(int id) {
		return questionDaoImpl.getQuestion(id);
	}

	
	public List getQuestionList(int pid) {
		return questionDaoImpl.getQuestionListByPid(pid);
	}

	
	public void saveMap(QuestionMap questionMap) {
		mapDaoImpl.addNewMap(questionMap);	
	}

}

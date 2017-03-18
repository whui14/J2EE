package hostel_world.service.bean;

import java.util.List;

import hostel_world.dao.AnswerDao;
import hostel_world.dao.QuestionDao;
import hostel_world.model.Answer;
import hostel_world.model.AnswerMap;
import hostel_world.model.Question;
import hostel_world.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceBean implements AnswerService {
	@Autowired
	private AnswerDao answerDaoImpl;
	@Autowired
	private QuestionDao questionDaoImpl;
	
	
	public void addAnswerMap(Integer uid, Integer pid) {
		List list=questionDaoImpl.getQuestionListByPid(pid);
		for(int i=0;i<list.size();i++){
			Question question=(Question)list.get(i);
			
			if(!answerDaoImpl.isIn(uid, question.getId())){
			AnswerMap am=new AnswerMap();
			am.setQid(question.getId());
			am.setUid(uid);
			answerDaoImpl.addAnswerMap(am);
			}			
		}	
	}

	public List getQuestionList(Integer uid) {
		return answerDaoImpl.getQuestion(uid);
	}

	
	public void saveAnswer(Answer answer) {
		answerDaoImpl.saveAnswer(answer);
		
	}

	
	public void deleteAnswerMap(Integer uid, Integer qid) {
		answerDaoImpl.deleteAnswerMap(uid, qid);
		
	}
	
}

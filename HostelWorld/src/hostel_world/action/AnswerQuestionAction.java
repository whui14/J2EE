package hostel_world.action;

import java.util.List;

import hostel_world.model.Answer;
import hostel_world.model.Question;
import hostel_world.model.list.QuestionList;
import hostel_world.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hostel_world.model.User;

import com.opensymphony.xwork2.Action;

@Repository
public class AnswerQuestionAction extends BaseAction implements Action{
	@Autowired
	private AnswerService answerServiceBean;
	
	public String execute() throws Exception {
		QuestionList questionList=(QuestionList)session.get("questionList");
		User user=(User)session.get("user");
		
		for(int i=0;i<questionList.getQuestionList().size();i++){
			int id=((Question)questionList.getQuestionList(i)).getId();
			String id_=String.valueOf(id);
			String option=request.getParameter(id_);
			int option_=Integer.parseInt(option);
			
			Answer answer=new Answer();
			answer.setAnswer(option_);
			answer.setQid(id);
			answer.setUid(user.getId());
			
			answerServiceBean.saveAnswer(answer);
			answerServiceBean.deleteAnswerMap(user.getId(), id);
		}
		
		
		return SUCCESS;
	}
	
	public String enterAnswer(){
		User user=(User)session.get("user");
		List list=answerServiceBean.getQuestionList(user.getId());
		
		QuestionList questionList=new QuestionList();
		questionList.setQuestionList(list);		
		session.put("questionList", questionList);
		return SUCCESS;
	}

}

package hostel_world.model.list;

import java.io.Serializable;
import java.util.List;

import hostel_world.model.Question;

public class QuestionList implements Serializable{
	private List questionList;

	public List getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List questionList) {
		this.questionList = questionList;
	}
	
	public Question getQuestionList(int index){
		return (Question)questionList.get(index);
	}
}

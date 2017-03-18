package hostel_world.action;


import hostel_world.model.Question;
import hostel_world.model.QuestionMap;
import hostel_world.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hostel_world.model.list.PlanIdList;
import hostel_world.service.PlanService;

import com.opensymphony.xwork2.Action;

@Repository
public class PutQuestionAction extends BaseAction implements Action{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private PlanService planServiceBean;
	@Autowired
	private QuestionService questionServiceBean;
	
	private Question question;
	private Integer[] plan;
	
	
	
	public String execute() throws Exception {
		int qid=questionServiceBean.addNewQuestion(question);
		QuestionMap questionMap=new QuestionMap();
		questionMap.setQid(qid);
		if(plan!=null&plan.length>0){
			for(int i=0;i<plan.length;i++){
				questionMap.setPid(plan[i]);
				questionServiceBean.saveMap(questionMap);
			}
		}
		return SUCCESS;
	}
	
	public String enterQuestion(){
		PlanIdList planIdList=new PlanIdList();
		planIdList.setPlanIdList(planServiceBean.getCurrentPlanId());
		session.put("planIdList", planIdList);
		return SUCCESS;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer[] getPlan() {
		return plan;
	}

	public void setPlan(Integer[] plan) {
		this.plan = plan;
	}
	
	
}

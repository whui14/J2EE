package hostel_world.dao;

import java.util.List;

import hostel_world.model.Question;

public interface QuestionDao {
	/**
	 * 加入新的问题
	 * @param question
	 */
	public int addNewQuestion(Question question);
	/**
	 * 根据id得到问题
	 * @param id
	 * @return
	 */
	public Question getQuestion(int id);
	/**
	 * 根据planID返回对应的问题列表
	 * @param pid
	 * @return
	 */
	public List getQuestionListByPid(int pid);
}

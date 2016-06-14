package com.monty.exam.dao;

import java.util.List;

public interface QuestionDAO {
	void insertQuestion(Question question);
	void deleteQuestion(Question question);
	Question getQuestionByID(int id);
	List<Question> getAllQuestionsByDifficulty(int difficulty);
	Question getAQuestionByDifficulty(int difficulty, List<Question> questions);
}

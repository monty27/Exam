package com.monty.exam.dao;

import java.sql.Connection;
import java.util.List;

public interface QuestionDAO {
	void insertQuestion(Question question);
	void deleteQuestion(Question question);
	List<Question> getAllQuestionsByDifficulty(int difficulty);
	Question getAQuestionByDifficulty(int difficulty, List<Question> questions);
	Question getQuestionByID(Connection con, int id);
}

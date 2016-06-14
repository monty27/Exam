package com.monty.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class QuestionDAOJDBCImpl extends BaseDAO implements QuestionDAO {

	@Override
	public void insertQuestion(Question question) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = getConnection();

			String sql = "INSERT INTO QUESTIONS (QUESTION, OPTIONA, OPTIONB, OPTIONC, OPTIOND, ANSWER, DIFFICULTY) VALUES (?, ?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setString(1, question.getQuestion());
			st.setString(2, question.getOptionA());
			st.setString(3, question.getOptionB());
			st.setString(4, question.getOptionC());
			st.setString(5, question.getOptionD());
			st.setInt(6, question.getAnswer());
			st.setInt(7, question.getDifficulty());
			st.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeResources(null, st, con);
		}

	}

	@Override
	public void deleteQuestion(Question question) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = getConnection();
			String sql = "DELETE FROM Questions WHERE ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, question.getId());
			st.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeResources(null, st, con);
		}

	}

	@Override
	public Question getQuestionByID(Connection con, int id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Question question = null;
		try {
			String sql = "SELECT * FROM QUESTIONS WHERE ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				String q = rs.getString("QUESTION");
				String optionA = rs.getString("OPTIONA");
				String optionB = rs.getString("OPTIONB");
				String optionC = rs.getString("OPTIONC");
				String optionD = rs.getString("OPTIOND");
				int answer = rs.getInt("ANSWER");
				int difficulty = rs.getInt("DIFFICULTY");
				question = new Question(id, q, optionA, optionB, optionC, optionD, answer, difficulty);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeResources(rs, st, null);
		}
		return question;
	}

	@Override
	public List<Question> getAllQuestionsByDifficulty(int difficulty) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Question> questions = new ArrayList<Question>();
		try {
			con = getConnection();
			String sql = "SELECT * FROM QUESTIONS WHERE difficulty = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, difficulty);
			rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String q = rs.getString("QUESTION");
				String optionA = rs.getString("OPTIONA");
				String optionB = rs.getString("OPTIONB");
				String optionC = rs.getString("OPTIONC");
				String optionD = rs.getString("OPTIOND");
				int answer = rs.getInt("ANSWER");

				questions.add(new Question(id, q, optionA, optionB, optionC, optionD, answer, difficulty));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeResources(rs, st, con);
		}
		return questions;
	}

	@Override
	public Question getAQuestionByDifficulty(int difficulty, List<Question> testQuestions) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Question> questions = new ArrayList<Question>();

		Question question = new Question();
		try {
			con = getConnection();
			String sql = "SELECT * FROM QUESTIONS WHERE difficulty = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, difficulty);
			rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String q = rs.getString("QUESTION");
				String optionA = rs.getString("OPTIONA");
				String optionB = rs.getString("OPTIONB");
				String optionC = rs.getString("OPTIONC");
				String optionD = rs.getString("OPTIOND");
				int answer = rs.getInt("ANSWER");

				questions.add(new Question(id, q, optionA, optionB, optionC, optionD, answer, difficulty));
			}
			if (testQuestions == null) {
				int index = 1 + (int) (Math.random() * questions.size());
				return questions.get(index);
			} else {
				for (Question q : testQuestions) {
					questions = removeQuestionFromQuestions(questions, q);
				}
				int index = (int) (Math.random() * questions.size());
				return questions.get(index);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeResources(rs, st, con);
		}
		return question;
	}

	public List<Question> removeQuestionFromQuestions(List<Question> questions, Question q) {
		int i = 0;
		for (Question que : questions) {
			if (que.getId() == q.getId()) {
				questions.remove(i);
				return questions;
			}
			i++;
		}
		return questions;
	}

}

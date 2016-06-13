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
		try{
			con = getConnection();
			String sql = "INSERT INTO QUESTIONS (QUESTION, OPTIONA, OPTIONB, OPTIONC, OPTIOND, ANSWER, DIFFICULTY) VALUES (?, ?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setString(1, question.getQuestion());
			st.setInt(2, question.getOptionA());
			st.setInt(3, question.getOptionB());
			st.setInt(4, question.getOptionC());
			st.setInt(5, question.getOptionD());
			st.setInt(5, question.getAnswer());
			st.setInt(5, question.getDifficulty());
			st.executeUpdate();
			
		}catch(SQLException ex){
			
		}finally{
			closeResources(null,st,con);
		}

	}

	@Override
	public void deleteQuestion(Question question) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = getConnection();
			String sql = "DELETE FROM Questions WHERE ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, question.getId());
			st.executeUpdate();
			
		}catch(SQLException ex){
			
		}finally{
			closeResources(null,st,con);
		}

	}

	@Override
	public Question getQuestionByID(int id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Question question = null;
		try{
			con = getConnection();
			String sql = "SELECT * FROM QUESTIONS WHERE ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()){
				String q = rs.getString("QUESTION");
				int optionA = rs.getInt("OPTIONA");
				int optionB = rs.getInt("OPTIONB");
				int optionC = rs.getInt("OPTIONC");
				int optionD = rs.getInt("OPTIOND");
				int answer = rs.getInt("ANSWER");
				int difficulty = rs.getInt("DIFFICULTY");
				question = new Question(id, q, optionA, optionB, optionC, optionD, answer, difficulty);
			}
		}catch(SQLException ex){
			
		}finally{
			closeResources(null,st,con);
		}
		return question;
	}

	@Override
	public List<Question> getAllQuestionsByDifficulty(int difficulty) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Question> questions = new ArrayList<Question>();
		try{
			con = getConnection();
			String sql = "SELECT * FROM QUESTIONS WHERE difficulty = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, difficulty);
			rs = st.executeQuery();
			while(rs.next()){
				int id = rs.getInt("ID");
				String q = rs.getString("QUESTION");
				int optionA = rs.getInt("OPTIONA");
				int optionB = rs.getInt("OPTIONB");
				int optionC = rs.getInt("OPTIONC");
				int optionD = rs.getInt("OPTIOND");
				int answer = rs.getInt("ANSWER");
				
				questions.add(new Question(id, q, optionA, optionB, optionC, optionD, answer, difficulty));
			}
		}catch(SQLException ex){
			
		}finally{
			closeResources(null,st,con);
		}
		return questions;
	}

}

package com.monty.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class TestDAOJDBCImpl extends BaseDAO implements TestDAO {

	@Override
	public void addTest(Test test) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = getConnection();
			String sql = "INSERT INTO TESTS (CUSTOMER_ID, SCORE) VALUES (?, ?)";
			st = con.prepareStatement(sql);
			st.setInt(1, test.getCustomer().getId());
			st.setInt(2, test.getScore());
			st.executeUpdate();
			int count = 0;
			for(Question question : test.getQuestions()){
				sql = "INSERT INTO TEST_DETAILS (TEST_ID, QUESTION_ID, ANSWER) VALUES (?, ?, ?)";
				PreparedStatement st2 = con.prepareStatement(sql);
				st2.setInt(1, test.getId());
				st2.setInt(2, question.getId());
				st2.setInt(2, test.getAnswers().get(count++));
				st2.executeUpdate();
				st2.close();
			}
		}catch(SQLException ex){
			
		}finally{
			closeResources(null,st,con);
		}
	}

	@Override
	public List<Test> getAllTestsForACustomer(Customer customer) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Test> tests = new ArrayList<Test>();
		try{
			con = getConnection();
			String sql = "SELECT * FROM TESTS WHERE CUSTOMER_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, customer.getId());
			rs = st.executeQuery();
			while(rs.next()){
				int test_id = rs.getInt("ID");
				int score = rs.getInt("SCORE");
				PreparedStatement st2 = null;
				ResultSet rs2 = null;
				sql = "SELECT * FROM TEST_DETAILS WHERE TEST_ID = ?";
				st2 = con.prepareStatement(sql);
				st2.setInt(1, test_id);
				rs2 = st2.executeQuery();
				List<Question> questions = new ArrayList<Question>();
				List<Integer> answers = new ArrayList<Integer>();
				while(rs2.next()){
					answers.add(rs2.getInt("ANSWER"));
					QuestionDAOJDBCImpl q = new QuestionDAOJDBCImpl();
					questions.add(q.getQuestionByID(rs2.getInt("QUESTION_ID")));
				}
				st2.close();
				rs2.close();
				Test test = new Test(test_id, customer, questions, answers, score);
				tests.add(test);
			}
		}catch(SQLException ex){
			
		}finally{
			closeResources(null,st,con);
		}
		return tests;
	}

}

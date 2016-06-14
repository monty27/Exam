package com.monty.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAOJDBCImpl extends BaseDAO implements TestDAO {

	@Autowired
	CustomerDAO c;
	
	
	public int getLatestTestID(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			String sql = "SELECT * FROM TESTS ORDER BY ID DESC";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				return rs.getInt("ID");
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			closeResources(rs,st,con);
		}
		return 0;
	}
	
	public void addTestDetails(int tid, int qid, int answer){
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = getConnection();
			String sql = "INSERT INTO TEST_DETAILS (TEST_ID, QUESTION_ID, ANSWER) VALUES (?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setInt(1, tid);
			st.setInt(2, qid);
			st.setInt(3, answer);
			st.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			closeResources(null,st,con);
		}
	}
	
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
				addTestDetails(getLatestTestID(),question.getId(),test.getAnswers().get(count++));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			closeResources(null,st,con);
		}
	}
	
	public List<Question> getAllQuestionsOfATest(int tid){
		List<Question> questions = new ArrayList<Question>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			String sql = "SELECT * FROM TEST_DETAILS WHERE TEST_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, tid);
			rs = st.executeQuery();
			while(rs.next()){
				QuestionDAOJDBCImpl q = new QuestionDAOJDBCImpl();
				questions.add(q.getQuestionByID(rs.getInt("QUESTION_ID")));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			closeResources(null,st,con);
		}
		return questions;
	}
	
	public List<Integer> getAllAnswersOfATest(int tid){
		List<Integer> answers = new ArrayList<Integer>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			String sql = "SELECT * FROM TEST_DETAILS WHERE TEST_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, tid);
			rs = st.executeQuery();
			while(rs.next()){
				answers.add(rs.getInt("ANSWER"));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			closeResources(null,st,con);
		}
		return answers;
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
				Test test = new Test(test_id, customer, getAllQuestionsOfATest(test_id), getAllAnswersOfATest(test_id), score);
				tests.add(test);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			closeResources(null,st,con);
		}
		return tests;
	}

	@Override
	public Test getTestByID(int test_id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			String sql = "SELECT * FROM TESTS WHERE ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, test_id);
			rs = st.executeQuery();
			while(rs.next()){
				int cust_id = rs.getInt("CUSTOMER_ID");
				int score = rs.getInt("SCORE");
				
				return new Test(test_id, c.getCustomerByID(cust_id), getAllQuestionsOfATest(test_id), getAllAnswersOfATest(test_id), score);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			closeResources(null,st,con);
		}
		return null;
	}

}

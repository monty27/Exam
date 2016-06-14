package com.monty.exam.controller;

import com.monty.exam.dao.Question;
import com.monty.exam.dao.QuestionDAO;
import com.monty.exam.dao.QuestionDAOJDBCImpl;

public class createQuestions {

	public static void main(String[] args) {
		QuestionDAO q = new QuestionDAOJDBCImpl();
		for(int i=4;i<50;i++){
			String question = "Sample Question " + i;
			if(i%4 == 1){
				String optionA = "sample answer";
				String optionB = "this is correct";
				String optionC = "sample answer";
				String optionD = "sample answer";
				int answer = i%4 + 1;
				int difficulty = i%5 + 1;
				q.insertQuestion(new Question(1, question, optionA, optionB, optionC, optionD, answer, difficulty));
			}else if(i%4 == 2){
				String optionA = "sample answer";
				String optionB = "sample answer";
				String optionC = "this is correct";
				String optionD = "sample answer";
				int answer = i%4 + 1;
				int difficulty = i%5 + 1;
				q.insertQuestion(new Question(1, question, optionA, optionB, optionC, optionD, answer, difficulty));
			}else if(i%4 == 3){
				String optionA = "sample answer";
				String optionB = "sample answer";
				String optionC = "sample answer";
				String optionD = "this is correct";
				int answer = i%4 + 1;
				int difficulty = i%5 + 1;
				q.insertQuestion(new Question(1, question, optionA, optionB, optionC, optionD, answer, difficulty));
			}else{
				String optionA = "this is correct";
				String optionB = "sample answer";
				String optionC = "sample answer";
				String optionD = "sample answer";
				int answer = i%4 + 1;
				int difficulty = i%5 + 1;
				q.insertQuestion(new Question(1, question, optionA, optionB, optionC, optionD, answer, difficulty));
			}
			//q.insertQuestion(new Question(1, question, optionA, optionB, optionC, optionD, answer, difficulty));
		}

	}

}

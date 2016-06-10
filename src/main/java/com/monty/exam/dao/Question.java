package com.monty.exam.dao;

public class Question {
	private int id;
	private String question;
	private int optionA;
	private int optionB;
	private int optionC;
	private int optionD;
	private int answer;
	private int difficulty;
	public Question(int id, String question, int optionA, int optionB, int optionC, int optionD, int answer,
			int difficulty) {
		super();
		this.id = id;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.difficulty = difficulty;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getOptionA() {
		return optionA;
	}
	public void setOptionA(int optionA) {
		this.optionA = optionA;
	}
	public int getOptionB() {
		return optionB;
	}
	public void setOptionB(int optionB) {
		this.optionB = optionB;
	}
	public int getOptionC() {
		return optionC;
	}
	public void setOptionC(int optionC) {
		this.optionC = optionC;
	}
	public int getOptionD() {
		return optionD;
	}
	public void setOptionD(int optionD) {
		this.optionD = optionD;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public int getId() {
		return id;
	}
	
	
	}

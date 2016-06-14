package com.monty.exam.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Test {
	private int id;
	private Customer customer;
	private List<Question> questions;
	private  List<Integer> answers;
	private int score;
	
	public Test(){
		
	}
	
	public Test(int id, Customer customer, List<Question> questions, List<Integer> answers, int score) {
		super();
		this.id = id;
		this.customer = customer;
		this.questions = questions;
		this.answers = answers;
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	
	public int getId() {
		return id;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Integer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Integer> answers) {
		this.answers = answers;
	}
	
	
}

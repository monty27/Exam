package com.monty.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.monty.exam.dao.Question;
import com.monty.exam.dao.QuestionDAO;

@Controller
public class QuestionController {
	@Autowired
	QuestionDAO q;

	@RequestMapping("/AddQuestion")
	public String addQuestion() {
		System.out.println("I am in get");

		return "AddQuestion";
	}

	@RequestMapping(value = "/AddQuestion", method = RequestMethod.POST)
	public String processQuestion(@RequestParam String question, @RequestParam String optionA, @RequestParam String optionB,
			@RequestParam String optionC, @RequestParam String optionD, @RequestParam int answer,
			@RequestParam int difficulty) {
		System.out.println("I am in post");
		q.insertQuestion(new Question(1, question, optionA, optionB, optionC, optionD, answer, difficulty));

		return "AddQuestion";
	}

}

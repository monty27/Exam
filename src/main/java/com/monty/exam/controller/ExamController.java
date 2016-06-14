package com.monty.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.monty.exam.dao.Customer;
import com.monty.exam.dao.Question;
import com.monty.exam.dao.QuestionDAO;
import com.monty.exam.dao.Test;
import com.monty.exam.dao.TestDAO;

@Controller
public class ExamController {

	@Autowired
	QuestionDAO q;

	@Autowired
	TestDAO t;

	@RequestMapping("/InExam")
	public String startExam(HttpSession session) {
		if (session.getAttribute("loggedInCustomer") != null) {
			if (session.getAttribute("testQuestions") == null) {
				System.out.println(" Just started exam");
				List<Question> questions = new ArrayList<Question>();
				List<Integer> answers = new ArrayList<Integer>();
				Question question = q.getAQuestionByDifficulty(3, null);
				questions.add(question);
				session.setAttribute("score", 0);
				session.setAttribute("currentQuestion", question);
				session.setAttribute("testQuestions", questions);
				session.setAttribute("testAnswers", answers);
			}
			return "currentQuestion";
		}
		return "redirect:Home";
	}

	@RequestMapping(value = "/InExam", method = RequestMethod.POST)
	public String continueExam(@RequestParam int answer, HttpSession session) {
		if (session.getAttribute("testQuestions") != null) {
			List<Integer> answers = (ArrayList<Integer>) session.getAttribute("answers");
			if (answers != null) {
				answers.add(answer);
			} else {
				answers = new ArrayList<Integer>();
				answers.add(answer);
			}
			session.setAttribute("answers", answers);

			Question question = (Question) session.getAttribute("currentQuestion");
			int difficulty = question.getDifficulty();
			if (question.getAnswer() == answer) {
				int score = (int) session.getAttribute("score");
				score++;
				session.setAttribute("score", score);
				if (difficulty < 5) {
					difficulty++;
				}
			} else if (difficulty > 1) {
				difficulty--;
			}

			if (answers.size() == 10) {
				session.setAttribute("examFinished", true);
				return "redirect:FinishExam";

			} else {

				List<Question> questions = (ArrayList<Question>) session.getAttribute("testQuestions");
				Question nextQuestion = q.getAQuestionByDifficulty(difficulty, questions);
				questions.add(nextQuestion);
				session.setAttribute("currentQuestion", nextQuestion);
				session.setAttribute("testQuestions", questions);

				return "currentQuestion";
			}
		}return "redirect:Home";
	}

	@RequestMapping("/FinishExam")
	public String finishExam(HttpSession session) {
		if (session.getAttribute("loggedInCustomer") != null) {
			if (session.getAttribute("testQuestions") == null || !(boolean) session.getAttribute("examFinished")) {
				return "redirect:Home";
			} else {
				List<Question> questions = (ArrayList<Question>) session.getAttribute("testQuestions");
				System.out.println(questions);
				List<Integer> answers = (ArrayList<Integer>) session.getAttribute("answers");
				System.out.println(answers);
				int score = (int) session.getAttribute("score");
				Customer customer = (Customer) session.getAttribute("loggedInCustomer");
				t.addTest(new Test(1, customer, questions, answers, score));
				session.removeAttribute("testQuestions");
				session.removeAttribute("answers");
				session.removeAttribute("examFinished");
			}
			return "Success";
		}
		return "redirect:Home";
	}

}

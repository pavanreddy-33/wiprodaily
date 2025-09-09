package com.test.quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.quiz_service.feign.QuizInterface;
//import com.test.quiz_service.model.Question;
import com.test.quiz_service.model.QuestionWrapper;
import com.test.quiz_service.model.Quiz;
import com.test.quiz_service.model.Response;
//import com.test.quiz_service.repo.QuestionRepo;
import com.test.quiz_service.repo.QuizRepo;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo quizRepo;
	
	@Autowired
	QuizInterface quizInterface;
	
	public ResponseEntity<String> createQuiz(String category, int qnum, String title) {
		
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category,qnum).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizRepo.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Quiz quiz = quizRepo.findById(id).get();
		List<Integer> questionIds=quiz.getQuestionIds();
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
		return questions;
	}

	public ResponseEntity<Integer> submitQuiz(int id, List<Response> responses) {
		ResponseEntity<Integer> score=quizInterface.getScore(responses);
		return score;
	}
	
}

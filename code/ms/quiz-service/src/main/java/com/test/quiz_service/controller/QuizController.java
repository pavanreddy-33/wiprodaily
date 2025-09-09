package com.test.quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.quiz_service.model.QuestionWrapper;
import com.test.quiz_service.model.QuizDto;
import com.test.quiz_service.model.Response;
import com.test.quiz_service.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
		return service.createQuiz(quizDto.getCategory(),quizDto.getQnum(),quizDto.getTitle());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
		return service.getQuizQuestions(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
		return service.submitQuiz(id,responses);
	}
}

package com.test.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.question_service.model.Question;
import com.test.question_service.model.QuestionWrapper;
import com.test.question_service.model.Response;
import com.test.question_service.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired 
	QuestionService service;
	
	@GetMapping("/allQuestions")
	public List<Question> getAll(){
		return service.getAllQuetions();
	}
	
	@GetMapping("/{id}")
	public Question getQuestionById(@PathVariable int id){
		return service.getQuestionById(id);
	}
	
	@GetMapping("/category/{category}")
	public List<Question> getQuestionByCategory(@PathVariable String category){
		return service.getQuestionByCategory(category);
	}
	
	@PostMapping
	public String createQuestion(@RequestBody Question question) {
		return service.createQuestion(question);
	}
	
	@PutMapping("/{id}")
	public String updateQuestion(@PathVariable int id,@RequestBody Question question) {
		question.setId(id);
		return service.createQuestion(question);
	}
	
	@DeleteMapping("/{id}")
	public String deleteQuestionById(@PathVariable int id){
		return service.deleteQuestionById(id);
	}
	
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam int qnum){
		return service.getQuestionsForQuiz(category,qnum);
	}
	
	@PostMapping("/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
		return service.getQuestionsFromId(questionIds);
	}
	
	@PostMapping("/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		return service.getScore(responses);
	}
}

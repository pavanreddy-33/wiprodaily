package com.test.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.quizapp.model.Question;
import com.test.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired 
	QuestionService service;
	
	@GetMapping
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
}

package com.test.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.quiz_service.model.QuestionWrapper;
import com.test.quiz_service.model.Response;


@FeignClient(name = "question-service")
public interface QuizInterface {
	@GetMapping("/question/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam int qnum);
	
	@PostMapping("/question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
	
	@PostMapping("/question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}

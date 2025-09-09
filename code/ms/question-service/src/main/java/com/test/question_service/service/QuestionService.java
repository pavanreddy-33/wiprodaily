package com.test.question_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.question_service.model.Question;
import com.test.question_service.model.QuestionWrapper;
import com.test.question_service.model.Response;
import com.test.question_service.repo.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepo repo;

	public List<Question> getAllQuetions() {
		return repo.findAll();
	}

	public Question getQuestionById(int id) {
		try {
			Question q=repo.findById(id).get();
			return q;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<Question> getQuestionByCategory(String category) {
		return repo.findByCategory(category);
	}

	public String createQuestion(Question question) {
		try {
			repo.save(question);
			return "success";
		}catch(Exception e) {
			return "No Question is Added";
		}
	}

	public String deleteQuestionById(int id) {
		try {
			repo.deleteById(id);
			return "deleted";
		}catch(Exception e) {
			return "No Question is Deleted";
		}
	}

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int qnum) {
		List<Integer> questions = repo.findRandomQuestionByCategory(category,qnum);
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
		List<QuestionWrapper> wrappers = new ArrayList<>();
		List<Question> questions = new ArrayList<>();
		
		for(Integer id: questionIds) {
			questions.add(repo.findById(id).get());
		}
		
		for(Question question: questions) {
			QuestionWrapper wrapper = new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());
			wrappers.add(wrapper);
		}
		return new ResponseEntity<>(wrappers,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		int right=0;
		for(Response response: responses) {
			Question question = repo.findById(response.getId()).get();
			if(response.getResponse().equals(question.getRightAnswer())) {
				right++;
			}
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
	

}

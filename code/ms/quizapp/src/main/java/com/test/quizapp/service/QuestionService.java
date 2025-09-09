package com.test.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.quizapp.model.Question;
import com.test.quizapp.repo.QuestionRepo;

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
	
	

}

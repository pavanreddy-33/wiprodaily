package com.test.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.quizapp.model.Question;
import com.test.quizapp.model.QuestionWrapper;
import com.test.quizapp.model.Quiz;
import com.test.quizapp.model.Response;
import com.test.quizapp.repo.QuestionRepo;
import com.test.quizapp.repo.QuizRepo;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo quizRepo;
	
	@Autowired
	QuestionRepo questionRepo;

	public ResponseEntity<String> createQuiz(String category, int qnum, String title) {
		
		List<Question> questions = questionRepo.findRandomQuestionByCategory(category,qnum);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizRepo.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizRepo.findById(id);
		List<Question> qForDB=quiz.get().getQuestions();
		List<QuestionWrapper> qForUser = new ArrayList<>();
		for(Question q:qForDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			qForUser.add(qw);
		}
		
		return new ResponseEntity<>(qForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> submitQuiz(int id, List<Response> responses) {
		Optional<Quiz> quiz = quizRepo.findById(id);
		List<Question> questions=quiz.get().getQuestions();
		int right=0;
		int i=0;
		for(Response response: responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
				right++;
			}
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
}

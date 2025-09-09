package com.test.quizapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.quizapp.model.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}

package com.test.quizapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.quizapp.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{
	 
	List<Question> findByCategory(String category);

	@Query(value="select * from question q where q.category=:category order by Rand() limit :qnum",nativeQuery=true)
	List<Question> findRandomQuestionByCategory(String category, int qnum);
}

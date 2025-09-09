package com.test.question_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.question_service.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{
	 
	List<Question> findByCategory(String category);

	@Query(value="select q.id from question q where q.category=:category order by Rand() limit :qnum",nativeQuery=true)
	List<Integer> findRandomQuestionByCategory(String category, int qnum);
}

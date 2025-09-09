package com.test.question_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="question")
@Data
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="question_title")
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	@Column(name="right_answer")
	private String rightAnswer;
	@Column(name="difficulty_level")
	private String difficultyLevel;
	private String category;
}

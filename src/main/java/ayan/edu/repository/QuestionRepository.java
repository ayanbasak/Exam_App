package ayan.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ayan.edu.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	List<Question> findByQmodel(String qmodel);

}

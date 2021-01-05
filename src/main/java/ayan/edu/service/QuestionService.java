package ayan.edu.service;

import java.util.List;

import ayan.edu.entity.Question;

public interface QuestionService {

	public List<Question> findAll();

	public Question findById(int theId);

	public void save(Question theQuestion);

	public void deleteById(int theId);

	public List<Question> findByQmodel(String qmodel);

}

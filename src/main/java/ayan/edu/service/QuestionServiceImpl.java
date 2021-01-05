package ayan.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ayan.edu.entity.Question;
import ayan.edu.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	private QuestionRepository questionRepository;

	@Autowired
	public QuestionServiceImpl(QuestionRepository theQuestionRepository) {
		this.questionRepository = theQuestionRepository;
	}

	@Transactional
	public List<Question> findAll() {
		return questionRepository.findAll();
	}

	@Transactional
	public Question findById(int theId) {

		Optional<Question> result = questionRepository.findById(theId);

		Question theQuestion = null;

		if (result.isPresent()) {
			theQuestion = result.get();
		} else {
			// we did not find the employee
			theQuestion = null;
		}
		return theQuestion;
	}

	@Transactional
	public void save(Question theQuestion) {
		questionRepository.save(theQuestion);

	}

	@Transactional
	public void deleteById(int theId) {
		questionRepository.deleteById(theId);
	}

	@Override
	public List<Question> findByQmodel(String qmodel) {

		return questionRepository.findByQmodel(qmodel);
	}

}

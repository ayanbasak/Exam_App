package ayan.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ayan.edu.entity.Exam;
import ayan.edu.repository.ExamRepository;

@Service
public class ExamServiceImpl implements ExamService {

	private ExamRepository examRepository;

	@Autowired
	public ExamServiceImpl(ExamRepository theExamRepository) {
		this.examRepository = theExamRepository;
	}

	@Transactional
	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	@Transactional
	public Exam findById(int theId) {

		Optional<Exam> result = examRepository.findById(theId);

		Exam theExam = null;

		if (result.isPresent()) {
			theExam = result.get();
		} else {
			// we did not find the employee
			throw new RuntimeException("Did not find Exam Id - " + theId);
		}
		return theExam;
	}

	@Transactional
	public void save(Exam theExam) {
		examRepository.save(theExam);

	}

	@Transactional
	public void deleteById(int theId) {
		examRepository.deleteById(theId);
	}

}

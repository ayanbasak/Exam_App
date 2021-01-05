package ayan.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ayan.edu.entity.Subject;
import ayan.edu.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	private SubjectRepository subjectRepository;

	@Autowired
	public SubjectServiceImpl(SubjectRepository theSubjectRepository) {
		this.subjectRepository = theSubjectRepository;
	}

	@Transactional
	public List<Subject> findAll() {
		return subjectRepository.findAll();
	}

	@Transactional
	public Subject findById(int theId) {

		Optional<Subject> result = subjectRepository.findById(theId);

		Subject theSubject = null;

		if (result.isPresent()) {
			theSubject = result.get();
		} else {
			// we did not find the employee
			throw new RuntimeException("Did not find Subject Id - " + theId);
		}
		return theSubject;
	}

	@Transactional
	public void save(Subject theSubject) {
		subjectRepository.save(theSubject);

	}

	@Transactional
	public void deleteById(int theId) {
		subjectRepository.deleteById(theId);
	}

}

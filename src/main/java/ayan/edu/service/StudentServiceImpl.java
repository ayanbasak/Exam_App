package ayan.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ayan.edu.entity.Student;
import ayan.edu.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepository) {
		this.studentRepository = theStudentRepository;
	}

	@Transactional
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Transactional
	public Student findById(int theId) {

		Optional<Student> result = studentRepository.findById(theId);

		Student theStudent = null;

		if (result.isPresent()) {
			theStudent = result.get();
		} else {
			// we did not find the employee
			throw new RuntimeException("Did not find Student Id - " + theId);
		}
		return theStudent;
	}

	@Transactional
	public void save(Student theStudent) {
		studentRepository.save(theStudent);

	}

	@Transactional
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
	}

}

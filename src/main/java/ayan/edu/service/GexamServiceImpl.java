package ayan.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ayan.edu.entity.Gexam;
import ayan.edu.repository.GexamRepository;

@Service
public class GexamServiceImpl implements GexamService {

	private GexamRepository gexamRepository;

	@Autowired
	public GexamServiceImpl(GexamRepository theGexamRepository) {
		this.gexamRepository = theGexamRepository;
	}

	@Transactional
	public List<Gexam> findAll() {
		return gexamRepository.findAll();
	}

	@Transactional
	public Gexam findById(int theId) {

		Optional<Gexam> result = gexamRepository.findById(theId);

		Gexam theGexam = null;

		if (result.isPresent()) {
			theGexam = result.get();
		} else {
			// we did not find the employee
			throw new RuntimeException("Did not find Gexam Id - " + theId);
		}
		return theGexam;
	}

	@Transactional
	public List<Gexam> findBySname(String theSub) {

		System.out.println("debug 2------->" + theSub);

		return gexamRepository.findBySname(theSub);
	}

	@Transactional
	public void save(Gexam theGexam) {
		gexamRepository.save(theGexam);

	}

	@Transactional
	public void deleteById(int theId) {
		gexamRepository.deleteById(theId);
	}

}

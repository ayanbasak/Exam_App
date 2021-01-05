package ayan.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ayan.edu.entity.EQ;
import ayan.edu.repository.EQRepository;

@Service
public class EQServiceImpl implements EQService {

	private EQRepository eqRepository;

	@Autowired
	public EQServiceImpl(EQRepository theEQepository) {
		this.eqRepository = theEQepository;
	}

	@Transactional
	public List<EQ> findAll() {
		return eqRepository.findAll();
	}

	@Transactional
	public EQ findById(int theId) {

		Optional<EQ> result = eqRepository.findById(theId);

		EQ theEQ = null;

		if (result.isPresent()) {
			theEQ = result.get();
		} else {
			// we did not find the employee
			throw new RuntimeException("Did not find eq Id - " + theId);
		}
		return theEQ;
	}

	@Transactional
	public void save(EQ theEQ) {
		eqRepository.save(theEQ);

	}

	@Transactional
	public void deleteById(int theId) {
		eqRepository.deleteById(theId);
	}

}

package ayan.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ayan.edu.entity.Oex;
import ayan.edu.repository.OexRepository;

@Service
public class OexServiceImpl implements OexService {

	private OexRepository oxRepository;

	@Autowired
	public OexServiceImpl(OexRepository theOexRepository) {
		this.oxRepository = theOexRepository;
	}

	@Transactional
	public List<Oex> findAll() {
		return oxRepository.findAll();
	}

	@Transactional
	public Oex findById(int theId) {

		Optional<Oex> result = oxRepository.findById(theId);

		Oex theOex = null;

		if (result.isPresent()) {
			theOex = result.get();
		} else {
			// we did not find the employee
			throw new RuntimeException("Did not find Oex Id - " + theId);
		}
		return theOex;
	}

	@Transactional
	public void save(Oex theOex) {
		oxRepository.save(theOex);

	}

	@Transactional
	public void deleteById(int theId) {
		oxRepository.deleteById(theId);
	}

}

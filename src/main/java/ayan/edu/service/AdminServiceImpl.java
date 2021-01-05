package ayan.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ayan.edu.entity.Admin;
import ayan.edu.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;

	@Autowired
	public AdminServiceImpl(AdminRepository theAdminRepository) {
		this.adminRepository = theAdminRepository;
	}

	@Transactional
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Transactional
	public Admin findById(int theId) {

		Optional<Admin> result = adminRepository.findById(theId);

		Admin theAdmin = null;

		if (result.isPresent()) {
			theAdmin = result.get();
		} else {
			// we did not find the employee
			throw new RuntimeException("Did not find Admin Id - " + theId);
		}
		return theAdmin;
	}

	@Transactional
	public void save(Admin theAdmin) {
		adminRepository.save(theAdmin);

	}

	@Transactional
	public void deleteById(int theId) {
		adminRepository.deleteById(theId);
	}

}

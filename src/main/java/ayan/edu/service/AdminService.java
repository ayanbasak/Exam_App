package ayan.edu.service;

import java.util.List;

import ayan.edu.entity.Admin;

public interface AdminService {

	public List<Admin> findAll();

	public Admin findById(int theId);

	public void save(Admin theAdmin);

	public void deleteById(int theId);

}

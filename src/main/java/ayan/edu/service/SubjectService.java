package ayan.edu.service;

import java.util.List;

import ayan.edu.entity.Subject;

public interface SubjectService {

	public List<Subject> findAll();

	public Subject findById(int theId);

	public void save(Subject theSubject);

	public void deleteById(int theId);

}

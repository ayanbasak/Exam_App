package ayan.edu.service;

import java.util.List;

import ayan.edu.entity.Exam;

public interface ExamService {

	public List<Exam> findAll();

	public Exam findById(int theId);

	public void save(Exam theExam);

	public void deleteById(int theId);

}

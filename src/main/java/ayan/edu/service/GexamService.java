package ayan.edu.service;

import java.util.List;

import ayan.edu.entity.Gexam;

public interface GexamService {

	public List<Gexam> findAll();

	public Gexam findById(int theId);

	public void save(Gexam theGexam);

	public void deleteById(int theId);

	public List<Gexam> findBySname(String sname);

}

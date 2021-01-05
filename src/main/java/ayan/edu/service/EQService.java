package ayan.edu.service;

import java.util.List;

import ayan.edu.entity.EQ;

public interface EQService {

	public List<EQ> findAll();

	public EQ findById(int theId);

	public void save(EQ theEQ);

	public void deleteById(int theId);

}

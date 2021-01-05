package ayan.edu.service;

import java.util.List;

import ayan.edu.entity.Oex;

public interface OexService {

	public List<Oex> findAll();

	public Oex findById(int theId);

	public void save(Oex theOex);

	public void deleteById(int theId);

}

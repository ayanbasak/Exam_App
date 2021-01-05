package ayan.edu.service;

import java.util.List;

import ayan.edu.entity.Emails;

public interface EmailsService {

	public List<Emails> findAll();

	public Emails findById(int theId);

	public void save(Emails theEmails);

	public void deleteById(int theId);

}

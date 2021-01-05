package ayan.edu.service;

import java.util.List;

import ayan.edu.entity.Notification;


public interface NotificationService {

	public List<Notification> findAll();

	public Notification findById(int theId);

	public void save(Notification theNotification);

	public void deleteById(int theId);


}

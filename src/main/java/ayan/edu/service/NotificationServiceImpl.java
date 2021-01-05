package ayan.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ayan.edu.entity.Notification;
import ayan.edu.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

	private NotificationRepository notificationRepository;

	@Autowired
	public NotificationServiceImpl(NotificationRepository theRepository) {
		this.notificationRepository = theRepository;
	}

	@Transactional
	public List<Notification> findAll() {
		return notificationRepository.findAllByOrderByIdDesc(); //findAllByOrderByIdAsc();
	}

	@Transactional
	public Notification findById(int theId) {

		Optional<Notification> result = notificationRepository.findById(theId);

		Notification theNotification = null;

		if (result.isPresent()) {
			theNotification = result.get();
		} else {
			// we did not find the employee
			throw new RuntimeException("Did not find Notification Id - " + theId);
		}
		return theNotification;
	}

	@Transactional
	public void save(Notification theNotification) {
		notificationRepository.save(theNotification);

	}

	@Transactional
	public void deleteById(int theId) {
		notificationRepository.deleteById(theId);
	}

	
}

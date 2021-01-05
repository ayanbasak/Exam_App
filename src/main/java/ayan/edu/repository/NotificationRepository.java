package ayan.edu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ayan.edu.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

	List<Notification> findAllByOrderByIdDesc();


}

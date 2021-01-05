package ayan.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ayan.edu.entity.Emails;

public interface EmailsRepository extends JpaRepository<Emails, Integer> {

}

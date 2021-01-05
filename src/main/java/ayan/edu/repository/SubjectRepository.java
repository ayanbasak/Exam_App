package ayan.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ayan.edu.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}

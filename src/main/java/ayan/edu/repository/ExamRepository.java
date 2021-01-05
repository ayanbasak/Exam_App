package ayan.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ayan.edu.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

}

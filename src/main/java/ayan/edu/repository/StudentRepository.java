package ayan.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ayan.edu.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

package ayan.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ayan.edu.entity.Gexam;

public interface GexamRepository extends JpaRepository<Gexam, Integer> {

	List<Gexam> findBySname(String theSub);

}

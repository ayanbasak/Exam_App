package ayan.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ayan.edu.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}

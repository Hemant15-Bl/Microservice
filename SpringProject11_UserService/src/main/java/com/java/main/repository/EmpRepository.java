package com.java.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.main.entites.Employee;

public interface EmpRepository extends JpaRepository<Employee, String>{

}

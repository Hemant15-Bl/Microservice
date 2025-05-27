package com.java.main.services;

import java.util.List;

import com.java.main.entites.Employee;

public interface EmpService {
	public Employee addEmp(Employee emp);
	public List<Employee> getAllEmp();
	public Employee getEmp(String id);
	
}

package com.airtel.IMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airtel.IMS.model.Employee;

public interface EmployeeRepository
extends JpaRepository<Employee, Integer> {

}
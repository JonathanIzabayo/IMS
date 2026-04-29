package com.airtel.IMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airtel.IMS.model.Department;

public interface DepartmentRepository
extends JpaRepository<Department, Integer> {

}
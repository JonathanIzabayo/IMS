package com.airtel.IMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airtel.IMS.model.Assignment;

public interface AssignmentRepository
extends JpaRepository<Assignment, Integer> {

}
package com.airtel.IMS.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.airtel.IMS.model.Department;
import com.airtel.IMS.repository.DepartmentRepository;

@Controller
public class DepartmentController {

    private final DepartmentRepository repo;

    public DepartmentController(DepartmentRepository repo) {

        this.repo = repo;
    }

    // LIST DEPARTMENTS
    @GetMapping("/department/list")
    public String listDepartments(Model model) {

        List<Department> departments = repo.findAll();

        model.addAttribute("departments", departments);

        return "department/list";
    }
}
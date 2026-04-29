package com.airtel.IMS.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.airtel.IMS.model.Employee;
import com.airtel.IMS.repository.EmployeeRepository;

@Controller
public class EmployeeController {

    private final EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {

        this.repo = repo;
    }

    // SHOW ADD FORM
    @GetMapping("/employee/add")
    public String addEmployee(Model model) {

        model.addAttribute("employee", new Employee());

        return "employee/add";
    }

    // SAVE EMPLOYEE
    @PostMapping("/employee/save")
    public String saveEmployee(@ModelAttribute Employee employee) {

        repo.save(employee);

        return "redirect:/employee/list";
    }

    // LIST EMPLOYEES
    @GetMapping("/employee/list")
    public String listEmployees(Model model) {

        List<Employee> employees = repo.findAll();

        model.addAttribute("employees", employees);

        return "employee/list";
    }
}
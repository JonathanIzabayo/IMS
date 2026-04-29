package com.airtel.IMS.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.airtel.IMS.model.Assignment;
import com.airtel.IMS.model.Device;
import com.airtel.IMS.model.Employee;
import com.airtel.IMS.repository.AssignmentRepository;
import com.airtel.IMS.repository.DeviceRepository;
import com.airtel.IMS.repository.EmployeeRepository;

@Controller
public class AssignmentController {

    private final AssignmentRepository repo;
    private final EmployeeRepository employeeRepo;
    private final DeviceRepository deviceRepo;

    public AssignmentController(AssignmentRepository repo,
                                EmployeeRepository employeeRepo,
                                DeviceRepository deviceRepo) {

        this.repo = repo;
        this.employeeRepo = employeeRepo;
        this.deviceRepo = deviceRepo;
    }

    // SHOW ASSIGNMENT FORM
    @GetMapping("/assignment/add")
    public String addAssignment(Model model) {

        model.addAttribute("assignment", new Assignment());

        model.addAttribute("employees",
                employeeRepo.findAll());

        model.addAttribute("devices",
                deviceRepo.findAll());

        return "assignment/add";
    }

    // SAVE ASSIGNMENT
    @PostMapping("/assignment/save")
    public String saveAssignment(@ModelAttribute Assignment assignment,
                                 @RequestParam int employeeId,
                                 @RequestParam int deviceId) {

        Employee employee =
                employeeRepo.findById(employeeId).orElse(null);

        Device device =
                deviceRepo.findById(deviceId).orElse(null);

        assignment.setEmployee(employee);

        assignment.setDevice(device);

        repo.save(assignment);

        return "redirect:/assignment/list";
    }

    // LIST ASSIGNMENTS
    @GetMapping("/assignment/list")
    public String listAssignments(Model model) {

        List<Assignment> assignments = repo.findAll();

        model.addAttribute("assignments", assignments);

        return "assignment/list";
    }
}
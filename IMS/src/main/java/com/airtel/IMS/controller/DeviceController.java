package com.airtel.IMS.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.airtel.IMS.model.Department;
import com.airtel.IMS.model.Device;
import com.airtel.IMS.repository.DepartmentRepository;
import com.airtel.IMS.repository.DeviceRepository;

@Controller
public class DeviceController {

    private final DeviceRepository repo;
    private final DepartmentRepository departmentRepo;

    public DeviceController(DeviceRepository repo,
                            DepartmentRepository departmentRepo) {

        this.repo = repo;
        this.departmentRepo = departmentRepo;
    }

    // LOGIN PAGE
    @GetMapping("/")
    public String loginPage() {

        return "login";
    }

    // DASHBOARD
    @GetMapping("/dashboard")
    public String dashboard() {

        return "welcome";
    }

    // SHOW ADD DEVICE FORM
    @GetMapping("/device/add")
    public String addDevice(Model model) {

        model.addAttribute("device", new Device());

        model.addAttribute("departments",
                departmentRepo.findAll());

        return "device/add";
    }

    // SAVE DEVICE
    @PostMapping("/device/save")
    public String saveDevice(@ModelAttribute Device device,
                             @RequestParam int departmentId) {

        Department dept =
                departmentRepo.findById(departmentId).orElse(null);

        device.setDepartment(dept);

        repo.save(device);

        return "redirect:/device/list";
    }

    // LIST DEVICES
    @GetMapping("/device/list")
    public String listDevices(Model model) {

        List<Device> devices = repo.findAll();

        model.addAttribute("devices", devices);

        return "device/list";
    }

    // SHOW EDIT FORM
    @GetMapping("/device/edit/{id}")
    public String editDevice(@PathVariable int id,
                             Model model) {

        Device device =
                repo.findById(id).orElse(null);

        model.addAttribute("device", device);

        model.addAttribute("departments",
                departmentRepo.findAll());

        return "device/edit";
    }

    // UPDATE DEVICE
    @PostMapping("/device/update")
    public String updateDevice(@ModelAttribute Device device,
                               @RequestParam int departmentId) {

        Department dept =
                departmentRepo.findById(departmentId).orElse(null);

        device.setDepartment(dept);

        repo.save(device);

        return "redirect:/device/list";
    }

    // DELETE DEVICE
    @GetMapping("/device/delete/{id}")
    public String deleteDevice(@PathVariable int id) {

        repo.deleteById(id);

        return "redirect:/device/list";
    }
}
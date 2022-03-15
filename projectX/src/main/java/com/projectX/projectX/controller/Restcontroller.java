package com.projectX.projectX.controller;

import com.projectX.projectX.model.Employee;
import com.projectX.projectX.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class Restcontroller {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmp());
        return "index";
    }

    @GetMapping("/add")
    public String addNewUser(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAllEmp(), HttpStatus.OK);
    }

    @GetMapping("/deleteEmployee/{id}")
    public String getDelete(@PathVariable(value = "id") Integer id) {
        employeeService.deleteById(id);
        return "redirect:/home";
    }
    @GetMapping("/updateId/{id}")
    public String getUpdate(@PathVariable(value = "id") Integer id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee.get());
        return "update_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        try {
            employeeService.insertEmployee(employee);
        } catch (Exception ex) {
            System.out.println("error here");
        }
        return "redirect:/home";
    }
}

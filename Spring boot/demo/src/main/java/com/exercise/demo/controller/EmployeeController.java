package com.exercise.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exercise.demo.model.Employee;

@Controller
@RequestMapping("/exercise1")
public class EmployeeController {

    
    private List<Employee> employees = new ArrayList<>();

    public EmployeeController() {
        

    	 Employee employee = new Employee(1L, "Fawzy", "Ghazawy", "ghazawyfawzy@gmail.com", 0L, "Software Engineer");
    	    Employee employee2 = new Employee(2L, "charbl", "nn", "nn@nn.cnn", 1L, "Project Manager");
    	    employees.add(employee);
    	    employees.add(employee2);
    }

    @GetMapping("")
    public String welcome() {
        return "welcome"; 
    }

    @GetMapping("/employees")
    public String showAllEmployees(Model model) {
        model.addAttribute("employees", employees);
        return "employees"; 
    }


    @GetMapping("/addEmployee")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee(null, "", "", "", null, "")); 
        return "add-Employee"; 
    }

    @PostMapping("/addEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        
        employee.setId((long) (employees.size() + 1)); 
        employees.add(employee);

        
        return "redirect:/exercise1/employees";

    }
}

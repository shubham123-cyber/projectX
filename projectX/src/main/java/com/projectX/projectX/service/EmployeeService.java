package com.projectX.projectX.service;

import com.projectX.projectX.model.Employee;
import com.projectX.projectX.repository.Sqlrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private Sqlrepo sqlrepo;

    public Employee insertEmployee(Employee employee) throws Exception {
        return sqlrepo.save(employee);
    }

    public List<Employee> getAllEmp() {
        return (List<Employee>) sqlrepo.findAll();
    }

    public String deleteById(Integer id) {
        if (id == null) {
            return "Bad id";
        }
        sqlrepo.deleteById(id);
        return "😘😘😘😘😘";
    }


    public Optional<Employee> getEmployeeById(Integer id) {
        if(id==null) {
            return null;
        }
        return sqlrepo.findById(id);
    }
    public Employee updateById(Employee employee) {
        Optional<Employee> employ =getEmployeeById(employee.getId());
        if(employ.isPresent()) {
            return sqlrepo.save(employee);
        }
        return null;
    }
}

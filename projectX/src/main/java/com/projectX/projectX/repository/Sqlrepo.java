package com.projectX.projectX.repository;

import com.projectX.projectX.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface Sqlrepo extends CrudRepository<Employee, Integer> {

}

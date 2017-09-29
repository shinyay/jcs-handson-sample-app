package com.oracle.jp.jcs.workshop.application.facade;

import com.oracle.jp.jcs.workshop.employee.entity.Employee;
import com.oracle.jp.jcs.workshop.infrastructure.persistence.jpa.EmployeeRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("empFacade")
@RequestScoped
public class SampleEmployeeFacade {

    @Inject
    EmployeeRepository repository;

    private List<Employee> empList;

    @PostConstruct
    public void init(){
        System.out.println("[SampleEmployeeFacade - PostConstruct]");

        empList = repository.findAll();
        empList.forEach(System.out::println);
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }
}

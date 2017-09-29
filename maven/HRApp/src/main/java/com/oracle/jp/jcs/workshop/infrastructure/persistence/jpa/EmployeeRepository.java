package com.oracle.jp.jcs.workshop.infrastructure.persistence.jpa;

import com.oracle.jp.jcs.workshop.employee.entity.Employee;
import com.oracle.jp.jcs.workshop.employee.repository.EmployeeRepositoryInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class EmployeeRepository implements EmployeeRepositoryInterface{

    @PersistenceContext(unitName = "HumanResourcesPU")
    private EntityManager entityManager;

    @Override
    public Employee find(int employee_id) {
        return entityManager.find(Employee.class, employee_id);
    }

//    @Override
//    public List<Employee> findAll() {
//        return entityManager.createNamedQuery("Employee.all", Employee.class).getResultList();
//    }


    @Override
    public List<Employee> findAll() {

        System.out.println("[EmployeeRepository - findAll]");

        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        final Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}

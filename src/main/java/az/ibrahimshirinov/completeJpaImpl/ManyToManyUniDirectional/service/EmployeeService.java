package az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.service;

import az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.model.Employee;
import az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.model.Project;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();
    Employee update(Long id,Employee employee);
    void delete(Long id);
    Employee createProject(Long id, Project project) ;

}

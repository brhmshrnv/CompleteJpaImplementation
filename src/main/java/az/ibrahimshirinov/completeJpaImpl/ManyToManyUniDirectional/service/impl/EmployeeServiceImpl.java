package az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.service.impl;

import az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.model.Employee;
import az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.model.Project;
import az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.repository.EmployeeRepository;
import az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.repository.ProjectRepository;
import az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projetRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ProjectRepository projetRepository) {
        this.employeeRepository = employeeRepository;
        this.projetRepository = projetRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found employee with id = " + id);
        }
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Optional<Employee> optional = employeeRepository.findById(id);

        if (optional.isPresent()) {
            return employeeRepository.save(employee);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cant update employee with id= "+ id);
        }
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee createProject(Long id, Project project) {
        Optional<Employee> optional = employeeRepository.findById(id);

        if (optional.isPresent()) {
            projetRepository.save(project);
            Employee employee = optional.get();
            employee.getProjects().add(project);
            return employee;
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cant add project to employee with id="+id);
        }
    }
}

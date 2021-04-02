package az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.api;

import az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.model.Employee;
import az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.model.Project;
import az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable(name = "id") Long id) {
        return employeeService.findById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.findAll();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
       return employeeService.save(employee);
    }

    @PutMapping("{id}")
    public Employee updateEmployee(@PathVariable(name = "id") Long id, Employee employee) {
       return employeeService.update(id,employee);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable(name = "id") Long id ) {
        employeeService.delete(id);
    }

    @PostMapping("{empId}/projects")
    public Employee createProject(@PathVariable(name = "empId") Long empId, @RequestBody Project project) {
        return employeeService.createProject(empId,project);
    }
}


package hva.ewa.service;

import hva.ewa.model.Employee;
import hva.ewa.model.User;

import java.util.List;

public interface EmployeeRepositoryService {
    boolean saveEmployee(Employee employee);

    List<User> getAllEmployees();

    boolean deleteEmployee(Employee employee);

    User getEmployee(int id);

    boolean editEmployee(Employee employee);
}

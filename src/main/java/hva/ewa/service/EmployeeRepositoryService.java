package hva.ewa.service;

import hva.ewa.model.User;

import java.util.List;

public interface EmployeeRepositoryService {
    boolean saveEmployee(User user);

    List<User> getAllEmployees();

    boolean deleteEmployee(int id);

    User getEmployee(int id);

    boolean editEmployee(int id);
}

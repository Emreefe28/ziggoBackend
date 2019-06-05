package hva.ewa.service;

import hva.ewa.model.Employee;
import hva.ewa.model.User;

import java.util.List;

public interface EmployeeRepositoryService {
    boolean saveEmployee(Employee employee);


    /**
     *
     * @return
     */
    List<Employee> getAllEmployees();

    /**
     *
     * @param employee
     * @return
     */
    boolean deleteEmployee(Employee employee);

    /**
     *
     * @param id
     * @return
     */
    Employee getEmployee(int id);

    /**
     *
     * @param employee
     * @return
     */
    boolean editEmployee(Employee employee);
}

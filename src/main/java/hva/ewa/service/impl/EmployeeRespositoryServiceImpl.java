package hva.ewa.service.impl;

import hva.ewa.model.Employee;
import hva.ewa.model.User;
import hva.ewa.service.EmployeeRepositoryService;
import hva.ewa.service.RepositoryService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmployeeRespositoryServiceImpl extends RepositoryService implements EmployeeRepositoryService {

    private static EmployeeRespositoryServiceImpl instance = new EmployeeRespositoryServiceImpl();

    public static EmployeeRepositoryService getInstance() {
        return instance;
    }

    @Override
    public boolean saveEmployee(Employee employee) {
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public List<User> getAllEmployees() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return false;
    }

    @Override
    public User getEmployee(int id) {
        return null;
    }

    @Override
    public boolean editEmployee(Employee employee) {
        return false;
    }
}

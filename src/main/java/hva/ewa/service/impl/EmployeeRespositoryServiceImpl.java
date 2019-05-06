package hva.ewa.service.impl;

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
    public boolean saveEmployee(User user) {
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            em.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public List<User> getAllEmployees() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT e FROM User e WHERE e.role = 2");
        return query.getResultList();
    }

    @Override
    public boolean deleteEmployee(int id) {
        return false;
    }

    @Override
    public User getEmployee(int id) {
        return null;
    }

    @Override
    public boolean editEmployee(int id) {
        return false;
    }
}

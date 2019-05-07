package hva.ewa.service.impl;

import hva.ewa.model.Customer;
import hva.ewa.service.CustomerRepositoryService;
import hva.ewa.service.RepositoryService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class CustomerRepositoryServiceImpl extends RepositoryService implements CustomerRepositoryService {

    private static CustomerRepositoryServiceImpl instance = new CustomerRepositoryServiceImpl();

    public static CustomerRepositoryService getInstance() {
        return instance;
    }

    @Override
    public Customer getCustomer(int id) {
        EntityManager em = getEntityManager();
        System.out.println("GET CUSTOMER BITCH");
        System.out.println(em.find(Customer.class, id));
        return em.find(Customer.class, id);
    }

    @Override
    public boolean editCustomer(Customer customer) {
        try {
            EntityManager em = getEntityManager();
            em.merge(customer);
            return true;
        } catch (PersistenceException pE){
            return false;
        }
    }
}

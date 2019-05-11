package hva.ewa.service.impl;

import hva.ewa.model.Customer;
import hva.ewa.model.Appointment;
import hva.ewa.model.Equipment;
import hva.ewa.service.CustomerRepositoryService;
import hva.ewa.service.RepositoryService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CustomerRepositoryServiceImpl extends RepositoryService implements CustomerRepositoryService {

    private static CustomerRepositoryServiceImpl instance = new CustomerRepositoryServiceImpl();

    public static CustomerRepositoryService getInstance() {
        return instance;
    }

    @Override
    public Customer getCustomer(int id) {
        EntityManager em = getEntityManager();
         return em.find(Customer.class, id);
    }
    @Override
    public List<Appointment> getAppointments(int id) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT m FROM Appointment m WHERE m.id.customer.id = "  + id );
        return query.getResultList();
    }

    @Override
    public List<Equipment> getEquipment(int id) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT m FROM Equipment m WHERE m.id.customer.id = "  + id );
        return query.getResultList();
    }
}

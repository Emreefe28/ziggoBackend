package hva.ewa.service;

import hva.ewa.model.Customer;

public interface CustomerRepositoryService {
    Customer getCustomer(int id);
    boolean editCustomer(Customer customer);
}

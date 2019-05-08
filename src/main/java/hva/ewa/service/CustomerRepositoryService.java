package hva.ewa.service;

import hva.ewa.model.Customer;
import hva.ewa.model.MonteursAfspraak;

import java.util.List;

public interface CustomerRepositoryService {
    Customer getCustomer(int id);

    List<MonteursAfspraak> getMonteursAfspraken(int id);

    boolean editCustomer(Customer customer);
}

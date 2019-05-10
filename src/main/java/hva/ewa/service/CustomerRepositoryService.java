package hva.ewa.service;

import hva.ewa.model.Customer;
import hva.ewa.model.Appointment;

import java.util.List;

public interface CustomerRepositoryService {
    Customer getCustomer(int id);

    List<Appointment> getAppointments(int id);

    boolean editCustomer(Customer customer);
}

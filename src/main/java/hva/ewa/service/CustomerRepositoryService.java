package hva.ewa.service;

import hva.ewa.model.Customer;
import hva.ewa.model.Appointment;
import hva.ewa.model.Equipment;

import java.util.List;

public interface CustomerRepositoryService {
    Customer getCustomer(int id);

    List<Appointment> getAppointments(int id);
    List<Equipment> getEquipment(int id);
}

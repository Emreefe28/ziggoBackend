package hva.ewa.model.embeddable;

import hva.ewa.model.Customer;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EquipmentId implements Serializable {

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private Customer customer;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

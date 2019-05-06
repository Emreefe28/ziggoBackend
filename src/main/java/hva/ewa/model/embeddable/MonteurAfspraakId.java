package hva.ewa.model.embeddable;

import hva.ewa.model.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
public class MonteurAfspraakId implements Serializable {

    @Column(name = "datum", nullable = false)
    private Timestamp datum;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private Customer customer;


    public Timestamp getDatum() {
        return datum;
    }

    public void setDatum(Timestamp datum) {
        this.datum = datum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

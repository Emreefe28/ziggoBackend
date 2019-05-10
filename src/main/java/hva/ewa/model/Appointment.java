package hva.ewa.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Appointment implements Serializable {

    @EmbeddedId
    private hva.ewa.model.embeddable.Appointment id;

    @Basic
    @Column(name = "status", nullable = false)
    private String status;

    public hva.ewa.model.embeddable.Appointment getId() {
        return id;
    }

    public void setId(hva.ewa.model.embeddable.Appointment id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

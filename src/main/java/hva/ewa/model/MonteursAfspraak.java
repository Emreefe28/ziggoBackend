package hva.ewa.model;

import hva.ewa.model.embeddable.MonteurAfspraakId;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class MonteursAfspraak implements Serializable {

    @EmbeddedId
    private MonteurAfspraakId id;

    @Basic
    @Column(name = "status", nullable = false)
    private String status;

    public MonteurAfspraakId getId() {
        return id;
    }

    public void setId(MonteurAfspraakId id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

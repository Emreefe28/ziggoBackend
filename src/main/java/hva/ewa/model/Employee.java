package hva.ewa.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Employee extends User implements Serializable {

    @Basic
    @Column(name = "afdeling")
    private String afdeling;

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }
}

package hva.ewa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerCode", updatable = false)
    private int customerCode;

    @Transient
    private Collection<Questionnaire> issues;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="idUser")
    private User user;

    public Customer() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public void addIssues(Questionnaire questionnaire){
        issues.add(questionnaire);
    }

    public Collection<Questionnaire> getIssues() {
        return issues;
    }

    public void setIssues(Collection<Questionnaire> issues) {
        this.issues = issues;
    }

}

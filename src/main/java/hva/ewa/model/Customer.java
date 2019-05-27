package hva.ewa.model;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.UUID;

@Entity
public class Customer extends User implements Serializable {

    @Basic
    @Column(name = " customerCode")
    private String customerCode;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "phone")
    private String phone;

   @Transient
    private Collection<Questionnaire> issues;

   public Customer(){
       String uuid = UUID.randomUUID().toString();
       setCustomerCode(uuid);
   }
    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

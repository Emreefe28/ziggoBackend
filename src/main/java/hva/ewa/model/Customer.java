package hva.ewa.model;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Customer extends User implements Serializable {

    @Basic
    @Column(name = "klantNummer", nullable = false, unique = true)
    private String klantNummer;

    @Basic
    @Column(name = "adres", nullable = false, unique = true)
    private String adres;
    @Basic
    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Basic
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Basic
    @Column(name = "mobilePhone")
    private String mobilePhone;

    @OneToMany
    private Collection<Questionnaire> issues;

    public String getKlantNummer() {
        return klantNummer;
    }

    public void setKlantNummer(String klantNummer) {
        this.klantNummer = klantNummer;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }


    public Collection<Questionnaire> getIssues() {
        return issues;
    }

    public void setIssues(Collection<Questionnaire> issues) {
        this.issues = issues;
    }
}

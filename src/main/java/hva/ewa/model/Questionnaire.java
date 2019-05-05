package hva.ewa.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int number;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Categorie> categories;


    public Questionnaire() {

        setCategories(new ArrayList<>());
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}

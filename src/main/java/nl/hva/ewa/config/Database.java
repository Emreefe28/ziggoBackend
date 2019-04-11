package nl.hva.ewa.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {

    private final String PERSISTENCE_UNIT_NAME = "VodafoneZiggoDB" ;
    private  EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public   EntityManagerFactory getFactory()
    {
        // If it doesn't exist create it
        if(emf == null)
        {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        return emf;
    }

}

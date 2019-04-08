package nl.hva.ewa.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {

    private  EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public  EntityManagerFactory getFactory()
    {
        // If it doesn't exist create it
        if(emf == null)
        {

            emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        }

        return emf;
    }

}

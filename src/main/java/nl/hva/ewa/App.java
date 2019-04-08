package nl.hva.ewa;

import nl.hva.ewa.rest.CompetenceServlet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class App extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes = new HashSet<>();
        classes.add(CompetenceServlet.class);

        return classes;
    }


}

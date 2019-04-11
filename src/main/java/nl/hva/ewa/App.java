package nl.hva.ewa;

import nl.hva.ewa.rest.EmployeeResource;
import nl.hva.ewa.rest.filters.CORSFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class App extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(EmployeeResource.class);
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> providers = new HashSet<>();
        CORSFilter corsFilter = new CORSFilter();
        providers.add(corsFilter);
        return providers;
    }


}

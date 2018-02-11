package za.co.techtest.restapi;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import za.co.techtest.restapi.v0.ProcessCSVFile;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by rchennupati on 1/26/18.
 */
public class CSVRestApplication extends Application {

    private static final Logger logger = Logger.getLogger(CSVRestApplication.class.getName());


    /**
     * Get the list of service classes provided by this JAX-RS application
     */

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
        serviceClasses.add(za.co.techtest.restapi.v0.ProcessCSVFile.class);
        return serviceClasses;
    }

    @Override
    public Set<Object> getSingletons() {

        Set<Object> s = new HashSet<Object>();

        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector primary = new JaxbAnnotationIntrospector();
        AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
        AnnotationIntrospector pair = new AnnotationIntrospector.Pair(primary, secondary);
        mapper.getDeserializationConfig().setAnnotationIntrospector(pair);
        mapper.getSerializationConfig().setAnnotationIntrospector(pair);

        // Set up the provider
        JacksonJaxbJsonProvider jaxbProvider = new JacksonJaxbJsonProvider();
        jaxbProvider.setMapper(mapper);

        s.add(jaxbProvider);
        return s;
    }
}

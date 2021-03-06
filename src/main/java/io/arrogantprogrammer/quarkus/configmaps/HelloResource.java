package io.arrogantprogrammer.quarkus.configmaps;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/hello")
public class HelloResource {

    @ConfigProperty(name = "greeting")
    String greeting;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return Optional.ofNullable(greeting).orElse("Hello, from a non-existent property!");
    }
}
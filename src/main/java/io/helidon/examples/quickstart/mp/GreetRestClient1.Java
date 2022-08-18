package io.helidon.examples.quickstart.mp;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri="http://localhost:8080/outbound")
interface GreetRestClient1 {

    @GET
    JsonObject getDefaultMessage();

    @Path("/{name}")
    @GET
    JsonObject getMessage(@PathParam("name") String name);

}

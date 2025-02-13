package org.acme.getting.started;

import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestStreamElementType;

@Path("/hello")
public class StreamApi {

    @Inject
    StreamService service;

    @GET
    @Path("stream")
    @Consumes(MediaType.APPLICATION_JSON)
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    public Multi<OutputResponse> stream() {
        return service.callStream();
    }

}
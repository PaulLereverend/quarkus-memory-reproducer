package org.acme.getting.started;

import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestStreamElementType;

import java.util.stream.IntStream;

@Path("/")
public class StreamApi {


    @POST
    @Path("stream")
    @Consumes(MediaType.APPLICATION_JSON)
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    public Multi<OutputResponse> stream(InputBody input) {

        return Multi.createFrom().items(() -> {
            return IntStream.rangeClosed(1, 10).mapToObj(i -> new OutputResponse("test"));
        });


    }

}
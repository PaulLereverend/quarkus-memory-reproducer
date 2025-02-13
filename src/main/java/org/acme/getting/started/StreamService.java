package org.acme.getting.started;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class StreamService {

    @RestClient
    HttpClientStream restClient;

    public Multi<OutputResponse> callStream(){

        DummyObject test = new DummyObject("");
        
        return restClient.callStream(new InputBody("test"))
                .filter(item -> !item.getResponse().isEmpty())
                .onItem()
                .transform(item -> this.onItem(item, test));
    }

    public OutputResponse onItem(OutputResponse item, DummyObject test){
        item.response = test.test;
        return item;
    }

}

package com.psira.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/posts")
@RegisterRestClient(configKey = "post-api")
public interface PostApiClient {

    @GET
    @Path("/{postId}")
    @Produces("application/json")
    PostResponse getPostById(@PathParam("postId") Long postId);
}

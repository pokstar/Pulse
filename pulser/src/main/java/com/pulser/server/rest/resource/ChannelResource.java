package com.pulser.server.rest.resource;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.pulser.server.model.Channel;

@Path("/channel")
@RequestScoped
public class ChannelResource {
    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @GET
    @Produces("application/json")
    public List<Channel> getAll() {
        log.info("::getAll: retrieving all channels");
        @SuppressWarnings("unchecked")
        final List<Channel> results = em.createQuery("select c from Channel c").getResultList();//TODO Figure out why table name must be case sensitive
        log.info("::getAll: found " + results.size() + " channels");
        return results;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public Channel get(@PathParam("id") int id) {
        log.info("::get: retrieving channelId=" + id);
        return em.find(Channel.class, id);
    }

    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces("application/json")
    public String create(String json) {
        log.info("::create: creating new channel");

        return "todo";
    }
}

package com.pulser.server.rest.resource;

import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.pulser.server.model.Channel;

@Path("/pulse")
@RequestScoped
@Stateful
public class PulseResource {
    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String sendPulse(String json) {
        log.info("::sendPulse: received params=" + json);
        Channel channel = new Gson().fromJson(json, Channel.class);
        channel = em.find(Channel.class, channel.getId());
        log.info("::sendPulse: sending pulse to channelId=" + channel.getId());

        //TODO do something

        return "{status:200}";
    }

}
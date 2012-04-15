package com.pulser.server.rest.resource;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.pulser.server.model.Channel;
import com.pulser.server.model.User;
import com.pulser.server.model.Userchannel;

@Path("/channel")
@RequestScoped
@Stateful
public class ChannelResource {
    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @GET
    @Produces("application/json")
    public List<Channel> get() {
        log.info("::getAll: retrieving all channels");
        @SuppressWarnings("unchecked")
        List<Channel> results = em.createQuery("select c from " + Channel.class.getName() + " c").getResultList();
        log.info("::getAll: found " + results.size() + " channels");
        return results;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public Channel getById(@PathParam("id") int id) {
        log.info("::getById: retrieving channelId=" + id);
        Channel channel = null;
        try {
            channel = em.find(Channel.class, id);
        } catch(Exception e) {
            log.warning("::getById error: problem retrieving channelId=" + id);
        }
        return channel;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Channel create(String json) {
        log.info("::create: creating channel with params=" + json);
        Channel channelTmp = null;
        try {
            channelTmp = new Gson().fromJson(json, Channel.class);
            em.persist(channelTmp);
        } catch(Exception e) {
            log.info("::create error: problem creating channel=" + channelTmp);
        }
        return channelTmp;
    }

    @POST
    @Path("/{id:[0-9][0-9]*}/subscribe")
    @Consumes("application/json")
    @Produces("application/json")
    public String subscribe(@PathParam("id") int id, String json) {
        log.info("::subscribe: subscribing user to channelId=" + id + " with params=" + json);

        //TODO validate channelId
        try {
            //TODO subscribe to caller user, not to all users
            @SuppressWarnings("unchecked")
            List<Integer> userIds = em.createQuery("select u.id from " + User.class.getName() + " u").getResultList();
            for(Iterator<Integer> it = userIds.iterator(); it.hasNext();) {
                Userchannel userchannelTmp = new Userchannel();
                try {
                    int userId = it.next();
                    userchannelTmp.setChannel_id(id);
                    userchannelTmp.setUser_id(userId);
                    em.persist(userchannelTmp);
                } catch(Exception e) {
                    log.info("::subscribe error: problem creating to userchannel=" + userchannelTmp);
                }
            }
        } catch(Exception e) {
            log.info("::subscribe error: problem subscribing to channelId=" + id);
        }

        return "{status:200}";
    }
}

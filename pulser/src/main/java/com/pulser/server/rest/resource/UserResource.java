package com.pulser.server.rest.resource;

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
import com.pulser.server.model.User;

@Path("/user")
@RequestScoped
@Stateful
public class UserResource {
    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @GET
    @Produces("application/json")
    public User get() {
        log.info("::get: retrieving self user");
        User user = null;
        try {
            user = em.find(User.class, 6);//TODO Hardcoded for testing purpose!!
        } catch(Exception e) {
            log.warning("::get error: problem retrieving self user");
        }
        return user;
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<User> getAll() {
        log.info("::getAll: retrieving all users");
        @SuppressWarnings("unchecked")
        List<User> results = em.createQuery("select u from " + User.class.getName() + " u").getResultList();
        log.info("::getAll: found " + results.size() + " users");
        return results;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public User getById(@PathParam("id") int id) {
        log.info("::getById: retrieving userId=" + id);
        User user = null;
        try {
            user = em.find(User.class, id);
        } catch(Exception e) {
            log.warning("::getById error: problem retrieving userId=" + id);
        }
        return user;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public User create(String json) {
        log.info("::create: creating user with params=" + json);
        User userTmp = null;
        try {
            userTmp = new Gson().fromJson(json, User.class);
            em.persist(userTmp);
        } catch(Exception e) {
            log.info("::create error: problem creating user=" + userTmp);
        }
        return userTmp;
    }
}

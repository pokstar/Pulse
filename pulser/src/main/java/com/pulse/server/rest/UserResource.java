package com.pulse.server.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.pulse.server.model.User;

@Path("/user")
@RequestScoped
public class UserResource {
    @Inject
    private EntityManager em;

    @GET
    @Produces("application/json")
    public List<User> listAllUsers() {
        @SuppressWarnings("unchecked")
        final List<User> results = em.createQuery("select u from User u order by name").getResultList();//TODO Figure out why table name must be case sensitive
        return results;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public User lookupUserById(@PathParam("id") long id) {
        return em.find(User.class, id);
    }
}

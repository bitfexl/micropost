package com.github.bitfexl.micropost.resources;

import com.github.bitfexl.micropost.entities.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @GET
    public List<User> list() {
        return User.listAll();
    }

    @GET
    @Path("/{id}")
    public User get(Long id) {
        return User.findById(id);
    }

    @POST
    @Transactional
    public Response create(User user) {
        user.persist();
        return Response.created(URI.create("/user/" + user.id)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public User update(Long id, User user) {
        User existing = User.findById(id);
        if (existing == null) {
            throw new NotFoundException();
        }

        existing.name = user.name != null ? user.name : existing.name;
        existing.about = user.about != null ? user.about : existing.about;

        return existing;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id) {
        User existing = User.findById(id);
        if (existing == null) {
            throw new NotFoundException();
        }

        existing.delete();
    }

    @GET
    @Path("/count")
    public Long count() {
        return User.count();
    }
}

package com.spring.boot.jaxrs.resource;

import com.spring.boot.jaxrs.model.User;
import com.spring.boot.jaxrs.utility.ResponseUtility;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api("Users api")
@Path("/users")
public class UserResource {

    private static List<User> userList = null;

    static {

        userList = new ArrayList<>();

        User user = new User("yogesh", "ahmedabad", 1233L, "test@gmail.com");
        userList.add(user);
        user = new User("john", "USA", 123456789L, "test@gmail.com");
        userList.add(user);
    }

    @ApiOperation("Get all users")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getUsers() {

        return ResponseUtility.getInstance().generateResponse(Response.Status.OK, null,
                userList);
    }

    @ApiOperation("Get users by name")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{userName}")
    public Response getUserByName(@PathParam("userName") String userName) {

        return ResponseUtility.getInstance().generateResponse(Response.Status.OK, null,
                userList.stream().filter(user -> user.getName().equalsIgnoreCase(userName)).collect(Collectors.toList()));
    }

    @ApiOperation("Add new user")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addUser(User user) {
        userList.add(user);
        return ResponseUtility.getInstance().generateResponse(Response.Status.CREATED, null,
                userList);
    }

    @ApiOperation("Update user")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateUser(User user) {
        if (userList.contains(user)) {
            userList.remove(user);
        }
        userList.add(user);
        return ResponseUtility.getInstance().generateResponse(Response.Status.CREATED, null,
                userList);
    }

    @ApiOperation("Delete user")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{userName}")
    public Response deleteUser(@PathParam("userName") String userName) {
        userList.remove(userList.stream().filter(user -> user.getName().equalsIgnoreCase(userName))
                .collect(Collectors.toList()).get(0));
        return ResponseUtility.getInstance().generateResponse(Response.Status.OK, null,
                userList);
    }
}

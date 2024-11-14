package com.psira.resource;

import com.psira.dto.UserDTO;
import com.psira.model.ContactInfo;
import com.psira.model.Address;
import com.psira.model.User;
import com.psira.pojo.EmailRequest;
import com.psira.service.EmailService;
import com.psira.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    UserService userService;

    @GET
    public Response getAllUsers() {
        try {
            List<User> users = userService.listAll();
            return Response.ok(users).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error fetching users: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") Long id) {
        return userService.findById(id);
    }

    @GET
    @Path("/username/{username}")
    public Response getUserByUsername(@PathParam("username") String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found for username: " + username)
                    .build();
        }
    }

    @POST
    public Response createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setIdNumber(userDTO.getIdNumber());
        user.setCvFile(userDTO.getCvFile());

        List<Address> addressList = userDTO.getAddress().stream().map(dto -> {
            Address address = new Address();
            address.setStreetName(dto.getStreetName());
            address.setStreetNumber(dto.getStreetNumber());
            address.setProvince(dto.getProvince());
            address.setCity(dto.getCity());
            address.setPostalCode(dto.getPostalCode());
            address.setUser(user);
            return address;
        }).collect(Collectors.toList());

        List<ContactInfo> contactInfoList = userDTO.getContactInfo().stream().map(dto -> {
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setEmail(dto.getEmail());
            contactInfo.setCellphone(dto.getCellphone());
            contactInfo.setFax(dto.getFax());
            contactInfo.setWorkPhone(dto.getWorkPhone());
            contactInfo.setUser(user);
            return contactInfo;
        }).collect(Collectors.toList());

        user.setAddresses(addressList);
        user.setContactInfo(contactInfoList);

        userService.create(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, UserDTO userDTO) {
        User user = userService.findById(id);
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setIdNumber(userDTO.getIdNumber());
        user.setCvFile(userDTO.getCvFile());

        userService.update(user);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        userService.delete(id);
        return Response.noContent().build();
    }

    @Inject
    EmailService emailService;

    @POST
    @Path("/send-email")
    public String sendEmail(EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
        return "Email sent successfully to " + emailRequest.getTo();
    }
}

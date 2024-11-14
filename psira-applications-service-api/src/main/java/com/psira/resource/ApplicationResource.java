package com.psira.resource;

import com.psira.dto.ApplicationDTO;
import com.psira.dto.SiftingApplicationDTO;
import com.psira.model.Application;
import com.psira.service.ApplicationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/api/applications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApplicationResource {

    @Inject
    ApplicationService applicationService;

    @GET
    public List<ApplicationDTO> getAllApplications() {
        List<Application> applications = applicationService.listAll();
        return applications.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public ApplicationDTO getApplicationById(@PathParam("id") Long id) {
        Application application = applicationService.findById(id);
        return convertToDTO(application);
    }

    @POST
    public Response createApplication(ApplicationDTO applicationDTO) {
        Application application = applicationService.create(applicationDTO);
        return Response.status(Response.Status.CREATED).entity(convertToDTO(application)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateApplication(@PathParam("id") Long id, ApplicationDTO applicationDTO) {
        Application application = applicationService.update(id, applicationDTO);
        return Response.ok(convertToDTO(application)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteApplication(@PathParam("id") Long id) {
        applicationService.delete(id);
        return Response.noContent().build();
    }

    // New endpoint to retrieve SiftingApplicationDTO list
    @GET
    @Path("/sifting")
    public List<SiftingApplicationDTO> getSiftingApplications() {
        return applicationService.getSiftingApplications();
    }

    private ApplicationDTO convertToDTO(Application application) {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setApplicationId(application.getApplicationId());
        dto.setPostId(application.getPostId());
        dto.setUserId(application.getUser().getUserId());
        dto.setQualification(application.getQualification());
        dto.setDriversLicense(application.getDriversLicense());
        dto.setCurrentPosition(application.getCurrentPosition());
        dto.setCurrentCompany(application.getCurrentCompany());
        dto.setYearsInPosition(application.getYearsInPosition());
        dto.setCurrentSalary(application.getCurrentSalary());
        dto.setTotalExperience(application.getTotalExperience());
        dto.setPreviousPosition(application.getPreviousPosition());
        dto.setPreviousCompany(application.getPreviousCompany());
        dto.setPeriodFrom(application.getPeriodFrom());
        dto.setPeriodTo(application.getPeriodTo());
        return dto;
    }
}

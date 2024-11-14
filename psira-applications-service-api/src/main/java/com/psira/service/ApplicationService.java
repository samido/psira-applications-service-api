package com.psira.service;

import com.psira.dto.ApplicationDTO;
import com.psira.dto.SiftingApplicationDTO;
import com.psira.model.Application;
import com.psira.model.User;
import com.psira.repository.ApplicationRepository;
import com.psira.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ApplicationService {

    @Inject
    ApplicationRepository applicationRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    @RestClient
    PostApiClient postApiClient;

    public List<Application> listAll() {
        return applicationRepository.listAll();
    }

    public Application findById(Long id) {
        return applicationRepository.findById(id);
    }

    @Transactional
    public Application create(ApplicationDTO applicationDTO) {
        User user = userRepository.findById(applicationDTO.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Application application = new Application();
        application.setPostId(applicationDTO.getPostId());
        application.setUser(user);
        application.setQualification(applicationDTO.getQualification());
        application.setDriversLicense(applicationDTO.getDriversLicense());
        application.setCurrentPosition(applicationDTO.getCurrentPosition());
        application.setCurrentCompany(applicationDTO.getCurrentCompany());
        application.setYearsInPosition(applicationDTO.getYearsInPosition());
        application.setCurrentSalary(applicationDTO.getCurrentSalary());
        application.setTotalExperience(applicationDTO.getTotalExperience());
        application.setPreviousPosition(applicationDTO.getPreviousPosition());
        application.setPreviousCompany(applicationDTO.getPreviousCompany());
        application.setPeriodFrom(applicationDTO.getPeriodFrom());
        application.setPeriodTo(applicationDTO.getPeriodTo());

        applicationRepository.persist(application);
        return application;
    }

    @Transactional
    public Application update(Long id, ApplicationDTO applicationDTO) {
        Application application = findById(id);
        if (application == null) {
            throw new IllegalArgumentException("Application not found");
        }

        User user = userRepository.findById(applicationDTO.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        application.setPostId(applicationDTO.getPostId());
        application.setUser(user);
        application.setQualification(applicationDTO.getQualification());
        application.setDriversLicense(applicationDTO.getDriversLicense());
        application.setCurrentPosition(applicationDTO.getCurrentPosition());
        application.setCurrentCompany(applicationDTO.getCurrentCompany());
        application.setYearsInPosition(applicationDTO.getYearsInPosition());
        application.setCurrentSalary(applicationDTO.getCurrentSalary());
        application.setTotalExperience(applicationDTO.getTotalExperience());
        application.setPreviousPosition(applicationDTO.getPreviousPosition());
        application.setPreviousCompany(applicationDTO.getPreviousCompany());
        application.setPeriodFrom(applicationDTO.getPeriodFrom());
        application.setPeriodTo(applicationDTO.getPeriodTo());

        return applicationRepository.merge(application);
    }

    @Transactional
    public void delete(Long id) {
        applicationRepository.deleteById(id);
    }

    // New method to get a list of SiftingApplicationDTO objects
    public List<SiftingApplicationDTO> getSiftingApplications() {
        List<Application> applications = applicationRepository.listAll();

        return applications.stream().map(application -> {
            SiftingApplicationDTO dto = new SiftingApplicationDTO();
            User user = application.getUser();

            dto.setName(user.getName());
            dto.setSurname(user.getSurname());
            dto.setProvince(user.getAddresses().isEmpty() ? null : user.getAddresses().get(0).getProvince());

            // Calculate driver’s license points
            int licensePoints = application.getDriversLicense() ? 2 : 0;
            dto.setDriversLicense(application.getDriversLicense() ? "2" : "0");

            // Determine qualification points (2 if qualifications match)
            int qualificationPoints = Integer.parseInt(determineQualificationValue(application));
            dto.setQualification1(application.getQualification().toString());
            dto.setQualification2(String.valueOf(qualificationPoints));

            // Set experience and experience points separately
            dto.setExperience(application.getTotalExperience()); // Actual years of experience for display
            int experiencePoints = calculateExperiencePoints(application);
            dto.setExperiencePoints(experiencePoints); // Points based on experience requirement

            // Calculate total points
            int totalPoints = licensePoints + experiencePoints + qualificationPoints;
            dto.setTotalPoints((int) totalPoints);

            // Determine if requirements are met
            dto.setMeetRequirement(totalPoints == 6 ? "Yes" : "No");
            dto.setReviewCV(user.getCvFile());

            return dto;
        }).collect(Collectors.toList());
    }

    private Double calculateTotalPoints(Application application) {
        return (application.getTotalExperience() * 2) + (application.getYearsInPosition() * 1.5);
    }

    private Boolean checkRequirement(Application application) {
        return application.getTotalExperience() >= 5 && application.getDriversLicense();
    }

    private int calculateExperiencePoints(Application application) {
        try {
            PostResponse postResponse = postApiClient.getPostById(application.getPostId());
            int requiredExperience = postResponse.getExperienceYears();
            return application.getTotalExperience() >= requiredExperience ? 2 : 0;
        } catch (Exception e) {
            System.err.println("Failed to fetch post experience: " + e.getMessage());
            return 2;
        }
    }

    private String determineQualificationValue(Application application) {
        try {
            PostResponse postResponse = postApiClient.getPostById(application.getPostId());
            String externalQualification = postResponse.getQualification();

            if (application.getQualification().toString().equals(externalQualification)) {
                return "2"; // Qualifications match
            }
        } catch (Exception e) {
            System.err.println("Failed to fetch external qualification: " + e.getMessage());
        }
        return "0"; // Default if qualifications do not match or if an error occurs
    }
}

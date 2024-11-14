package com.psira.service;

import com.psira.dto.ApplicationDTO;
import com.psira.model.Application;
import com.psira.model.Qualification;
import com.psira.model.User;
import com.psira.repository.ApplicationRepository;
import com.psira.repository.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@QuarkusTest
public class ApplicationServiceTest {

    @Inject
    ApplicationService applicationService;

    @Inject
    UserRepository userRepository;

    @Inject
    ApplicationRepository applicationRepository;

    @InjectMock
    @RestClient
    PostApiClient postApiClient; // Mock PostApiClient to avoid real HTTP calls

    private Long testUserId;

    @BeforeEach
    @Transactional
    public void setUp() {
        // Clear existing data to ensure isolation between tests
       //  applicationRepository.listAll().forEach(application -> applicationRepository.deleteById(application.getApplicationId()));
        //  userRepository.listAll().forEach(user -> userRepository.deleteById(user.getUserId()));

        // Create a test User with all required fields populated
        Date date = new Date();
        long longValue2 = date.getTime();

        User testUser = new User();
        testUser.setUsername(longValue2 + "@gmail.com");
        testUser.setPassword("securepassword" + longValue2);
        testUser.setName("Test" + longValue2);
        testUser.setSurname("User" + longValue2);
        testUser.setIdNumber("" + longValue2);
        testUser.setCvFile("JVBERi0xLjQKJaqrrK0KNCAwIG9iago8PCAvVHlwZSAvUGFnZQovUGFyZW50IDMgMCBS\n" +
                "Ci9NZWRpYUJveCBbMCAwIDU5NSA4NDJdCi9Db250ZW50cyAyIDAgUgovUmVzb3VyY2Vz\n" +
                "IDw8Ci9Gb250IDw8Ci9GIFMgMSAwIFIKPj4KPj4KPj4KZW5kb2JqCjYgMCBvYmoKPDwg\n" +
                "L1R5cGUgL0ZvbnQKL05hbWUgL0YgL1N1YnR5cGUgL1R5cGUgL0VuY29kaW5nIC9XaW5B\n" +
                "bnNpRW5jb2RpbmcKPj4KZW5kb2JqCjEgMCBvYmoKPDwgL1R5cGUgL1BhZ2VzCi9LaWRz\n" +
                "IFsgNCAwIFIgXQo+PgplbmRvYmoKMiAwIG9iago8PCAvTGVuZ3RoIDEwID4+CnN0cmVh\n" +
                "bQpICkVPRgoKZW5kb2JqCjMgMCBvYmoKPDwgL1R5cGUgL1BhZ2VzCi9Db3VudCAxCi9L\n" +
                "aWRzIFsgNCAwIFIgXQo+PgplbmRvYmoKeHJlZgowIDYKMDAwMDAwMDAwMCA2NTUzNSBm\n" +
                "IAowMDAwMDAwMDEwIDAwMDAwIG4gCjAwMDAwMDAwMDAgMDAwMDAgbgogICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKZW5kb2YKeHJlZg==");
        userRepository.persist(testUser);
        testUserId = testUser.getUserId();

        // Configure mock behavior for PostApiClient
        PostResponse mockResponse = new PostResponse();
        mockResponse.setQualification("PHD");
        when(postApiClient.getPostById(Mockito.anyLong())).thenReturn(mockResponse);
    }

    @Test
    @Transactional
    public void testCreateApplication() {
        // Prepare ApplicationDTO with test data
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setPostId(101L);
        applicationDTO.setUserId(testUserId);  // Use the test user's ID
        applicationDTO.setQualification(Qualification.PHD);
        applicationDTO.setDriversLicense(false);
        applicationDTO.setCurrentPosition("Software Engineer");
        applicationDTO.setCurrentCompany("Tech Corp");
        applicationDTO.setYearsInPosition(3L);
        applicationDTO.setCurrentSalary(60000.00);
        applicationDTO.setTotalExperience(5L);

        // Set new fields
        applicationDTO.setPreviousPosition("Junior Developer");
        applicationDTO.setPreviousCompany("Startup Inc.");
        applicationDTO.setPeriodFrom(new Date());
        applicationDTO.setPeriodTo(new Date());

        // Call create method in ApplicationService
        Application application = applicationService.create(applicationDTO);

        // Verify that the Application object was created and persisted
        assertNotNull(application);
        assertNotNull(application.getApplicationId());
        assertEquals(applicationDTO.getPostId(), application.getPostId());
        assertEquals(applicationDTO.getUserId(), application.getUser().getUserId());
        assertEquals(applicationDTO.getQualification(), application.getQualification());
        assertEquals(applicationDTO.getDriversLicense(), application.getDriversLicense());
        assertEquals(applicationDTO.getCurrentPosition(), application.getCurrentPosition());
        assertEquals(applicationDTO.getCurrentCompany(), application.getCurrentCompany());
        assertEquals(applicationDTO.getYearsInPosition(), application.getYearsInPosition());
        assertEquals(applicationDTO.getCurrentSalary(), application.getCurrentSalary());
        assertEquals(applicationDTO.getTotalExperience(), application.getTotalExperience());

        // Verify new fields
        assertEquals(applicationDTO.getPreviousPosition(), application.getPreviousPosition());
        assertEquals(applicationDTO.getPreviousCompany(), application.getPreviousCompany());
        assertEquals(applicationDTO.getPeriodFrom(), application.getPeriodFrom());
        assertEquals(applicationDTO.getPeriodTo(), application.getPeriodTo());
    }
}

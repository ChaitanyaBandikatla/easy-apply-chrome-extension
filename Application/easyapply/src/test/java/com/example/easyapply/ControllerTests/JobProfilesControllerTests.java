package com.example.easyapply.ControllerTests;

import com.example.easyapply.controllers.JobProfileController;
import com.example.easyapply.models.JobProfileModel;
import com.example.easyapply.models.Response;
import com.example.easyapply.services.JobProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JobProfilesControllerTests {

    private JobProfileModel jobProfileModel;
    private JobProfileService jobProfileService;
    private JobProfileController jobProfileController;

    @BeforeEach
    public void initialize(){
        jobProfileService = Mockito.mock(JobProfileService.class);
        jobProfileModel = new JobProfileModel();
        jobProfileController = new JobProfileController(jobProfileService);
    }

    @Test
    public void test_createJobProfile_successful(){
        when(jobProfileService.createJobProfile(jobProfileModel)).thenReturn(Optional.of(1));
        ResponseEntity<Response> responseEntity = this.jobProfileController.createJobProfile(jobProfileModel);
        assertEquals(1, ((Optional<Integer>) responseEntity.getBody().getResponse()).get().intValue());
    }

    @Test
    public void test_createJobProfile_failed(){
        when(jobProfileService.createJobProfile(jobProfileModel)).thenReturn(Optional.empty());
        ResponseEntity<Response> responseEntity = this.jobProfileController.createJobProfile(jobProfileModel);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getBody().getHttpStatus());
    }

    @Test
    public void test_getJobProfile_successful(){
        jobProfileModel.setJobProfileId(1);
        when(jobProfileService.getJobProfile(1)).thenReturn(Optional.of(jobProfileModel));
        ResponseEntity<Response> responseEntity = this.jobProfileController.getJobProfile(1);
        assertEquals(1, ((Optional<JobProfileModel>) responseEntity.getBody().getResponse()).get().getJobProfileId());
    }

    @Test
    public void test_getJobProfile_failed(){
        when(jobProfileService.getJobProfile(1)).thenReturn(Optional.empty());
        ResponseEntity<Response> responseEntity = this.jobProfileController.getJobProfile(1);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getBody().getHttpStatus());
    }

    @Test
    public void test_updateJobProfile_successful(){
        when(jobProfileService.updateJobProfile(jobProfileModel)).thenReturn(Optional.of(1));
        ResponseEntity<Response> responseEntity = this.jobProfileController.updateJobProfile(jobProfileModel);
        assertEquals(1, ((Optional<Integer>) responseEntity.getBody().getResponse()).get().intValue());
    }

    @Test
    public void test_updateJobProfile_failed(){
        when(jobProfileService.updateJobProfile(jobProfileModel)).thenReturn(Optional.empty());
        ResponseEntity<Response> responseEntity = this.jobProfileController.updateJobProfile(jobProfileModel);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getBody().getHttpStatus());
    }

    @Test
    public void test_getJobProfiles_successful(){
        List<JobProfileModel> jobProfileModelList = new ArrayList<>();
        jobProfileModelList.add(jobProfileModel);
        when(jobProfileService.getJobProfiles(1)).thenReturn(jobProfileModelList);
        ResponseEntity<Response> responseEntity = this.jobProfileController.getJobProfiles(1);
        assertEquals(1, ((List<JobProfileModel>) responseEntity.getBody().getResponse()).size());
    }

    @Test
    public void test_getJobProfiles_failed(){
        when(jobProfileService.getJobProfiles(1)).thenReturn(new ArrayList<>());
        ResponseEntity<Response> responseEntity = this.jobProfileController.getJobProfiles(1);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getBody().getHttpStatus());
    }
}

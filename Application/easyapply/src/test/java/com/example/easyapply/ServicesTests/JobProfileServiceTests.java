package com.example.easyapply.ServicesTests;

import com.example.easyapply.entities.JobProfileDetailsEntity;
import com.example.easyapply.entities.UserDetailsEntity;
import com.example.easyapply.models.JobProfileModel;
import com.example.easyapply.repositories.JobProfileRepository;
import com.example.easyapply.services.JobProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class JobProfileServiceTests {
    private JobProfileRepository jobProfileRepository;
    private JobProfileDetailsEntity jobProfileDetailsEntity;
    private JobProfileModel jobProfileModel;
    private JobProfileService jobProfileService;

    @BeforeEach
    public void initialize(){
        this.jobProfileDetailsEntity = new JobProfileDetailsEntity();
        this.jobProfileDetailsEntity.setJobProfileId(1);
        this.jobProfileDetailsEntity.setJobType("test");
        this.jobProfileDetailsEntity.setUserId(1);
        this.jobProfileDetailsEntity.setJobProfileName("test");
        this.jobProfileDetailsEntity.setPhone("9899");
        this.jobProfileDetailsEntity.setLinkedinProfile("test");
        this.jobProfileDetailsEntity.setFirstName("test");
        this.jobProfileDetailsEntity.setLastName("test");
        this.jobProfileDetailsEntity.setEmail("test");

        this.jobProfileModel = new JobProfileModel();
        this.jobProfileRepository = Mockito.mock(JobProfileRepository.class);
        this.jobProfileService = new JobProfileService(jobProfileRepository);
    }

    @Test
    public void test_createJobProfile_success(){
        jobProfileDetailsEntity.setJobProfileId(1);
        when(jobProfileRepository.save(org.mockito.Matchers.any(JobProfileDetailsEntity.class))).thenReturn(jobProfileDetailsEntity);
        Optional<Integer> jobProfileId = jobProfileService.createJobProfile(jobProfileModel);
        assertEquals(1, jobProfileId.get().intValue());
    }

    @Test
    public void test_updateJobProfile_success(){
        jobProfileDetailsEntity.setJobProfileId(0);
        when(jobProfileRepository.findById(0)).thenReturn(Optional.of(jobProfileDetailsEntity));
        when(jobProfileRepository.save(org.mockito.Matchers.any(JobProfileDetailsEntity.class))).thenReturn(jobProfileDetailsEntity);
        Optional<Integer> jobProfileId = jobProfileService.updateJobProfile(jobProfileModel);
        assertEquals(0, jobProfileId.get().intValue());
    }

    @Test
    public void test_getJobProfiles_success(){
        List<JobProfileDetailsEntity> jobProfileDetailsEntityList = new ArrayList<>();
        jobProfileDetailsEntityList.add(jobProfileDetailsEntity);
        when(jobProfileRepository.findJobProfileByUserId(0)).thenReturn(jobProfileDetailsEntityList);
        List<JobProfileModel> jobProfileModelList = this.jobProfileService.getJobProfiles(0);
        assertEquals(1, jobProfileModelList.size());
    }

    @Test
    public void test_getJobProfile_success(){
        when(jobProfileRepository.findById(0)).thenReturn(Optional.of(jobProfileDetailsEntity));
        Optional<JobProfileModel> jobProfileModel = this.jobProfileService.getJobProfile(0);
        assertEquals(1, jobProfileModel.get().getJobProfileId());
    }
}

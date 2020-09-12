package com.example.easyapply.services;

import com.example.easyapply.entities.JobProfileDetailsEntity;
import com.example.easyapply.models.JobProfileModel;
import com.example.easyapply.models.UserModel;
import com.example.easyapply.repositories.JobProfileRepository;
import com.example.easyapply.utilities.ApplicationLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

/**
 * Service layer for job profile flows
 */
@Service
public class JobProfileService {

    @Autowired
    private JobProfileRepository jobProfileRepository;

    /**
     * Creates a job profile for a given DTO
     * @param jobProfileModel
     * @return
     */
    public Optional<Integer> createJobProfile(@NonNull JobProfileModel jobProfileModel){
        if(jobProfileModel != null){
            JobProfileDetailsEntity jobProfileDetailsEntity = new JobProfileDetailsEntity();
            jobProfileDetailsEntity.setEmail(jobProfileModel.getEmail());
            jobProfileDetailsEntity.setPhone(jobProfileModel.getPhone());
            jobProfileDetailsEntity.setFirstName(jobProfileModel.getFirstName());
            jobProfileDetailsEntity.setLastName(jobProfileModel.getLastName());
            jobProfileDetailsEntity.setGithubProfile(jobProfileModel.getGithubProfile());
            jobProfileDetailsEntity.setLinkedinProfile(jobProfileModel.getLinkedinProfile());
            jobProfileDetailsEntity.setWebsite(jobProfileModel.getWebsite());
            jobProfileDetailsEntity.setInformationSource(jobProfileModel.getInformationString());
            jobProfileDetailsEntity.setUserId(jobProfileModel.getUserId());
            jobProfileDetailsEntity.setJobProfileName(jobProfileModel.getJobProfileName());
            jobProfileDetailsEntity.setJobType(jobProfileModel.getJobType());

            try {
                jobProfileDetailsEntity = jobProfileRepository.save(jobProfileDetailsEntity);
                return Optional.ofNullable(jobProfileDetailsEntity.getJobProfileId());
            } catch (Exception ex) {
                ApplicationLogger.getInstance().logException(ex);
            }
        }

        return Optional.ofNullable(null);
    }

    /**
     * Returns a Job Profile model with matching job profile id
     * @param  jobId
     * @return
     */
    public Optional<JobProfileModel> getJobProfile(int jobId){
        Optional<JobProfileDetailsEntity> jobProfileDetailsEntity = jobProfileRepository.findById(jobId);

        if(jobProfileDetailsEntity.isPresent()){
            JobProfileModel jobProfileModel = new JobProfileModel();
            jobProfileModel.setJobProfileId(jobProfileDetailsEntity.get().getJobProfileId());
            jobProfileModel.setUserId(jobProfileDetailsEntity.get().getUserId());
            jobProfileModel.setJobProfileName(jobProfileDetailsEntity.get().getJobProfileName());
            jobProfileModel.setJobType(jobProfileDetailsEntity.get().getJobType());
            jobProfileModel.setFirstName(jobProfileDetailsEntity.get().getFirstName());
            jobProfileModel.setLastName(jobProfileDetailsEntity.get().getLastName());
            jobProfileModel.setPhone(jobProfileDetailsEntity.get().getPhone());
            jobProfileModel.setLinkedinProfile(jobProfileDetailsEntity.get().getLinkedinProfile());
            jobProfileModel.setGithubProfile(jobProfileDetailsEntity.get().getGithubProfile());
            jobProfileModel.setEmail(jobProfileDetailsEntity.get().getEmail());
            jobProfileModel.setWebsite(jobProfileDetailsEntity.get().getWebsite());
            jobProfileModel.setInformationString(jobProfileDetailsEntity.get().getInformationSource());
            return Optional.of(jobProfileModel);
        }

        return Optional.ofNullable(null);
    }


    /**
     * Updates a job profile for a given DTO
     * @param jobProfileModel, jobId
     * @return
     */
    public Optional<Integer> updateJobProfile(@NonNull JobProfileModel jobProfileModel,int jobId){
        if(jobProfileModel != null){
            JobProfileDetailsEntity jobProfileDetailsEntity = new JobProfileDetailsEntity();
            jobProfileDetailsEntity.setJobProfileId(jobId);
            jobProfileDetailsEntity.setEmail(jobProfileModel.getEmail());
            jobProfileDetailsEntity.setPhone(jobProfileModel.getPhone());
            jobProfileDetailsEntity.setFirstName(jobProfileModel.getFirstName());
            jobProfileDetailsEntity.setLastName(jobProfileModel.getLastName());
            jobProfileDetailsEntity.setGithubProfile(jobProfileModel.getGithubProfile());
            jobProfileDetailsEntity.setLinkedinProfile(jobProfileModel.getLinkedinProfile());
            jobProfileDetailsEntity.setWebsite(jobProfileModel.getWebsite());
            jobProfileDetailsEntity.setInformationSource(jobProfileModel.getInformationString());
            jobProfileDetailsEntity.setUserId(jobProfileModel.getUserId());
            jobProfileDetailsEntity.setJobProfileName(jobProfileModel.getJobProfileName());
            jobProfileDetailsEntity.setJobType(jobProfileModel.getJobType());

            try {
                jobProfileDetailsEntity = jobProfileRepository.save(jobProfileDetailsEntity);
                return Optional.ofNullable(jobProfileDetailsEntity.getJobProfileId());
            } catch (Exception ex) {
                ApplicationLogger.getInstance().logException(ex);
            }
        }

        return Optional.ofNullable(null);
    }

    /**
     * Returns jobprofile models with matching user id
     * @param userId
     * @return
     */
    public List<JobProfileModel> getJobProfiles(int userId){
        List<JobProfileDetailsEntity> jobProfilesByUserId = jobProfileRepository.findJobProfileByUserId(userId);
        List<JobProfileModel> jobProfilesList = new ArrayList<>();
        for(JobProfileDetailsEntity jobProfileByUserId: jobProfilesByUserId) {
            JobProfileModel jobProfileModel = new JobProfileModel();
            jobProfileModel.setJobProfileId(jobProfileByUserId.getJobProfileId());
            jobProfileModel.setUserId(jobProfileByUserId.getUserId());
            jobProfileModel.setJobProfileName(jobProfileByUserId.getJobProfileName());
            jobProfileModel.setJobType(jobProfileByUserId.getJobType());
            jobProfileModel.setFirstName(jobProfileByUserId.getFirstName());
            jobProfileModel.setLastName(jobProfileByUserId.getLastName());
            jobProfileModel.setPhone(jobProfileByUserId.getPhone());
            jobProfileModel.setLinkedinProfile(jobProfileByUserId.getLinkedinProfile());
            jobProfileModel.setGithubProfile(jobProfileByUserId.getGithubProfile());
            jobProfileModel.setEmail(jobProfileByUserId.getEmail());
            jobProfileModel.setWebsite(jobProfileByUserId.getWebsite());
            jobProfileModel.setInformationString(jobProfileByUserId.getInformationSource());
            jobProfilesList.add(jobProfileModel);
        }
        return jobProfilesList;
    }
}

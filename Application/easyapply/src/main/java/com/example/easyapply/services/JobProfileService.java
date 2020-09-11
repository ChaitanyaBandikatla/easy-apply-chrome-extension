package com.example.easyapply.services;

import com.example.easyapply.entities.JobProfileDetailsEntity;
import com.example.easyapply.entities.UserDetailsEntity;
import com.example.easyapply.models.JobProfileModel;
import com.example.easyapply.models.UserModel;
import com.example.easyapply.repositories.JobProfileRepository;
import com.example.easyapply.utilities.ApplicationLogger;
import com.example.easyapply.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            JobProfileDetailsEntity jobProfileDetailsEntity = createJobProfileDetailsEntity(jobProfileModel);
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
    public Optional<Integer> updateJobProfile(@NonNull JobProfileModel jobProfileModel){
        if (jobProfileModel != null) {
            Optional<JobProfileDetailsEntity> jobProfileDetailsEntity =
                    jobProfileRepository.findById(jobProfileModel.getJobProfileId());

            if (jobProfileDetailsEntity.isPresent()) {
                Utilities.copyNonNullProperties(createJobProfileDetailsEntity(jobProfileModel), jobProfileDetailsEntity.get());
                try {
                    jobProfileRepository.save(jobProfileDetailsEntity.get());
                    return Optional.ofNullable(jobProfileDetailsEntity.get().getJobProfileId());
                } catch (Exception ex) {
                    ApplicationLogger.getInstance().logException(ex);
                }
            }
        }

        return Optional.ofNullable(null);
    }

    /**
     * Create a job profile details entity for a given job profile model
     * @param jobProfileModel
     * @return
     */
    private JobProfileDetailsEntity createJobProfileDetailsEntity(@NonNull JobProfileModel jobProfileModel){
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
        jobProfileDetailsEntity.setJobProfileId(jobProfileModel.getJobProfileId());

        return jobProfileDetailsEntity;
    }
}

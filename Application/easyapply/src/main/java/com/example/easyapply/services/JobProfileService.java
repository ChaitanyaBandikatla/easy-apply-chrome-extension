package com.example.easyapply.services;

import com.example.easyapply.entities.JobProfileDetailsEntity;
import com.example.easyapply.entities.UserDetailsEntity;
import com.example.easyapply.models.JobProfileModel;
import com.example.easyapply.repositories.JobProfileRepository;
import com.example.easyapply.utilities.ApplicationLogger;
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
}

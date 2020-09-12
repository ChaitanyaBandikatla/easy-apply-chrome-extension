package com.example.easyapply.repositories;

import com.example.easyapply.entities.JobProfileDetailsEntity;
import com.example.easyapply.models.JobProfileModel;

import java.util.List;
import java.util.Optional;

public interface JobProfileCustom {
    public List<JobProfileDetailsEntity> findJobProfileByUserId(int userId);
}

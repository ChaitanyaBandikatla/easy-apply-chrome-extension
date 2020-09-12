package com.example.easyapply.repositories;

import com.example.easyapply.entities.JobProfileDetailsEntity;

import java.util.List;

public interface JobProfileCustom {
    public List<JobProfileDetailsEntity> findJobProfileByUserId(int userId);
}

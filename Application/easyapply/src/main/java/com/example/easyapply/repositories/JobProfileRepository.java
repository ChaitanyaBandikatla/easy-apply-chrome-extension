package com.example.easyapply.repositories;

import com.example.easyapply.entities.JobProfileDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobProfileRepository extends JpaRepository<JobProfileDetailsEntity, Integer>, JobProfileCustom {
}

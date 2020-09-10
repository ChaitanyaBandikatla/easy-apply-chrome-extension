package com.example.easyapply.controllers;

import com.example.easyapply.models.JobProfileModel;
import com.example.easyapply.models.Response;
import com.example.easyapply.services.JobProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Controller which deals with job profile operations
 */

@RestController
public class JobProfileController {

    @Autowired
    private JobProfileService jobProfileService;

    /**
     * Create a job profile id
     * @param jobProfileModel
     * @return
     */
    @RequestMapping(value = "/jobProfile")
    public ResponseEntity<Response> createJobProfile(@RequestBody JobProfileModel jobProfileModel) {
        Optional<Integer> jobProfileId = jobProfileService.createJobProfile(jobProfileModel);
        if(jobProfileId.isPresent()){
            jobProfileModel.setUserId(jobProfileId.get());
            return new ResponseEntity<Response>(new Response(HttpStatus.OK, jobProfileId), HttpStatus.OK);
        }

        return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST, "Creation of job Profile failed"),
                HttpStatus.OK);
    }
}

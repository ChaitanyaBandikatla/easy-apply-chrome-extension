package com.example.easyapply.controllers;

import com.example.easyapply.models.JobProfileModel;
import com.example.easyapply.models.Response;
import com.example.easyapply.services.JobProfileService;
import com.example.easyapply.utilities.ApplicationLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;
/**
 * Controller which deals with job profile operations
 */

@RestController
public class JobProfileController {

    @Autowired
    private JobProfileService jobProfileService;

    public JobProfileController(JobProfileService jobProfileService){
        this.jobProfileService = jobProfileService;
    }

    /**
     * Create a job profile id
     * @param jobProfileModel
     * @return
     */
    @RequestMapping(value = "/jobProfile")
    public ResponseEntity<Response> createJobProfile(@RequestBody JobProfileModel jobProfileModel) {
        Optional<Integer> jobProfileId = jobProfileService.createJobProfile(jobProfileModel);
        if(jobProfileId.isPresent()){
            jobProfileModel.setJobProfileId(jobProfileId.get());
            return new ResponseEntity<Response>(new Response(HttpStatus.OK, jobProfileId), HttpStatus.OK);
        }

        return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST, "Creation of job Profile failed"),
                HttpStatus.OK);
    }

    @RequestMapping("/jobProfile/{profile_id}")
    public ResponseEntity<Response> getJobProfile(@PathVariable("profile_id") int profileId){
        Optional<JobProfileModel> jobProfileModel = jobProfileService.getJobProfile(profileId);
        if(jobProfileModel.isPresent()){
            return new ResponseEntity<Response>(new Response(HttpStatus.OK, jobProfileModel), HttpStatus.OK);
        }

        return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST, "Job Profile not found"), HttpStatus.OK);
    }

    @RequestMapping("/jobProfile/edit/")
    public ResponseEntity<Response> updateJobProfile(@RequestBody JobProfileModel jobProfileModel){
        Optional<Integer> jobProfileId = jobProfileService.updateJobProfile(jobProfileModel);
        if(jobProfileId.isPresent()){
            return new ResponseEntity<Response>(new Response(HttpStatus.OK, jobProfileId), HttpStatus.OK);
        }

        return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST, "Updation of job Profile failed"),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/userJobProfile/{user_id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getJobProfiles(@PathVariable("user_id") int userId){
        List<JobProfileModel> jobProfilesList = jobProfileService.getJobProfiles(userId);
        if (!jobProfilesList.isEmpty()) {
            return new ResponseEntity<Response>(new Response(HttpStatus.OK, jobProfilesList), HttpStatus.OK);
        }

        return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST, "No Job Profiles"),
                HttpStatus.OK);
    }
}

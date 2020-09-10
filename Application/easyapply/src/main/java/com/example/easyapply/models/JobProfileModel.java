package com.example.easyapply.models;

/**
 * DTO for job profile
 */
public class JobProfileModel {
    private int jobProfileId;
    private int userId;
    private String jobProfileName;
    private String jobType;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String linkedinProfile;
    private String githubProfile;
    private String website;
    private String informationString;

    public int getJobProfileId() {
        return jobProfileId;
    }

    public void setJobProfileId(int jobProfileId) {
        this.jobProfileId = jobProfileId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getJobProfileName() {
        return jobProfileName;
    }

    public void setJobProfileName(String jobProfileName) {
        this.jobProfileName = jobProfileName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkedinProfile() {
        return linkedinProfile;
    }

    public void setLinkedinProfile(String linkedinProfile) {
        this.linkedinProfile = linkedinProfile;
    }

    public String getGithubProfile() {
        return githubProfile;
    }

    public void setGithubProfile(String githubProfile) {
        this.githubProfile = githubProfile;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getInformationString() {
        return informationString;
    }

    public void setInformationString(String informationString) {
        this.informationString = informationString;
    }
}

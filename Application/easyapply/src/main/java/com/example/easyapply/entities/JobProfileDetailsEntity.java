package com.example.easyapply.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "job_profile_details", schema = "public", catalog = "d9egl5hpouila3")
public class JobProfileDetailsEntity {
    private int jobProfileId;
    private String jobProfileName;
    private String jobType;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String linkedinProfile;
    private String githubProfile;
    private String website;
    private String informationSource;
    private Timestamp createdOn;
    private Integer userId;

    @Id
    @Column(name = "job_profile_id")
    @GeneratedValue
    public int getJobProfileId() {
        return jobProfileId;
    }

    public void setJobProfileId(int jobProfileId) {
        this.jobProfileId = jobProfileId;
    }

    @Basic
    @Column(name = "job_profile_name")
    public String getJobProfileName() {
        return jobProfileName;
    }

    public void setJobProfileName(String jobProfileName) {
        this.jobProfileName = jobProfileName;
    }

    @Basic
    @Column(name = "job_type")
    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "linkedin_profile")
    public String getLinkedinProfile() {
        return linkedinProfile;
    }

    public void setLinkedinProfile(String linkedinProfile) {
        this.linkedinProfile = linkedinProfile;
    }

    @Basic
    @Column(name = "github_profile")
    public String getGithubProfile() {
        return githubProfile;
    }

    public void setGithubProfile(String githubProfile) {
        this.githubProfile = githubProfile;
    }

    @Basic
    @Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Basic
    @Column(name = "information_source")
    public String getInformationSource() {
        return informationSource;
    }

    public void setInformationSource(String informationSource) {
        this.informationSource = informationSource;
    }

    @Basic
    @Column(name = "created_on", insertable = false)
    @GeneratedValue
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Object createdOn) {
        this.createdOn = (Timestamp) createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobProfileDetailsEntity that = (JobProfileDetailsEntity) o;
        return jobProfileId == that.jobProfileId &&
                Objects.equals(jobProfileName, that.jobProfileName) &&
                Objects.equals(jobType, that.jobType) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(linkedinProfile, that.linkedinProfile) &&
                Objects.equals(githubProfile, that.githubProfile) &&
                Objects.equals(website, that.website) &&
                Objects.equals(informationSource, that.informationSource) &&
                Objects.equals(createdOn, that.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobProfileId, jobProfileName, jobType, firstName, lastName, email, phone, linkedinProfile, githubProfile, website, informationSource, createdOn);
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

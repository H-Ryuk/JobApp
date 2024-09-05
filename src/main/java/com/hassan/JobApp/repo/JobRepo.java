package com.hassan.JobApp.repo;


import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hassan.JobApp.model.JobPost;

import javax.swing.*;

@Repository
public class JobRepo {

    // arrayList to store store JobPost objects
    List<JobPost> jobs = new ArrayList<>();

    // ****************************************************************************

    // constructor->injecting objects into ArrayList defined above.
    public JobRepo() {

        // Java Developer Job Post
        jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

        // Frontend Developer Job Post
        jobs.add(
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")));

        // Data Scientist Job Post
        jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of("Python", "Machine Learning", "Data Analysis")));

    }

    // ****************************************************************************

    // method to return all JobPosts
    public List<JobPost> returnAllJobPosts() {
        return jobs;
    }

    // method to save a job post object into arrayList
    public void addJobPost(JobPost job) {
        jobs.add(job);

    }


    public void deleteJobPost(int jobId) {
        for (int i = 0; i < jobs.size(); i++) {
            if (jobId == jobs.get(i).getPostId()) {
                jobs.remove(i);
            }
        }
    }



    public void updateJobPost(JobPost job){
        for(JobPost jobPost : jobs){
            if(jobPost.getPostId() == job.getPostId()){
                jobPost.setPostId(job.getPostId());
                jobPost.setPostProfile(job.getPostProfile());
                jobPost.setPostDesc(job.getPostDesc());
                jobPost.setReqExperience(job.getReqExperience());
                jobPost.setPostTechStack(job.getPostTechStack());
            }
        }
    }


    public JobPost getById(int postId){
        for(JobPost jp : jobs){
            if (postId == jp.getPostId())
                return jp;
        }
        return null;
    }


}
package com.hassan.JobApp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassan.JobApp.model.JobPost;
import com.hassan.JobApp.repo.JobRepo;

@Service
public class JobService {
    @Autowired
    public JobRepo repo;



    //method to return all JobPosts
    public List<JobPost> returnAllJobPosts() {
        return repo.returnAllJobPosts();


    }

    // ***************************************************************************

    // method to add a jobPost
    public void addJobPost(JobPost jobPost) {
        repo.addJobPost(jobPost);

    }


    public void deleteJobPost(int jobId){
        repo.deleteJobPost(jobId);
    }


    public void updateJobPost(JobPost job){
        repo.updateJobPost(job);
    }


    public JobPost getById(int postId){
        return repo.getById(postId);
    }

}

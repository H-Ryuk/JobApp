package com.hassan.JobApp.controller;

import com.hassan.JobApp.model.JobPost;
import com.hassan.JobApp.service.JobService;
import jakarta.websocket.server.PathParam;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class JobRestContoller {

    private final JobService jobService;

    public JobRestContoller(JobService jobService) {
        this.jobService = jobService;
    }



//    @GetMapping(path="posts", produces = {"application/xml"})
    @GetMapping(path="posts")
    public List<JobPost> posts() {
        return jobService.returnAllJobPosts();
    }



    @PostMapping(path="post", consumes = {"application/json"})
    public JobPost savePost(@RequestBody JobPost post){
        jobService.addJobPost(post);
        return post;
    }



    @GetMapping("post/{postId}")
    public JobPost findPost(@PathVariable("postId") int id){
        return jobService.getById(id);
    }



    @DeleteMapping("post/{id}")
    public void deletePost(@PathVariable int id){
        jobService.deleteJobPost(id);
    }



    @PutMapping("post")
    public void updatePost(@RequestBody JobPost jobPost){
        jobService.updateJobPost(jobPost);
    }




}

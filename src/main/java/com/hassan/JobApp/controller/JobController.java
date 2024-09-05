package com.hassan.JobApp.controller;



import java.util.List;


import com.hassan.JobApp.model.JobPost;
import com.hassan.JobApp.service.JobService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class JobController {

    @Autowired
    private JobService service;

    // ************************************************************************

    @RequestMapping({"/","/home"})
    public String home() {
        return "home";
    }

    // ************************************************************************

    @RequestMapping("/addjob")
    public String addJob() {
        return "addjob";
    }

    // ************************************************************************


    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {
        List<JobPost> jobPosts = service.returnAllJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }

    // ************************************************************************

    @PostMapping("/handleForm")
    public String handleAddJobForm(JobPost jobPost,Model model) {
        service.deleteJobPost(jobPost.getPostId());
        model.addAttribute("jobPost", jobPost);
        service.addJobPost(jobPost);
        return "success";
    }


    // ************************************************************************


    @RequestMapping("/deletePost")
    public String deletePost(@RequestParam("id") Integer id){
        service.deleteJobPost(id);
        return "redirect:/viewalljobs";
    }



    // ************************************************************************


    @RequestMapping("/updatePost")
    public String updatePost(int postId, Model model){
        model.addAttribute("jobPost", service.getById(postId));
        return "updatejob";
    }



}
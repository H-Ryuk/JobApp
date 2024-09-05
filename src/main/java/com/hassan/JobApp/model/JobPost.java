package com.hassan.JobApp.model;




import java.util.List;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {


    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostProfile() {
        return postProfile;
    }

    public void setPostProfile(String postProfile) {
        this.postProfile = postProfile;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public int getReqExperience() {
        return reqExperience;
    }

    public void setReqExperience(int reqExperience) {
        this.reqExperience = reqExperience;
    }

    public List<String> getPostTechStack() {
        return postTechStack;
    }

    public void setPostTechStack(List<String> postTechStack) {
        this.postTechStack = postTechStack;
    }
}
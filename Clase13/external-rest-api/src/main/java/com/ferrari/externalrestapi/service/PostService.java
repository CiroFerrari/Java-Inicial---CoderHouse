package com.ferrari.externalrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferrari.externalrestapi.externalApi.PostRestApi;

import java.util.HashMap;

@Service
public class PostService {
  @Autowired
  private PostRestApi postsRestApi;

  public HashMap<String, Object> createPost(HashMap<String, Object> postBody) {
    return postsRestApi.createPost(postBody);
  }

  public void updatePost(HashMap<String, Object> putBody, Integer postId) {
    postsRestApi.updatePost(putBody, postId);
  }
}

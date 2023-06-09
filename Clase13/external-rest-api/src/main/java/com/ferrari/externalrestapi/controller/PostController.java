package com.ferrari.externalrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ferrari.externalrestapi.service.PostService;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
  @Autowired
  private PostService postService;

  @PostMapping
  public ResponseEntity<HashMap<String, Object>> createPost(@RequestBody HashMap<String, Object> requestPost) {
    System.out.println(requestPost);
    return ResponseEntity.ok(postService.createPost(requestPost));
  }

  @PutMapping(path = "{postId}")
  public ResponseEntity<String> updatePost(
      @RequestBody HashMap<String, Object> requestPut,
      @PathVariable("postId") Integer id) {
    System.out.println(requestPut);
    postService.updatePost(requestPut, id);
    return ResponseEntity.ok("Updated successfully");
  }
}

package com.maxfromeverett.misto.controllers;

import com.maxfromeverett.misto.dtos.UniversalSearchRequest;
import com.maxfromeverett.misto.entities.SellPostEntity;
import com.maxfromeverett.misto.services.SellPostService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/")
public class SellPostController {

  private SellPostService service;

  public SellPostController(SellPostService service) {
    this.service = service;
  }

  @GetMapping("/sell-posts")
  public List<SellPostEntity> getAllSellPosts(){
    return service.findAll();
  }

  @GetMapping("/sell-posts/{id}")
  public  SellPostEntity getSellPostById(@PathVariable Long id) {
    return service.findById(id);
  }

  @PostMapping("/search")
  public List<SellPostEntity> universalSearch(@ModelAttribute UniversalSearchRequest searchRequest) {
    return service.search(searchRequest);
  }

}

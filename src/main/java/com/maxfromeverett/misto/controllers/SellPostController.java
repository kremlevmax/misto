package com.maxfromeverett.misto.controllers;

import com.maxfromeverett.misto.dtos.UniversalSearchRequest;
import com.maxfromeverett.misto.entities.SellPostEntity;
import com.maxfromeverett.misto.repository.SellPostRepository;
import com.maxfromeverett.misto.services.SellPostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/sell-posts")
public class SellPostController {

  private SellPostService service;

  public SellPostController(SellPostService service) {
    this.service = service;
  }

  @GetMapping("/all")
  public List<SellPostEntity> getAllSellPosts(){
    return service.findAll();
  }

  @PostMapping("/search")
  public List<SellPostEntity> universalSearch(@ModelAttribute UniversalSearchRequest searchRequest) {
    return service.search(searchRequest);
  }

}

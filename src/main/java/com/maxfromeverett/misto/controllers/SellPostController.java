package com.maxfromeverett.misto.controllers;

import com.maxfromeverett.misto.dtos.UniversalSearchRequest;
import com.maxfromeverett.misto.entities.SellPostEntity;
import com.maxfromeverett.misto.repository.SellPostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/sell-posts")
public class SellPostController {

  private SellPostRepository repository;

  public SellPostController(SellPostRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/all")
  public List<SellPostEntity> getAllSellPosts(){
    return repository.findAll();
  }

  @PostMapping("/search")
  public List<SellPostEntity> universalSearch(@ModelAttribute UniversalSearchRequest searchRequest) {
    return repository.search(searchRequest);
  }

}

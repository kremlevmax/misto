package com.maxfromeverett.misto.controllers;

import com.maxfromeverett.misto.dtos.UniversalSearchRequest;
import com.maxfromeverett.misto.entities.Post;
import com.maxfromeverett.misto.entities.SellPostEntity;
import com.maxfromeverett.misto.services.SellPostService;

import java.util.Optional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sell-posts")
public class SellPostController {

  private final SellPostService sellPostService;

  public SellPostController(SellPostService sellPostService) {
    this.sellPostService = sellPostService;
  }

  @GetMapping
  public List<SellPostEntity> getAllSellPosts() {
    return (List<SellPostEntity>) sellPostService.getAllPosts();
  }

  @GetMapping("/{id}")
  public Optional<SellPostEntity> getSellPostById(@PathVariable Long id) {
    return Optional.ofNullable(sellPostService.getPostById(id));
  }

  @PostMapping("/search")
  public List<SellPostEntity> universalSearch(@ModelAttribute UniversalSearchRequest searchRequest) {
    return sellPostService.search(searchRequest);
  }
}
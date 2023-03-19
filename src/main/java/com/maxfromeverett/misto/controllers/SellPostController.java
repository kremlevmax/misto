package com.maxfromeverett.misto.controllers;

import com.maxfromeverett.misto.dtos.UniversalSearchRequest;
import com.maxfromeverett.misto.entities.SellPostEntity;
import com.maxfromeverett.misto.services.SellPostService;

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
    return sellPostService.findAll();
  }

  @GetMapping("/{id}")
  public SellPostEntity getSellPostById(@PathVariable Long id) {
    return sellPostService.findById(id);
  }

  @PostMapping("/search")
  public List<SellPostEntity> universalSearch(@ModelAttribute UniversalSearchRequest searchRequest) {
    return sellPostService.search(searchRequest);
  }
}
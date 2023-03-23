package com.maxfromeverett.misto.controllers;

import com.maxfromeverett.misto.dtos.UniversalSearchRequest;
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
  public List<SellPostEntity> getAllSellPostsOptionallyFiltered(
      @RequestParam("search") Optional<String> searchRequest,
      @RequestParam("from") Optional<Long> fromOptional,
      @RequestParam("to") Optional<Long> toOptional) {
    return sellPostService.getAllPosts(searchRequest, fromOptional, toOptional);
  }

  @GetMapping("/{id}")
  public Optional<SellPostEntity> getSellPostById(@PathVariable Long id) {
    return Optional.ofNullable(sellPostService.getPostById(id));
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    sellPostService.deletePostById(id);
  }

  @GetMapping("/category/{goodType}")
  public List<SellPostEntity> openSellPostCategory(@PathVariable String goodType){
    return sellPostService.findByGoodType(goodType);
  }
}
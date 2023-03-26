package com.maxfromeverett.misto.controller;

import com.maxfromeverett.misto.entity.SellPost;
import com.maxfromeverett.misto.service.SellPostService;

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
  public List<SellPost> getAllSellPostsOptionallyFiltered(
      @RequestParam("search") Optional<String> searchRequest,
      @RequestParam("from") Optional<Long> fromOptional,
      @RequestParam("to") Optional<Long> toOptional) {
    return sellPostService.getAllPosts(searchRequest, fromOptional, toOptional);
  }

  @PostMapping
  public SellPost savePost(@ModelAttribute SellPost sellPost){
    return sellPostService.savePost(sellPost);
  }

  @GetMapping("/{id}")
  public Optional<SellPost> getSellPostById(@PathVariable Long id) {
    return Optional.ofNullable(sellPostService.getPostById(id));
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    sellPostService.deletePostById(id);
  }

  @GetMapping("/category/{goodType}")
  public List<SellPost> openSellPostCategory(@PathVariable String goodType){
    return sellPostService.findByGoodType(goodType);
  }
}
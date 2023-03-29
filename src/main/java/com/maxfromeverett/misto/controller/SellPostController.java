package com.maxfromeverett.misto.controller;

import com.maxfromeverett.misto.dto.SellPostDto;
import com.maxfromeverett.misto.entity.SellPost;
import com.maxfromeverett.misto.exceptions.NotEnoughInformationException;
import com.maxfromeverett.misto.service.SellPostService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/sell-posts")
public class SellPostController {

  private final SellPostService sellPostService;

  public SellPostController(SellPostService sellPostService) {
    this.sellPostService = sellPostService;
  }

  @GetMapping
  public List<SellPostDto> getAllSellPostsOptionallyFiltered(
      @RequestParam("search") Optional<String> searchRequest,
      @RequestParam("from") Optional<Long> fromOptional,
      @RequestParam("to") Optional<Long> toOptional) {
    return sellPostService.getAllPosts(searchRequest, fromOptional, toOptional)
        .stream()
        .map(SellPostDto::fromSellPost)
        .collect(Collectors.toList());
  }

  @PostMapping
  public SellPostDto savePost(@ModelAttribute SellPost sellPost){
      return SellPostDto.fromSellPost(sellPostService.savePost(sellPost));
  }

  @GetMapping("/{id}")
  public Optional<SellPostDto> getSellPostById(@PathVariable Long id) {
    return Optional.ofNullable(SellPostDto.fromSellPost(sellPostService.getPostById(id)));
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    sellPostService.deletePostById(id);
  }

  @GetMapping("/category/{goodType}")
  public List<SellPostDto> openSellPostCategory(@PathVariable String goodType){
    return sellPostService.findByGoodType(goodType)
        .stream()
        .map(SellPostDto::fromSellPost)
        .collect(Collectors.toList());
  }
}
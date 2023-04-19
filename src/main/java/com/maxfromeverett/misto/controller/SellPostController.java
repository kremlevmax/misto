package com.maxfromeverett.misto.controller;

import com.maxfromeverett.misto.dto.SellPostDto;
import com.maxfromeverett.misto.entity.SellPost;
import com.maxfromeverett.misto.exceptions.NotEnoughInformationForPostCreationException;
import com.maxfromeverett.misto.service.SellPostService;
import jakarta.validation.Valid;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/sell-posts", produces = "application/json")
//@CrossOrigin(origins = "http://localhost:8080/")
@AllArgsConstructor
public class SellPostController {

  private final SellPostService sellPostService;

  @GetMapping
  public List<SellPostDto> getAllSellPostsOptionallyFilteredByNamePriceAndGoodType(
      @RequestParam("search") Optional<String> searchRequest,
      @RequestParam("from") Optional<Long> fromOptional,
      @RequestParam("to") Optional<Long> toOptional,
      @RequestParam("goodType") Optional<String> goodType
      )
  {
    return sellPostService.getSellPosts(searchRequest, fromOptional, toOptional, goodType)
        .stream()
        .map(SellPostDto::fromSellPost)
        .collect(Collectors.toList());
  }

  @PostMapping
  public SellPostDto savePost(@Valid @RequestBody SellPost sellPost, BindingResult bindingResult){

    if (bindingResult.hasErrors()) {
      String errorMessage = "Error: " + bindingResult.getFieldError().getDefaultMessage();
      throw new NotEnoughInformationForPostCreationException(errorMessage);
    }

    return SellPostDto.fromSellPost(sellPostService.savePost(sellPost));
  }

  @GetMapping("/{id}")
  public SellPostDto getSellPostById(@PathVariable Long id) {
    return SellPostDto.fromSellPost(sellPostService.getPostById(id));
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    sellPostService.deleteSellPostById(id);
  }

  @PatchMapping("/{id}")
  public SellPostDto patchSellPostById(@PathVariable Long id, @Valid @RequestBody SellPost sellPost) {
    return SellPostDto.fromSellPost(sellPostService.patchSellPostById(id, sellPost));
  }
}
package com.maxfromeverett.misto.controller;

import com.maxfromeverett.misto.dto.SellPostDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/images")
public class ImageController {
  @GetMapping("/{id}")
  public ResponseEntity<SellPostDto> getSellPostById(@PathVariable Long id) {
    return new ResponseEntity<SellPostDto>(SellPostDto.fromSellPost(sellPostService.getPostById(id)),
        HttpStatus.OK);
  }
}

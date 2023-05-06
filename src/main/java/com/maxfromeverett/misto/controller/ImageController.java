package com.maxfromeverett.misto.controller;

import com.maxfromeverett.misto.dto.ImageDto;
import com.maxfromeverett.misto.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

  private ImageService imageService;
  @GetMapping("/{id}")
  public ResponseEntity<ImageDto> getSellPostById(@PathVariable Long id) {
    return new ResponseEntity<ImageDto>(ImageDto.fromImage(ImageService.getImageById(id)),
        HttpStatus.OK);
  }
}

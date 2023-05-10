package com.maxfromeverett.misto.controller;

import com.maxfromeverett.misto.dto.ImageDto;
import com.maxfromeverett.misto.service.ImageService;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/images")
public class ImageController {

  private ImageService service;

  @GetMapping("/{id}")
  public ResponseEntity<ImageDto> getSellPostById(@PathVariable Long id) {
    return new ResponseEntity<ImageDto>(ImageDto.fromImage(service.getImageById(id)),
        HttpStatus.OK);
  }

  @PostMapping("/upload")
  public ResponseEntity<?> uploadImage(@RequestParam("post_id") Integer post_id, @RequestParam("files") MultipartFile[] files)
      throws IOException {

    service.saveFiles(post_id, files);
    return ResponseEntity.ok().build();
  }
}

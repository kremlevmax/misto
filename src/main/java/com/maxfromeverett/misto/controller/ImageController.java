package com.maxfromeverett.misto.controller;

import com.maxfromeverett.misto.dto.ImageDto;
import com.maxfromeverett.misto.entity.Image;
import com.maxfromeverett.misto.repository.ImageRepository;
import com.maxfromeverett.misto.service.ImageService;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

  private ImageRepository service;

  @GetMapping("/{id}")
  public ResponseEntity<ImageDto> getSellPostById(@PathVariable Long id) {
    return new ResponseEntity<ImageDto>(ImageDto.fromImage(ImageService.getImageById(id)),
        HttpStatus.OK);
  }

  @PostMapping("/upload")
  public ResponseEntity<?> uploadImage(@RequestParam("post_id") Integer post_id, @RequestParam("files") MultipartFile[] files)
      throws IOException {
    System.out.println(file.getSize());
    Image image = new Image();
    image.setBody(file.getBytes());
    image.setPost_id(post_id);
    service.save(image);

    return ResponseEntity.ok().build();
  }
}

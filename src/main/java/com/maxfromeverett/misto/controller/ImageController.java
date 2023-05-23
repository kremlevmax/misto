package com.maxfromeverett.misto.controller;

import com.maxfromeverett.misto.dto.ImageDto;
import com.maxfromeverett.misto.entity.Image;
import com.maxfromeverett.misto.repository.ImageRepository;
import com.maxfromeverett.misto.service.ImageService;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
  private ImageRepository repository;

  @GetMapping("/{id}")
  public ResponseEntity<ImageDto> getSellPostById(@PathVariable Long id) {
    return new ResponseEntity<ImageDto>(ImageDto.fromImage(service.getImageById(id)),
        HttpStatus.OK);
  }

  @PostMapping("/upload")
  public ResponseEntity<?> uploadImage(@RequestParam("post_id") Integer post_id, @RequestParam("files") MultipartFile[] files)
      throws IOException {
    return service.saveFiles(post_id, files);
  }

  @GetMapping("/get-image-ids")
  public ResponseEntity<?> getImageIds(@RequestParam("post_id") Integer post_id) {
    return new ResponseEntity<>(repository.getImageIdList(post_id), HttpStatus.OK);
  }

  @GetMapping("/get-image-body")
  public ResponseEntity<?> getImageBody(@RequestParam("id") Integer id) {
    Image image = repository.findById(id).get();
    return ResponseEntity.ok()
        .contentType(MediaType.IMAGE_PNG)
        .contentLength(image.getBody().length)
        .body(new ByteArrayResource(image.getBody()));
  }
}

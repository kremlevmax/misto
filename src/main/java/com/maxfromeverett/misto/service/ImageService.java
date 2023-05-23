package com.maxfromeverett.misto.service;

import com.maxfromeverett.misto.entity.Image;
import com.maxfromeverett.misto.repository.ImageRepository;
import java.io.IOException;
import java.util.Arrays;
import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@AllArgsConstructor
public class ImageService {

  private final ImageRepository repository;
  public Image getImageById(Long id) {
    return null;
  }

  public ResponseEntity<?> saveFiles(Integer post_id, MultipartFile[] files) throws IOException {
    for (MultipartFile file : files) {

      if(!Arrays.asList(
          "image/png", "image/jpg", "image/jpeg").contains(file.getContentType())) {
        throw new IllegalStateException("File must be an jpg or png");
      }

      Image image = new Image();
      image.setBody(file.getBytes());
      image.setPost_id(post_id);
      repository.save(image);
    }
    return ResponseEntity.ok().build();
  }
}

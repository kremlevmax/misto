package com.maxfromeverett.misto.service;

import com.maxfromeverett.misto.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

  private final ImageRepository repository;

  public ImageService(ImageRepository repository) {
    this.repository = repository;
  }


}

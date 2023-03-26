package com.maxfromeverett.misto.service;

import com.maxfromeverett.misto.entity.RentOutPost;
import com.maxfromeverett.misto.repository.RentOutPostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class RentOutPostService {
  private final RentOutPostRepository repository;

  public RentOutPostService(RentOutPostRepository repository) {
    this.repository = repository;
  }

  public RentOutPost save(RentOutPost rentOutPost){
    return null;
  }

  @PostConstruct
  void initDatabase() {

  }
}
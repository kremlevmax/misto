package com.maxfromeverett.misto.services;

import com.maxfromeverett.misto.dtos.UniversalSearchRequest;
import com.maxfromeverett.misto.entities.SellPostEntity;
import com.maxfromeverett.misto.enums.GoodType;
import com.maxfromeverett.misto.repository.SellPostRepository;
import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SellPostService {

  private SellPostRepository repository;

  public SellPostService(SellPostRepository repository) {
    this.repository = repository;
  }

  public List<SellPostEntity> findAll() {
    return repository.findAll();
  }

  public List<SellPostEntity> search(UniversalSearchRequest searchRequest) {
    SellPostEntity probe = new SellPostEntity();

    if (StringUtils.hasText(searchRequest.value())) {
      probe.setTitle(searchRequest.value());
      probe.setDescription(searchRequest.value());
    }
    Example<SellPostEntity> example = Example.of(probe, ExampleMatcher.matchingAny()
        .withIgnoreCase()
        .withStringMatcher(StringMatcher.CONTAINING));
    return repository.findAll(example);
  }

  public SellPostEntity findById(Long id) {
    return repository.findById(id).get();
  }

  @PostConstruct
  void initDatabase() {
    System.out.println("Initalized");
    repository.save(new SellPostEntity("Toyota Corolla", "Brand new", (String[]) null, "Max", "4123",
        Long.valueOf("1231"), "Everett",
        LocalDateTime.now(), true, GoodType.CARS, Long.valueOf("5000")));
  }
}

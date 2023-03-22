package com.maxfromeverett.misto.services;

import com.maxfromeverett.misto.dtos.UniversalSearchRequest;
import com.maxfromeverett.misto.entities.Post;
import com.maxfromeverett.misto.entities.SellPostEntity;
import com.maxfromeverett.misto.enums.GoodType;
import com.maxfromeverett.misto.repository.SellPostRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SellPostService {

  private final SellPostRepository repository;

  public SellPostService(SellPostRepository repository) {
    this.repository = repository;
  }

  public List<SellPostEntity> getAllPosts(Long from, Long to) {
    if (from.equals(null) && to.equals(null)) {
      return repository.findAll();
    } else if (to.equals(null)) {
      return repository.findByPriceGreaterThanEqual(from);
    }
    return repository.findAll();
  }

  public SellPostEntity getPostById(Long id) {
    return  repository.findById(id).get();
  }

  public Post savePost(SellPostEntity SellPostEntity) {
    return repository.save(SellPostEntity);
  }

  public void deletePostById(Long id) {
    repository.deleteById(id);
  }

  public List<SellPostEntity> search(UniversalSearchRequest searchRequest) {
    SellPostEntity probe = new SellPostEntity();

    if (StringUtils.hasText(searchRequest.getValue())) {
      probe.setTitle(searchRequest.getValue());
      probe.setDescription(searchRequest.getValue());
    }

    ExampleMatcher matcher = ExampleMatcher.matchingAny()
        .withStringMatcher(StringMatcher.CONTAINING)
        .withIgnoreCase();

    Example<SellPostEntity> example = Example.of(probe, matcher);
    return repository.findAll(example);
  }

  public List<SellPostEntity> findByGoodType(String goodTypeString) {
    GoodType goodType = GoodType.valueOf(goodTypeString.toUpperCase());
    return repository.findByGoodType(goodType);
  }

  @PostConstruct
  void initDatabase() {
    repository.save(SellPostEntity.builder()
        .title("Bicycle")
        .description("New")
        .price(Long.valueOf(12321))
        .goodType(GoodType.BIKES)
        .build());

    repository.save(SellPostEntity.builder()
        .title("boat")
        .description("old")
        .price(Long.valueOf(12321))
        .goodType(GoodType.BOATS)
        .build());

    repository.save(SellPostEntity.builder()
        .title("Телевизор")
        .description("Большой")
        .price(Long.valueOf(12321))
        .goodType(GoodType.ELECTRONICS)
        .build());
  }
}

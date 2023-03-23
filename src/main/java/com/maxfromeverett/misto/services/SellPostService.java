package com.maxfromeverett.misto.services;

import com.maxfromeverett.misto.entities.Post;
import com.maxfromeverett.misto.entities.SellPostEntity;
import com.maxfromeverett.misto.enums.GoodType;
import com.maxfromeverett.misto.repository.SellPostRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SellPostService {

  private final SellPostRepository repository;

  public SellPostService(SellPostRepository repository) {
    this.repository = repository;
  }

  public List<SellPostEntity> getAllPosts(
      Optional<String> searchRequestOptional,
      Optional<Long> fromOptional,
      Optional<Long> toOptional
  ) {
    String searchRequest = searchRequestOptional.orElse("%");
    Long from = fromOptional.orElse(repository.getMinPrice());
    Long to = toOptional.orElse(repository.getMaxPrice());

    if (!searchRequest.equals("%")) {
      searchRequest = "%".concat(searchRequest).concat("%");
    }

    return repository.findBySearchQueryStringBetweenPriceMargins(searchRequest, from, to);
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

  public List<SellPostEntity> findByGoodType(String goodTypeString) {
    GoodType goodType = GoodType.valueOf(goodTypeString.toUpperCase());
    return repository.findByGoodType(goodType);
  }

  @PostConstruct
  void initDatabase() {
    repository.save(SellPostEntity.builder()
        .title("Bicycle")
        .description("New")
        .price(Long.valueOf(100))
        .goodType(GoodType.BIKES)
        .build());

    repository.save(SellPostEntity.builder()
        .title("boat")
        .description("old")
        .price(Long.valueOf(300))
        .goodType(GoodType.BOATS)
        .build());

    repository.save(SellPostEntity.builder()
        .title("Телевизор")
        .description("Большой")
        .price(Long.valueOf(500))
        .goodType(GoodType.ELECTRONICS)
        .build());
  }
}

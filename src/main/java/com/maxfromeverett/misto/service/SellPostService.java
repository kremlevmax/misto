package com.maxfromeverett.misto.service;

import com.maxfromeverett.misto.entity.SellPost;
import com.maxfromeverett.misto.entity.enums.GoodType;
import com.maxfromeverett.misto.exceptions.NotEnoughInformationForPostCreationException;
import com.maxfromeverett.misto.exceptions.PostNotFoundException;
import com.maxfromeverett.misto.repository.SellPostRepository;
import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
@Transactional
public class SellPostService {

  private final SellPostRepository repository;

  public SellPostService(SellPostRepository repository) {
    this.repository = repository;
  }

  public List<SellPost> getAllPosts(
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

  public SellPost getPostById(Long id) {
    Optional<SellPost> sellPost = repository.findById(id);

    if (!sellPost.isPresent()) {
      throw new PostNotFoundException(
          "Error: Post with id " + id + " doesn't exist or was deleted");
    }
    return  sellPost.get();
  }

  public SellPost savePost(SellPost sellPost, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      String errorMessage = "Error: " + bindingResult.getFieldError().getDefaultMessage();
      throw new NotEnoughInformationForPostCreationException(errorMessage);
    }

    return repository.save(SellPost.builder()
        .title(sellPost.getTitle())
        .description(sellPost.getDescription())
        .images(sellPost.getImages())
        .author(sellPost.getAuthor())
        .phoneNumber(sellPost.getPhoneNumber())
        .zipCode(sellPost.getZipCode())
        .town(sellPost.getTown())
        .postDateTime(LocalDateTime.now())
        .goodType(sellPost.getGoodType())
        .isActive(true)
        .price(sellPost.getPrice())
        .build());
  }

  public void deletePostById(Long id) {
    repository.deleteById(id);
  }

  public List<SellPost> findByGoodType(String goodTypeString) {
    GoodType goodType = GoodType.valueOf(goodTypeString.toUpperCase());
    return repository.findByGoodType(goodType);
  }

  @PostConstruct
  void initDatabase() {
    repository.save(SellPost.builder()
        .title("Bicycle")
        .description("New")
        .price(Long.valueOf(100))
        .goodType(GoodType.BIKES)
        .zipCode(Long.valueOf(12345))
        .build());

    repository.save(SellPost.builder()
        .title("boat")
        .description("old")
        .price(Long.valueOf(300))
        .goodType(GoodType.BOATS)
        .zipCode(Long.valueOf(12345))
        .build());

    repository.save(SellPost.builder()
        .title("Телевизор")
        .description("Большой")
        .price(Long.valueOf(500))
        .goodType(GoodType.ELECTRONICS)
        .zipCode(Long.valueOf(12345))
        .build());
  }
}

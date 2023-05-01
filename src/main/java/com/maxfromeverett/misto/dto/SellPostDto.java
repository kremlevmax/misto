package com.maxfromeverett.misto.dto;

import com.maxfromeverett.misto.entity.SellPost;
import com.maxfromeverett.misto.entity.enums.GoodType;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class SellPostDto extends PostDto {
  private GoodType goodType;
  private Long price;

  public GoodType getGoodType() {
    return goodType;
  }

  public void setGoodType(GoodType goodType) {
    this.goodType = goodType;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public SellPostDto(
      Long id, String title, String description,
      List<String> images, String author, String phoneNumber,
      Long zipCode, String town, LocalDateTime postDateTime,
      Boolean isActive, GoodType goodType, Long price) {
    super(id, title, description, images, author, phoneNumber, zipCode, town, postDateTime,
        isActive);
    this.goodType = goodType;
    this.price = price;
  }

  public static SellPostDto fromSellPost(SellPost sellPost){
    return new SellPostDto(
        sellPost.getId(),
        sellPost.getTitle(),
        sellPost.getDescription(),
        sellPost.getImages(),
        sellPost.getAuthor(),
        sellPost.getPhoneNumber(),
        sellPost.getZipCode(),
        sellPost.getTitle(),
        sellPost.getPostDateTime(),
        sellPost.getIsActive(),
        sellPost.getGoodType(),
        sellPost.getPrice()
    );
  }

  public SellPost toProduct() {
    return SellPost.builder()
        .title(this.getTitle())
        .description(this.getDescription())
        .images(this.getImages())
        .author(this.getAuthor())
        .phoneNumber(this.getPhoneNumber())
        .zipCode(this.getZipCode())
        .title(this.getTitle())
        .postDateTime(this.getPostDateTime())
        .isActive(this.getIsActive())
        .goodType(this.getGoodType())
        .price(this.getPrice())
        .build();
  }
}

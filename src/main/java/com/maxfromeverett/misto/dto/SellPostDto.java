package com.maxfromeverett.misto.dto;

import com.maxfromeverett.misto.entity.SellPost;
import com.maxfromeverett.misto.entity.enums.GoodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class SellPostDto extends PostDto {
  private GoodType goodType;
  private Long price;

  public static SellPostDto fromSellPost(SellPost sellPost){
    return SellPostDto.builder()
        .id(sellPost.getId())
        .title(sellPost.getTitle())
        .description(sellPost.getDescription())
        .author(sellPost.getAuthor())
        .phoneNumber(sellPost.getPhoneNumber())
        .zipCode(sellPost.getZipCode())
        .postDateTime(sellPost.getPostDateTime())
        .isActive(sellPost.getIsActive())
        .goodType(sellPost.getGoodType())
        .price(sellPost.getPrice())
        .build();
  }

  public SellPost toProduct() {
    return SellPost.builder()
        .title(this.getTitle())
        .description(this.getDescription())
//        .images(this.getImages())
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

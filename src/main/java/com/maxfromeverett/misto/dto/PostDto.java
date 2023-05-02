package com.maxfromeverett.misto.dto;

import com.maxfromeverett.misto.entity.Post;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PostDto {
  private Long id;
  private String title;
  private String description;
//  private List<String> images;
  private String author;
  private String phoneNumber;
  private Long zipCode;
  private String town;
  private LocalDateTime postDateTime;
  private Boolean isActive;


  public static PostDto fromPost(Post post){
    return new PostDto(
        post.getId(),
        post.getTitle(),
        post.getDescription(),
        post.getAuthor(),
        post.getPhoneNumber(),
        post.getZipCode(),
        post.getTitle(),
        post.getPostDateTime(),
        post.getIsActive());
  }
}

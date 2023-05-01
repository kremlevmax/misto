package com.maxfromeverett.misto.dto;

import com.maxfromeverett.misto.entity.Post;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class PostDto {
  private Long id;
  private String title;
  private String description;
  private List<String> images;
  private String author;
  private String phoneNumber;
  private Long zipCode;
  private String town;
  private LocalDateTime postDateTime;
  private Boolean isActive;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Long getZipCode() {
    return zipCode;
  }

  public void setZipCode(Long zipCode) {
    this.zipCode = zipCode;
  }

  public String getTown() {
    return town;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public LocalDateTime getPostDateTime() {
    return postDateTime;
  }

  public void setPostDateTime(LocalDateTime postDateTime) {
    this.postDateTime = postDateTime;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public PostDto(Long id, String title, String description, List<String> images, String author,
      String phoneNumber, Long zipCode, String town, LocalDateTime postDateTime, Boolean isActive) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.images = images;
    this.author = author;
    this.phoneNumber = phoneNumber;
    this.zipCode = zipCode;
    this.town = town;
    this.postDateTime = postDateTime;
    this.isActive = isActive;
  }

  public static PostDto fromPost(Post post){
    return new PostDto(
        post.getId(),
        post.getTitle(),
        post.getDescription(),
        post.getImages(),
        post.getAuthor(),
        post.getPhoneNumber(),
        post.getZipCode(),
        post.getTitle(),
        post.getPostDateTime(),
        post.getIsActive());
  }
}

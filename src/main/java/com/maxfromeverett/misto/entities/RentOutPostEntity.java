package com.maxfromeverett.misto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class RentOutPostEntity {

  private @Id @GeneratedValue Long id;
  private String title;
  private String description;
  private String[] photoFileNames;
  private String author;
  private String phoneNumber;
  private Long zipCode;
  private String town;
  private LocalDateTime postDateTime;
  private Boolean isActive;

  //Additional
  private Long bedroomNumber;
  private Long bathroomNumber;
  private Long totalArea;
  private Long price;

  public RentOutPostEntity() {
  }

  public RentOutPostEntity(Long id, String title, String description, String[] photoFileNames,
      String author, String phoneNumber, Long zipCode, String town, LocalDateTime postDateTime,
      Boolean isActive, Long bedroomNumber, Long bathroomNumber, Long totalArea, Long price) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.photoFileNames = photoFileNames;
    this.author = author;
    this.phoneNumber = phoneNumber;
    this.zipCode = zipCode;
    this.town = town;
    this.postDateTime = postDateTime;
    this.isActive = isActive;
    this.bedroomNumber = bedroomNumber;
    this.bathroomNumber = bathroomNumber;
    this.totalArea = totalArea;
    this.price = price;
  }

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

  public String[] getPhotoFileNames() {
    return photoFileNames;
  }

  public void setPhotoFileNames(String[] photoFileNames) {
    this.photoFileNames = photoFileNames;
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

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public Long getBedroomNumber() {
    return bedroomNumber;
  }

  public void setBedroomNumber(Long bedroomNumber) {
    this.bedroomNumber = bedroomNumber;
  }

  public Long getBathroomNumber() {
    return bathroomNumber;
  }

  public void setBathroomNumber(Long bathroomNumber) {
    this.bathroomNumber = bathroomNumber;
  }

  public Long getTotalArea() {
    return totalArea;
  }

  public void setTotalArea(Long totalArea) {
    this.totalArea = totalArea;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }
}

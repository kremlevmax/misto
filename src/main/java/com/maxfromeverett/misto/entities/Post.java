package com.maxfromeverett.misto.entities;

import com.maxfromeverett.misto.enums.BusinessType;
import com.maxfromeverett.misto.enums.GoodType;
import java.time.LocalDateTime;

public class Post{
  private Long id;

  private BusinessType businessType;
  private GoodType goodType;

  private String title;
  private String description;
  private String[] photoFileNames;
  private long price;
  private String author;
  private String phoneNumber;
  private Long zipCode;
  private String town;
  private LocalDateTime postDateTime;
  private Boolean isActive;

  //Additional
  //Event Post
  private String eventPlace;
  private LocalDateTime evenDateTime;

  //Job Post
  private String wage;

  //Rent-Out Post
  private Long bedroomNumber;
  private Long bathroomNumber;
  private Long totalArea;


  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public BusinessType getBusinessType() {
    return businessType;
  }
  public void setBusinessType(BusinessType businessType) {
    this.businessType = businessType;
  }
  public GoodType getGoodType() {
    return goodType;
  }
  public void setGoodType(GoodType goodType) {
    this.goodType = goodType;
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
  public long getPrice() {
    return price;
  }
  public void setPrice(long price) {
    this.price = price;
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
  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }
  public String getEventPlace() {
    return eventPlace;
  }
  public void setEventPlace(String eventPlace) {
    this.eventPlace = eventPlace;
  }
  public LocalDateTime getEvenDateTime() {
    return evenDateTime;
  }
  public void setEvenDateTime(LocalDateTime evenDateTime) {
    this.evenDateTime = evenDateTime;
  }
  public String getWage() {
    return wage;
  }
  public void setWage(String wage) {
    this.wage = wage;
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

  public Post(Long id, BusinessType businessType, GoodType goodType, String title, String description, String[] photoFileNames, long price, String author, String phoneNumber, Long zipCode, String town, LocalDateTime postDateTime, Boolean isActive,
      String eventPlace, LocalDateTime evenDateTime, String wage, Long bedroomNumber, Long bathroomNumber, Long totalArea) {
    super();
    this.id = id;
    this.businessType = businessType;
    this.goodType = goodType;
    this.title = title;
    this.description = description;
    this.photoFileNames = photoFileNames;
    this.price = price;
    this.author = author;
    this.phoneNumber = phoneNumber;
    this.zipCode = zipCode;
    this.town = town;
    this.postDateTime = postDateTime;
    this.isActive = isActive;
    this.eventPlace = eventPlace;
    this.evenDateTime = evenDateTime;
    this.wage = wage;
    this.bedroomNumber = bedroomNumber;
    this.bathroomNumber = bathroomNumber;
    this.totalArea = totalArea;
  }
}
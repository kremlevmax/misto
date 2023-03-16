package com.maxfromeverett.misto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class EventPostEntity {

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
  private String eventLocation;
  private LocalDateTime evenDateTime;

  public EventPostEntity() {
  }

  public EventPostEntity(Long id, String title, String description, String[] photoFileNames,
      String author,
      String phoneNumber, Long zipCode, String town, LocalDateTime postDateTime, Boolean isActive,
      String eventLocation, LocalDateTime evenDateTime) {
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
    this.eventLocation = eventLocation;
    this.evenDateTime = evenDateTime;
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

  public String getEventLocation() {
    return eventLocation;
  }

  public void setEventLocation(String eventLocation) {
    this.eventLocation = eventLocation;
  }

  public LocalDateTime getEvenDateTime() {
    return evenDateTime;
  }

  public void setEvenDateTime(LocalDateTime evenDateTime) {
    this.evenDateTime = evenDateTime;
  }
}

package com.maxfromeverett.misto.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
//@MappedSuperclass
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String description;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Image> images;

  private String author;
  private String phoneNumber;
  private Long zipCode;
  private String town;
  private LocalDateTime postDateTime;
  private Boolean isActive;


}

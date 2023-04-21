package com.maxfromeverett.misto.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor( force=true)
@SuperBuilder(toBuilder = true)
@MappedSuperclass
public abstract class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Title has to be provided for creating a post")
  private String title;

  @NotBlank(message = "Description has to be provided for creating a post")
  private String description;

  private List<MultipartFile> images;

  private String author;
  private String phoneNumber;

  @NotNull(message = "Zip has to be provided for creating a post")
  private Long zipCode;
  private String town;
  private LocalDateTime postDateTime;
  private Boolean isActive;
}

package com.maxfromeverett.misto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "rent_posts")
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@SuperBuilder(toBuilder = true)
public class RentOutPost extends Post {

  private Long bedroomNumber;
  private Long bathroomNumber;
  private Long totalArea;
  private Long price;
}

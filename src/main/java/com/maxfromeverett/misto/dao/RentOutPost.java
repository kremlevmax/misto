package com.maxfromeverett.misto.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "rent_posts")
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class RentOutPost extends Post {

  private Long bedroomNumber;
  private Long bathroomNumber;
  private Long totalArea;
  private Long price;
}

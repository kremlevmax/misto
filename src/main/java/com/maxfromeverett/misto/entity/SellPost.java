package com.maxfromeverett.misto.entity;

import com.maxfromeverett.misto.entity.enums.GoodType;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "sell_posts")
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@SuperBuilder(toBuilder = true)
public class SellPost extends Post {
  @NotNull(message = "GoodType has to be provided for creating a SellPost")
  private GoodType goodType;
  @NotNull(message = "Price has to be provided for creating a SellPost")
  private Long price;
}
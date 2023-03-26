package com.maxfromeverett.misto.dao;

import com.maxfromeverett.misto.enums.GoodType;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "sell_posts")
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class SellPost extends Post {
  private GoodType goodType;
  private Long price;
}
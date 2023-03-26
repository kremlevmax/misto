package com.maxfromeverett.misto.entity;

import com.maxfromeverett.misto.entity.enums.BusinessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "business_posts")
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class BusinessPost extends Post {
  private BusinessType businessType;
}

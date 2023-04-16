package com.maxfromeverett.misto.entity;

import com.maxfromeverett.misto.entity.enums.BusinessType;
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
@Table(name = "job_posts")
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@SuperBuilder(toBuilder = true)
public class JobPost extends Post {
  private BusinessType businessType;
  private String wage;
  private String schedule;
}

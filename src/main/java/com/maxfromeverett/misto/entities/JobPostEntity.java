package com.maxfromeverett.misto.entities;

import com.maxfromeverett.misto.enums.BusinessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "job_posts")
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class JobPostEntity extends Post {
  private BusinessType businessType;
  private String wage;
  private String schedule;
}

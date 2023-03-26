package com.maxfromeverett.misto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "event_posts")
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class EventPost extends Post {
  private String eventLocation;
  private LocalDateTime evenDateTime;
}

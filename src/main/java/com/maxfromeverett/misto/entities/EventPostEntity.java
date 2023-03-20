package com.maxfromeverett.misto.entities;

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
@Table(name = "event_posts")
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class EventPostEntity {
  private String eventLocation;
  private LocalDateTime evenDateTime;
}

package com.maxfromeverett.misto.repository;

import com.maxfromeverett.misto.entities.EventPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPostRepository extends JpaRepository<EventPostEntity, Long> {
}

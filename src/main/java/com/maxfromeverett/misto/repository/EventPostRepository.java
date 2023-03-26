package com.maxfromeverett.misto.repository;

import com.maxfromeverett.misto.entity.EventPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPostRepository extends JpaRepository<EventPost, Long> {
}

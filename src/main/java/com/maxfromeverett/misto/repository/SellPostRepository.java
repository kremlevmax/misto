package com.maxfromeverett.misto.repository;

import com.maxfromeverett.misto.dtos.UniversalSearchRequest;
import com.maxfromeverett.misto.entities.SellPostEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellPostRepository extends JpaRepository<SellPostEntity, Long> {

}

package com.maxfromeverett.misto.repository;

import com.maxfromeverett.misto.entities.Post;
import com.maxfromeverett.misto.entities.SellPostEntity;
import com.maxfromeverett.misto.enums.GoodType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellPostRepository extends JpaRepository<SellPostEntity, Long> {
  List<SellPostEntity> findByGoodType(GoodType goodType);

  List<SellPostEntity> findByPriceGreaterThanEqual(Long from);
}

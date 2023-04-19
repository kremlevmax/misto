package com.maxfromeverett.misto.repository;

import com.maxfromeverett.misto.entity.SellPost;
import com.maxfromeverett.misto.entity.enums.GoodType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellPostRepository extends JpaRepository<SellPost, Long> {
  List<SellPost> findByGoodType(GoodType goodType);

  @Query("SELECT sp FROM SellPost sp WHERE (sp.title ILIKE ?1 OR sp.description ILIKE ?1) AND (sp.price >= ?2 AND sp.price <= ?3)")
  List<SellPost> findBySearchQueryStringBetweenPriceMargins(String searchQuery, Long from, Long to);

  @Query("SELECT sp FROM SellPost sp WHERE (sp.title ILIKE ?1 OR sp.description ILIKE ?1) AND (sp.price >= ?2 AND sp.price <= ?3) AND sp.goodType = ?4")
  List<SellPost> findBySearchQueryStringBetweenPriceMarginsByGoodType(String searchRequest, Long from, Long to, GoodType goodType);

  @Query("SELECT MAX(sp.price) FROM SellPost sp")
  Long getMaxPrice();

  @Query("SELECT MIN(sp.price) FROM SellPost sp")
  Long getMinPrice();

}

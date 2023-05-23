package com.maxfromeverett.misto.repository;

import com.maxfromeverett.misto.entity.Image;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image, Integer> {
  @Query("SELECT t.id FROM Image t WHERE t.post_id = :post_id")
  public List<Integer> getImageIdList(@Param("post_id") Integer post_id);
}

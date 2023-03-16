package com.maxfromeverett.misto.repository;

import com.maxfromeverett.misto.entities.BusinessPostEntity;
import com.maxfromeverett.misto.enums.BusinessType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessPostRepository extends JpaRepository<BusinessPostEntity, Long> {
  List<BusinessPostEntity> findByBusinessType (BusinessType businessType);
}

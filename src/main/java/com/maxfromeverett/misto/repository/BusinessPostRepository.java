package com.maxfromeverett.misto.repository;

import com.maxfromeverett.misto.dao.BusinessPost;
import com.maxfromeverett.misto.enums.BusinessType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessPostRepository extends JpaRepository<BusinessPost, Long> {
  List<BusinessPost> findByBusinessType (BusinessType businessType);
}

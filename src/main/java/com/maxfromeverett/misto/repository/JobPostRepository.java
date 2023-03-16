package com.maxfromeverett.misto.repository;

import com.maxfromeverett.misto.entities.JobPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPostEntity, Long> {

}

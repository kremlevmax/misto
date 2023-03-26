package com.maxfromeverett.misto.repository;

import com.maxfromeverett.misto.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {

}

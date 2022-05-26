package com.demo.jobsearchproject.repository;

import com.demo.jobsearchproject.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
    @Transactional
    @Query(value = "select distinct * from job join job_skill on job.id=job_skill.job_id join skill on skill.id=job_skill.skill_id where job.location like %:keyword% or skill.skills like %:keyword%  ", nativeQuery = true)
    List<Job> findByKeyword(@Param("keyword") String keyword);
    @Transactional
    List<Job> findByLocation(String location);
    @Transactional
    @Query(value = "select distinct * from job join job_skill on job.id=job_skill.job_id join skill on skill.id=job_skill.skill_id where skill.skills like %:keyword%  ", nativeQuery = true)
    List<Job> findBySkill(@Param("keyword") String keyword);
}

package com.verinite.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.verinite.bookstore.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    @Query(value="select * from tbl_feedback where is_deleted=false",nativeQuery = true)
    List<Feedback> find();
}
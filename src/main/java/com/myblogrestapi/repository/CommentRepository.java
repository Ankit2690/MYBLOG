package com.myblogrestapi.repository;

import com.myblogrestapi.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByPostId(long postId);//Custom method to get the records as per your choice of column.
}

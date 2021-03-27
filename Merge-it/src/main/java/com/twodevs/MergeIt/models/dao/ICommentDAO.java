package com.twodevs.MergeIt.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twodevs.MergeIt.models.entities.Comment;

@Repository
public interface ICommentDAO extends JpaRepository<Comment, Integer> {

}
package com.twodevs.MergeIt.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twodevs.MergeIt.models.entities.Users;

@Repository
public interface IUsersDAO extends JpaRepository<Users, Integer>{

}
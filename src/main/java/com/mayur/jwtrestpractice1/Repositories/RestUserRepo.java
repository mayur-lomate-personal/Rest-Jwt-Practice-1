package com.mayur.jwtrestpractice1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayur.jwtrestpractice1.Entities.RestUser;

@Repository
public interface RestUserRepo extends JpaRepository<RestUser, String>{

}

package com.siva.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siva.crud.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	//Custom finder methods/Derived query methods
	public List<UserEntity> findByLastname(String lastname);
	public String deleteByEm(String em);
}

package com.sakha.unittest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sakha.model.UserEntity;

//https://www.concretepage.com/spring-boot/spring-boot-crudrepository-example

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	
	UserEntity findById(Integer id);
	
	UserEntity findByName(String name);
	
	UserEntity findByMobile(String mobile);
	
	 List<UserEntity> findAll();


}

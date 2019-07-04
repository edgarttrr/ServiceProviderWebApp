package com.test.app.aws;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.app.aws.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	UserEntity findByEmail(String email);

}

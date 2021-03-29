package com.zensar.repository;

import com.zensar.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends MongoRepository<User,Integer> {

}

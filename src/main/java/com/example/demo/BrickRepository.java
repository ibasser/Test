package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BrickRepository extends MongoRepository<Bricks, Long> {
	
	List<Bricks> findById(long id);

			
}

package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrickRepository extends MongoRepository<Bricks, String> {}

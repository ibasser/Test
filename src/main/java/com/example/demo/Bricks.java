package com.example.demo;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bricks {

	//variables for bricks class
    private String numBricks;
    private String orderNum = UUID.randomUUID().toString();
    private long id;
	
    //constructor
    public Bricks() {
   
    }
    
    
    //set Id when creating order
    public void setId(final long id) {
		this.id = id;
	}
    
    //returns Id when when creating order
    public long getId() {
		return id;
	}

    //sets 'numBricks' variable by calling this method
    //used to create order
    public void setBricks(String numBricks){
    	this.numBricks = numBricks;
    }
  
    //unique order reference which is returned in create order
    public String getOrderNum() {
        return orderNum;
    }
    
    //retrieves 'numBricks' variable which is set in the method above
    public String getnumBricks() {
        return numBricks;
    }
}

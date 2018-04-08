package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brick")
public class BricksController {
	
	private final AtomicLong counter = new AtomicLong();
	
	//post method to create order of number of bricks
	//returns a unique reference
    @RequestMapping(method=RequestMethod.POST)
    public long createOrder(@RequestBody Bricks b) {

    	b.setId(counter.incrementAndGet());
    	 return b.getId();
                           
    }
}
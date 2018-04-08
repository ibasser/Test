package com.example.demo;

import java.util.ArrayList;
import java.util.List;
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
	
	private BrickRepository brickRepository;
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	public BricksController(BrickRepository brickRepository){
		this.brickRepository = brickRepository;
		
	}
	
	//post method to create order of number of bricks
	//returns a unique reference
    @RequestMapping(method=RequestMethod.POST)
    public long createOrder(@RequestBody Bricks b) {
    	brickRepository.save(b);
    	b.setId(counter.incrementAndGet());
    	 return b.getId();                      
    }
    
    //gets order based on id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Bricks> getOrder(@PathVariable long id) {

    	return brickRepository.findById(id);
                           
    }

    
    //gets all orders
    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<Bricks> getOrders() {
      return brickRepository.findAll();
      
    }
}
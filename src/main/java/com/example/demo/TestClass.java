package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.nio.charset.Charset;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(BricksController.class)
public class TestClass {

	//Media Type for request
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	//request to send as JSON
	private final String BRICK_REQUEST = "{\"numBricks\" : \"10\"}";

	private MockMvc mockMvc;

	@Autowired
	private BricksController brickController;

	// sets mock interface for testing
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(brickController).build();
	}
    
    
	@Test
	public void Test1(){
		//initialise Bricks class and sets 'numBricks'
		Bricks b = new Bricks();
		b.setBricks("10");
		
		//equals that 'getnumBricks' returns the value set in 'setBricks' method
		assertEquals("10", b.getnumBricks());
		
		//the create method order returns a unique reference
		BricksController bc = new BricksController();
		long test = bc.createOrder(b);
		assertNotNull(test);
		
	}
	
	//test for web call out using mock 
	@Test
	public void Test2() throws Exception{
		this.mockMvc
		.perform(
				post("/brick").content(BRICK_REQUEST)
						.contentType(APPLICATION_JSON_UTF8))
		.andExpect(status().isOk());
	}
	

}

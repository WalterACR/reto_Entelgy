package com.wacr.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getMessage_thenStatus200() throws Exception {

		
	        mvc.perform(get("/api/getmessage").contentType(MediaType.APPLICATION_JSON))
	          .andDo(print())
	          .andExpect(status().isOk())
	          .andExpect(jsonPath("$.[0]postId", Matchers.is(1))).andExpect(jsonPath("$.id", Matchers.is(1)))
				.andExpect(jsonPath("$.[0]name", Matchers.is("id labore ex et quam laborum")))
				.andExpect(jsonPath("$.[0]email", Matchers.is("Eliseo@gardner.biz")))
				.andExpect(jsonPath("$.[0]body", Matchers.is(
							"laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium")));
	    
	}
}

package com.wacr.demo.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wacr.demo.controller.DemoController;

@RunWith(SpringJUnit4ClassRunner.class)
public class DemoControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private DemoController demoControllerTest;

	@Before
	private void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(demoControllerTest).build();
	}

	@Test
	public void testHelloWorldJson() throws Exception {
		mockMvc.perform(get("/api/getmessage").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0]postId", Matchers.is(1))).andExpect(jsonPath("$.id", Matchers.is(1)))
				.andExpect(jsonPath("$.[0]name", Matchers.is("id labore ex et quam laborum")))
				.andExpect(jsonPath("$.[0]email", Matchers.is("Eliseo@gardner.biz")))
				.andExpect(jsonPath("$.[0]body", Matchers.is(
						"laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium")));
		
	}

}

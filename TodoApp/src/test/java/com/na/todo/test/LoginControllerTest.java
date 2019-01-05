package com.na.todo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.na.todo.controller.LoginController;
import com.na.todo.model.User;
import com.na.todo.service.ILoginService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=LoginController.class)
public class LoginControllerTest {

	@Autowired 
	private MockMvc mockMvc;

	@MockBean
	private ILoginService loginService;

	@Test
	public void redirectToHome() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/TodoApp")).andReturn().equals("index");
	}

	@Test
	public void login() throws Exception {
		User user = new User("admin","pwd123");
		String json = new ObjectMapper().writeValueAsString(user);
		Mockito.when(loginService.authenticate(user)).thenReturn(user);

		mockMvc.perform(MockMvcRequestBuilders.post("/login",user)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().is(200));
				//.andExpect(MockMvcResultMatchers.jsonPath("userId").value("admin"));//TODO:Need to check
	}
}
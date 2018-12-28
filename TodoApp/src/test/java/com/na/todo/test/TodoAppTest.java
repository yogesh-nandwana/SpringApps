package com.na.todo.test;

import java.util.ArrayList;
import java.util.Arrays;

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
import com.na.todo.model.Todo;
import com.na.todo.model.User;
import com.na.todo.service.ILoginService;
import com.na.todo.service.ITodoService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TodoAppTest {

    @Autowired 
    private MockMvc mockMvc;
    
    @MockBean
    private ITodoService todoService;
    
    @MockBean
    private ILoginService loginService;
    
    @Test
    public void redirectToHome() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/TodoApp")).andReturn().equals("index");
    }
    
    @Test
    public void login() throws Exception {
    	User user = new User("todouser3","todopwd3");
    	String json = new ObjectMapper().writeValueAsString(user);
    	mockMvc.perform(MockMvcRequestBuilders.post("/login",user).contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andDo(MockMvcResultHandlers.print())
    	.andExpect(MockMvcResultMatchers.status().is(200));
    }
    
    
    @Test
    public void fetchDefaultTodos() throws Exception {
    	Mockito.when(todoService.getAllTodos()).thenReturn(new ArrayList<>(Arrays.asList(new Todo(1,"todo1"),new Todo(2,"todo2"),new Todo(3,"Todo3"))));
    	
    	mockMvc.perform(MockMvcRequestBuilders.get("/todo")).andDo(MockMvcResultHandlers.print()).andDo(MockMvcResultHandlers.log())
    	.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
    
    @Test
    public void fetchTodo_forSpecificTodoText() throws Exception {
    	Mockito.when(todoService.getTodo("todo1")).thenReturn(new Todo(1,"todo1"));
    	mockMvc.perform(MockMvcRequestBuilders.get("/todo/todo1")).andDo(MockMvcResultHandlers.print())
    	.andExpect(MockMvcResultMatchers.status().is(200))
    	.andReturn().equals("true");
    }
    
    @Test
    public void fetchLatestSrNo() throws Exception {
    	Mockito.when(todoService.getLatestSrNo()).thenReturn(3);
    	mockMvc.perform(MockMvcRequestBuilders.get("/todo/srNo")).andDo(MockMvcResultHandlers.print())
    	.andExpect(MockMvcResultMatchers.status().is(200))
    	.andReturn().equals(3);
    }
    
    @Test
    public void createNewTodo() throws Exception {
    	Todo todo = new Todo(4,"todo4");
    	String json = new ObjectMapper().writeValueAsString(todo);
    	mockMvc.perform(MockMvcRequestBuilders.post("/todo",todo).contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andDo(MockMvcResultHandlers.print())
    	.andExpect(MockMvcResultMatchers.status().is(200));
    }
    
    @Test
    public void updateTodo() throws Exception {
    	Todo todo = new Todo(1,"todo1");
    	String json = new ObjectMapper().writeValueAsString(todo);
    	mockMvc.perform(MockMvcRequestBuilders.put("/todo",todo).contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andDo(MockMvcResultHandlers.print())
    	.andExpect(MockMvcResultMatchers.status().is(200));
    }
    
    
    
    @Test
    public void deleteSpecificTodo() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.delete("/todo/4")).andDo(MockMvcResultHandlers.print())
    	.andExpect(MockMvcResultMatchers.status().is(200));
    }
}
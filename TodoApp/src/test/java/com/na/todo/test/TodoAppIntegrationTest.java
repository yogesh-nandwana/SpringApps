package com.na.todo.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.na.todo.model.Todo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TodoAppIntegrationTest {
	@Autowired 
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void getAllTodos_shouldReturn_3todos() {
		ResponseEntity<List<Todo>> responseEntity = testRestTemplate.exchange("/todo", HttpMethod.GET, null,new ParameterizedTypeReference<List<Todo>>() {});
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		assertThat(responseEntity.getBody()).isNotEmpty();
		assertThat(responseEntity.getBody().size()).isEqualTo(3);
	}
}

package com.na.todo.test;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.na.todo.model.Todo;
import com.na.todo.repository.TodoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TodoRepository todoRepositroy;

	@Test
	public void testFindByText() {
		Todo found = todoRepositroy.findByText("SampleTodo1");
		Assertions.assertThat(found).isNotNull();
		Assertions.assertThat(found.getText()).isEqualTo("SampleTodo1");
	}

	@Test
	public void testFindBySrNo() {
		Todo found = todoRepositroy.findBySrNo(1);
		Assertions.assertThat(found).isNotNull();
		Assertions.assertThat(found.getSrNo()).isEqualTo(1);
	}

	/*@Test
	public void testFindByUserId() {
		List<Todo> todos = todoRepositroy.findByUserId(1);
		Assertions.assertThat(todos).isNotNull();
		Assertions.assertThat(todos.size()).isEqualTo(3);
	}*/

	@Test
	public void testFindMaxSrNo() {
		Integer srNo = todoRepositroy.findMaxSrNo();
		Assertions.assertThat(srNo).isNotNull();
		Assertions.assertThat(srNo).isEqualTo(3);
	}
}
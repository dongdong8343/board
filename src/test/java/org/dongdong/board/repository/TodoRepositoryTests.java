package org.dongdong.board.repository;

import lombok.extern.log4j.Log4j2;
import org.dongdong.board.repository.entities.Todo;
import org.dongdong.board.repository.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class TodoRepositoryTests {

    @Autowired(required = false)
    private TodoRepository todoRepository;



    @Test
    public void testInsert() {
        for (int i = 0; i < 10000; i++) {
            Todo todo = Todo.builder()
                    .title("test" + i)
                    .writer("user" + i)
                    .build();

            todoRepository.save(todo);
        }
    }
}
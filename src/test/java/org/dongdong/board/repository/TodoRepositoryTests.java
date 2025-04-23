package org.dongdong.board.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.log4j.Log4j2;
import org.dongdong.board.todo.dto.PageRequest;
import org.dongdong.board.todo.dto.PageResponse;
import org.dongdong.board.todo.dto.TodoList;
import org.dongdong.board.todo.entities.QTodo;
import org.dongdong.board.todo.entities.Todo;
import org.dongdong.board.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Log4j2
@SpringBootTest
public class TodoRepositoryTests {
    @Autowired(required = false)
    private TodoRepository todoRepository;

    @Autowired
    private JPAQueryFactory queryFactory;

    @Test
    public void testSearch1() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPage(3);
        pageRequest.setSize(10);

        PageResponse<TodoList> li = todoRepository.list(pageRequest);
    }

    @Test
    public void testQuery() {
        log.info("====> " + queryFactory);

        QTodo todo = QTodo.todo;

        JPQLQuery<Todo> query = queryFactory.selectFrom(todo);

        query.where(todo.tno.gt(0L));
        query.where(todo.title.like("test%"));

        query.orderBy(new OrderSpecifier<>(Order.DESC, todo.tno));

        query.limit(10);
        query.offset(5);

        log.info(query);
        List<Todo> entityList = query.fetch();

        long count = query.fetchCount();

        log.info(entityList);
        log.info(count);
    }


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

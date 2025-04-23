package org.dongdong.board.todo.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dongdong.board.todo.dto.PageRequest;
import org.dongdong.board.todo.dto.PageResponse;
import org.dongdong.board.todo.dto.TodoList;
import org.dongdong.board.todo.entities.QTodo;
import org.dongdong.board.todo.entities.Todo;

import java.util.List;


@Log4j2
@RequiredArgsConstructor
public class TodoSearchImpl implements TodoSearch {

    private final JPAQueryFactory queryFactory;

    @Override
    public PageResponse<TodoList> list(PageRequest pageRequest) {
        QTodo todo = QTodo.todo;

        JPQLQuery<Todo> query = queryFactory.selectFrom(todo);

        query.limit(pageRequest.getSize());
        query.offset(pageRequest.getOffset());
        query.orderBy(new OrderSpecifier<>(Order.DESC, todo.tno));

        JPQLQuery<TodoList> dtoQuery = query.select(
                Projections.bean(TodoList.class,
                        todo.tno, todo.title, todo.writer, todo.regDate));

        long count = dtoQuery.fetchCount();

        List<TodoList> todoList = dtoQuery.fetch();

        log.info(todoList);
        log.info(count);

        return PageResponse.<TodoList>withAll()
                .total((int) count)
                .dtoList(todoList)
                .pageRequestDTO(pageRequest)
                .build();
    }
}

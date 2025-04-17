package org.dongdong.board.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dongdong.board.todo.dto.PageRequest;
import org.dongdong.board.todo.dto.PageResponse;
import org.dongdong.board.todo.dto.TodoList;
import org.dongdong.board.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;


@Log4j2
@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public PageResponse<TodoList> readTodoList(PageRequest request) {
        return todoRepository.list(request);
    }
}

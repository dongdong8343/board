package org.dongdong.board.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dongdong.board.todo.dto.PageRequest;
import org.dongdong.board.todo.dto.PageResponse;
import org.dongdong.board.todo.dto.TodoList;
import org.dongdong.board.todo.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/list")
    public PageResponse<TodoList> readTodoList(@RequestBody PageRequest request) {
        return todoService.readTodoList(request);
    }
}

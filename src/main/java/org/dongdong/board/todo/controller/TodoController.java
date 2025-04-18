package org.dongdong.board.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dongdong.board.todo.dto.*;
import org.dongdong.board.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/list")
    public PageResponse<TodoList> readTodoList(@ModelAttribute PageRequest request) {
        log.info(request.getPage());
        log.info(request.getSize());
        return todoService.readTodoList(request);
    }

    @PostMapping("/new")
    public Long saveTodo(@RequestBody AddTodo request) {
        return todoService.saveTodo(request);
    }

    @PatchMapping("/{tno}")
    public Long updateTodo(@PathVariable Long tno, @RequestBody UpdateTodo updateTodo) {
        return todoService.updateTodo(tno, updateTodo);
    }
}

package org.dongdong.board.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dongdong.board.todo.dto.*;
import org.dongdong.board.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("{tno}")
    public ReadTodo.Response getTodo(@PathVariable Long tno) {
        return todoService.getTodoByTno(tno);
    }

    @PostMapping("/new")
    public Long saveTodo(@RequestBody AddTodo request) {
        return todoService.saveTodo(request);
    }

    @PatchMapping("/{tno}")
    public Long updateTodo(@PathVariable Long tno, @RequestBody UpdateTodo updateTodo) {
        log.info("수정 요청 ------------------------");
        log.info(updateTodo.getEditedContent() + " " + updateTodo.getEditedTitle());
        return todoService.updateTodo(tno, updateTodo);
    }

    @DeleteMapping("/{tno}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long tno) {
        todoService.deleteTodo(tno);

        return ResponseEntity.ok(tno + "번 게시글이 삭제됐습니다.");
    }
}

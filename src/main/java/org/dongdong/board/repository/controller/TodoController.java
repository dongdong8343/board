package org.dongdong.board.repository.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.dongdong.board.repository.dto.AddTodo;
import org.dongdong.board.repository.dto.UpdateTodo;
import org.dongdong.board.repository.service.TodoService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/todos")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("new")
    public Long createPost(@RequestBody AddTodo request) {
        return todoService.savePost(request); //tno
    }

    @PatchMapping("/{tno}/update")
    public Long updateTodo(@PathVariable Long tno, @RequestBody UpdateTodo request) {
        request.setTno(tno);
        return todoService.changePost(request);
    }


}

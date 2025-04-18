package org.dongdong.board.repository.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.dongdong.board.repository.dto.TodoRegisterDTO;
import org.dongdong.board.repository.dto.TodoUpdateDTO;
import org.dongdong.board.repository.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/todos")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("register")
    public void register() {

    }

    @PostMapping("register")
    public String postMethodName(@Validated TodoRegisterDTO dto) {

        log.info("1111");
        return "redirect:/board";
    }

    @PostMapping("/{tno}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody TodoUpdateDTO dto) {
        log.info("222: " + dto);
        return ResponseEntity.ok().build();
    }
}

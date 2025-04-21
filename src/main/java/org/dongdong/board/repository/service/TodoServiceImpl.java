package org.dongdong.board.repository.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.dongdong.board.repository.dto.AddTodo;
import org.dongdong.board.repository.dto.UpdateTodo;
import org.dongdong.board.repository.entities.Todo;
import org.dongdong.board.repository.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;


    @Override
    public Long savePost(AddTodo request) {
        Todo todo = Todo.createTodo(request.getTitle(), request.getContent(), request.getWriter());
        return repository.save(todo).getTno();
    }

    @Override
    @Transactional
    public Long changePost(UpdateTodo request) {
        Todo todo = repository.findById(request.getTno())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        todo.update(request.getTitle(), request.getContent(), request.getWriter());


        return todo.getTno();
    }

}
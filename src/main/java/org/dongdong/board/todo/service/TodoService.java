package org.dongdong.board.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dongdong.board.todo.dto.*;
import org.dongdong.board.todo.entities.Todo;
import org.dongdong.board.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Log4j2
@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public PageResponse<TodoList> readTodoList(PageRequest request) {
        return todoRepository.list(request);
    }

    public ReadTodo.Response getTodoByTno(Long tno) {
        return ReadTodo.toResponse(todoRepository.findByTno(tno));
    }

    public Long saveTodo(AddTodo request) {
        Todo todo = request.toEntity();

        return todoRepository.save(todo).getTno();
    }

    @Transactional
    public Long updateTodo(Long tno, UpdateTodo request) {
        Todo todo = todoRepository.findByTno(tno);

        todo.update(request.getEditedTitle(), request.getEditedContent());

        return tno;
    }

    @Transactional
    public void deleteTodo(Long tno) {
        Todo todo = todoRepository.findByTno(tno);

        todo.delete();
    }
}

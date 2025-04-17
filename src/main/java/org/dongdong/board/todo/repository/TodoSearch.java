package org.dongdong.board.todo.repository;

import org.dongdong.board.todo.dto.PageRequest;
import org.dongdong.board.todo.dto.PageResponse;
import org.dongdong.board.todo.dto.TodoList;


public interface TodoSearch {
    PageResponse<TodoList> list(PageRequest pageRequest);
}

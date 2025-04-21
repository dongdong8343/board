package org.dongdong.board.repository.repository;

import org.dongdong.board.repository.entities.Todo;
import org.dongdong.board.repository.service.TodoService;
import org.dongdong.board.repository.service.TodoServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    public abstract Todo findByTno(Long tno);
}
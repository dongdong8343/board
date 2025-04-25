package org.dongdong.board.repository.repository;

import org.dongdong.board.repository.dto.TodoDTO;
import org.dongdong.board.repository.entities.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo, Long> {


    @Query("select t from Todo t where t.title like %:title% ")//SQL이 아님
    Page<Todo> listOfTitle(@Param("title") String title, Pageable pageable);


    @Query("select new org.dongdong.board.repository.dto.TodoRegisterDTO(t.title, t.writer, t.content,t.regDate, t.modDate) from Todo t where t.tno = :tno")
    TodoDTO selectDTO(@Param("tno") Long tno  );

}
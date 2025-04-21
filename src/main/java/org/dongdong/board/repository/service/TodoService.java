package org.dongdong.board.repository.service;

import org.dongdong.board.repository.dto.AddTodo;
import org.dongdong.board.repository.dto.UpdateTodo;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TodoService {

    Long savePost(AddTodo request);

    Long changePost(UpdateTodo request);

}

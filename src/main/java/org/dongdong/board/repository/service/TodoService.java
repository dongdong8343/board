package org.dongdong.board.repository.service;

import org.dongdong.board.repository.dto.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TodoService {

    TodoDTO getOne(Long tno);

}

package org.dongdong.board.repository.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dongdong.board.repository.dto.TodoDTO;

import org.dongdong.board.repository.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;

    @Override
    public TodoDTO getOne(Long tno) {

        //조회하면 Optional<Todo>

        //Todo를 꺼내서 TodoDTO로 변환

        return null;

    }

}
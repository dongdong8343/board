package org.dongdong.board.todo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateTodo {
    private String title;
    private String content;
}

package org.dongdong.board.todo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateTodo {
    private String editedTitle;
    private String editedContent;
}

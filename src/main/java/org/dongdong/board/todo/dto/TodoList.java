package org.dongdong.board.todo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TodoList {
    private Long tno;

    private String title;

    private String writer;

    private LocalDateTime regDate;
}

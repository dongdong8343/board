package org.dongdong.board.todo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dongdong.board.todo.entities.Todo;

@Getter
@NoArgsConstructor
public class AddTodo {
    private String title;
    private String writer;
    private String content;

    public Todo toEntity() {
        return Todo.of(this.title, this.writer, this.content);
    }
}

package org.dongdong.board.todo.dto;

import lombok.Getter;
import org.dongdong.board.todo.entities.Todo;

public class ReadTodo {
    @Getter
    public static class Response {
        private Long tno;
        private String title;
        private String writer;
        private String content;

        private Response(Long tno, String title, String writer, String content) {
            this.tno = tno;
            this.title = title;
            this.writer = writer;
            this.content = content;
        }
    }

    public static Response toResponse(Todo todo) {
        return new Response(todo.getTno(), todo.getTitle(), todo.getWriter(), todo.getContent());
    }

}

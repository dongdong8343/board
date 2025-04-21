package org.dongdong.board.repository.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class AddTodo {

    private String title;

    private String writer;

    private String content;


    public AddTodo(String title, String writer, String content ) {

        this.title = title;
        this.writer = writer;
        this.content = content;

    }
}

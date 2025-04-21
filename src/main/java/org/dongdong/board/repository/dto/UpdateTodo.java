package org.dongdong.board.repository.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UpdateTodo {
    private Long tno;        // ← 이거 꼭 필요함!
    private String title;
    private String content;
    private String writer;

    public UpdateTodo(Long tno, String title, String content, String writer) {
        this.tno = tno;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }


}

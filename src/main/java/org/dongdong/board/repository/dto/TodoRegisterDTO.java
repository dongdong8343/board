package org.dongdong.board.repository.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data

@NoArgsConstructor
public class TodoRegisterDTO {


    private String title;

    private String writer;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    public TodoRegisterDTO(String title, String writer, String content ,LocalDateTime regDate, LocalDateTime modDate) {

        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}

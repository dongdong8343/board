package org.dongdong.board.repository.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor

public class TodoUpdateDTO {

    private Long tno;
    private String title;
    private String content;
    private LocalDateTime modDate;

    public TodoUpdateDTO(Long tno, String title, String content, LocalDateTime modDate) {
        this.tno = tno;
        this.title = title;
        this.content = content;
        this.modDate = modDate;
    }

    public Long getTno() {
        return tno;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getModDate() {
        return modDate;
    }
}

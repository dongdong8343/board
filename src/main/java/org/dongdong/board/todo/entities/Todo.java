package org.dongdong.board.todo.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "tbl_todo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Todo extends BaseEntity{
    // 모든 엔티티는 반드시 id가 존재
    // PK는 반드시 객체 타입 (기본 자료형 사용 불가)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;

    @Column(nullable = false, length = 300)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    private Todo(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public static Todo of(String title, String writer, String content) {
        return new Todo(title, writer, content);
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void delete() {
        this.isDeleted = true;
    }
}


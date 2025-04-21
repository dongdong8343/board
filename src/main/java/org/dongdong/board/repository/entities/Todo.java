package org.dongdong.board.repository.entities;

import jakarta.persistence.*;
import lombok.*;

// 테이블 용도
// @Table 생략시에는 클래스 이름이 테이블 이름
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

    @Column(length = 1000)
    private String content;

    @Column(nullable = false)
    private String writer;

    private Todo(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    // 정적 팩토리 메서드
    public static Todo createTodo(String title, String content, String writer) {
        return new Todo(title, content, writer);
    }


    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}

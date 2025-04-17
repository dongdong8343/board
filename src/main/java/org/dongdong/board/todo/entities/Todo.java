package org.dongdong.board.todo.entities;


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

    @Column(nullable = false)
    private String writer;

    // JPA는 가능하면 엔티티 객체를 readonly로 하는 것을 권장
    // 변경하고 싶을 때 setxxx가 아니라 별도의 메서드를 이용

    public void changeTitle(String title) {
        this.title = title;
    }
}

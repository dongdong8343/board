package org.dongdong.board.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dongdong.board.user.entities.Member;

public class AddUser {
    @NoArgsConstructor
    @Getter
    public static class Request {
        private String email;
        private String password;
        private String nickname;

        public Member toEntity() {
            return Member.createUser(email, password, nickname);
        }
    }
}

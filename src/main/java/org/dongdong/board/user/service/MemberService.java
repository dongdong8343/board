package org.dongdong.board.user.service;

import lombok.RequiredArgsConstructor;
import org.dongdong.board.user.dto.AddUser;
import org.dongdong.board.user.repository.MemberRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Long saveMember(AddUser.Request request) {
        return memberRepository.save(request.toEntity()).getMid();
    }
}

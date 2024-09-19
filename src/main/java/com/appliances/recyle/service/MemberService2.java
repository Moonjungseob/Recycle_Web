package com.appliances.recyle.service;


import com.appliances.recyle.domain.Member;
import com.appliances.recyle.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService2 {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

//    public MemberService2(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    // 이메일로 멤버 정보를 가져오는 메서드
    public Optional<Member> getMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    // 사용자 정보 업데이트 (비밀번호 포함)
    public void updatePassword(Member member, String newPassword) {
        // 새 비밀번호를 암호화하여 설정
        member.setPw(passwordEncoder.encode(newPassword));

        // 변경된 사용자 정보를 데이터베이스에 저장 (업데이트)
        memberRepository.save(member);  // save()는 수정된 데이터를 업데이트합니다.
    }

    public void save(Member member) {
        memberRepository.save(member);
    }
}

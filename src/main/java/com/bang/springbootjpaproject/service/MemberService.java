package com.bang.springbootjpaproject.service;

import com.bang.springbootjpaproject.domain.Member;
import com.bang.springbootjpaproject.dto.MemberDto;
import com.bang.springbootjpaproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(MemberDto.Request requestDto) {
        return memberRepository.save(requestDto.toEntity()).getSn();
    }

    @Transactional(readOnly = true)
    public MemberDto.Response findById(Long sn) {
        Member member = memberRepository.findById(sn).orElseThrow(() -> new IllegalArgumentException("해당 멤버는 존재하지 않습니다. sn = " + sn));

        return new MemberDto.Response(member);
    }

    @Transactional
    public Long update(Long sn, MemberDto.Request requestDto) {
        Member member = memberRepository.findById(sn).orElseThrow(() -> new IllegalArgumentException("해당 멤버는 존재하지 않습니다. sn = " + sn));
        member.update(requestDto.getId(), requestDto.getPassword(), requestDto.getName());

        return sn;
    }

    @Transactional
    public void delete(Long sn) {
        Member member = memberRepository.findById(sn).orElseThrow(() -> new IllegalArgumentException("해당 멤버는 존재하지 않습니다. sn = " + sn));
        memberRepository.delete(member);
    }
}

package com.bang.springbootjpaproject.controller;

import com.bang.springbootjpaproject.dto.MemberDto;
import com.bang.springbootjpaproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<Long> save(@RequestBody MemberDto.Request requestDto) {
        return ResponseEntity.ok(memberService.save(requestDto));
    }

    @GetMapping("/member/{sn}")
    public ResponseEntity<MemberDto.Response> findById(@PathVariable Long sn) {
        return ResponseEntity.ok(memberService.findById(sn));
    }

    @PutMapping("/member/{sn}")
    public ResponseEntity<Long> update(@PathVariable Long sn, @RequestBody MemberDto.Request requestDto) {
        return ResponseEntity.ok(memberService.update(sn, requestDto));
    }

    @DeleteMapping("/member/{sn}")
    public ResponseEntity<Long> delete(@PathVariable Long sn) {
        memberService.delete(sn);

        return ResponseEntity.ok(sn);
    }
}

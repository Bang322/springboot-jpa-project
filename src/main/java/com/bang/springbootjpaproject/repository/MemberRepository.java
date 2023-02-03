package com.bang.springbootjpaproject.repository;

import com.bang.springbootjpaproject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

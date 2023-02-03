package com.bang.springbootjpaproject.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR")
    private Long sn;

    @NotNull
    @Column(length = 100)
    private String id;

    @NotNull
    @Column(length = 150)
    private String password;

    @Column(length = 100)
    private String name;

    @Builder
    public Member(Long sn, String id, String password, String name) {
        this.sn = sn;
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public void update(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
}

package com.bang.springbootjpaproject.dto;

import com.bang.springbootjpaproject.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private Long sn;
        private String id;
        private String password;
        private String name;

        public Member toEntity() {
            return Member.builder()
                    .sn(sn)
                    .id(id)
                    .password(password)
                    .name(name)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private Long sn;
        private String id;
        private String password;
        private String name;

        public Response(Member entity) {
            this.sn = entity.getSn();
            this.id = entity.getId();
            this.password = entity.getPassword();
            this.name = entity.getName();
        }
    }
}

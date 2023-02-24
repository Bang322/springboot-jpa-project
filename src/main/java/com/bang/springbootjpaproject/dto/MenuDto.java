package com.bang.springbootjpaproject.dto;

import com.bang.springbootjpaproject.domain.Menu;
import lombok.*;

import java.util.List;

public class MenuDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Request {
        private Long menuId; // 메뉴 PK
        private Long parentId; // 부모의 menuId
        private String path; // 메뉴 경로
        private String name; // 메뉴명
        private String icon; // 아이콘 (material icon)
        private Long order; // 메뉴 순서 (부모 메뉴 기준)
        private String useYn; // 사용 여부 (Y, N)

        public Menu toEntity() {
            return Menu.builder()
                    .menuId(menuId)
                    .parentId(parentId)
                    .path(path)
                    .name(name)
                    .icon(icon)
                    .order(order)
                    .useYn(useYn)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private Long menuId; // 메뉴 PK
        private Long parentId; // 부모의 menuId
        private String path; // 메뉴 경로
        private String name; // 메뉴명
        private String icon; // 아이콘 (material icon)
        private Long order; // 메뉴 순서 (부모 메뉴 기준)
        private String useYn; // 사용 여부 (Y, N)

        public Response(Menu entity) {
            this.menuId = entity.getMenuId();
            this.parentId = entity.getParentId();
            this.path = entity.getPath();
            this.name = entity.getName();
            this.icon = entity.getIcon();
            this.order = entity.getOrder();
            this.useYn = entity.getUseYn();
        }
    }
}

package com.bang.springbootjpaproject.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Menu {
    @Id
    private Long menuId; // 메뉴 PK
    private Long parentId; // 부모의 menuId
    private String path; // 메뉴 경로
    @NotNull
    private String name; // 메뉴명
    private String icon; // 아이콘 (material icon)
    @Column(name = "MENU_ORDER")
    private Long order; // 메뉴 순서 (부모 메뉴 기준)
    @NotNull
    @Column(length = 1)
    private String useYn; // 사용 여부 (Y, N)

    @Builder
    public Menu(Long menuId, Long parentId, String path, String name, String icon, Long order, String useYn) {
        this.menuId = menuId;
        this.parentId = parentId;
        this.path = path;
        this.name = name;
        this.icon = icon;
        this.order = order;
        this.useYn = useYn;
    }

    public void update(Long parentId, String path, String name, String icon, Long order, String useYn) {
        this.parentId = parentId;
        this.path = path;
        this.name = name;
        this.icon = icon;
        this.order = order;
        this.useYn = useYn;
    }
}

package com.bang.springbootjpaproject.controller;

import com.bang.springbootjpaproject.dto.MenuDto;
import com.bang.springbootjpaproject.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/menu")
    public ResponseEntity<Long> save(@RequestBody MenuDto.Request requestDto) {
        return ResponseEntity.ok(menuService.save(requestDto));
    }

    @PostMapping("/menus")
    public ResponseEntity<List<MenuDto.Response>> saveAll(@RequestBody List<MenuDto.Request> requestDtoList) {
        return ResponseEntity.ok(menuService.saveAll(requestDtoList));
    }

    @GetMapping("/menus")
    public ResponseEntity<List<MenuDto.Response>> findAll() {
        return ResponseEntity.ok(menuService.findAll());
    }
}

package com.bang.springbootjpaproject.service;

import com.bang.springbootjpaproject.domain.Menu;
import com.bang.springbootjpaproject.dto.MenuDto;
import com.bang.springbootjpaproject.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService {
    private final MenuRepository menuRepository;

    public Long save(MenuDto.Request requestDto) {
        return menuRepository.save(requestDto.toEntity()).getMenuId();
    }

    @Transactional
    public List<MenuDto.Response> saveAll(List<MenuDto.Request> requestDtoList) {
        // save 하기 전에 테이블 데이터 모두 삭제
        menuRepository.truncate();

        List<Menu> menuList = new ArrayList<>();

        // 요청 객체로부터 entity 객체를 생성하여 리스트에 넣어줌
        for (MenuDto.Request requestDto : requestDtoList) {
            Menu entity = requestDto.toEntity();
            menuList.add(entity);
        }

        List<Menu> savedMenuList = menuRepository.saveAll(menuList);
        List<MenuDto.Response> responseDtoList = new ArrayList<>();

        for(Menu entity : savedMenuList) {
            MenuDto.Response responseDto  = new MenuDto.Response(entity);
            responseDtoList.add(responseDto);
        }

        return responseDtoList;
    }

    @Transactional(readOnly = true)
    public List<MenuDto.Response> findAll() {
        List<Menu> menuList = menuRepository.findAll();
        List<MenuDto.Response> responseDtoList = new ArrayList<>();

        for (Menu entity : menuList) {
            MenuDto.Response responseDto = new MenuDto.Response(entity);
            responseDtoList.add(responseDto);
        }

        return responseDtoList;
    }
}

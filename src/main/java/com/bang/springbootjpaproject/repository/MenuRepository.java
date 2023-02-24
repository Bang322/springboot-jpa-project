package com.bang.springbootjpaproject.repository;

import com.bang.springbootjpaproject.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Transactional
    @Modifying
    @Query(
            value = "truncate table MENU", nativeQuery = true
    )
    void truncate();
}

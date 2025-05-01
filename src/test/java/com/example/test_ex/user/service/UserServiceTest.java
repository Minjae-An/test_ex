package com.example.test_ex.user.service;

import com.example.test_ex.user.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;


    @Sql(value = "/sql/find-user-by-id-setup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @DisplayName("사용자를 ID로 조회할 수 있다.")
    @Test
    public void findById() {
        // given
        long userId = 1L;

        // when
        User user = userService.findById(userId);

        // then
        Assertions.assertThat(user.getId()).isEqualTo(userId);
    }
}
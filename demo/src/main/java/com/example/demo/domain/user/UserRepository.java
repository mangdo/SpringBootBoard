package com.example.demo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // email을 통해 등록된 사용자인지 신규 가입자인지 확인
    Optional<User> findByEmail(String email);

}

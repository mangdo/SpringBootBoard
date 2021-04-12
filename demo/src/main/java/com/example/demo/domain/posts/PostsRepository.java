package com.example.demo.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
    // SpringDataJpa에서 제공되지않는 메소드는 위처럼 쿼리로 작성된다.
    // 복잡한 쿼리의 경우 조회용 프레임워크를 추가사용한다. 대표적으로 querydsl, jooq, MyBatis가 있다.
    // JPA를 적극적으로 도입하는 회사들의 경우엔 querydsl를 사용하는 편이다.
}

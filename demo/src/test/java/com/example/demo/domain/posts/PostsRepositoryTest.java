package com.example.demo.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    //@SpringBootTest사용시 H2 데이터베이스를 자동실행

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }
    //JUnit에서 단위 테스트가 끝날때마다 수행되는 메소드 지정


    @Test
    public void saveAndRead(){
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("cms71198@gmail.com")
                .build());
        // save : posts테이블에 insert/update 쿼리 실행

        // when
        List<Posts> postsList = postsRepository.findAll();
        //findall(): posts 테이블에 있는 모든 데이터를 조회해오는 메소드

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_register(){
        //given
        LocalDateTime now = LocalDateTime.of(2021,4,10,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title").content("content").author("author").build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>> CreateDate = "+posts.getCreatedDate()+" modifiedDate = "+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);


    }
}

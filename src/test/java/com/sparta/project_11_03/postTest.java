package com.sparta.project_11_03;

import com.sparta.project_11_03.entity.Post;
import com.sparta.project_11_03.respository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
@SpringBootTest
public class postTest {


    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    EntityManager em;
    @Test
    @Transactional
    @Rollback(value = false) // 테스트 코드에서 @Transactional 를 사용하면 테스트가 완료된 후 롤백하기 때문에 false 옵션 추가
    @DisplayName("메모 생성 성공")
    void test1() {
        Post post = new Post();
        post.setUsername("Robbert");
        post.setContents("@Transactional 테스트 중!");
        post.setPassword("1234");

        this.em.persist(post);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
    }


}

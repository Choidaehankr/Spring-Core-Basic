package example.mybatis.repository;

import example.mybatis.domain.News;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsRepositoryTest {

    @Autowired
    NewsRepository newsRepository;

    @Test
    @DisplayName("mybatis 게시물 등록 테스트")
    void save1() {
        newsRepository.save1(new News("test1", "choi", 12));
    }

    @Test
    void save2() {
    }
}
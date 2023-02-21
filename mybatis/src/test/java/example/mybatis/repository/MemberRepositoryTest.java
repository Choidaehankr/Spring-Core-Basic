package example.mybatis.repository;

import example.mybatis.domain.Gender;
import example.mybatis.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository userRepository;

    @Test
    @DisplayName("mybatis 회원가입 테스트")
    void save1() {
        userRepository.save1(new Member("choiMax", 26, Gender.MAN, "Naesu"));
    }

    @Test
    void save2() {
        userRepository.save2(new Member("choiMax", 26, Gender.MAN, "Naesu"));
    }
}
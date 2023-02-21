package example.mybatis.repository;

import static org.assertj.core.api.Assertions.*;

import example.mybatis.domain.Gender;
import example.mybatis.domain.Member;
import example.mybatis.dto.MemberRequestDto;
import example.mybatis.dto.MemberResponseDto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository userRepository;


    @BeforeEach
    void before() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("MyBatis 회원가입 테스트-xml")
    void save1() {
        userRepository.save1(new Member("Gillette", 26, Gender.MAN, "Cheongju"));
    }

    @Test
    @DisplayName("MyBatis 회원가입 테스트")
    void save2() {
        userRepository.save2(new Member("ChoiKorea", 24, Gender.WOMAN, "Seoul"));
    }

    @Test
    @DisplayName("findById 테스트")
    void find() {
        MemberResponseDto dto = userRepository.findById(16L);
        assertThat(dto.getUsername()).isEqualTo("korea");
        MemberResponseDto newDto = userRepository.findByUsername("korea");
        assertThat(newDto.getAge()).isEqualTo(26);
    }

    @Test
    @DisplayName("update 테스트")
    void update() {
        MemberRequestDto dto = MemberRequestDto.builder()
                .id(17L)
                .username("kim")
                .age(33)
                .address("Seoul")
                .build();
        userRepository.update(dto);
        MemberResponseDto updatedMember = userRepository.findById(17L);
        assertThat(updatedMember.getUsername()).isEqualTo(dto.getUsername());
    }

    @Test
    @DisplayName("delete 테스트")
    void delete() {
        userRepository.deleteById(17L);
        MemberResponseDto deletedMember = userRepository.findById(17L);
        assertThat(deletedMember).isNull();
    }

    @Test
    @DisplayName("findAll 테스트")
    void findAll() {
        userRepository.save1(new Member("Gillette", 26, Gender.MAN, "Cheongju"));
        userRepository.save2(new Member("ChoiKorea", 24, Gender.WOMAN, "Seoul"));
        List<MemberResponseDto> memberList = userRepository.findAll();
        assertThat(memberList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("deleteAll 테스트")
    void deleteAll() {
        userRepository.save1(new Member("Gillette", 26, Gender.MAN, "Cheongju"));
        userRepository.save2(new Member("ChoiKorea", 24, Gender.WOMAN, "Seoul"));
        userRepository.deleteAll();
        List<MemberResponseDto> memberList = userRepository.findAll();
        assertThat(memberList.size()).isEqualTo(0);
    }
}
package example.mybatis.repository;

import static org.assertj.core.api.Assertions.*;

import example.mybatis.domain.Gender;
import example.mybatis.domain.Member;
import example.mybatis.dto.MemberRequestDto;
import example.mybatis.dto.MemberResponseDto;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

//    @BeforeEach
//    void before() {
//        memberRepository.save1(new Member("ChoiKorea", 26, Gender.MAN, "Cheong-ju"));
//    }
//    @AfterEach
//    void after() {
//        memberRepository.deleteAll();
//    }

    @Test
    @DisplayName("MyBatis 회원가입 테스트-xml")
    void save1() {
        memberRepository.save1(new Member("ChoiKorea", 26, Gender.MAN, "Cheongju"));
    }

    @Test
    @DisplayName("MyBatis 회원가입 테스트")
    void save2() {
        memberRepository.save2(new Member("ChoiKorea", 24, Gender.WOMAN, "Seoul"));
    }

    @Test
    @DisplayName("findById 테스트")
    void find() {
        memberRepository.save1(new Member("ChoiKorea", 26, Gender.MAN, "Cheong-ju"));
        MemberResponseDto dto = memberRepository.findById(33L);
        assertThat(dto.getUsername()).isEqualTo("ChoiKorea");
        MemberResponseDto newDto = memberRepository.findByUsername("korea");
        assertThat(newDto.getAge()).isEqualTo(26);
    }
    
    @Test
    @DisplayName("findById 테스트2")
    void find2() {
        MemberResponseDto dto = memberRepository.findById2(33L);
        assertThat(dto.getUsername()).isEqualTo("ChoiKorea");
    }

    @Test
    @DisplayName("findByUsername 테스트2")
    void find3() {
        MemberResponseDto dto = memberRepository.findByUsername2("ChoiKorea");
        assertThat(dto.getAge()).isEqualTo(26);
    }

    @Test
    @DisplayName("update 테스트")
    void update() {
        MemberRequestDto dto = MemberRequestDto.builder()
                .id(47L)
                .username("Kim")
                .address("Seoul")
                .build();
        memberRepository.update(dto);
        MemberResponseDto updatedMember = memberRepository.findById(47L);
        assertThat(updatedMember.getUsername()).isEqualTo(dto.getUsername());
    }

    @Test
    @DisplayName("update2 테스트")
    void update2() {
        MemberRequestDto dto = MemberRequestDto.builder()
                .id(33L)
                .username("kim")
                .age(33)
                .address("Seoul")
                .build();
        memberRepository.update(dto);
        MemberResponseDto updatedMember = memberRepository.findById(33L);
        assertThat(updatedMember.getUsername()).isEqualTo(dto.getUsername());
    }

    @Test
    @DisplayName("update3 테스트-Null 입력 테스트")
    void update3() {
        MemberRequestDto dto = MemberRequestDto.builder()
                .id(47L)
                .age(26)
                .build();
        memberRepository.update3(dto);
        MemberResponseDto updatedMember = memberRepository.findById(47L);
        assertThat(updatedMember.getAge()).isEqualTo(dto.getAge());
    }

    @Test
    @DisplayName("delete 테스트")
    void delete() {
        memberRepository.deleteById(17L);
        MemberResponseDto deletedMember = memberRepository.findById(17L);
        assertThat(deletedMember).isNull();
    }

    @Test
    @DisplayName("delete 테스트2")
    void delete2() {
        memberRepository.deleteById(48L);
        MemberResponseDto deletedMember = memberRepository.findById(34L);
        assertThat(deletedMember).isNull();
    }

    @Test
    @DisplayName("findAll 테스트")
    void findAll() {
        memberRepository.save1(new Member("Gillette", 26, Gender.MAN, "Cheongju"));
        memberRepository.save2(new Member("ChoiKorea", 24, Gender.WOMAN, "Seoul"));
        List<MemberResponseDto> memberList = memberRepository.findAll();
        assertThat(memberList.size()).isEqualTo(2);
    }
    @Test
    @DisplayName("findAll 테스트2")
    void findAll2() {
        deleteAll();
        memberRepository.save1(new Member("Gillette", 26, Gender.MAN, "Cheongju"));
        memberRepository.save2(new Member("ChoiKorea", 24, Gender.WOMAN, "Seoul"));
        List<MemberResponseDto> memberList = memberRepository.findAll2();
        assertThat(memberList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("deleteAll 테스트")
    void deleteAll() {
        memberRepository.save1(new Member("Gillette", 26, Gender.MAN, "Cheongju"));
        memberRepository.save2(new Member("ChoiKorea", 24, Gender.WOMAN, "Seoul"));
        memberRepository.deleteAll2();
        List<MemberResponseDto> memberList = memberRepository.findAll();
        assertThat(memberList.size()).isEqualTo(0);
    }
}
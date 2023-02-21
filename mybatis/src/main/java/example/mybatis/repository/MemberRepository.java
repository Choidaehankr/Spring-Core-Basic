package example.mybatis.repository;

import example.mybatis.domain.Member;
import example.mybatis.dto.MemberRequestDto;
import example.mybatis.dto.MemberResponseDto;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

    void save1(Member member);

    @Insert("insert into member(username, age, gender, address) values (#{username}, #{age}, #{gender}, #{address})")
    void save2(Member member);

    MemberResponseDto findById(Long id);

    MemberResponseDto findByUsername(String username);

    void update(MemberRequestDto dto);

    void deleteById(Long id);

    void deleteAll();

    List<MemberResponseDto> findAll();
}

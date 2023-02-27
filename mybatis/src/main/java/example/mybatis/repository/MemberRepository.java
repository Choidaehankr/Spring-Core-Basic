package example.mybatis.repository;

import example.mybatis.domain.Member;
import example.mybatis.dto.MemberRequestDto;
import example.mybatis.dto.MemberResponseDto;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberRepository {

    void save1(Member member);

    @Insert("insert into member(username, age, gender, address) values (#{username}, #{age}, #{gender}, #{address})")
    void save2(Member member);

    MemberResponseDto findById(Long id);

    @Select("select * from member where id = #{id}")
    MemberResponseDto findById2(Long id);

    MemberResponseDto findByUsername(String username);

    @Select("select * from member where username = #{username}")
    MemberResponseDto findByUsername2(String username);

    void update(MemberRequestDto dto);

    @Update("update member set username=#{username}, age=#{age}, address=#{address} where id=#{id}")
    void update2(MemberRequestDto dto);
    void update3(MemberRequestDto dto);

    void update4(MemberRequestDto dto);
    void deleteById(Long id);
    @Delete("delete from member where id=#{id}")
    void deleteById2(Long id);

    void deleteAll();
    @Delete("delete from member")
    void deleteAll2();

    List<MemberResponseDto> findAll();
    @Select("select * from member order by id DESC")
    List<MemberResponseDto> findAll2();
}

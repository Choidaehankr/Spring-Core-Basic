package example.mybatis.repository;

import example.mybatis.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

    void save1(Member member);

    @Insert("insert into member(username, age, gender, address) values (#{username}, #{age}, #{gender}, #{address})")
    void save2(Member member);
}

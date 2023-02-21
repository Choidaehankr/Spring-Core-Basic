package example.mybatis.repository;

import example.mybatis.domain.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsRepository {

    void save1(News post);

    //    @Insert("insert into user(username, age, gender, address) values (#{username}, #{age}, #{gender}, #{address}")
    @Insert("insert into news(title, author, page) values (#{title}, #{author}, #{page})")
    void save2(News post);
}

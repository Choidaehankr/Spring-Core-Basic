package example.mybatis.dto;

import example.mybatis.domain.Gender;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {

    private Long id;
    private String username;
    private int age;
    private Gender gender;
    private String address;
}

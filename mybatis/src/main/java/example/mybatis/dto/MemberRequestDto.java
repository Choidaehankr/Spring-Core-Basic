package example.mybatis.dto;

import example.mybatis.domain.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberRequestDto {

    private Long id;
    private String username;
    private int age;
    private String address;
}

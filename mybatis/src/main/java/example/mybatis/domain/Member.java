package example.mybatis.domain;

import lombok.Data;

@Data
public class Member {

    private Long id;
    private String username;
    private int age;
    private Gender gender;
    private String address;

    public Member(String username, int age, Gender gender, String address) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

}

package example.mybatis.domain;

import lombok.Data;

@Data
public class News {

    private String title;
    private String author;
    private Integer page;

    public News(String title, String author, Integer page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }
}

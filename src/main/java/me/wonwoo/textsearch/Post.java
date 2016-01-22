package me.wonwoo.textsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import java.util.List;

/**
 * Created by wonwoo on 2016. 1. 22..
 */
@Document
@Data
public class Post {

    @Id
    private String id;

    @TextIndexed(weight = 3)
    private String title;
    @TextIndexed(weight = 2)
    private String content;
    @TextIndexed
    private List<String> categories;
    @TextScore
    private Float score;
}

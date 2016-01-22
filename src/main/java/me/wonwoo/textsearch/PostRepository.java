package me.wonwoo.textsearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by wonwoo on 2016. 1. 22..
 */

public interface PostRepository extends MongoRepository<Post, String> {

    Page<Post> findAllBy(@Param("text") TextCriteria textCriteria, Pageable pageable);
}

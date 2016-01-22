package me.wonwoo;

import me.wonwoo.textsearch.Post;
import me.wonwoo.textsearch.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.repository.init.Jackson2ResourceReader;


/**
 * Created by wonwoo on 16. 1. 19..
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    private PostRepository postRepository;

    @Autowired
    MongoOperations operations;

    @Bean
    CommandLineRunner runner(){
        return (args)->{
            Jackson2ResourceReader reader = new Jackson2ResourceReader();
            Object source = reader.readFrom(new ClassPathResource("spring-blog"), this.getClass().getClassLoader());
            if (source instanceof Iterable) {
                postRepository.save((Iterable<Post>) source);
            } else {
                postRepository.save((Post)source);
            }
        };
    }
}
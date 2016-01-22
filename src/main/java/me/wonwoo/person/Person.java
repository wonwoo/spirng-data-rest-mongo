package me.wonwoo.person;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by wonwoo on 16. 1. 19..
 */

@Data
public class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;

}

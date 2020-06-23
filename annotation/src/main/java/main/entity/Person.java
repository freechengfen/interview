package main.entity;/*
@author : Administrator
@create : 2020-06-2020/6/15-22:17

*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Value("552")
    private Integer id;
    @Value("${person.nickname}")
    private String name;



}

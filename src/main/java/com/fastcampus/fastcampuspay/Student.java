package com.fastcampus.fastcampuspay;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class Student {

    private String name;
    private int age;

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

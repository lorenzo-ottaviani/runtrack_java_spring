package com.example.jour2.model;

import jakarta.validation.constraints.*;

public class UserForm {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    @Min(1)
    @Max(120)
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}


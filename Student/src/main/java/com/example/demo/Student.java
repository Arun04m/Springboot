package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Size(min = 5, message = "Name must be at least 5 characters")
    private String name;

    @Column(name = "age")
    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @Column(name = "mark1")
    @NotNull(message = "Mark 1 is required")
    @Min(value = 0, message = "Mark 1 must be at least 0")
    private int mark1;

    @Column(name = "mark2")
    @NotNull(message = "Mark 2 is required")
    @Min(value = 0, message = "Mark 2 must be at least 0")
    private int mark2;

    @Column(name = "mark3")
    @NotNull(message = "Mark 3 is required")
    @Min(value = 0, message = "Mark 3 must be at least 0")
    private int mark3;

    @Column(name = "total")
    private int total;
    
    @Column(name = "result")
    private String result;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public int getMark3() {
        return mark3;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

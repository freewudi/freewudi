package com.example.idea20212src;


import com.example.idea20212src.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Idea20212srcApplication {
    public void test() {
        Test t = new Test();
        t.name = "1";
        System.out.println(t.name);
    }

    public static void main(String[] args) {
        SpringApplication.run(Idea20212srcApplication.class, args);
    }

}

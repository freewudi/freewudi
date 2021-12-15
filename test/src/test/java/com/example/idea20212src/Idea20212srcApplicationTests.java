package com.example.idea20212src;

import com.example.idea20212src.entity.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class Idea20212srcApplicationTests {

    @org.junit.jupiter.api.Test
    void contextLoads() {
        Test t = new Test();
        t.name = "1";
        System.out.println(t.name);
    }

}

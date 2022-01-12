package com.example.idea20212src;


import com.example.idea20212src.dao.UserDao;
import com.example.idea20212src.entity.Test;
import com.example.idea20212src.factory.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Idea20212srcApplication {
    public void test() {
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }

    public static void main(String[] args) {
        SpringApplication.run(Idea20212srcApplication.class, args);
    }

}

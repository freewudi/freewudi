package stream;

import lombok.Data;

@Data
public class Student {
    String name;
    Integer age;
    Integer type;

    public Student(String name, Integer age,Integer type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}

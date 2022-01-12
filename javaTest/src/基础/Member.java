package 基础;

import java.util.Arrays;

public class Member extends User{
    public Member(String name,int age) {
        super.name = name;
        super.age = age;
    }

    public static void main(String[] args) {
        Member mem1 = new Member("哈利波特",10);
        System.out.println("name="+mem1.name+",age="+mem1.age);
        int[] a = {1,2,4,3,2,2,1,5,7,5,3,2,};
        Arrays.sort(a);
        for (int b : a) {
            System.out.print(b);
        }
    }
}

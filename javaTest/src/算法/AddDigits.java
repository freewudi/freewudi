package 算法;

import java.sql.SQLOutput;

public class AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.addDigits(19999));
    }
}

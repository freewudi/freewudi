package charact3;

class Letter {
    char c;
    static void f(Letter y) {
        y.c = 'z';
    }
}
public class PassObject {

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1: x.c: " + x.c);
        Letter.f(x);
        System.out.println("2: x.c: " + x.c);
    }
} 
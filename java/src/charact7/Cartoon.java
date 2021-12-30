package charact7;

class Art{
    Art(){
        System.out.println("Art constructor");
    }
}

class Draw extends Art{
    Draw(){
        System.out.println("Draw constructor");
    }
}

public class Cartoon extends Draw{
    Cartoon(){
        System.out.println("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon c = new Cartoon();
    }
}

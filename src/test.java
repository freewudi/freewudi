import java.util.List;

public class test {
    public static int ladder(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else{
            return ladder(n-1)+ladder(n-2);
        }
    }

    private int getIndex(List<Object> lists, Object o){
        return lists.indexOf(o);
    }

    public static void main(String[] args) {
        System.out.println(ladder(9)+"+"+ladder(11));
        System.out.println("hello world");
    }
}

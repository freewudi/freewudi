package Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayBinarySearch {
    public static void main(String[] args) {
//        int[] nums = {2,5,0,4,1,-10};
//        Arrays.sort(nums);
//        int index = Arrays.binarySearch(nums,5);
//        System.out.println(index);
        //定义list

        List<User> list = new ArrayList<>();
        User  user1 = new User();
        User  user2 = new User();
        user1.setName("111");
        user2.setName("222");
        list.add(user1);
        list.add(user2);
//删除集合中某一元素值
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            String name = next.getName();
            if (name.equals("222")){
                iterator.remove();
            }
        }
        System.out.println(list);

    }
}

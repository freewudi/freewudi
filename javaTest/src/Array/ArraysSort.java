package Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class ArraysSort {
    public static void main(String[] args) {
        //Array a = [3,2,1,3,4]
        int[] nums = {2,5,0,4,1,-10};
        Arrays.sort(nums);
        Iterator it = Arrays.stream(nums).iterator();
        while(it.hasNext()){
            System.out.println(it.next()+",");
        }

        int[] nums1 = {2,5,0,4,1,-10};
        Arrays.sort(nums1,0,3);
        Iterator it1 = Arrays.stream(nums1).iterator();
        while(it1.hasNext()){
            System.out.println(it1.next()+",");
        }
    }
}

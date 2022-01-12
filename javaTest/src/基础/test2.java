package 基础;

import java.util.HashMap;
import java.util.Map;

public class test2 {

    public static void main(String[] args) {
        int[] my_array = {1, 2, 5, 5, 6, 6, 7, 2, 9, 2};
        //cfsz(my_array);
        Map<Integer,Integer> map = cfsz2(my_array);
        for(Integer key : map.keySet()){
            Integer value = map.get(key);
            System.out.println(key+":"+value);
        }
    }

    //查找数组里重复的元素
    public static void cfsz(int[] a){
        Map<Integer,Integer> map = cfsz2(a);
        int count=0;
        for(int j=0;j<a.length;j++) {
            for(int k =j+1;k<a.length;k++) {
                if(a[j]==a[k]) {
                    count++;
                }
            }
            if(count==1)
                System.out.println( "重复元素 : " +  a[j] + "::" + map.get(a[j]));
            count = 0;
        }
    }
    //查找数组里重复的元素,每个元素出现几次
    public static Map<Integer,Integer> cfsz2(int[] a){
        //循环数组，添加到map
        //如果map中没有这个数(key)，put(值,1)
        //有的话加一
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<a.length; i++){
            if(map.containsKey(a[i])){
                int val = map.get(a[i]);
                map.put(a[i],val+1);
            }else{
                map.put(a[i],1);
            }
        }
        return map;
    }
}

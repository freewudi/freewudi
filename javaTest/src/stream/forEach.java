package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class forEach {

    public static void insert(List<String> list){
        if(list.size() <= 500){
            //保存
            System.out.println(list.size());
        }else{
            insert(list.stream().limit(500).collect(Collectors.toList()));
            insert(list.stream().skip(500).collect(Collectors.toList()));
        }
    }

    public static void main(String[] args) {
//        List<String> dbNotes = new ArrayList<>();
//        dbNotes.add("Oracle");
//        dbNotes.add("Mysql");
//        dbNotes.add("Mysql");
//        dbNotes.add("Mysql");
//        StringBuilder str = new StringBuilder();
//        dbNotes.stream().filter(name -> !name.startsWith("Oracle"))
//                .forEach(str::append);
//        String str1 = dbNotes.stream().filter(name -> !name.startsWith("Oracle"))
//                .collect(Collectors.joining("/"));
//        System.out.println(str1);
        List<String> list = new ArrayList<>();
        for(int i = 0;i < 1020; i++){
            list.add("aaa");
        }
        insert(list);

    }
}

package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Distinct {

    public static void main(String[] args){
        Integer[] list1 = {1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8};
        List<Integer> listWithoutDuplicates1
                = Arrays.stream(list1)
                .distinct().collect(Collectors.toList());
        System.out.println(listWithoutDuplicates1);

        List<Integer> list =  Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8);
        List<Integer> listWithoutDuplicates
                = list.stream()
                    .distinct()
                    .collect(Collectors.toList());
        System.out.println(listWithoutDuplicates);
    }
}

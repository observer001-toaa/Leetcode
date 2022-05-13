package ClassTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseToNumber {
    //基础类转包装类，包装类转集合
    @Test
    public void test1(){
        //数组: int[]
        int[] arrayInt = new int[]{1,2,3,4,5,6};
        //原生数组转包装类数组: int[] 2 Integer[]
        Integer[] arrayInter = Arrays.stream(arrayInt).boxed().toArray(Integer[]::new);
        //*包装类数组转List/ArrayList: Integer[] 2 List<Integer>
        List<Integer> listInter = Arrays.asList(arrayInter);
        //*List/ArrayList转包装类数组: List<Integer> 2 Integer[]
        Integer[] arrayInter2 = listInter.toArray(new Integer[listInter.size()]);
        //包装类数组转原生数组: Integer[] 2 int[]
        int[] arrayInt2 = Arrays.stream(arrayInter2).mapToInt(Integer::valueOf).toArray();
        //原生数组转List/ArrayList: int[] 2 List<Integer>
        List<Integer> listInter2 = Arrays.stream(arrayInt2).boxed().collect(Collectors.toList());
        //List/ArrayList转原生数组： List<Integer> 2 int[]
        int[] arrayInt3 = listInter2.stream().mapToInt(Integer::valueOf).toArray();
    }
}

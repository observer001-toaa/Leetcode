package methodTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortTest {
    //Java中如何对一个数组进行升序排序
    @Test
    public void aSort(){
        int []nums={2,3,6,7,3,4,5,1,9,8,3};
        //调用Arrays中的sort方法
        Arrays.sort(nums);
        //打印
        System.out.println(Arrays.toString(nums));

    }
    //Java中如何对一个数组进行降序排序
    //要想改变默认的排列顺序，不能使用基本类型（int,double,char）而要使用它们对应的类
    @Test
    public void dSort1(){//利用 Collections.reverseOrder() 方法
        int []nums={2,3,6,7,3,4,5,1,9,8,3};
        Integer[] num=Arrays.stream(nums).boxed().toArray(Integer[]::new);
        //调用Arrays中的sort方法
        Arrays.sort( num,Collections.reverseOrder());
        // int[] arrayInt2 = Arrays.stream(arrayInter2).mapToInt(Integer::valueOf).toArray();
        nums=Arrays.stream(num).mapToInt(Integer::intValue).toArray();
        //打印
        System.out.println(Arrays.toString(nums));
    }
    @Test
    public void dSort2(){//利用Comparator接口复写compare
        int []nums={2,3,6,7,3,4,5,1,9,8,3};
        Integer[] num=Arrays.stream(nums).boxed().toArray(Integer[]::new);
        //调用Arrays中的sort方法
        Arrays.sort( num,new CMP());
        // int[] arrayInt2 = Arrays.stream(arrayInter2).mapToInt(Integer::valueOf).toArray();
        nums=Arrays.stream(num).mapToInt(Integer::intValue).toArray();
        //打印
        System.out.println(Arrays.toString(nums));
    }
    class CMP implements Comparator<Integer> {
        @Override //可以去掉。作用是检查下面的方法名是不是父类中所有的
        public int compare(Integer a, Integer b) {
//        两种都可以，升序排序的话反过来就行
//        return a-b<0?1:-1;
            return b - a;
        }
    }
    @Test
    public void dSort3(){//利用Comparator接口复写compare
        int []nums={2,3,6,7,3,4,5,1,9,8,3};
        Integer[] num=Arrays.stream(nums).boxed().toArray(Integer[]::new);
        //调用Arrays中的sort方法
        Arrays.sort( num,new Comparator(
        ){
            @Override
            public int compare(Object o1, Object o2) {
                Integer e1=(Integer)o1;
                Integer e2=(Integer)o2;
                return e2-e1;
            }
        });
        // int[] arrayInt2 = Arrays.stream(arrayInter2).mapToInt(Integer::valueOf).toArray();
        nums=Arrays.stream(num).mapToInt(Integer::intValue).toArray();
        //打印
        System.out.println(Arrays.toString(nums));
    }
    @Test
    public void dSort4(){//用lamada表达式（暂定为最终方案）
        int[] num = {1, 9, 2, 6, 5};    //定义一个int数组
        for(int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " "); //输出原来的数组
        }
        System.out.println();
        Integer[] Integernum = Arrays.stream(num).boxed().toArray(Integer[]::new);  //这一行代码和下面几行代码实现的功能相同
        /*//将int数组转换为Integer数组
        IntStream stream = Arrays.stream(num);  //将int数组转换为数值流
        Stream<Integer> integerStream = stream.boxed(); //将数值流中的元素全部装箱, 转换为流, int转为Integer。
        Integer[] Integernum = integerStream.toArray(Integer[]::new);   //将流转换为Integer数组*/
        Arrays.sort(Integernum, (a, b)->b - a); //使用lambda表达式对数组降序排列, 这一行代码和下面几行代码实现的功能相同。
        /*Arrays.sort(Integernum, (a, b)->{
            return b - a;
        });*/
        for(int i = 0; i < Integernum.length; i++) {
            System.out.print(Integernum[i] + " ");  //输出降序排列的数组
        }
        System.out.println();
    }
}

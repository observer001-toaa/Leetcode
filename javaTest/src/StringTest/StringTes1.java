package StringTest;

import org.junit.Test;

public class StringTes1 {
    @Test
    public void StringToCharArrayTest(){
        String[] strs={"123","abc","234","qwe"};
        for (String s:
             strs) {
            for (char c:s.toCharArray()
                 ) {
                System.out.println(c);
            }
        }
    }
}

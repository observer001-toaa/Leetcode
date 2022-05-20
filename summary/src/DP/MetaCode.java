package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class MetaCode {
    /*
    * 1确定dp数组以及下标的含义
    * 2确定递推公式（观察问题性质推出）
    * 3.dp数组如何初始化
    * 4确定遍历顺序
    * 5举例推导dp数组
    * */
    @Test
    public void testMultiPack1(){//多重背包
        // 版本一：改变物品数量为01背包格式
        List<Integer> weight = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15, 20, 30));
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 2));
        int bagWeight = 10;

        for (int i = 0; i < nums.size(); i++) {
            while (nums.get(i) > 1) { // 把物品展开为i
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums.set(i, nums.get(i) - 1);
            }
        }

        int[] dp = new int[bagWeight + 1];
        for(int i = 0; i < weight.size(); i++) { // 遍历物品
            for(int j = bagWeight; j >= weight.get(i); j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
            }
            System.out.println(Arrays.toString(dp));
        }
    }
    @Test
    public void testMultiPack2(){//多重背包
        // 版本二：改变遍历个数
        int[] weight = new int[] {1, 3, 4};
        int[] value = new int[] {15, 20, 30};
        int[] nums = new int[] {2, 3, 2};
        int bagWeight = 10;

        int[] dp = new int[bagWeight + 1];
        for(int i = 0; i < weight.length; i++) { // 遍历物品
            for(int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
                // 以上为01背包，然后加一个遍历个数
                for (int k = 1; k <= nums[i] && (j - k * weight[i]) >= 0; k++) { // 遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
    }
    @Test
    public void FullBagTest(){
        int [] weight={1,3,4};
        int[]value={15,20,30};
        int bagWeight=4;
        int [] dp=new int[bagWeight+1];
        for (int i = 0; i <weight.length ; i++) {
            for (int j = weight[i]; j <=bagWeight ; j++) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        for (int maxValue:dp
             ) {
            System.out.println(maxValue+" ");
        }
    }
    @Test
    public void Bag01Test1(){
        //输入
        int[] weight={1,3,4};
        int[] value={15,20,30};
        int bagsize=4;
        int wlen=weight.length;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int [][]dp= new int[wlen][bagsize+1];
        //初始化：背包容量为0时，能获得的价值都为0
        for (int j = weight[0]; j <bagsize+1 ; j++) {
            dp[0][j]=value[0];
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <wlen ; i++) {
            for(int j=0;j<=bagsize;j++){
                if(j<weight[i])dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        System.out.println(dp[wlen-1][bagsize]);
    }
    @Test
    public void Bag01Test2(){
        //输入
        int[] weight={1,3,4};
        int[] value={15,20,30};
        int bagsize=4;
        int wlen=weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，前i个物品能获得的最大价值
        int []dp= new int[bagsize+1];
        //初始化：背包容量为0时，能获得的价值都为0，java默认数组值为0
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i <wlen ; i++) {
            for(int j=bagsize;j>=weight[i];j--){
               dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(dp[bagsize]);
    }
}

package DP;

import org.junit.Test;

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

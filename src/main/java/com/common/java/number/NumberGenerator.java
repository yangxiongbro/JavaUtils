package com.common.java.number;

import java.util.Random;

/**
 * <b><code>NumberGenerator</code></b>
 * <p/>
 * 数字生成器
 * <p/>
 * <b>Creation Time:</b> 2024/5/30 23:43
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class NumberGenerator {

    /**
     * 0 <= random.nextInt(bound) < bound
     */
    private Random random;

    public NumberGenerator(){
        this.random = new Random();
    }

    /**
     * @description: 生成 count 个和为 sum 的随机数
     * @param: sum - [int]
     * @param: count - [int]
     * @return: int[]
     * @throws
     * @author yang xiong
     * @date 2024/5/30 23:46
     **/
    public int[] generateSomeNumberBySum(final int sum, final int count){
        if(count < 1){
            return new int[]{};
        }
        int[] randomNums = new int[count];
        int leftSum = sum;
        int i = 0;
        for(int randomCount = count - 1; i < randomCount; i++){
            int bound = leftSum / (count - i);
            int randomNum = random.nextInt(bound) + (bound / 2);
            leftSum -= randomNum;
            randomNums[i] = randomNum;
        }
        randomNums[i] = leftSum;
        return randomNums;
    }
}

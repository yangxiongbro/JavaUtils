package com.common.java.number;

import org.junit.jupiter.api.Test;

/**
 * <b><code>NumberGeneratorTest</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/5/30 23:55
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class NumberGeneratorTest {

    @Test
    public void generateSomeNumberBySum(){
        NumberGenerator numberGenerator = new NumberGenerator();

        int[] nums = numberGenerator.generateSomeNumberBySum(60, 3);
        for(int num:nums){
            System.out.println(num);
        }
    }
}

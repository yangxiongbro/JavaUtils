package com.common.java.number;

import com.common.java.number.enums.OperatorEnum;

/**
 * <b><code>MathUtils</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/8/7 15:35
 *
 * @author yang xiong
 * @since CommonJava 0.1.0
 */
public class MathUtils {
    /**
     * @description: 计算比率，比率 = 比例 * 100
     * @param: numerator
     * @param: denominator
     * @return: java.lang.Double
     * @throws
     * @author yang xiong
     * @date 2024/7/22 17:45
     **/
    public static Double rate(Number numerator, Number denominator){
        Double result = divide(numerator, denominator);
        return null == result ? null : result * 100;
    }

    /**
     * @description: 计算两个数的比例
     * @param: numerator
     * @param: denominator
     * @return: java.lang.Double
     * @throws
     * @author yang xiong
     * @date 2024/8/7 14:53
     **/
    public static Double divide(Number numerator, Number denominator){
        if(null == numerator || null == denominator){
            return null;
        }
        double dNumerator = numerator.doubleValue();
        double dDenominator = denominator.doubleValue();
        if(Math.abs(dDenominator) < Double.MIN_NORMAL){
            return null;
        }
        return dNumerator / dDenominator;
    }

    /**
     * @description: 判断大小
     * @param: operator
     * @param: target
     * @param: threshold
     * @return: boolean
     * @throws
     * @author yang xiong
     * @date 2024/8/7 15:39
     **/
    public static boolean judge(OperatorEnum operator, Number target, Number threshold){
        if(null == target || null == threshold){
            return false;
        }
        double dTarget = target.doubleValue();
        double dThreshold = threshold.doubleValue();
        if (operator == OperatorEnum.GE) {
            return dTarget >= dThreshold;
        } else if (operator == OperatorEnum.GT) {
            return dTarget > dThreshold;
        } else if (operator == OperatorEnum.EQ) {
            return dTarget == dThreshold;
        } else if (operator == OperatorEnum.NE) {
            return dTarget != dThreshold;
        } else if (operator == OperatorEnum.LT) {
            return dTarget < dThreshold;
        } else if (operator == OperatorEnum.LE) {
            return dTarget <= dThreshold;
        }
        return false;
    }
}

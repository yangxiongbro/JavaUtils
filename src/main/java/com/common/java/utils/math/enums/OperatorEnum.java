package com.common.java.utils.math.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <b><code>OperatorEnum</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/8/7 15:37
 *
 * @author yang xiong
 * @since CommonJava 0.1.0
 */
@Getter
@AllArgsConstructor
public enum OperatorEnum {
    GE("GE", ">=", "大于或等于", "<", "小于"),
    GT("GT", ">", "大于", "<=", "小于或等于"),
    EQ("EQ", "=", "等于", "!=", "不等于"),
    NE("NE", "!=", "不等于", "=", "等于"),
    LT("LT", "<", "小于", ">=", "大于或等于"),
    LE("LE", "<=", "小于或等于", ">", "大于"),
    CLOSED_INTERVAL("CLOSED_INTERVAL", "()", "含于", "[]", "不含于");

    private String type;
    private String operator;
    private String desc;
    private String notOperator;
    private String notDesc;

    public static String getOperator(String type) {
        for (OperatorEnum item : OperatorEnum.values()) {
            if (item.getType().equals(type)) {
                return item.getOperator();
            }
        }
        return null;
    }
}
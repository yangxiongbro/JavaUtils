package com.common.java.utils;

import com.common.java.constants.StringsConstants;

/**
 * <b><code>StringsUtils</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2023/11/21 22:07
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class StringsUtils {

    /**
     * @description: 小驼峰命名法
     * 驼峰命名法是一种常见的变量命名风格，它的特点是将多个单词连接在一起，每个单词的首字母大写，除了第一个单词的首字母小写
     * 例如: firstName、enabled
     * @param: str - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:28
     **/
    public static String lowerCamelCase(String[] strArray){
        if(null != strArray && strArray.length > 0){
            StringBuffer sb = new StringBuffer();
            String str = strArray[0];
            if(isNotEmpty(str)){
                sb.append(str.toLowerCase());
            }
            int len = strArray.length;
            for(int i = 1; i < len; i++){
                str = strArray[i];
                if(isNotEmpty(str)){
                    Byte firstChar = StringsConstants.LOWER_UPPER_MAP.get((byte)str.charAt(0));
                    sb.append((char)(null == firstChar ? str.charAt(0) : firstChar));
                    sb.append(str.substring(1));
                }
            }
            return sb.toString();
        }
        return StringsConstants.EMPTY_STRING;
    }

    /**
     * @description: 大驼峰命名法
     * 将多个单词连接在一起，每个单词的首字母大写。与小驼峰命名法的区别在于第一个单词的首字母大写
     * 例如: FirstName、Enabled
     * @param: str - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:28
     **/
    public static String upperCamelCase(String str){

        return str;
    }

    /**
     * @description: 帕斯卡命名法
     * 所有单词的首字母大写，然后直接连接起来，单词之间没有连接符。与大驼峰命名法相同
     * 例如: FirstName、Enabled
     * @param: str - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:27
     **/
    public static String pascalCase(String str){

        return str;
    }

    /**
     * @description: 下划线命名法
     * 所有字母都小写，单词之间使用下划线连接的命名风格
     * 例如: first_name、enabled
     * @param: str - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:27
     **/
    public static String snakeCase(String str){

        return str;
    }

    /**
     * @description: 全部大写命名法
     * 全部大写命名法是一种将所有字母都大写，单词之间使用下划线连接的命名风格，通常用来表示常量或者全局变量
     * 例如: FIRST_NAME、ENABLED
     * @param: str - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:27
     **/
    public static String allCapsCase(String str){

        return str;
    }

    /**
     * @description: 匈牙利命名法
     * 种将变量名前缀化的命名风格，它的特点是在变量名前面加上一个或多个表示变量类型或属性的小写字母前缀
     * 例如: strFirstName、bIsEnabled
     * 这种命名风格在过去较为流行，但现在已经不太常用。它能够清晰地表示变量的类型，但同时也增加了代码的几余性和可读性的难度
     * @param: str - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:27
     **/
    public static String hungarianNotation(String str){
        return str;
    }

    /**
     * @description: 将字符串使用分隔符分割为字符串数组
     * @param: str - [String]
     * @param: separator - [String]
     * @param: limit - [int]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:43
     **/
    public static String[] split(String str, String separator, int limit){
        if(isNotEmpty(str)){
            return str.split(separator, limit);
        }
        return StringsConstants.EMPTY_STRING_ARRAY;
    }

    public static boolean isNotEmpty(CharSequence str) {
        return str != null && str.length() > 0 && containsText(str);
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !str.isEmpty() && containsText(str);
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();

        for(int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}

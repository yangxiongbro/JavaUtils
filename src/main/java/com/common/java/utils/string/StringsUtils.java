package com.common.java.utils.string;

import com.common.java.constants.StringsConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <b><code>StringsUtils</code></b>
 * <p/>
 * 字符串组件
 * <p/>
 * <b>Creation Time:</b> 2024/8/9 18:34
 *
 * @author yang xiong
 * @since CommonJava 0.1.0
 */
public class StringsUtils {


    /**
     * @description: 大驼峰命名法转全部大写命名法
     * @param: str - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/23 0:07
     **/
    public static String upperCamelCase2allCapsCase(String str){
        return allCapsCase(split(str, StringsConstants.UPPER_CHAR_SET));
    }

    /**
     * @description: 小驼峰命名法
     * 驼峰命名法是一种常见的变量命名风格，它的特点是将多个单词连接在一起，每个单词的首字母大写，除了第一个单词的首字母小写
     * 例如: firstName、enabled
     * @param: strArray - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/22 22:22
     **/
    public static String lowerCamelCase(String[] strArray){
        if(null != strArray && strArray.length > 0){
            String str = strArray[0];
            if(isNotEmpty(str)){
                return str.toLowerCase() + upperCamelCase(strArray, 1);
            }
            return upperCamelCase(strArray, 1);
        }
        return StringsConstants.EMPTY_STRING;
    }

    /**
     * @description: 大驼峰命名法
     * 将多个单词连接在一起，每个单词的首字母大写。与小驼峰命名法的区别在于第一个单词的首字母大写
     * 例如: FirstName、Enabled
     * @param: strArray - [String]
     * @param: beginIndex - [int]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/22 22:25
     **/
    public static String upperCamelCase(String[] strArray, int beginIndex){
        if(null != strArray && strArray.length > 0 && beginIndex < strArray.length){
            int len = strArray.length;
            StringBuffer sb = new StringBuffer();
            for(int i = beginIndex; i < len; i++){
                String str = strArray[i];
                if(isNotEmpty(str)){
                    Byte firstChar = StringsConstants.LOWER_UPPER_CHAR_MAP.get((byte)str.charAt(0));
                    sb.append((char)(null == firstChar ? str.charAt(0) : firstChar));
                    sb.append(str.substring(1).toLowerCase());
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
     * @param: strArray - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:28
     **/
    public static String upperCamelCase(String[] strArray){
        return upperCamelCase(strArray, 0);
    }

    /**
     * @description: 帕斯卡命名法
     * 所有单词的首字母大写，然后直接连接起来，单词之间没有连接符。与大驼峰命名法相同
     * 例如: FirstName、Enabled
     * @param: strArray - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:27
     **/
    public static String pascalCase(String[] strArray){
        return upperCamelCase(strArray);
    }

    /**
     * @description: 下划线命名法
     * 所有字母都小写，单词之间使用下划线连接的命名风格
     * 例如: first_name、enabled
     * @param: strArray - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:27
     **/
    public static String snakeCase(String[] strArray){
        return connectWord(strArray, StringsConstants.UNDER_LINE).toLowerCase();
    }

    /**
     * @description: 全部大写命名法
     * 全部大写命名法是一种将所有字母都大写，单词之间使用下划线连接的命名风格，通常用来表示常量或者全局变量
     * 例如: FIRST_NAME、ENABLED
     * @param: strArray - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:27
     **/
    public static String allCapsCase(String[] strArray){
        return connectWord(strArray, StringsConstants.UNDER_LINE).toUpperCase();
    }

    /**
     * @description: 将字符串数组使用连接符号连接起来
     * @param: strArray - [String]
     * @param: connector - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2023/11/22 22:54
     **/
    public static String connectWord(String[] strArray, String connector){
        if(null != strArray && strArray.length > 0 && null != connector){
            StringBuffer sb = new StringBuffer();
            int len = strArray.length;
            String str = strArray[0];
            if(isNotEmpty(str)){
                sb.append(str);
            }
            for(int i = 1; i < len; i++){
                str = strArray[i];
                if(isNotEmpty(str)){
                    sb.append(connector);
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        return StringsConstants.EMPTY_STRING;
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
     * 当limit>0时，limit代表最后的数组长度，同时一共会切割 limit-1 次，最后没有切割完成的直接放在一起
     * 当limit=0时，会尽量多去匹配，并且会把末尾的空（例如：用逗号分隔后面“name,” 最后就会出现空）去掉
     * 当limit<0时，会尽量多去匹配，但不会去掉末尾的空
     * split(regex)调用了split(regex,0)
     *
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

    /**
     * @description: 根据 Set 集合中得 char 队字符串进行分割
     * @param: str - [String]
     * @param: charSet - [Byte>]
     * @return: java.lang.String[]
     * @throws
     * @author yang xiong
     * @date 2023/11/22 23:54
     **/
    public static String[] split(String str, Set<Byte> charSet){
        if(isNotEmpty(str) && null != charSet && charSet.size() > 0){
            List<String> list = new ArrayList<>();
            StringBuffer sb = new StringBuffer();
            byte[] byteArray = str.getBytes();
            for(byte b: byteArray){
                if(charSet.contains(b)){
                    if(sb.length()>0){
                        list.add(sb.toString());
                    }
                    sb.delete(0, sb.length());
                }
                sb.append((char)b);
            }
            if(sb.length()>0){
                list.add(sb.toString());
            }
            String[] strArray = new String[list.size()];
            return list.toArray(strArray);
        }
        return StringsConstants.EMPTY_STRING_ARRAY;
    }

    public static boolean isNotEmpty(CharSequence str) {
        if(str != null && str.length() > 0){
            int strLen = str.length();
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @description: 去除首位空白字符
     * @param: str
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2024/8/9 18:36
     **/
    public static String trim(String str){
        if(null != str && isNotEmpty(str.trim())){
            return str.trim();
        }
        return null;
    }

    /**
     * @description: 提取开始符号，结束符号之间的字符(不包括开始、结束字符)
     * @param: str
     * @param: startStr
     * @param: endStr
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2024/8/9 17:58
     **/
    public static String extractFrom(String str, String startStr, String endStr){
        if(null == str || null == startStr || null == endStr){
            return null;
        }
        int startIndex = str.lastIndexOf(startStr);
        int endIndex = str.lastIndexOf(endStr);
        return -1 < startIndex && startIndex < endIndex ? str.substring(startIndex + 1, endIndex) : null;
    }

    /**
     * @description: 提取结束符号之前的字符(不包括开结束字符)
     * @param: str
     * @param: startStr
     * @param: endStr
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2024/8/9 18:25
     **/
    public static String extractPrevious(String str, String endStr){
        if(null == str){
            return null;
        }
        int endIndex = null == endStr ? str.length() : str.lastIndexOf(endStr);
        return -1 < endIndex ? str.substring(0, endIndex) : str;
    }
}

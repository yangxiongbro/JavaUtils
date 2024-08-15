package com.common.java.utils.string;

import com.common.java.constants.StringsConstants;
import org.junit.jupiter.api.Test;

/**
 * <b><code>StringsConvertorTest</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2023/11/21 23:17
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class StringsUtilsTest {

    private String str2DArray[][] = new String[][]{
            new String[]{"first", "name"},
            new String[]{"FIRST", "NAME"},
            new String[]{"first", "NAME"},
            new String[]{"FIRST", "name"},
            new String[]{"First", "name"},
            new String[]{"first", "Name"},
            new String[]{"", "name"},
            new String[]{null, "name"},
            new String[]{"first", null},
            new String[]{null, null},
            new String[]{},
            null
    };

    private String strArray[] = new String[]{null, "", "  ", " first", " first ", "first name", " first name", " first name ", "name"
            , " First",  "firsT ", " FirsT ", "First Name", " First name", " First namE ", "NAME"
            , "NoHandlerFoundException", " NoHandlerFoundException ", " noHandlerFoundException "};

    @Test
    public void upperCamelCase2allCapsCase(){
        for(String str:strArray){
            System.out.println(String.format("\"%s\" -> \"%s\"", str, StringsUtils.upperCamelCase2allCapsCase(str)));
        }
    }

    @Test
    public void lowerCamelCase(){
        for(String[] strArray:str2DArray){
            System.out.println(String.format("\"%s\" -> \"%s\"", strArray, StringsUtils.lowerCamelCase(strArray)));
        }
    }

    @Test
    public void upperCamelCase(){
        for(String[] strArray:str2DArray){
            System.out.println(String.format("\"%s\" -> \"%s\"", strArray, StringsUtils.upperCamelCase(strArray)));
        }
    }

    @Test
    public void pascalCase(){
        for(String[] strArray:str2DArray){
            System.out.println(String.format("\"%s\" -> \"%s\"", strArray, StringsUtils.pascalCase(strArray)));
        }
    }

    @Test
    public void snakeCase(){
        for(String[] strArray:str2DArray){
            System.out.println(String.format("\"%s\" -> \"%s\"", strArray, StringsUtils.snakeCase(strArray)));
        }
    }

    @Test
    public void allCapsCase(){
        for(String[] strArray:str2DArray){
            System.out.println(String.format("\"%s\" -> \"%s\"", strArray, StringsUtils.allCapsCase(strArray)));
        }
    }

    @Test
    public void split() {
        for(String str:strArray){
            System.out.println(String.format("\"%s\" -> \"%s\"", str, StringsUtils.split(str, " ", -1)));
        }
    }

    @Test
    public void split2() {
        for(String str:strArray){
            System.out.println(String.format("\"%s\" -> \"%s\"", str, StringsUtils.split(str, StringsConstants.UPPER_CHAR_SET)));
        }
    }

    @Test
    public void isNotEmpty() {
        for(String str:strArray){
            System.out.println(String.format("\"%s\" -> \"%s\"", str, StringsUtils.isNotEmpty(str)));
        }
    }

    @Test
    public void trim(){
        for(String str:strArray){
            System.out.println(String.format("\"%s\" -> \"%s\"", str, StringsUtils.trim(str)));
        }
    }

    @Test
    public void extractFrom(){
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcd", StringsUtils.extractFrom("abcd", "ab", "cd")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcdabcd", StringsUtils.extractFrom("abcdabcd", "ab", "cd")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcd", StringsUtils.extractFrom("abcd", "a", "d")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcd", StringsUtils.extractFrom("abcd", "d", "a")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "", StringsUtils.extractFrom("", "ab", "cd")));
        System.out.println(String.format("\"%s\" -> \"%s\"", null, StringsUtils.extractFrom(null, "d", "a")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcd", StringsUtils.extractFrom("abcd", null, "d")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcd", StringsUtils.extractFrom("abcd", "a", null)));
    }

    @Test
    public void extractPrevious(){
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcd", StringsUtils.extractPrevious("abcd", "cd")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcd", StringsUtils.extractPrevious("abcd", "ab")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "", StringsUtils.extractPrevious("", "ab")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "", StringsUtils.extractPrevious(null, "ab")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcd", StringsUtils.extractPrevious("abcd", null)));
    }

    @Test
    public void extractAfter(){
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcd", StringsUtils.extractAfter("abcd", "cd")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcd", StringsUtils.extractAfter("abcd", "ab")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "", StringsUtils.extractAfter("", "ab")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "", StringsUtils.extractAfter(null, "ab")));
        System.out.println(String.format("\"%s\" -> \"%s\"", "abcd", StringsUtils.extractAfter("abcd", null)));
    }


}

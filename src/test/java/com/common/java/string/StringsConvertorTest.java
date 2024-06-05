package com.common.java.string;

import com.common.java.constants.StringsConstants;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class StringsConvertorTest {

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
            log.info("{} -> {}", str, StringsConvertor.upperCamelCase2allCapsCase(str));
        }
    }

    @Test
    public void lowerCamelCase(){
        for(String[] strArray:str2DArray){
            log.info("{} -> {}", strArray, StringsConvertor.lowerCamelCase(strArray));
        }
    }

    @Test
    public void upperCamelCase(){
        for(String[] strArray:str2DArray){
            log.info("{} -> {}", strArray, StringsConvertor.upperCamelCase(strArray));
        }
    }

    @Test
    public void pascalCase(){
        for(String[] strArray:str2DArray){
            log.info("{} -> {}", strArray, StringsConvertor.pascalCase(strArray));
        }
    }

    @Test
    public void snakeCase(){
        for(String[] strArray:str2DArray){
            log.info("{} -> {}", strArray, StringsConvertor.snakeCase(strArray));
        }
    }

    @Test
    public void allCapsCase(){
        for(String[] strArray:str2DArray){
            log.info("{} -> {}", strArray, StringsConvertor.allCapsCase(strArray));
        }
    }

    @Test
    public void split() {
        for(String str:strArray){
            log.info("{} -> {}", str, StringsConvertor.split(str, " ", -1));
        }
    }

    @Test
    public void split2() {
        for(String str:strArray){
            log.info("{} -> {}", str, StringsConvertor.split(str, StringsConstants.UPPER_CHAR_SET));
        }
    }

    @Test
    public void isNotEmpty() {
        for(String str:strArray){
            log.info("{} -> {}", str, StringsConvertor.isNotEmpty(str));
        }
    }

}

package com.common.java.utils.string;

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
            log.info("{} -> {}", str, StringsUtils.upperCamelCase2allCapsCase(str));
        }
    }

    @Test
    public void lowerCamelCase(){
        for(String[] strArray:str2DArray){
            log.info("{} -> {}", strArray, StringsUtils.lowerCamelCase(strArray));
        }
    }

    @Test
    public void upperCamelCase(){
        for(String[] strArray:str2DArray){
            log.info("{} -> {}", strArray, StringsUtils.upperCamelCase(strArray));
        }
    }

    @Test
    public void pascalCase(){
        for(String[] strArray:str2DArray){
            log.info("{} -> {}", strArray, StringsUtils.pascalCase(strArray));
        }
    }

    @Test
    public void snakeCase(){
        for(String[] strArray:str2DArray){
            log.info("{} -> {}", strArray, StringsUtils.snakeCase(strArray));
        }
    }

    @Test
    public void allCapsCase(){
        for(String[] strArray:str2DArray){
            log.info("{} -> {}", strArray, StringsUtils.allCapsCase(strArray));
        }
    }

    @Test
    public void split() {
        for(String str:strArray){
            log.info("{} -> {}", str, StringsUtils.split(str, " ", -1));
        }
    }

    @Test
    public void split2() {
        for(String str:strArray){
            log.info("{} -> {}", str, StringsUtils.split(str, StringsConstants.UPPER_CHAR_SET));
        }
    }

    @Test
    public void isNotEmpty() {
        for(String str:strArray){
            log.info("{} -> {}", str, StringsUtils.isNotEmpty(str));
        }
    }

}

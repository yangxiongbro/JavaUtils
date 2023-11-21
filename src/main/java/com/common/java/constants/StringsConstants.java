package com.common.java.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * <b><code>StringsConstants</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2023/11/21 23:06
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class StringsConstants {
    public static final String UNDER_LINE = "_";

    public static final String EMPTY_STRING = "";

    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final Map<Byte, Byte> LOWER_UPPER_MAP = new HashMap(26);

    static {
        LOWER_UPPER_MAP.put((byte)97, (byte)65);
        LOWER_UPPER_MAP.put((byte)98, (byte)66);
        LOWER_UPPER_MAP.put((byte)99, (byte)67);
        LOWER_UPPER_MAP.put((byte)100, (byte)68);
        LOWER_UPPER_MAP.put((byte)101, (byte)69);
        LOWER_UPPER_MAP.put((byte)102, (byte)70);
        LOWER_UPPER_MAP.put((byte)103, (byte)71);
        LOWER_UPPER_MAP.put((byte)104, (byte)72);
        LOWER_UPPER_MAP.put((byte)105, (byte)73);
        LOWER_UPPER_MAP.put((byte)106, (byte)74);
        LOWER_UPPER_MAP.put((byte)107, (byte)75);
        LOWER_UPPER_MAP.put((byte)108, (byte)76);
        LOWER_UPPER_MAP.put((byte)109, (byte)77);
        LOWER_UPPER_MAP.put((byte)110, (byte)78);
        LOWER_UPPER_MAP.put((byte)111, (byte)79);
        LOWER_UPPER_MAP.put((byte)112, (byte)80);
        LOWER_UPPER_MAP.put((byte)113, (byte)81);
        LOWER_UPPER_MAP.put((byte)114, (byte)82);
        LOWER_UPPER_MAP.put((byte)115, (byte)83);
        LOWER_UPPER_MAP.put((byte)116, (byte)84);
        LOWER_UPPER_MAP.put((byte)117, (byte)85);
        LOWER_UPPER_MAP.put((byte)118, (byte)86);
        LOWER_UPPER_MAP.put((byte)119, (byte)87);
        LOWER_UPPER_MAP.put((byte)120, (byte)88);
        LOWER_UPPER_MAP.put((byte)121, (byte)89);
        LOWER_UPPER_MAP.put((byte)122, (byte)90);
    }
}

package com.common.java.constants;

import java.util.*;

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
    public static final char UNDER_LINE_CHAR = '_';

    public static final String UNDER_LINE = "_";

    public static final String EMPTY_STRING = "";

    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final Map<Byte, Byte> LOWER_UPPER_CHAR_MAP = new HashMap(26);
    static {
        LOWER_UPPER_CHAR_MAP.put((byte)97, (byte)65);
        LOWER_UPPER_CHAR_MAP.put((byte)98, (byte)66);
        LOWER_UPPER_CHAR_MAP.put((byte)99, (byte)67);
        LOWER_UPPER_CHAR_MAP.put((byte)100, (byte)68);
        LOWER_UPPER_CHAR_MAP.put((byte)101, (byte)69);
        LOWER_UPPER_CHAR_MAP.put((byte)102, (byte)70);
        LOWER_UPPER_CHAR_MAP.put((byte)103, (byte)71);
        LOWER_UPPER_CHAR_MAP.put((byte)104, (byte)72);
        LOWER_UPPER_CHAR_MAP.put((byte)105, (byte)73);
        LOWER_UPPER_CHAR_MAP.put((byte)106, (byte)74);
        LOWER_UPPER_CHAR_MAP.put((byte)107, (byte)75);
        LOWER_UPPER_CHAR_MAP.put((byte)108, (byte)76);
        LOWER_UPPER_CHAR_MAP.put((byte)109, (byte)77);
        LOWER_UPPER_CHAR_MAP.put((byte)110, (byte)78);
        LOWER_UPPER_CHAR_MAP.put((byte)111, (byte)79);
        LOWER_UPPER_CHAR_MAP.put((byte)112, (byte)80);
        LOWER_UPPER_CHAR_MAP.put((byte)113, (byte)81);
        LOWER_UPPER_CHAR_MAP.put((byte)114, (byte)82);
        LOWER_UPPER_CHAR_MAP.put((byte)115, (byte)83);
        LOWER_UPPER_CHAR_MAP.put((byte)116, (byte)84);
        LOWER_UPPER_CHAR_MAP.put((byte)117, (byte)85);
        LOWER_UPPER_CHAR_MAP.put((byte)118, (byte)86);
        LOWER_UPPER_CHAR_MAP.put((byte)119, (byte)87);
        LOWER_UPPER_CHAR_MAP.put((byte)120, (byte)88);
        LOWER_UPPER_CHAR_MAP.put((byte)121, (byte)89);
        LOWER_UPPER_CHAR_MAP.put((byte)122, (byte)90);
    }

    public static final Set<Byte> LOWER_CHAR_SET = new HashSet<>(26);
    static {
        LOWER_CHAR_SET.add((byte)97);
        LOWER_CHAR_SET.add((byte)98);
        LOWER_CHAR_SET.add((byte)99);
        LOWER_CHAR_SET.add((byte)100);
        LOWER_CHAR_SET.add((byte)101);
        LOWER_CHAR_SET.add((byte)102);
        LOWER_CHAR_SET.add((byte)103);
        LOWER_CHAR_SET.add((byte)104);
        LOWER_CHAR_SET.add((byte)105);
        LOWER_CHAR_SET.add((byte)106);
        LOWER_CHAR_SET.add((byte)107);
        LOWER_CHAR_SET.add((byte)108);
        LOWER_CHAR_SET.add((byte)109);
        LOWER_CHAR_SET.add((byte)110);
        LOWER_CHAR_SET.add((byte)111);
        LOWER_CHAR_SET.add((byte)112);
        LOWER_CHAR_SET.add((byte)113);
        LOWER_CHAR_SET.add((byte)114);
        LOWER_CHAR_SET.add((byte)115);
        LOWER_CHAR_SET.add((byte)116);
        LOWER_CHAR_SET.add((byte)117);
        LOWER_CHAR_SET.add((byte)118);
        LOWER_CHAR_SET.add((byte)119);
        LOWER_CHAR_SET.add((byte)120);
        LOWER_CHAR_SET.add((byte)121);
        LOWER_CHAR_SET.add((byte)122);
    }

    public static final Set<Byte> UPPER_CHAR_SET = new HashSet<>(26);
    static {
        UPPER_CHAR_SET.add((byte)65);
        UPPER_CHAR_SET.add((byte)66);
        UPPER_CHAR_SET.add((byte)67);
        UPPER_CHAR_SET.add((byte)68);
        UPPER_CHAR_SET.add((byte)69);
        UPPER_CHAR_SET.add((byte)70);
        UPPER_CHAR_SET.add((byte)71);
        UPPER_CHAR_SET.add((byte)72);
        UPPER_CHAR_SET.add((byte)73);
        UPPER_CHAR_SET.add((byte)74);
        UPPER_CHAR_SET.add((byte)75);
        UPPER_CHAR_SET.add((byte)76);
        UPPER_CHAR_SET.add((byte)77);
        UPPER_CHAR_SET.add((byte)78);
        UPPER_CHAR_SET.add((byte)79);
        UPPER_CHAR_SET.add((byte)80);
        UPPER_CHAR_SET.add((byte)81);
        UPPER_CHAR_SET.add((byte)82);
        UPPER_CHAR_SET.add((byte)83);
        UPPER_CHAR_SET.add((byte)84);
        UPPER_CHAR_SET.add((byte)85);
        UPPER_CHAR_SET.add((byte)86);
        UPPER_CHAR_SET.add((byte)87);
        UPPER_CHAR_SET.add((byte)88);
        UPPER_CHAR_SET.add((byte)89);
        UPPER_CHAR_SET.add((byte)90);
    }
}

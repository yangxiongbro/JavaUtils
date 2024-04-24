package com.common.java.config.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

/**
 * <b><code>JacksonConfig</code></b>
 * <p/>
 * jackson配置
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 2:54
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class JacksonConfig {

    public static ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setLocale(Locale.CHINA);
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.ALWAYS);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, false);
        objectMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    public XmlMapper xmlMapper() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();

//        LocalDateTimeSerializer localDateTimeSerializer = new LocalDateTimeSerializer(dtf);
//        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(dtf);
//        LocalDateSerializer localDateSerializer = new LocalDateSerializer(dtf);
//        LocalDateDeserializer localDateDeserializer = new LocalDateDeserializer(dtf);

//        jacksonXmlModule.addSerializer(LocalDateTime.class, localDateTimeSerializer).addSerializer(
//                LocalDate.class, localDateSerializer).addDeserializer(
//                LocalDateTime.class, localDateTimeDeserializer).addDeserializer(LocalDate.class, localDateDeserializer);
//        jacksonXmlModule.setDefaultUseWrapper(false);

        XmlMapper xmlMapper = new XmlMapper(jacksonXmlModule);
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).setDefaultMergeable(true)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .disable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                .disable(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)
                .disable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                .setLocale(Locale.CHINA)
                .setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return xmlMapper;
    }
}

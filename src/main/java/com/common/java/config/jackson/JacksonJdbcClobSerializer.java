//package com.common.java.config.jackson;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.h2.jdbc.JdbcClob;
//import org.springframework.boot.jackson.JsonComponent;
//
//import java.io.BufferedReader;
//
///**
// * <b><code>DateTimeUtiles</code></b>
// * <p/>
// * 使用 @JsonComponent 注释会自动被注册到 Jackson 中.
// * <p/>
// * <b>Creation Time:</b> 2024/4/21 2:54
// *
// * @author yang xiong
// * @since CommonJava 1.0
// */
//@Slf4j
//public class JacksonJdbcClobSerializer extends JsonSerializer<JdbcClob> {
//
//    @SneakyThrows
//    @Override
//    public void serialize(JdbcClob jdbcClob, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
//        try (BufferedReader br = new BufferedReader(jdbcClob.getCharacterStream())){
//            String readLine;
//            StringBuilder sb = new StringBuilder();
//            while ((readLine = br.readLine()) != null) {
//                sb.append(readLine);
//            }
//            jsonGenerator.writeString(sb.toString());
//        }catch (Exception e){
//            log.warn(e.getMessage());
//        }
//    }
//}

package com.poc.boldconnect.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.poc.boldconnect.Application;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public final class CommonUtils {
    private CommonUtils() {
    }

    public static String getInputFromFile(String filePath) {
        try {
            return getInputFromFile(getStreamFromFile(Application.class.getClassLoader().getResource(filePath).toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }  public static String getInputFromFileUsingStream(String filePath) {
        InputStream resourceAsStream = Application.class.getClassLoader().getResourceAsStream(filePath);
        try {
           return IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Stream<String> getStreamFromFile(URI filePath) throws IOException {
        return Files.lines(Paths.get(filePath));
    }

    private static String getInputFromFile(Stream<String> stream) {
        return stream.collect(Collectors.joining());
    }

    public static <T> T convertJSONToObject(String json, Class<T> classType) {
        try {
            return objectMapper().readValue(json, classType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> convertJSONToObjectList(String json, Class<T> classType) {
        try {
            JavaType type = objectMapper().getTypeFactory().constructCollectionType(List.class, classType);
            return objectMapper().readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertObjectToJson(Object obj) {
        String json = null;
        try {
            json = objectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        // Hack time module to allow 'Z' at the end of string (i.e. javascript json's)
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_INSTANT));
        mapper.registerModule(javaTimeModule);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
        return mapper;
    }

    public static String formatDateTime(LocalDateTime now) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }
}

package com.poc.boldconnect.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.poc.boldconnect.Application;


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
}

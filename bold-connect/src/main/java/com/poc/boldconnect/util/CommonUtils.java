package com.poc.boldconnect.util;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public final class CommonUtils {
    private CommonUtils() {
    }

    private static Stream<String> getStreamFromFile(URI filePath) throws IOException {
        return Files.lines(Paths.get(filePath));
    }

    private static String getInputFromFile(Stream<String> stream) {
        return stream.collect(Collectors.joining());
    }

    public static String getInputFromFile(URI filePath) throws IOException {
        return getInputFromFile(getStreamFromFile(filePath));
    }

    public static Object convertJSONToObject(String json, Class<?> classType) throws JsonParseException, JsonMappingException, IOException {
        return new ObjectMapper().readValue(json, classType);
    }
}

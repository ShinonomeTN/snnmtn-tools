package com.shiononometn.commons.web.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class JSON {
    private JSON(){}

    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper jsonMapper(){
        return objectMapper;
    }

    public static <T> T readFromJson(InputStream fileInputStream, TypeReference<T> typeReference) throws IOException {

        return objectMapper.readValue(fileInputStream,typeReference);
    }

    public static void writeToFile(File file, Object object) throws IOException {
        if(file.exists()){
            if (!file.delete()){
                throw new IllegalStateException("File could not be updated.");
            }
        }
        objectMapper.writeValue(file,object);
    }
}

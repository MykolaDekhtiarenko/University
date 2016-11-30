package com.mdekhtiarenko.universitysignin.utils;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by mykola.dekhtiarenko on 29.11.16.
 */
public class Helper {

    public static String writeListToJsonArray(List list) {
        final ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result=mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  result;
    }


}

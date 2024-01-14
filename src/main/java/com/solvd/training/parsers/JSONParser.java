package com.solvd.training.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.training.exceptions.DeserializationException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static com.solvd.training.utils.LoggerUtil.log;

public class JSONParser {

    private final String jsonPath;
    private final ObjectMapper mapper = new ObjectMapper();

    public JSONParser(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public void parseJSON() throws DeserializationException {
        try (InputStream inputStream = new FileInputStream(jsonPath)) {
            Map<String, Object> companyData = mapper.readValue(inputStream, Map.class);

            if (companyData != null) {
                printNestedObjects(companyData);
            } else {
                throw new DeserializationException("Deserialization resulted in a null companyData");
            }
        } catch (IOException e) {
            log.error("Error parsing JSON file: ", e);
            throw new DeserializationException("Error parsing JSON file", e);
        }
    }

    public void printNestedObjects(Map<String, Object> data) throws DeserializationException {
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            Object value = entry.getValue();
            try {
                String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
                log.info(json);
            } catch (JsonProcessingException e) {
                log.error("Error printing JSON", e);
                throw new DeserializationException("Error printing JSON", e);
            }
        }
    }
}
